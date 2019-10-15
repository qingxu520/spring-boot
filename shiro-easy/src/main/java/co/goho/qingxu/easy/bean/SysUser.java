package co.goho.qingxu.easy.bean;

import co.goho.qingxu.easy.conmmon.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * @Data相当于@Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode这5个注解的合集。
 * callSuper=true可以调用父类属性
 */
@Entity(name = "sys_user")
@ToString
@EqualsAndHashCode(callSuper=true)//callSuper=true可以调用父类属性
@NoArgsConstructor
@AllArgsConstructor
public class SysUser extends BaseEntity {
    @Transient
    private static final long serialVersionUID = 1L;

    /** 姓名 */
    @Column(nullable = false)
    private String name;

    /** 性别 */
    @Column
    private String sex;

    /** 用户名 */
    @Column(nullable = false, unique = true)
    private String userName;

    /** 密码 */
    @Column(nullable = false)
    private String passWord;

    /** 邮箱 */
    @Column(nullable = false, unique = true)
    private String email;

    /** 电话 */
    @Column(nullable = false, unique = true)
    private String phone;

    /** 身份证 */
    @Column(nullable = false, unique = true)
    private String idcard;

    /** 用户头像 */
    @Column
    private String avatar;

    /** 盐加密 */
    @Column
    private String salt;

    /** 所属部门Id */
    @Column
    private String deptId;

    /** 最后登陆IP */
    @Column
    private String loginIp;

    /** 最后登陆时间 */
    @Column
    private Date loginDate;

    /** 所属部门*/
    @ManyToOne(fetch= FetchType.EAGER)//立即从数据库中进行加载数据;
    @JoinColumn(name="deptId",insertable = false, updatable = false)
    private SysDept dept;

    @ManyToMany(fetch= FetchType.EAGER)//立即从数据库中进行加载数据;
    @JoinTable(name = "sys_user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns ={@JoinColumn(name = "role_id")})
    @Fetch(FetchMode.SUBSELECT)
    private List<SysRole> roles;


    public boolean isAdmin() {
        return this.id != null && "1".equals(this.id);
    }

    @NotBlank(message = "姓名不能为空")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotBlank(message = "登录账号不能为空")
    @Size(min = 0, max = 30, message = "登录账号长度不能超过30个字符")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @NotBlank(message = "密码不能为空")
    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Email(message = "邮箱格式不正确")
    @Size(min = 0, max = 50, message = "邮箱长度不能超过50个字符")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Size(min = 0, max = 11, message = "手机号码长度不能超过11个字符")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @NotBlank(message = "身份证不能为空")
    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public SysDept getDept() {
        return dept;
    }

    public void setDept(SysDept dept) {
        this.dept = dept;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
}
