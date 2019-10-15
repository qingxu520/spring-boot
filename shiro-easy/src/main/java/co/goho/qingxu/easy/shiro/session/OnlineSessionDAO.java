package co.goho.qingxu.easy.shiro.session;

import co.goho.qingxu.easy.conmmon.enums.OnlineStatus;
import co.goho.qingxu.easy.shiro.service.SysShiroService;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;
import java.util.Date;

/**
 * EnterpriseCacheSessionDAO继承了CachingSessionDAO抽象类，
 * 定义了在缓存中保存session，更新session，删除session，读取session，获取所有的session集合等操作。
 *
 * 针对自定义的ShiroSession的db操作
 *
 * @author ruoyi
 */
public class OnlineSessionDAO extends EnterpriseCacheSessionDAO {
    /**
     * 同步session到数据库的周期 单位为毫秒（默认1分钟）
     */
    @Value("${shiro.session.dbSyncPeriod}")
    private int dbSyncPeriod;

    /**
     * 上次同步数据库的时间戳
     */
    private static final String LAST_SYNC_DB_TIMESTAMP = OnlineSessionDAO.class.getName() + "LAST_SYNC_DB_TIMESTAMP";

    @Autowired
    private SysShiroService sysShiroService;

    public OnlineSessionDAO() {
        super();
    }

    public OnlineSessionDAO(long expireTime) {
        super();
    }

    /**
     * 根据sessionId读取session信息
     *
     * 根据会话ID获取会话
     * @param sessionId 会话ID
     * @return ShiroSession
     */
    @Override
    protected Session doReadSession(Serializable sessionId) {
        return sysShiroService.getSession(sessionId);
    }

    /**
     * 更新操作
     * @param session
     * @throws UnknownSessionException
     */
    @Override
    public void update(Session session) throws UnknownSessionException {
        super.update(session);
    }

    /**
     * 更新会话；如更新会话最后访问时间/停止会话/设置超时时间/设置移除属性等会调用
     */
    public void syncToDb(OnlineSession onlineSession) {
        Date lastSyncTimestamp = (Date) onlineSession.getAttribute(LAST_SYNC_DB_TIMESTAMP);
        if (lastSyncTimestamp != null) {
            //session是否变化
            boolean needSync = true;
            long deltaTime = onlineSession.getLastAccessTime().getTime() - lastSyncTimestamp.getTime();
            if (deltaTime < dbSyncPeriod * 60 * 1000) {
                // 时间差不足 无需同步
                needSync = false;
            }
            // isGuest = true 访客
            boolean isGuest = onlineSession.getUserId() == null || onlineSession.getUserId() == "0";

            // session 数据变更了 同步
            if (isGuest == false && onlineSession.isAttributeChanged()) {
                needSync = true;
            }

            if (needSync == false) {
                return;
            }
        }
        // 更新上次同步数据库时间
        onlineSession.setAttribute(LAST_SYNC_DB_TIMESTAMP, onlineSession.getLastAccessTime());
        // 更新完后 重置标识
        if (onlineSession.isAttributeChanged()) {
            onlineSession.resetAttributeChanged();
        }
    }

    /**
     * 当会话过期/停止（如用户退出时）属性等会调用
     */
    @Override
    protected void doDelete(Session session) {
        OnlineSession onlineSession = (OnlineSession) session;
        if (null == onlineSession) {
            return;
        }
        onlineSession.setOnlineStatus(OnlineStatus.off_line);
        sysShiroService.deleteSession(onlineSession);
    }
}
