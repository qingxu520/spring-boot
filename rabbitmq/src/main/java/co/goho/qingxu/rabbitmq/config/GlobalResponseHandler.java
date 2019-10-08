package co.goho.qingxu.rabbitmq.config;

import co.goho.qingxu.rabbitmq.common.ResponseApi;
import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@Slf4j
@ControllerAdvice(annotations = {RestController.class, Controller.class})
public class GlobalResponseHandler implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        final String returnTypeName =methodParameter.getParameterType().getName();
        return !"co.goho.qingxu.rabbitmq.common.ResponseApi".equals(returnTypeName)
                && !"org.springframework.http.ResponseEntity".equals(returnTypeName);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        final String returnTypeName =methodParameter.getParameterType().getName();
        if("void".equals(returnTypeName)){
            return ResponseApi.OK();
        }
        if(!mediaType.includes(MediaType.APPLICATION_JSON)){
            return o;
        }
        if("co.goho.qingxu.rabbitmq.common.ResponseApi".equals(returnTypeName)){
            return o;
        }
        return ResponseApi.OK(o);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({DemoException.class})
    public <T> ResponseApi<T> handleException(DemoException e){
        log.error(Throwables.getStackTraceAsString(e));
        return ResponseApi.ERROR(e.getCode(),e.getMsg());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({Throwable.class})
    public <T> ResponseApi<T> handleThrowables(Throwable e){
        log.error(Throwables.getStackTraceAsString(e));
        return ResponseApi.ERROR(Throwables.getStackTraceAsString(e));
    }
}
