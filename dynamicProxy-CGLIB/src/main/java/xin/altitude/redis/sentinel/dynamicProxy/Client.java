package xin.altitude.redis.cluster.dynamicProxy;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import org.junit.Test;

/**
 * @Author explore
 * @Date 2021/03/10 17:19
 **/
public class Client {
    @Test
    public void test01() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(xin.altitude.redis.cluster.dynamicProxy.RealSubject.class);
        enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {
            System.out.println("before method run...");
            Object result = proxy.invokeSuper(obj, args);
            System.out.println("after method run...");
            return result;
        });
        xin.altitude.redis.cluster.dynamicProxy.RealSubject realSubject = (xin.altitude.redis.cluster.dynamicProxy.RealSubject) enhancer.create();
        realSubject.request("john");
    }
}
