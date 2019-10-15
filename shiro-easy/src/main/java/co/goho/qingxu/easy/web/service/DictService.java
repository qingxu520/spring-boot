package co.goho.qingxu.easy.web.service;

import co.goho.qingxu.easy.bean.SysDict;
import co.goho.qingxu.easy.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * RuoYi首创 html调用 thymeleaf 实现字典读取
 * 
 * @author ruoyi
 */
@Service("dict")
public class DictService {
    @Autowired
    private SysDictService sysDictService;

    /**
     * 根据字典类型查询字典数据信息
     * 
     * @param dictType 字典类型
     * @return 参数键值
     */
    public List<SysDict> getType(String dictType) {
        SysDict sysDict = new SysDict();
        sysDict.setType(dictType);
        return sysDictService.findList(sysDict);
    }

    /**
     * 根据字典类型和字典键值查询字典数据信息
     * 
     * @param dictType 字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    public String getLabel(String dictType, String dictValue) {
        String label = "";
        SysDict sysDict = sysDictService.findBytypeAndValue(dictType,dictValue);
        if(sysDict!=null){
            label=sysDict.getLabel();
        }
        return label;
    }
}
