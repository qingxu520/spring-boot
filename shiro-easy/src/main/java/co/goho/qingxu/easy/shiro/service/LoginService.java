package co.goho.qingxu.easy.shiro.service;

import co.goho.qingxu.easy.bean.SysUser;
import co.goho.qingxu.easy.conmmon.constant.Constants;
import co.goho.qingxu.easy.conmmon.constant.ShiroConstants;
import co.goho.qingxu.easy.conmmon.constant.UserConstants;
import co.goho.qingxu.easy.conmmon.enums.UserStatus;
import co.goho.qingxu.easy.conmmon.utils.DateUtils;
import co.goho.qingxu.easy.conmmon.utils.MessageUtils;
import co.goho.qingxu.easy.conmmon.utils.ServletUtils;
import co.goho.qingxu.easy.conmmon.utils.StringUtils;
import co.goho.qingxu.easy.exception.user.*;
import co.goho.qingxu.easy.manager.AsyncManager;
import co.goho.qingxu.easy.manager.factory.AsyncFactory;
import co.goho.qingxu.easy.service.SysUserService;
import co.goho.qingxu.easy.web.util.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginService {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private PasswordService passwordService;


    public SysUser login(String userName,String passWord){

        // 验证码校验
        if (!org.springframework.util.StringUtils.isEmpty(ServletUtils.getRequest().getAttribute(ShiroConstants.CURRENT_CAPTCHA))) {
            AsyncManager.me().execute(AsyncFactory.recordlogininfo(userName, Constants.LOGIN_FAIL, MessageUtils.message("user.jcaptcha.error")));
            throw new CaptchaException();
        }
        if(StringUtils.isEmpty(userName)||StringUtils.isEmpty(passWord)){
            AsyncManager.me().execute(AsyncFactory.recordlogininfo(userName, Constants.LOGIN_FAIL, MessageUtils.message("not.null")));
            throw  new UserNotExistsException();
        }
        // 密码如果不在指定范围内 错误
        if (passWord.length() < UserConstants.PASSWORD_MIN_LENGTH || passWord.length() > UserConstants.PASSWORD_MAX_LENGTH) {
            AsyncManager.me().execute(AsyncFactory.recordlogininfo(userName, Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match")));
            throw new UserPasswordNotMatchException();
        }
        // 用户名不在指定范围内 错误
        if (userName.length() < UserConstants.USERNAME_MIN_LENGTH || userName.length() > UserConstants.USERNAME_MAX_LENGTH) {
            AsyncManager.me().execute(AsyncFactory.recordlogininfo(userName, Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match")));
            throw new UserPasswordNotMatchException();
        }
        SysUser user = sysUserService.findByUserName(userName);
        if(user==null && maybeMobilePhoneNumber(userName)){
            user = sysUserService.findByPhone(userName);
        }
        if(user==null && maybeEmail(userName)){
            user=sysUserService.findByEmail(userName);
        }
        if(user==null){
            AsyncManager.me().execute(AsyncFactory.recordlogininfo(userName, Constants.LOGIN_FAIL, MessageUtils.message("user.not.exists")));
            throw new UserNotExistsException();
        }
        //用户停用
        if(UserStatus.DISABLE.getCode().equals(user.getStatus())){
            AsyncManager.me().execute(AsyncFactory.recordlogininfo(userName, Constants.LOGIN_FAIL, MessageUtils.message("user.blocked", user.getRemark())));
            throw new UserBlockedException();
        }
        //用户删除
        if(UserStatus.DELETED.getCode().equals(user.getStatus())){
            AsyncManager.me().execute(AsyncFactory.recordlogininfo(userName, Constants.LOGIN_FAIL, MessageUtils.message("user.password.delete")));
            throw new UserDeleteException();
        }
        passwordService.validate(user, passWord);
        AsyncManager.me().execute(AsyncFactory.recordlogininfo(userName, Constants.LOGIN_SUCCESS, MessageUtils.message("user.login.success")));
        recordLoginInfo(user);
        return user;

    }
    /**
     * 邮箱格式
     */
    private boolean maybeEmail(String username) {
        if (!username.matches(UserConstants.EMAIL_PATTERN)) {
            return false;
        }
        return true;
    }

    /**
     * 手机号码格式
     */
    private boolean maybeMobilePhoneNumber(String username) {
        if (!username.matches(UserConstants.MOBILE_PHONE_NUMBER_PATTERN)) {
            return false;
        }
        return true;
    }

    /**
     * 记录登录信息
     */
    public void recordLoginInfo(SysUser user) {
        user.setLoginIp(ShiroUtils.getIp());
        user.setLoginDate(DateUtils.getNowDate());
        sysUserService.updateUserInfo(user);
    }
}
