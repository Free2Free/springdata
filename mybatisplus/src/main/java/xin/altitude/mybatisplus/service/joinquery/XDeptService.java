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
import xin.altitude.mybatisplus.vo.XDeptVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author explore
 * @Date 2021/05/24 11:09
 **/
@Service
public class XDeptService {
    @Autowired
    private XUserMapper xUserMapper;
    
    @Autowired
    private XDeptMapper xDeptMapper;
    
    /**
     * 查询单个部门（其中一个部门有多个用户）
     */
    public XDeptVo getOneDept(Integer deptId) {
        // 查询部门基础信息
        XDept xDept = xDeptMapper.selectOne(Wrappers.lambdaQuery(XDept.class).eq(XDept::getDeptId, deptId));
        // 根据部门deptId查询学生列表
        List<XUser> xUsers = xUserMapper.selectList(Wrappers.lambdaQuery(XUser.class).eq(XUser::getDeptId, xDept.getDeptId()));
        // 将结果合并成Vo
        return new XDeptVo(xDept, xUsers);
    }
    
    /**
     * 查询多个部门（其中一个部门有多个用户）
     */
    public List<XDeptVo> getDeptByList() {
        List<XDeptVo> result = new ArrayList<>();
        // 按条件查询部门信息
        List<XDept> xDepts = xDeptMapper.selectList(Wrappers.emptyWrapper());
        // 准备deptId方便批量查询用户信息
        List<Integer> deptIds = xDepts.stream().map(XDept::getDeptId).collect(Collectors.toList());
        // 用批量deptId查询用户信息
        List<XUser> xUsers = xUserMapper.selectList(Wrappers.lambdaQuery(XUser.class).in(XUser::getDeptId, deptIds));
        // 重点：将用户按照deptId分组
        Map<Integer, List<XUser>> hashMap = xUsers.stream().collect(Collectors.groupingBy(XUser::getDeptId, Collectors.toList()));
        // 合并结果，构造Vo，添加集合列表
        xDepts.forEach(e -> result.add(new XDeptVo(e, hashMap.get(e.getDeptId()))));
        return result;
    }
    
    /**
     * 分页查询部门信息（其中一个部门有多个用户）
     */
    public IPage<XDeptVo> getDeptByPage(Page page) {
        // 按条件查询部门信息
        IPage<XDept> xDeptPage = xDeptMapper.selectPage(page, Wrappers.emptyWrapper());
        // 准备deptId方便批量查询用户信息
        List<Integer> deptIds = xDeptPage.getRecords().stream().map(XDept::getDeptId).collect(Collectors.toList());
        // 用批量deptId查询用户信息
        List<XUser> xUsers = xUserMapper.selectList(Wrappers.lambdaQuery(XUser.class).in(XUser::getDeptId, deptIds));
        // 重点：将用户按照deptId分组
        Map<Integer, List<XUser>> hashMap = xUsers.stream().collect(Collectors.groupingBy(XUser::getDeptId, Collectors.toList()));
        // 合并结果，构造Vo，添加集合列表
        IPage<XDeptVo> result = xDeptPage.convert(e -> new XDeptVo(e, hashMap.get(e.getDeptId())));
        return result;
    }
}
