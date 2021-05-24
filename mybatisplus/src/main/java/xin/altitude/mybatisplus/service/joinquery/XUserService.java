package xin.altitude.mybatisplus.service.joinquery;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.altitude.mybatisplus.entity.joinquery.XDept;
import xin.altitude.mybatisplus.entity.joinquery.XUser;
import xin.altitude.mybatisplus.mapper.joinquery.XDeptMapper;
import xin.altitude.mybatisplus.mapper.joinquery.XUserMapper;
import xin.altitude.mybatisplus.vo.XUserVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author explore
 * @Date 2021/05/24 11:09
 **/
@Service
public class XUserService {
    @Autowired
    private XUserMapper xUserMapper;
    
    @Autowired
    private XDeptMapper xDeptMapper;
    
    /**
     * 查询单个学生信息（一个学生对应一个部门）
     */
    public XUserVo getOneUser(Integer userId) {
        // 先查询用户信息
        XUser xUser = xUserMapper.selectOne(Wrappers.lambdaQuery(XUser.class).eq(XUser::getUserId, userId));
        // 根据deptId查询deptName
        XDept xDept = xDeptMapper.selectOne(Wrappers.lambdaQuery(XDept.class).eq(XDept::getDeptId, xUser.getDeptId()));
        return new XUserVo(xUser, xDept.getDeptName());
    }
    
    /**
     * 批量查询学生信息（一个学生对应一个部门）
     */
    public List<XUserVo> getUserByList() {
        List<XUserVo> result = new ArrayList<>();
        // 先查询用户信息
        List<XUser> xUser = xUserMapper.selectList(Wrappers.emptyWrapper());
        // 提取用户userId，方便批量查询
        List<Integer> deptIds = xUser.stream().map(XUser::getDeptId).collect(Collectors.toList());
        // 根据deptId查询deptName
        List<XDept> xDept = xDeptMapper.selectList(Wrappers.lambdaQuery(XDept.class).in(XDept::getDeptId, deptIds));
        // 构造映射关系，方便匹配deptId与deptName
        Map<Integer, String> hashMap = xDept.stream().collect(Collectors.toMap(XDept::getDeptId, XDept::getDeptName));
        // 封装Vo，并添加到集合中
        xUser.forEach(e -> result.add(new XUserVo(e, hashMap.get(e.getDeptId()))));
        return result;
    }
    
    
    /**
     * 分页查询学生信息（一个学生对应一个部门）
     */
    public IPage<XUserVo> getUserByPage(Page page) {
        // 先查询用户信息
        IPage<XUser> xUserPage = xUserMapper.selectPage(page, Wrappers.emptyWrapper());
        // 提取用户userId，方便批量查询
        List<Integer> deptIds = xUserPage.getRecords().stream().map(XUser::getDeptId).collect(Collectors.toList());
        // 根据deptId查询deptName
        List<XDept> xDept = xDeptMapper.selectList(Wrappers.lambdaQuery(XDept.class).in(XDept::getDeptId, deptIds));
        // 构造映射关系，方便匹配deptId与deptName
        Map<Integer, String> hashMap = xDept.stream().collect(Collectors.toMap(XDept::getDeptId, XDept::getDeptName));
        // 封装Vo，并添加到集合中
        IPage<XUserVo> result = xUserPage.convert(e -> new XUserVo(e, hashMap.get(e.getDeptId())));
        return result;
    }
}
