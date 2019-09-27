package co.goho.qingxu.springboot.pojo;

import co.goho.qingxu.springboot.common.bean.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Data相当于@Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode这5个注解的合集。
 * callSuper=true可以调用父类属性
 */
@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper=true)//callSuper=true可以调用父类属性
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_user")
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
