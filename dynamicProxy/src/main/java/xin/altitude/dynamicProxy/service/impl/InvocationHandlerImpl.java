package xin.altitude.dynamicProxy.service.impl;

import xin.altitude.dynamicProxy.service.Subject;

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
        System.out.println("在调用之前，我要干点啥呢？");
        Object returnValue = method.invoke(subject, args);
        System.out.println("在调用之后，我要干点啥呢？");
        return returnValue;
    }
}
