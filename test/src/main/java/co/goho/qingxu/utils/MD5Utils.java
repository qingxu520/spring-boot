package co.goho.qingxu.utils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by lion on 2017/10/20.
 */
public class MD5Utils {

    public static String encode(String str){
        String aResult = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            aResult = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return aResult;
    }
}
