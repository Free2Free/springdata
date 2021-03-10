package xin.altitude.dynamicProxy.service;

/**
 * @Author explore
 * @Date 2021/03/10 13:00
 **/
public interface Subject {
    /**
     * 无参方法调用
     *
     * @return
     */
    void request();

    /**
     * 有餐方法调用
     *
     * @param name
     * @return
     */
    String request(String name);
}
