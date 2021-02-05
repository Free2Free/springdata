package xin.altitude.word.util;

import java.util.UUID;

/**
 * beetl模版针对word拓展函数
 * @Author explore
 * @Date 2021/02/05 15:32
 **/
public class TemplateService {

    /**
     * word中表示勾选☑️的符号
     * @param bl true->勾选 false->未勾选
     * @return
     */
    public static String wingdingRadio(Boolean bl){
        return bl?"00A8":"00FE";
    }

    /**
     * 在循环过程中需要唯一标示唯一行，通常需要唯一的字符串
     * @return
     */
    public static String uniqueKey(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}