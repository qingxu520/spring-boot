package co.goho.qingxu.utils;

import co.goho.qingxu.annotation.Ignore;
import co.goho.qingxu.annotation.Order;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BeanUtils {

    public static String getValueString(Object o){
        Field[] fields = o.getClass().getDeclaredFields();
        List<Field> fieldList = Arrays.asList(fields);
        String valueString ="";
        fieldList.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        for (int i = 0; i < fieldList.size(); i++) {
            Field f =fieldList.get(i);
            Object invoke = null;
            try {
                Method m = (Method) o.getClass().getMethod("get" + getMethodName(f.getName()));
                invoke = m.invoke(o);
                valueString=valueString+=invoke;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return valueString;
    }

    public static String getValueStringOrder(Object o){
        Field[] fields = o.getClass().getDeclaredFields();
        List<Field> fieldList = new ArrayList<>();
        String valueString ="";
        for(Field field:fields){
            if(field.getAnnotation(Order.class)!=null){
                fieldList.add(field);
            }
        }
        fieldList.sort(Comparator.comparingInt(
                m -> m.getAnnotation(Order.class).order()
        ));
        for (int i = 0; i < fieldList.size(); i++) {
            Field f =fieldList.get(i);
            Object invoke = null;
            try {
                Method m = (Method) o.getClass().getMethod("get" + getMethodName(f.getName()));
                invoke = m.invoke(o);
                valueString=valueString+=invoke;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return valueString;
    }

    public static String getValueStringPatient(Object o){
        Field[] fields = o.getClass().getDeclaredFields();
        List<Field> fieldList = new ArrayList<>();
        String valueString ="";
        for(Field field:fields){
            if(field.getAnnotation(Ignore.class)==null){
                fieldList.add(field);
            }
        }
        fieldList.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        for (int i = 0; i < fieldList.size(); i++) {
            Field f =fieldList.get(i);
            Object invoke = null;
            try {
                Method m = (Method) o.getClass().getMethod("get" + getMethodName(f.getName()));
                invoke = m.invoke(o);
                valueString=valueString+=invoke;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return valueString;
    }
    /**
     * 首字母大写
     * @param fildeName
     * @return
     * @throws Exception
     */
    private static String getMethodName(String fildeName) throws Exception{
        byte[] items = fildeName.getBytes();
        items[0] = (byte) ((char) items[0] - 'a' + 'A');
        return new String(items);
    }
}
