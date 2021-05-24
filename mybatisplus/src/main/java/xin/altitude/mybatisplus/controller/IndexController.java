package xin.altitude.mybatisplus.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.mybatisplus.service.joinquery.XDeptService;
import xin.altitude.mybatisplus.service.joinquery.XUserService;
import xin.altitude.mybatisplus.vo.XDeptVo;
import xin.altitude.mybatisplus.vo.XUserVo;

import java.util.List;

/**
 * @Author explore
 * @Date 2021/05/24 15:03
 **/
@RestController
public class IndexController {
    @Autowired
    private XUserService xUserService;
    
    @Autowired
    private XDeptService xDeptService;
    
    @GetMapping("/test/index1")
    public XUserVo index1() {
        return xUserService.getOneUser(1);
    }
    
    @GetMapping("/test/index2")
    public List<XUserVo> index2() {
        return xUserService.getUserByList();
    }
    
    @GetMapping("/test/index3")
    public IPage<XUserVo> index3() {
        return xUserService.getUserByPage(new Page());
    }
    
    // ------------
    @GetMapping("/test/index4")
    public XDeptVo index4() {
        return xDeptService.getOneDept(10);
    }
    
    @GetMapping("/test/index5")
    public List<XDeptVo> index5() {
        return xDeptService.getDeptByList();
    }
    
    @GetMapping("/test/index6")
    public IPage<XDeptVo> index6() {
        return xDeptService.getDeptByPage(new Page());
    }
}
