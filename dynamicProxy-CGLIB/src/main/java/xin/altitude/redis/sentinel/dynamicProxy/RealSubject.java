package xin.altitude.redis.cluster.dynamicProxy;

/**
 * @Author explore
 * @Date 2021/03/10 17:15
 **/
public class RealSubject {
    public void request() {
        System.out.println("啦啦啦，无参数方法调用，无返回值，用动态代理调用了就好");
    }

    public String request(String name) {
        System.out.println("name = " + name);
        return name;
    }
}
