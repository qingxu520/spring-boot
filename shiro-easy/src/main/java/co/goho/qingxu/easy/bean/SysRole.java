package co.goho.qingxu.easy.bean;

import co.goho.qingxu.easy.conmmon.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * 角色表 sys_role
 **/
@Entity(name = "sys_role")
@ToString
@EqualsAndHashCode(callSuper=true)//callSuper=true可以调用父类属性
@NoArgsConstructor
@AllArgsConstructor
public class SysRole extends BaseEntity {
    @Transient
    private static final long serialVersionUID = 1L;

    /** 角色名称 */
    @Column
    private String roleName;

    /** 角色权限 */
    @Column
    private String roleKey;

    /** 角色排序 */
    @Column
    private Integer orderNum;

    /** 数据范围（1：所有数据权限；2：自定义数据权限；3：本部门数据权限；4：本部门及以下数据权限） */
    @Column
    private String dataScope;

    /** 角色状态（0正常 1停用） */
    @Column
    private String status = "0";

    /** 用户是否存在此角色标识 默认不存在 */
    @Column
    private boolean flag = false;

    /** 所属部门Id */
    @Column
    private String deptId;

    /** 所属部门*/
    @ManyToOne(fetch= FetchType.EAGER)//立即从数据库中进行加载数据;
    @JoinColumn(name = "deptId",insertable = false, updatable = false)
    private SysDept dept;

    /** 菜单组 */
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name="sys_role_menu",joinColumns={@JoinColumn(name="role_id")},inverseJoinColumns={@JoinColumn(name="menu_id")})
    @Fetch(FetchMode.SUBSELECT)
    private List<SysMenu> menus;

    @ManyToMany(fetch= FetchType.EAGER)//立即从数据库中进行加载数据;
    @JoinTable(name = "sys_user_role", joinColumns = { @JoinColumn(name = "role_id") }, inverseJoinColumns ={@JoinColumn(name = "user_id")})
    @Fetch(FetchMode.SUBSELECT)
    private List<SysUser> users;

    @NotBlank(message = "角色名称不能为空")
    @Size(min = 0, max = 30, message = "角色名称长度不能超过30个字符")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @NotBlank(message = "权限字符不能为空")
    @Size(min = 0, max = 100, message = "权限字符长度不能超过100个字符")
    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getDataScope() {
        return dataScope;
    }

    public void setDataScope(String dataScope) {
        this.dataScope = dataScope;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<SysMenu> getMenus() {
        return menus;
    }

    public void setMenus(List<SysMenu> menus) {
        this.menus = menus;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public SysDept getDept() {
        return dept;
    }

    public void setDept(SysDept dept) {
        this.dept = dept;
    }
}
