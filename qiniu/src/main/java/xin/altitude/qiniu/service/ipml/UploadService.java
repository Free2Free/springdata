package xin.altitude.qiniu.service.ipml;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
import xin.altitude.qiniu.entity.ResReservoirResource;
import xin.altitude.qiniu.mapper.UploadMapper;
import xin.altitude.qiniu.service.QiniuService;

import java.io.File;
import java.util.List;

/**
 * @author explore
 * @date 2020/11/01 13:47
 */
@Service
public class UploadService implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private UploadMapper uploadMapper;
    @Autowired
    private QiniuService qiniuService;

    public void test(){
        QueryWrapper<ResReservoirResource> wrapper = new QueryWrapper<ResReservoirResource>();
        wrapper.isNotNull("file_thumb_path");
        final List<ResReservoirResource> lists = uploadMapper.selectList(wrapper);
        String basePath = "bathPath";
        for (ResReservoirResource list : lists) {
            File file = new File(basePath+list.getFileThumbPath());
            if(file.exists()){
                System.out.println("路径"+lists.indexOf(list)+" = " + list.getFileThumbPath());
                qiniuService.uploadFile(file,list.getFileThumbPath().substring(1));
            }
        }

    }

    /**
     * 测试环境2
     */
    public void test2() {
        String filename = "/resResource/img/ee4f024e3e85447cab3b0ec91533d287/t_20201028142159.JPG";
        String basePath = "bathPath";
        File file = new File(basePath+filename);
        qiniuService.uploadFile(file,filename.substring(1));
    }

    /**
     * 程序启动后执行此方法
     * @param contextRefreshedEvent
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        test();
    }
}
