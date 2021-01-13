package xin.altitude.word.controller;

import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.word.domain.BaseModel;
import xin.altitude.word.service.DataService;
import xin.altitude.word.service.WordService;
import xin.altitude.word.util.BeetlUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    @Autowired
    private WordService wordService;

    @GetMapping("/data")
    public List<BaseModel> getData1(){
        return dataService.getlists1();
    }

    @GetMapping("/download")
    public void docFileDownload(HttpServletResponse response) throws IOException {
        wordService.saveWorldFile(response);
    }

    @GetMapping("/download2")
    public void docFileDownload2(HttpServletResponse response) throws Exception {
        Map<String,Object> map = new HashMap<>();
        List<BaseModel> baseModels = dataService.getlists1();
        map.put("listData",baseModels);
        new BeetlUtils().exportWord(response,map);
    }
}
