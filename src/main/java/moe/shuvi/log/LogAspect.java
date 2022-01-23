package moe.shuvi.log;


import com.alibaba.fastjson.JSON;
import moe.shuvi.model.Log;
import moe.shuvi.service.LogService;
import moe.shuvi.utils.HttpContextUtils;
import moe.shuvi.utils.IPUtils;
import moe.shuvi.utils.JwtConstant;
import moe.shuvi.utils.JwtTokenUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @ClassName SysLogAspect
 * @Description TODO
 * @Author Administrator
 * @Date: 2022/1/4 14:09
 * @Version 1.0
 */
@Component
@Aspect
public class LogAspect {

    /**
     * 1.定位切点
     * 2.切入策略：around
     * 3.收集必要的日志数据，调用SysLogService进行日志记录
     */
    @Autowired
    private LogService logService;
    @Autowired
    private JwtTokenUtil tokenUtil;
    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    /**
     * 此处的切点是注解的方式
     * 只要出现 @LogAnnotation注解都会进入
     */
    @Pointcut("@annotation(moe.shuvi.log.LogAnnotation)")
    public void logPointCut(){

    }

    @Around(value = "logPointCut()")
    public Object doLog(ProceedingJoinPoint joinPoint){
        try {
            long before = System.currentTimeMillis();
            Object ret = joinPoint.proceed();//控制器方法
            long after = System.currentTimeMillis();
            long time = after-before;
            this.saveLog(joinPoint, time);
            return ret;
        }catch (Throwable e){
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

    public void saveLog(ProceedingJoinPoint joinPoint,long time)throws Exception{
        //1.控制器的执行时间-time
        //获取切点方法的相关信息
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        //切点方法
        Method method = methodSignature.getMethod();
        boolean annotationPresent = method.isAnnotationPresent(LogAnnotation.class);
        //如果方法上LogAnnotation注解存在
        String logOpertion="";
        if(annotationPresent){
            LogAnnotation logAnnotation = method.getAnnotation(LogAnnotation.class);
            String title = logAnnotation.title();
            String action = logAnnotation.action();
            //2.控制器上执行的操作-opertion
            logOpertion = title+"-"+action;
        }
        //方法名
        String methodName = method.getName();
        //目标类的完全限定名
        String className = joinPoint.getTarget().getClass().getName();
        //3.控制器上的具体method
        String logMethod = className+"."+methodName+"()";
        //传到控制器方法上的实参
        Object[] args = joinPoint.getArgs();
        //4.控制器上的实参params
        String logParams = JSON.toJSONString(args);
        //5.请求控制器的客户端IP
        HttpServletRequest req = HttpContextUtils.getHttpServletRequest();
        String ipAddr = IPUtils.getIpAddr(req);
        //6.记录当前日志的时间
        Date date = new Date();
        //7.获取当前操作的用户信息
        String token = req.getHeader(JwtConstant.ACCESS_TOKEN);

        String userId = tokenUtil.getUserId(token);
        String username = tokenUtil.getUserName(token);
//        System.out.println(token+"......."+ userId);
        //创建SysLog对像
        Log log = new Log();
        log.setTime((int)time);
        log.setUserId(Integer.parseInt(userId));
        log.setUsername(username);
        log.setCreateTime(date);
        log.setOperation(logOpertion);
        log.setMethod(logMethod);
        log.setParams(logParams);
        log.setIp(ipAddr);
        logService.addLog(log);
    }
}
