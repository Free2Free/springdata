package xin.altitude.redis.cluster.word.util;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @Author explore
 * @Date 2021/01/13 22:41
 **/
public class BeetlUtils {
    private static org.beetl.core.Template t;

    private static Template createGroupTemplate(String templateName) {
        try {
            templateName = templateName.replace(".btl", "");
            ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader("files/");
            Configuration config = Configuration.defaultConfiguration();
            GroupTemplate groupTemplate = new GroupTemplate(resourceLoader, config);
            addExtFunction(groupTemplate);
            Template template = groupTemplate.getTemplate(templateName + ".btl");
            t = template;
            return template;
        } catch (IOException e) {
        }
        return null;
    }

    /**
     * 向模版注册外部拓展函数
     * @param groupTemplate
     */
    private static void addExtFunction(GroupTemplate groupTemplate) {
        groupTemplate.registerFunctionPackage("temp", xin.altitude.redis.cluster.word.util.TemplateService.class);
    }

    /**
     * 将Map数据以word的形式导出
     *
     * @param response
     * @param dataMap      带转化的map数据
     * @param templateName 模版名称（不含后缀）
     */
    public static void exportWord(HttpServletResponse response, Map<String, Object> dataMap, String templateName) {
        exportWord(response, dataMap, templateName, null);
    }

    /**
     * 将Map数据以word的形式导出
     *
     * @param response
     * @param dataMap      带转化的map数据
     * @param templateName 模版名称（不含后缀）
     * @param fileName     导出word的文件名称
     */
    public static void exportWord(HttpServletResponse response, Map<String, Object> dataMap, String templateName, String fileName) {
        try {
            if (null == t) {
                createGroupTemplate(templateName);
            }
            response.setContentType("application/msword");
            if (fileName == null) {
                response.setHeader("Content-Disposition", "attachment; filename=" + System.currentTimeMillis() + ".doc");
            } else {
                response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName + ".doc", "utf-8"));
            }

            t.binding(dataMap);
            t.renderTo(response.getOutputStream());
        } catch (Exception e) {
        }
    }
}
