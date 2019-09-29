package co.goho.qingxu.jpaaop.pojo;

import co.goho.qingxu.jpaaop.common.bean.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @Data相当于@Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode这5个注解的合集。
 * callSuper=true可以调用父类属性
 */
@Entity(name = "tb_user")
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper=true)//callSuper=true可以调用父类属性
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(nullable = false)
    private String passWord;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String phone;
    @Column(nullable = false, unique = true)
    private String idcard;


}
