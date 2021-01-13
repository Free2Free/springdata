package xin.altitude.word.util;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.springframework.util.ClassUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Author explore
 * @Date 2021/01/13 22:41
 **/
public class BeetlUtils {
    private static org.beetl.core.Template t;

    private Template createGroupTemplate() throws IOException {
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader("files/");
        Configuration config = Configuration.defaultConfiguration();
        GroupTemplate groupTemplate = new GroupTemplate(resourceLoader, config);
//
//        String filepath = path+"files/table1.xml";
        Template template = groupTemplate.getTemplate("table1.btl");
        t = template;
        return template;
    }

    public void exportWord(HttpServletResponse response, Map<String, Object> dataMap) throws Exception {
        if (null == t) {
            createGroupTemplate();
        }
        response.setContentType("application/msword");
        response.setHeader("Content-Disposition", "attachment; filename=" + System.currentTimeMillis() + ".doc");
        t.binding(dataMap);
        t.renderTo(response.getOutputStream());
    }
}
