package co.goho.qingxu.easy.web.service;

import co.goho.qingxu.easy.bean.SysConfig;
import co.goho.qingxu.easy.conmmon.utils.StringUtils;
import co.goho.qingxu.easy.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RuoYi首创 html调用 thymeleaf 实现参数管理
 * 
 * @author ruoyi
 */
@Service("config")
public class ConfigService {
    @Autowired
    private SysConfigService configService;

    /**
     * 根据键名查询参数配置信息
     * 
     * @param configKey 参数名称
     * @return 参数键值
     */
    public String getKey(String configKey) {
        SysConfig sysConfig = configService.findByConfigKey(configKey);
        return StringUtils.isNotNull(sysConfig) ? sysConfig.getConfigValue() : "";
    }
}
