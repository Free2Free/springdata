package xin.altitude.dynamicProxy.service;

/**
 * @Author explore
 * @Date 2021/03/10 13:00
 **/
public interface Subject {
    // 无参方法调用
    void request();

    // 有参方法调用
    String request(String name);
}
