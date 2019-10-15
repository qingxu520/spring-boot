package co.goho.qingxu.easy.bean;

import co.goho.qingxu.easy.conmmon.base.BaseEntity;
import co.goho.qingxu.easy.conmmon.enums.OnlineStatus;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.Date;

/**
 * 当前在线会话 sys_user_online
 * 
 */
@Entity(name = "sys_user_online")
@ToString
@Getter
@Setter
@EqualsAndHashCode(callSuper=true)//callSuper=true可以调用父类属性
@NoArgsConstructor
@AllArgsConstructor
public class SysUserOnline extends BaseEntity {

    @Transient
    private static final long serialVersionUID = 1L;

    /** 部门名称 */
    @Column
    private String deptName;

    /** 登录名称 */
    @Column
    private String loginName;

    /** 登录IP地址 */
    @Column
    private String ipaddr;

    /** 登录地址 */
    @Column
    private String loginLocation;

    /** 浏览器类型 */
    @Column
    private String browser;

    /** 操作系统 */
    @Column
    private String os;

    /** session创建时间 */
    @Column
    private Date startTimestamp;

    /** session最后访问时间 */
    @Column
    private Date lastAccessTime;

    /** 超时时间，单位为分钟 */
    @Column
    private Long expireTime;

    /** 在线状态 */
    @Column
    private OnlineStatus onlineStatus = OnlineStatus.on_line;

}
