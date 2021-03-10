package xin.altitude.dynamicProxy.service.impl;

import xin.altitude.dynamicProxy.service.Subject;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author explore
 * @Date 2021/03/10 13:03
 **/
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("啦啦啦，无参数方法调用，无返回值，用动态代理调用了就好");
    }

    @Override
    public String request(String name) {
        Map<String, Object> map = new HashMap<>();
        map.put("key", name);
        map.put("value", System.currentTimeMillis());
        String msg = "模拟缓存操作，缓存是应用动态代理的典型场景" + map;
        System.out.println(msg);
        return msg;
    }
}
