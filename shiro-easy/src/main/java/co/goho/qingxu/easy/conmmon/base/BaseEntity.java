package co.goho.qingxu.easy.conmmon.base;

import co.goho.qingxu.easy.bean.SysUser;
import co.goho.qingxu.easy.conmmon.utils.UuIdUtil;
import co.goho.qingxu.easy.web.util.ShiroUtils;
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

    /*状态 0:正常 ；1:停用; 2:删除*/
    @Column(nullable = false)
    protected String status="0";

    /*是否新增 true*/
    @Transient
    protected Boolean newFlag = true;

    /** 备注 */
    @Column
    private String remark;

    public void inParst(){
        setId(UuIdUtil.getUuID());
        SysUser user = ShiroUtils.getSysUser();
        if(user!=null){
            setCreateBy(user.getId());
            setUpdateBy(user.getId());
        }else {
            setCreateBy("system");
            setUpdateBy("system");
        }
        setCreateDate(new Date());
        setUpdateDate(getCreateDate());
    }

    public void upParst(){
        SysUser user = ShiroUtils.getSysUser();
        setUpdateDate(new Date());
    }

}
