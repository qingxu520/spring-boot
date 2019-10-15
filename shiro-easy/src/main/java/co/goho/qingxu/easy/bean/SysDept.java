package co.goho.qingxu.easy.bean;

import co.goho.qingxu.easy.conmmon.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * 部门表 sys_dept
 * 
 * @author ruoyi
 */
@Entity(name = "sys_dept")
@ToString
@EqualsAndHashCode(callSuper=true)//callSuper=true可以调用父类属性
@NoArgsConstructor
@AllArgsConstructor
public class SysDept extends BaseEntity {
    @Transient
    private static final long serialVersionUID = 1L;

    /** 父部门ID */
    @Column
    private String parentId;

    /** 部门名称 */
    @Column
    private String deptName;

    /** 显示顺序 */
    @Column
    private Integer orderNum;

    /** 负责人 */
    @Column
    private String leader;

    /** 联系电话 */
    @Column
    private String phone;

    /** 邮箱 */
    @Column
    private String email;

    /** 父部门名称 */
    @Column
    private String parentName;

    /** 下级部门 */
    @OneToMany(fetch= FetchType.EAGER)//立即从数据库中进行加载数据;
    @JoinColumn(name = "parentId" ,insertable = false, updatable = false)
    @Fetch(FetchMode.SUBSELECT)
    private List<SysDept> children;

    @NotBlank(message = "部门名称不能为空")
    @Size(min = 0, max = 30, message = "部门名称长度不能超过30个字符")
    public String getDeptName()
    {
        return deptName;
    }

    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
    }

    @NotBlank(message = "显示顺序不能为空")
    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getLeader()
    {
        return leader;
    }

    public void setLeader(String leader)
    {
        this.leader = leader;
    }

    @Size(min = 0, max = 11, message = "联系电话长度不能超过11个字符")
    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    @Email(message = "邮箱格式不正确")
    @Size(min = 0, max = 50, message = "邮箱长度不能超过50个字符")
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getParentName()
    {
        return parentName;
    }

    public void setParentName(String parentName)
    {
        this.parentName = parentName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<SysDept> getChildren() {
        return children;
    }

    public void setChildren(List<SysDept> children) {
        this.children = children;
    }

}
