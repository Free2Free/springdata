package xin.altitude.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @Author explore
 * @Date 2020/12/11 18:52
 **/
@Component
public class MyKeyGenerator implements KeyGenerator {

    @Override
    public Object generate(Object target, Method method, Object... params) {
        String tagetName = target.getClass().getName();
        String methodName = method.getName();
        String key = tagetName + "_" + methodName + "_" + params.toString();
        System.out.println("key = " + key);
        return key;
    }
}