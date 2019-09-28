package co.goho.qingxu.mybatisone.pojo;

import co.goho.qingxu.mybatisone.common.bean.BaseEntity;
import lombok.*;

/**
 * @Data相当于@Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode这5个注解的合集。
 * callSuper=true可以调用父类属性
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper=true)//callSuper=true可以调用父类属性
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String name;
    private String userName;
    private String passWord;
    private String email;
    private String phone;
    private String idcard;


}
