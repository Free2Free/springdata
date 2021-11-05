package xin.altitude.redis.cluster.qiniu.service;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;

import java.io.File;
import java.io.InputStream;

/**
 * @author explore
 * @date 2020/11/01 13:39
 */
public interface QiniuService {
    Response uploadFile(File file);

    Response uploadFile(File file, String key);

    Response uploadFile(InputStream inputStream);

    Response delete(String key) throws QiniuException;

    void afterPropertiesSet() throws Exception;
}
