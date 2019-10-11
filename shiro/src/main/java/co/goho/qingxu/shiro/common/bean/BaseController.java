package co.goho.qingxu.shiro.common.bean;

import co.goho.qingxu.shiro.common.utils.DateUtils;
import co.goho.qingxu.shiro.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.util.Date;

/**
 * web层通用数据处理
 * 
 * @author ruoyi
 */
public class BaseController
{
    protected final Logger logger = LoggerFactory.getLogger(BaseController.class);

    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     */
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport()
        {
            @Override
            public void setAsText(String text)
            {
                setValue(DateUtils.parseDate(text));
            }
        });
    }

    /**
     * 响应返回结果
     * 
     * @param rows 影响行数
     * @return 操作结果
     */
    protected ResponseResult toAjax(int rows)
    {
        return rows > 0 ? success() : error();
    }

    /**
     * 响应返回结果
     * 
     * @param result 结果
     * @return 操作结果
     */
    protected ResponseResult toAjax(boolean result)
    {
        return result ? success() : error();
    }

    /**
     * 返回成功
     */
    public ResponseResult success()
    {
        return ResponseResult.success();
    }

    /**
     * 返回失败消息
     */
    public ResponseResult error()
    {
        return ResponseResult.error();
    }

    /**
     * 返回成功消息
     */
    public ResponseResult success(String message)
    {
        return ResponseResult.success(message);
    }

    /**
     * 返回失败消息
     */
    public ResponseResult error(String message)
    {
        return ResponseResult.error(message);
    }

    /**
     * 返回错误码消息
     */
    public ResponseResult error(ResponseResult.Type type, String message)
    {
        return new ResponseResult(type, message);
    }

    /**
     * 页面跳转
     */
    public String redirect(String url)
    {
        return StringUtils.format("redirect:{}", url);
    }
}
