package xin.altitude.word.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Map;

/**
 * @author lyl
 * freemarker 模板对象转成字符串
 */
public class FreemarkerUtils {

    private static Logger logger = LoggerFactory.getLogger(FreemarkerUtils.class);

    /**
     * @param template      模板数据
     * @param model         模板数据中的模板   key：模板对象  value：替换的数据
     * @param configuration
     * @return
     */
    public static String process(String template, Map<String, ?> model, Configuration configuration) {
        try {
            if (template == null) {
                return null;
            }
            if (configuration == null) {
                configuration = new Configuration(Configuration.VERSION_2_3_23);
            }
            StringWriter out = new StringWriter();
            new Template("template", new StringReader(template), configuration).process(model, out);
            return out.toString();
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param template      模板流数据
     * @param model         模板数据中的模板   key：模板对象  value：替换的数据
     * @param configuration
     * @return
     */
    public static String process(Reader template, Map<String, ?> model, Configuration configuration) {
        try {
            if (template == null) {
                return null;
            }
            if (configuration == null) {
                configuration = new Configuration(Configuration.VERSION_2_3_23);
//                configuration.setSharedVariable("");
            }
            StringWriter out = new StringWriter();
            new Template("template", template, configuration).process(model, out);
            return out.toString();
        } catch (TemplateException | IOException e) {
            logger.error("模板转化异常",e);
        }
        return null;
    }

    public static String process(Reader template, Map<String, ?> model) {
        return process(template, model, null);
    }

    /**
     *
     * @param modelPath 模板路径
     * @param modelName 模板名称
     * @param map 数据map
     * @return
     */
    public static String readModelSaveHtmlStr(String modelPath,String modelName,Map<String,Object> map){
        //读取模板文件
        Reader fileReader = null;
        try {
            //获取磁盘项目路径
            File file = new File(modelPath + modelName + ".ftl");
            fileReader = new FileReader(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String htmlStr = FreemarkerUtils.process(fileReader,map,null);
        return htmlStr;
    }
}
