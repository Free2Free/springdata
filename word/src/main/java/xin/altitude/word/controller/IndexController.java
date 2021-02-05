package xin.altitude.word.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.word.domain.BaseModel;
import xin.altitude.word.service.DataService;
import xin.altitude.word.util.BeetlUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author explore
 * @Date 2021/01/13 20:19
 **/
@RestController
public class IndexController {
    @Autowired
    private DataService dataService;

    @GetMapping("/data1")
    public List<BaseModel> getData1(){
        return dataService.getlists1();
    }

    @GetMapping("/data2")
    public List<List<BaseModel>> getData2(){
        return dataService.getlists2();
    }


    @GetMapping("/download2")
    public void docFileDownload2(HttpServletResponse response) throws Exception {
        Map<String,Object> map = new HashMap<>();
        List<List<BaseModel>> baseModels = dataService.getlists2();
        map.put("listData",baseModels);
        BeetlUtils.exportWord(response,map,"table2");
    }


    /**
     * 纵向合并单元格
     * @param response
     * @throws Exception
     */
    @GetMapping("/download3")
    public void docFileDownload3(HttpServletResponse response) throws Exception {
        Map<String,Object> map = new HashMap<>();
        List<BaseModel> baseModels = dataService.getlists1();
        map.put("listData",baseModels);
        BeetlUtils.exportWord(response,map,"table3");
    }
}
