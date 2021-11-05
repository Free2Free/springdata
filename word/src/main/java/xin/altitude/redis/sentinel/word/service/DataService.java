package xin.altitude.redis.cluster.word.service;

import org.springframework.stereotype.Service;
import xin.altitude.redis.cluster.word.domain.BaseModel;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author explore
 * @Date 2021/01/13 20:23
 **/
@Service
public class DataService {
    /**
     * 查询数据列表1
     */
    public List<BaseModel> getlists1(){
        List<BaseModel> lists1 = new ArrayList<>();
        lists1.add(new BaseModel("运行管理","坝容坝貌提升","1"));
        lists1.add(new BaseModel("运行管理","白蚁防治","0"));
        lists1.add(new BaseModel("运行管理","档案","0"));
        lists1.add(new BaseModel("安全管理","安全鉴定","1"));
        lists1.add(new BaseModel("安全管理","水尺","1"));
        lists1.add(new BaseModel("信息化管理","三要素建设","1"));
        lists1.add(new BaseModel("信息化管理","量水堰","1"));
        lists1.add(new BaseModel("信息化管理","视频监控建设","1"));
        lists1.add(new BaseModel("信息化管理","720度全景建设","1"));
        lists1.add(new BaseModel("物业化管理","物业化管理","1"));
        lists1.add(new BaseModel("其它","其它","1"));
        return lists1;
    }

    /**
     * 查询数组的数组，支持纵向合并单元格
     * @return
     */
    public List<List<BaseModel>> getlists2(){
        List<List<BaseModel>> rs = new ArrayList<>();
        Map<String,List<BaseModel>> map = new LinkedHashMap<>();
        List<BaseModel> list = getlists1();
        for (BaseModel model : list) {
            if(!map.containsKey(model.getModule())){
                map.put(model.getModule(), new ArrayList<>());
            }
            map.get(model.getModule()).add(model);
        }
        for (List<BaseModel> value : map.values()) {
            rs.add(value);
        }
        return rs;
    }
}
