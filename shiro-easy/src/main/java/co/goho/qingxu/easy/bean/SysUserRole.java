package co.goho.qingxu.easy.bean;

import co.goho.qingxu.easy.conmmon.base.BaseEntity;
import lombok.*;

import javax.persistence.Entity;

/**
 * 用户和角色关联 sys_user_role
 * 
 */
@Entity(name = "sys_user_role")
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper=true)//callSuper=true可以调用父类属性
@NoArgsConstructor
@AllArgsConstructor
public class SysUserRole extends BaseEntity {
    /** 用户ID */
    private String userId;
    
    /** 角色ID */
    private String roleId;
}
