package co.goho.qingxu.mybatistag.common.bean;

import co.goho.qingxu.mybatistag.common.utils.UuIdUtil;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {
    protected static final long serialVersionUID = 1L;

    /*主键id*/
    protected String id;

    /*创建时间*/
    protected Date createDate;

    /*更新时间*/
    protected Date updateDate;

    /*创建人id*/
    protected String createBy;

    /*更新人id*/
    protected String updateBy;

    /*删除标识 0:未删除 ；1:已删除*/
    protected String delFlag = "0";

    /*是否新增 true*/
    protected Boolean newFlag = true;

    public void inParst() {
        setId(UuIdUtil.getUuID());
        setCreateBy("sys");
        setUpdateBy("sys");
        setCreateDate(new Date());
        setUpdateDate(getCreateDate());
    }

    public void upParst() {
        setUpdateBy("sys");
        setUpdateDate(new Date());
    }

}
