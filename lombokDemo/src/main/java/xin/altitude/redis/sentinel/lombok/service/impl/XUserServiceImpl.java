package xin.altitude.redis.cluster.lombok.service.impl;

import lombok.extern.log4j.Log4j2;
import xin.altitude.redis.cluster.lombok.domain.XUser;

/**
 * @Author explore
 * @Date 2021/05/18 17:01
 **/
@Log4j2
public class XUserServiceImpl {
    public void saveUser(XUser user) {
        log.info("此方法保存用户信息");
    }
}
