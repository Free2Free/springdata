package xin.altitude.dynamicProxy;

import org.junit.jupiter.api.Test;
import xin.altitude.dynamicProxy.service.Subject;
import xin.altitude.dynamicProxy.service.impl.InvocationHandlerImpl;
import xin.altitude.dynamicProxy.service.impl.RealSubject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 客户端调用
 *
 * @Author explore
 * @Date 2021/03/10 13:13
 **/
public class Client {
    @Test
    void test01() {
        RealSubject realSubject = new RealSubject();
        InvocationHandler handler = new InvocationHandlerImpl(realSubject);

        ClassLoader loader = realSubject.getClass().getClassLoader();
        Class[] interfaces = realSubject.getClass().getInterfaces();
        /**
         * 该方法用于为指定类装载器、一组接口及调用处理器生成动态代理类实例
         */
        Subject subject = (Subject) Proxy.newProxyInstance(loader, interfaces, handler);

        subject.request();
    }


    @Test
    void test02() {
        RealSubject realSubject = new RealSubject();
        InvocationHandler handler = new InvocationHandlerImpl(realSubject);

        ClassLoader loader = realSubject.getClass().getClassLoader();
        Class[] interfaces = realSubject.getClass().getInterfaces();
        /**
         * 该方法用于为指定类装载器、一组接口及调用处理器生成动态代理类实例
         */
        Subject subject = (Subject) Proxy.newProxyInstance(loader, interfaces, handler);

        String returnValue = subject.request("john");
        System.out.println("返回值：" + returnValue);
    }
}
