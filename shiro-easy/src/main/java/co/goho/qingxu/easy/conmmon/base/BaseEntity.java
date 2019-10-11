package co.goho.qingxu.easy.conmmon.base;

import co.goho.qingxu.easy.conmmon.utils.UuIdUtil;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Transient
    protected static final long serialVersionUID = 1L;

    /*主键id*/
    @Id
    protected String id;

    /*创建时间*/
    @Column(nullable = false)
    protected Date createDate;

    /*更新时间*/
    @Column(nullable = false)
    protected Date updateDate;

    /*创建人id*/
    @Column(nullable = false)
    protected String createBy;

    /*更新人id*/
    @Column(nullable = false)
    protected String updateBy;

    /*删除标识 0:未删除 ；1:已删除*/
    @Column(nullable = false)
    protected String delFlag="0";

    /*是否新增 true*/
    @Transient
    protected Boolean newFlag = true;

    public void inParst(){
        setId(UuIdUtil.getUuID());
        setCreateBy("sys");
        setUpdateBy("sys");
        setCreateDate(new Date());
        setUpdateDate(getCreateDate());
    }

    public void upParst(){
        setUpdateBy("sys");
        setUpdateDate(new Date());
    }

}
