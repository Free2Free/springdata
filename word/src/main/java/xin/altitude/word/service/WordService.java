package xin.altitude.word.service;

import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import xin.altitude.word.domain.BaseModel;
import xin.altitude.word.util.FreemarkerUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author explore
 * @Date 2021/01/13 21:13
 **/
@Service
public class WordService {
    @Autowired
    private DataService dataService;

    public String getHtmlStr() throws FileNotFoundException {
        List<BaseModel> baseModels = dataService.getlists1();
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        String filepath = path+"/files/table1.ftl";
        Map<String,Object> map = new HashMap<>();
        map.put("listData",baseModels);
        return FreemarkerUtils.process(new FileReader(filepath),map);
    }

    public void saveWorldFile(HttpServletResponse response) throws IOException {
        String htmlStr = getHtmlStr();
        byte b[] = htmlStr.getBytes("utf-8");  //这里是必须要设置编码的，不然导出中文就会乱码。
        ByteArrayInputStream bais = new ByteArrayInputStream(b);//将字节数组包装到流中
        POIFSFileSystem poifs = new POIFSFileSystem();
        DirectoryEntry directory = poifs.getRoot();
        DocumentEntry documentEntry = directory.createDocument("WordDocument", bais);
        //========================
        // 清空response
        response.reset();
        // 设置response的Header
        response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(
                System.currentTimeMillis() + ".doc", "utf-8"));
        poifs.writeFilesystem(response.getOutputStream());
        bais.close();
        response.getOutputStream().close();
        poifs.close();
        //========================
    }
}
