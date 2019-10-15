package co.goho.qingxu.easy.shiro;

import co.goho.qingxu.easy.bean.SysMenu;
import co.goho.qingxu.easy.bean.SysRole;
import co.goho.qingxu.easy.bean.SysUser;
import co.goho.qingxu.easy.exception.user.*;
import co.goho.qingxu.easy.shiro.service.LoginService;
import co.goho.qingxu.easy.web.util.ShiroUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 自定义Realm 处理登录 权限
 */
public class UserRealm extends AuthorizingRealm {

    private static final Logger log = LoggerFactory.getLogger(UserRealm.class);

    @Autowired
    private LoginService loginService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SysUser user = ShiroUtils.getSysUser();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if(user.isAdmin()){
            info.addRole("admin");
            info.addStringPermission("*:*:*");
        }else {
            info.setRoles(getRoles(user.getRoles()));
            info.setStringPermissions(getMenus(user.getRoles()));
        }
        return info;
    }

    /**
     * 登录认证
     * AuthenticationToken是从表单穿过来封装好的对象
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName = token.getUsername();
        String passWord = "";
        if(token.getPassword()!=null){
            passWord = new String(token.getPassword());
        }
        SysUser user =null;
        try{
            user=loginService.login(userName,passWord);
        } catch (CaptchaException e) {
            throw new AuthenticationException(e.getMessage(), e);
        } catch (UserNotExistsException e) {
            throw new UnknownAccountException(e.getMessage(), e);
        } catch (UserPasswordNotMatchException e) {
            throw new IncorrectCredentialsException(e.getMessage(), e);
        } catch (UserPasswordRetryLimitExceedException e) {
            throw new ExcessiveAttemptsException(e.getMessage(), e);
        } catch (UserBlockedException e) {
            throw new LockedAccountException(e.getMessage(), e);
        } catch (RoleBlockedException e) {
            throw new LockedAccountException(e.getMessage(), e);
        } catch (Exception e) {
            log.info("对用户[" + userName + "]进行登录验证..验证未通过{}", e.getMessage());
            throw new AuthenticationException(e.getMessage(), e);
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, passWord, getName());
        return info;
    }

    public Set<String> getRoles(List<SysRole> roleList){
        Set<String> roles = new HashSet<>();
        if(roleList!=null&&!roleList.isEmpty()){
            for(SysRole role:roleList){
                roles.addAll(Arrays.asList(role.getRoleKey().trim().split(",")));
            }
        }
        return roles;
    }

    public Set<String> getMenus(List<SysRole> roleList){
        Set<String> roles = new HashSet<>();
        if(roleList!=null&&!roleList.isEmpty()){
            for(SysRole role:roleList){
                if(role.getMenus()!=null&&!role.getMenus().isEmpty()){
                    for(SysMenu menu:role.getMenus()){
                        roles.addAll(Arrays.asList(menu.getPerms().trim().split(",")));
                    }
                }}
            }
        return roles;
    }

    /**
     * 清理缓存权限
     */
    public void clearCachedAuthorizationInfo() {
        this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    }
}
