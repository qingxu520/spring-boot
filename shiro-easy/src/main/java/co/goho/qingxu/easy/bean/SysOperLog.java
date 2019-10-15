package co.goho.qingxu.easy.bean;

import co.goho.qingxu.easy.conmmon.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.Date;

/**
 * 操作日志记录表 oper_log
 * 
 * @author ruoyi
 */
@Entity(name = "sys_oper_log")
@ToString
@EqualsAndHashCode(callSuper=true)//callSuper=true可以调用父类属性
@NoArgsConstructor
@AllArgsConstructor
public class SysOperLog extends BaseEntity {
    @Transient
    private static final long serialVersionUID = 1L;

    /** 操作模块 */
    @Column
    private String title;

    /** 业务类型（0其它 1新增 2修改 3删除） */
    @Column
    private Integer businessType;

    /** 业务类型数组 */
    @Column
    private Integer[] businessTypes;

    /** 请求方法 */
    @Column
    private String method;

    /** 请求方式 */
    @Column
    private String requestMethod;

    /** 操作类别（0其它 1后台用户 2手机端用户） */
    @Column
    private Integer operatorType;

    /** 请求url */
    @Column
    private String operUrl;

    /** 操作地址 */
    @Column
    private String operIp;

    /** 操作地点 */
    @Column
    private String operLocation;

    /** 请求参数 */
    @Column
    private String operParam;

    /** 返回参数 */
    @Column
    private String jsonResult;

    /** 操作状态（0正常 1异常） */
    @Column
    private String operStatus;

    /** 错误消息 */
    @Column
    private String errorMsg;


    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Integer getBusinessType()
    {
        return businessType;
    }

    public void setBusinessType(Integer businessType)
    {
        this.businessType = businessType;
    }

    public Integer[] getBusinessTypes()
    {
        return businessTypes;
    }

    public void setBusinessTypes(Integer[] businessTypes)
    {
        this.businessTypes = businessTypes;
    }

    public String getMethod()
    {
        return method;
    }

    public void setMethod(String method)
    {
        this.method = method;
    }

    public String getRequestMethod()
    {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod)
    {
        this.requestMethod = requestMethod;
    }

    public Integer getOperatorType()
    {
        return operatorType;
    }

    public void setOperatorType(Integer operatorType)
    {
        this.operatorType = operatorType;
    }

    public String getOperUrl()
    {
        return operUrl;
    }

    public void setOperUrl(String operUrl)
    {
        this.operUrl = operUrl;
    }

    public String getOperIp()
    {
        return operIp;
    }

    public void setOperIp(String operIp)
    {
        this.operIp = operIp;
    }

    public String getOperLocation()
    {
        return operLocation;
    }

    public void setOperLocation(String operLocation)
    {
        this.operLocation = operLocation;
    }

    public String getOperParam()
    {
        return operParam;
    }

    public void setOperParam(String operParam)
    {
        this.operParam = operParam;
    }

    public String getJsonResult()
    {
        return jsonResult;
    }

    public void setJsonResult(String jsonResult)
    {
        this.jsonResult = jsonResult;
    }

    public String getErrorMsg()
    {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg)
    {
        this.errorMsg = errorMsg;
    }

    public String getOperStatus() {
        return operStatus;
    }

    public void setOperStatus(String operStatus) {
        this.operStatus = operStatus;
    }
}
