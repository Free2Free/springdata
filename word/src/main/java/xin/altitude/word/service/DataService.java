package xin.altitude.word.service;

import org.springframework.stereotype.Service;
import xin.altitude.word.domain.BaseModel;

import java.util.ArrayList;
import java.util.List;

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
        lists1.add(new BaseModel("基础管理","制度类","1","1"));
        lists1.add(new BaseModel("基础管理","防汛道路维修","0","1"));
        lists1.add(new BaseModel("运行管理","坝容坝貌提升","0","1"));
        lists1.add(new BaseModel("运行管理","白蚁防治","1","1"));
        return lists1;
    }
}
