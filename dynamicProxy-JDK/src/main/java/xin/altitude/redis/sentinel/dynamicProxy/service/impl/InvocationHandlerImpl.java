package xin.altitude.redis.cluster.dynamicProxy.service.impl;

import xin.altitude.redis.cluster.dynamicProxy.service.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author explore
 * @Date 2021/03/10 13:09
 **/
public class InvocationHandlerImpl implements InvocationHandler {
    private Subject subject;

    public InvocationHandlerImpl(Subject subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("【模拟AOP注解缓存】：在调用之前，先检查是否有缓存，有就直接返回，没有就继续执行方法。");
        Object returnValue = method.invoke(subject, args);
        System.out.println("【模拟AOP注解缓存】：在调用之后，将方法执行结果存入缓存。");
        return returnValue;
    }
}
