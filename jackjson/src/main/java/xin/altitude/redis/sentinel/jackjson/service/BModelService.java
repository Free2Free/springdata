package xin.altitude.redis.cluster.jackjson.service;/**
 * @author explore
 * @date 2020/11/14 15:13
 */

import org.springframework.stereotype.Service;
import xin.altitude.redis.cluster.jackjson.domain.BModel;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Date;

/**
 * @Author explore
 * @Date 2020/11/14 15:13
 **/
@Service
public class BModelService {
    /**
     * 初始化对象
     */
    public BModel getData(){
        BModel bModel = new BModel();
        bModel.setId(100L);
        bModel.setName("张三");
        bModel.setBirthDay(new Date());
        bModel.setAdult(true);
        bModel.setAge(12);
        bModel.setSalary(new BigDecimal("12.01", MathContext.DECIMAL64));
        return bModel;
    }
}
