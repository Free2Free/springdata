package xin.altitude.redis.cluster.mybatisplus.join.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.redis.cluster.mybatisplus.join.entity.vo.DeptVo;
import xin.altitude.redis.cluster.mybatisplus.join.entity.vo.UserVo;
import xin.altitude.redis.cluster.mybatisplus.join.service.joinquery.XDeptService;
import xin.altitude.redis.cluster.mybatisplus.join.service.joinquery.XUserService;

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
    public UserVo index1() {
        return xUserService.getOneUser(3);
    }
    
    @GetMapping("/test/index2")
    public List<UserVo> index2() {
        return xUserService.getUserByList();
    }
    
    @GetMapping("/test/index3")
    public IPage<UserVo> index3() {
        return xUserService.getUserByPage(new Page());
    }
    
    // ------------
    @GetMapping("/test/index4")
    public DeptVo index4() {
        return xDeptService.getOneDept(10);
    }
    
    @GetMapping("/test/index5")
    public List<DeptVo> index5() {
        return xDeptService.getDeptByList();
    }
    
    @GetMapping("/test/index6")
    public IPage<DeptVo> index6() {
        return xDeptService.getDeptByPage(new Page());
    }
}
