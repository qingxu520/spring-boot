package co.goho.qingxu.springboot.common.bean;

import co.goho.qingxu.springboot.common.utils.UuIdUtil;
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
    private static final long serialVersionUID = 1L;

    /*主键id*/
    @Id
    private String id;

    /*创建时间*/
    @Column(nullable = false)
    private Date createDate;

    /*更新时间*/
    @Column(nullable = false)
    private Date updateDate;

    /*创建人id*/
    @Column(nullable = false)
    private String createBy;

    /*更新人id*/
    @Column(nullable = false)
    private String updateBy;

    /*删除标识 0:未删除 ；1:已删除*/
    @Column(nullable = false)
    private String delFlag="0";

    /*是否新增 true*/
    @Transient
    private Boolean newFlag = true;

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
