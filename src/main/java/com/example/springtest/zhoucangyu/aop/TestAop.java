package com.example.springtest.zhoucangyu.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// 切面，即一个包含切入点和通知的类
@Aspect
// 将此类实例化并加入到ioc容器之中
@Component
public class TestAop {

    // 获取日志模块
    private static final Logger logger = LoggerFactory.getLogger(TestAop.class);

    // 配置切入点
    // 即设置哪些代码往里面塞代码
    // 这里是指com.example.springtest.zhoucangyu.controller包下所有的类的所有方法，执行过程中都会加入aop的代码
    @Pointcut("execution(* com.example.springtest.zhoucangyu.controller..*(..))")  // 代表切入点，即程序执行中一个明确的点
    // pointcut是函数名，也是标记一个切入点的唯一标识
    public void pointcut() {
    }

    // 配置切入点代码执行前需要执行的代码
    // @Before的参数pointcut()标识了是在哪个切入点前运行
    @Before("pointcut()")
    public void before() {
        logger.info("我是在切入点代码运行前面运行的代码----before");
    }

    // 配置切入点代码执行之后需要执行的代码
    @After("pointcut()")
    public void after() {
        logger.info("我是在切入点代码运行后面运行的代码----after");
    }

    // 配置切入点代码运行完成并正常返回后需要执行的代码
    @AfterReturning("pointcut()")  //后置返回
    public void afterReturning() {
        logger.info("我是在切入点代码运行完成并正常返回后运行的代码----afterReturning");
    }

    // 配置切入点代码运行中抛出了异常时需要执行的代码
    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        logger.info("我是在切入点代码运行中抛出异常后运行的代码----afterThrowing");
    }

    // 环绕通知
    // 它可以自由的配置代码切入的方式
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("我是在回调切入点方法之前的代码----around");
        // 这步是显示回调切入点的原有代码，即controller包的类下的方法被执行
        // 如果不显式的调用，原方法将不会被执行
        // 需要获取返回值并return，否则原方法只会运行，但不会触发return
        Object result = proceedingJoinPoint.proceed();
        logger.info("我是在回调切入点方法之后的代码----around");
        return result;
    }

}
