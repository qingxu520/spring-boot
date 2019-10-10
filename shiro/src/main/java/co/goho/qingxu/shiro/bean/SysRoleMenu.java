package co.goho.qingxu.shiro.bean;

import co.goho.qingxu.shiro.common.bean.BaseEntity;
import lombok.*;

import javax.persistence.Entity;

/**
 * 角色和菜单关联 sys_role_menu
 * 
 */
@Entity(name = "sys_user_role")
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper=true)//callSuper=true可以调用父类属性
@NoArgsConstructor
@AllArgsConstructor
public class SysRoleMenu extends BaseEntity {
    /** 角色ID */
    private String roleId;
    
    /** 菜单ID */
    private String menuId;

}
