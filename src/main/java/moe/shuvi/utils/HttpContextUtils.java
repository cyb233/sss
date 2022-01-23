package moe.shuvi.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName HttpContextUtils
 * @Description TODO
 * @Author Administrator
 * @Date: 2022/1/4 15:27
 * @Version 1.0
 */
public class HttpContextUtils {
    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }
    /**
     * 判断是否是 ajax/app请求
     */
    public  static boolean isAjaxRequest(HttpServletRequest request){

        //客户端向服务器说明，客户端可以接收的数据类型
        String accept = request.getHeader("accept");
        //客户端发送的请求格式
        String xRequestedWith = request.getHeader("X-Requested-With");

        // 如果是异步请求或是手机端，则直接返回信息
        //手机端接收的是JSON
        //异步请求，接收也是JSON,发送是XMLHttpRequest
        return ((accept != null && accept.indexOf("application/json") != -1
                || (xRequestedWith != null && xRequestedWith.indexOf("XMLHttpRequest") != -1)
        ));
    }
}
