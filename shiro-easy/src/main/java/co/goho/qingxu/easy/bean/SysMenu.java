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
 * 菜单权限表 sys_menu
 * 
 */
@Entity(name = "sys_menu")
@ToString
@EqualsAndHashCode(callSuper=true)//callSuper=true可以调用父类属性
@NoArgsConstructor
@AllArgsConstructor
public class SysMenu extends BaseEntity {
    @Transient
    private static final long serialVersionUID = 1L;

    /** 菜单名称 */
    @Column
    private String menuName;

    /** 父菜单名称 */
    @Column
    private String parentName;

    /** 父菜单ID */
    @Column
    private String parentId;

    /** 显示顺序 */
    @Column
    private Integer orderNum;

    /** 菜单URL */
    @Column
    private String url;

    /** 打开方式：menuItem页签 menuBlank新窗口 */
    @Column
    private String target;

    /** 类型:0目录,1菜单,2按钮 */
    @Column
    private String menuType;

    /** 菜单状态:0显示,1隐藏 */
    @Column
    private String visible;

    /** 权限字符串 */
    @Column
    private String perms;

    /** 菜单图标 */
    @Column
    private String icon;

    /** 子菜单 */
    @OneToMany(fetch= FetchType.EAGER)//立即从数据库中进行加载数据;
    @JoinColumn(name = "parentId",insertable = false, updatable = false)
    @Fetch(FetchMode.SUBSELECT)
    private List<SysMenu> children;

    /** 菜单组 */
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name="sys_role_menu",joinColumns={@JoinColumn(name="menu_id")},inverseJoinColumns={@JoinColumn(name="role_id")})
    @Fetch(FetchMode.SUBSELECT)
    private List<SysRole> roles;

    @NotBlank(message = "菜单名称不能为空")
    @Size(min = 0, max = 50, message = "菜单名称长度不能超过50个字符")
    public String getMenuName()
    {
        return menuName;
    }

    public void setMenuName(String menuName)
    {
        this.menuName = menuName;
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

    @NotBlank(message = "显示顺序不能为空")
    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }


    @Size(min = 0, max = 200, message = "请求地址不能超过200个字符")
    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getTarget()
    {
        return target;
    }

    public void setTarget(String target)
    {
        this.target = target;
    }

    @NotBlank(message = "菜单类型不能为空")
    public String getMenuType()
    {
        return menuType;
    }

    public void setMenuType(String menuType)
    {
        this.menuType = menuType;
    }

    public String getVisible()
    {
        return visible;
    }

    public void setVisible(String visible)
    {
        this.visible = visible;
    }

    @Size(min = 0, max = 100, message = "权限标识长度不能超过100个字符")
    public String getPerms()
    {
        return perms;
    }

    public void setPerms(String perms)
    {
        this.perms = perms;
    }

    public String getIcon()
    {
        return icon;
    }

    public void setIcon(String icon)
    {
        this.icon = icon;
    }

    public List<SysMenu> getChildren()
    {
        return children;
    }

    public void setChildren(List<SysMenu> children)
    {
        this.children = children;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }
}
