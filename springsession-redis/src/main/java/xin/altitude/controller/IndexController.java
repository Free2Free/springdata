package xin.altitude.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


/**
 * 通过redis实现session共享
 */
@RestController
public class IndexController {

    @RequestMapping("/set")
    public String setData(HttpSession session){
        session.setAttribute("myKey","Session！Session！Session！Session！NO zhongwen!");
        return "设置cookie成功";
    }

    @RequestMapping("/get")
    public String getData(HttpSession session){
        return (String) session.getAttribute("myKey");
    }
}
