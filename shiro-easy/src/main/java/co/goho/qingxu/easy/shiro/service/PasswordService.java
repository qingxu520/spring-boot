package co.goho.qingxu.easy.shiro.service;

import co.goho.qingxu.easy.bean.SysUser;
import co.goho.qingxu.easy.conmmon.constant.ShiroConstants;
import co.goho.qingxu.easy.exception.user.UserPasswordNotMatchException;
import co.goho.qingxu.easy.exception.user.UserPasswordRetryLimitCountException;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class PasswordService {

    @Autowired
    private CacheManager cacheManager;

    private Cache<String, AtomicInteger> loginRecordCache;

    @Value(value = "${user.password.maxRetryCount}")
    private Integer maxRetryCount;

    @PostConstruct
    public void init(){
        loginRecordCache=cacheManager.getCache(ShiroConstants.LOGINRECORDCACHE);
    }

    public void validate(SysUser sysUser,String passWord){
        String userName=sysUser.getUserName();
        AtomicInteger retryCount = loginRecordCache.get(userName);
        if(retryCount==null){
            retryCount=new AtomicInteger(0);
            loginRecordCache.put(userName,retryCount);
        }
        //递增
        if(retryCount.incrementAndGet()>maxRetryCount){
            throw new UserPasswordRetryLimitCountException(maxRetryCount);
        }
        if(!matches(sysUser,passWord)){
            throw new UserPasswordNotMatchException();
        }else {
            loginRecordCache.remove(userName);
        }

    }

    public boolean matches(SysUser user, String newPassword) {
        return user.getPassWord().equals(encryptPassword(user.getUserName(), newPassword, user.getSalt()));
    }

    /**
     * 加密
     * @param username
     * @param password
     * @param salt
     * @return
     */
    public String encryptPassword(String username, String password, String salt) {
        return new Md5Hash(username + password + salt).toHex().toString();
    }

}
