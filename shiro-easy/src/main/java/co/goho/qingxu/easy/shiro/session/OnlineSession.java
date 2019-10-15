package co.goho.qingxu.easy.shiro.session;

import co.goho.qingxu.easy.conmmon.enums.OnlineStatus;
import org.apache.shiro.session.mgt.SimpleSession;

/**
 * 在线用户会话属性
 * 
 * @author ruoyi
 */
public class OnlineSession extends SimpleSession {

    private static final long serialVersionUID = 1L;

    /** 用户ID */
    private String userId;

    /** 用户名称 */
    private String loginName;

    /** 部门名称 */
    private String deptName;
	
	/** 用户头像 */
	private String avatar;

    /** 登录IP地址 */
    private String host;

    /** 浏览器类型 */
    private String browser;

    /** 操作系统 */
    private String os;

    /** 在线状态 */
    private OnlineStatus onlineStatus = OnlineStatus.on_line;

    /** 属性是否改变 优化session数据同步 */
    private transient boolean attributeChanged = false;

    @Override
    public String getHost()
    {
        return host;
    }

    @Override
    public void setHost(String host)
    {
        this.host = host;
    }

    public String getBrowser()
    {
        return browser;
    }

    public void setBrowser(String browser)
    {
        this.browser = browser;
    }

    public String getOs()
    {
        return os;
    }

    public void setOs(String os)
    {
        this.os = os;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getLoginName()
    {
        return loginName;
    }

    public void setLoginName(String loginName)
    {
        this.loginName = loginName;
    }

    public OnlineStatus getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(OnlineStatus onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public void markAttributeChanged() {
        this.attributeChanged = true;
    }

    public void resetAttributeChanged() {
        this.attributeChanged = false;
    }

    public boolean isAttributeChanged() {
        return attributeChanged;
    }

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public void setAttribute(Object key, Object value)
    {
        super.setAttribute(key, value);
    }

    @Override
    public Object removeAttribute(Object key)
    {
        return super.removeAttribute(key);
    }
}
