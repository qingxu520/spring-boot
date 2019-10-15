package co.goho.qingxu.easy.exception.user;

import co.goho.qingxu.easy.exception.base.BaseException;

/**
 * 用户信息异常类
 * 
 * @author ruoyi
 */
public class UserException extends BaseException {
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args) {
        super("user", code, args, null);
    }
}
