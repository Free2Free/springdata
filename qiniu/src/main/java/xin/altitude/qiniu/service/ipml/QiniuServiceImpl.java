package xin.altitude.qiniu.service.ipml;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import xin.altitude.qiniu.service.QiniuService;

import java.io.File;
import java.io.InputStream;

/**
 * @author explore
 * @date 2020/11/01 13:38
 */
@Service
public class QiniuServiceImpl implements QiniuService {
    @Autowired
    private UploadManager uploadManager;

    @Autowired
    private BucketManager bucketManager;

    @Autowired
    private Auth auth;

    @Value("${qiniu.Bucket}")
    private String bucket;

    /**
     * 定义七牛云上传的相关策略
     */
    private StringMap putPolicy;


    /**
     * 以文件的形式上传(七牛云自动生成文件名)
     *
     * @param file
     * @return
     * @throws QiniuException
     */
    @Override
    public Response uploadFile(File file) {
        return uploadFile(file,null);
    }

    /**
     * 以文件的形式上传(七牛云自动生成文件名)
     *
     * @param file
     * @return
     * @throws QiniuException
     */
    @Override
    public Response uploadFile(File file,String key) {
        try {
            Response response = this.uploadManager.put(file, key, getUploadToken());
            int retry = 0;
            while (response.needRetry() && retry < 3) {
                response = this.uploadManager.put(file, null, getUploadToken());
                retry++;
            }
            return response;
        } catch (QiniuException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 以流的形式上传
     *
     * @param inputStream
     * @return
     * @throws QiniuException
     */
    @Override
    public Response uploadFile(InputStream inputStream) {
        try {
            Response response = this.uploadManager.put(inputStream, null, getUploadToken(), null, null);
            int retry = 0;
            while (response.needRetry() && retry < 3) {
                response = this.uploadManager.put(inputStream, null, getUploadToken(), null, null);
                retry++;
            }
            return response;
        } catch (QiniuException e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 删除七牛云上的相关文件
     *
     * @param key
     * @return
     * @throws QiniuException
     */
    @Override
    public Response delete(String key) throws QiniuException {
        Response response = bucketManager.delete(this.bucket, key);
        int retry = 0;
        while (response.needRetry() && retry++ < 3) {
            response = bucketManager.delete(bucket, key);
        }
        return response;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        this.putPolicy = new StringMap();
        putPolicy.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"width\":$(imageInfo.width), \"height\":${imageInfo.height}}");
    }

    /**
     * 获取上传凭证
     *
     * @return
     */
    private String getUploadToken() {
        return this.auth.uploadToken(bucket, null, 3600, putPolicy);
    }
}
