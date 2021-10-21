package xin.altitude.mybatisplus.join.service.joinquery;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.altitude.mybatisplus.join.entity.joinquery.Dept;
import xin.altitude.mybatisplus.join.entity.joinquery.User;
import xin.altitude.mybatisplus.join.entity.vo.DeptVo;
import xin.altitude.mybatisplus.join.mapper.joinquery.DeptMapper;
import xin.altitude.mybatisplus.join.mapper.joinquery.UserMapper;

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
    private UserMapper userMapper;
    
    @Autowired
    private DeptMapper deptMapper;
    
    /**
     * 查询单个部门（其中一个部门有多个用户）
     */
    public DeptVo getOneDept(Integer deptId) {
        // 查询部门基础信息
        Dept dept = deptMapper.selectOne(Wrappers.lambdaQuery(Dept.class).eq(Dept::getDeptId, deptId));
        // 初始化Vo
        DeptVo deptVo = new DeptVo(dept);
        addUserInfo(dept, deptVo);
        return deptVo;
    }
    
    private void addUserInfo(Dept dept, DeptVo deptVo) {
        // 根据部门deptId查询学生列表
        List<User> users = userMapper.selectList(Wrappers.lambdaQuery(User.class).eq(User::getDeptId, dept.getDeptId()));
        deptVo.setUsers(users);
    }
    
    /**
     * 查询多个部门（其中一个部门有多个用户）
     */
    public List<DeptVo> getDeptByList() {
        // 按条件查询部门信息
        List<Dept> depts = deptMapper.selectList(Wrappers.emptyWrapper());
        List<DeptVo> deptVos = depts.stream().map(DeptVo::new).collect(Collectors.toList());
        addUserInfo(depts, deptVos);
        return deptVos;
    }
    
    private void addUserInfo(List<Dept> depts, List<DeptVo> deptVos) {
        // 准备deptId方便批量查询用户信息
        List<Integer> deptIds = depts.stream().map(Dept::getDeptId).collect(Collectors.toList());
        // 用批量deptId查询用户信息
        List<User> users = userMapper.selectList(Wrappers.lambdaQuery(User.class).in(User::getDeptId, deptIds));
        // 重点：将用户按照deptId分组
        Map<Integer, List<User>> hashMap = users.stream().collect(Collectors.groupingBy(User::getDeptId));
        // 合并结果，构造Vo，添加集合列表
        deptVos.stream().map(e -> e.setUsers(hashMap.get(e.getDeptId()))).collect(Collectors.toList());
    }
    
    /**
     * 分页查询部门信息（其中一个部门有多个用户）
     */
    public IPage<DeptVo> getDeptByPage(Page page) {
        // 按条件查询部门信息
        IPage<Dept> xDeptPage = deptMapper.selectPage(page, Wrappers.emptyWrapper());
        IPage<DeptVo> deptVoIPage = xDeptPage.convert(DeptVo::new);
        addUserInfo(xDeptPage, deptVoIPage);
        return deptVoIPage;
    }
    
    private void addUserInfo(IPage<Dept> xDeptPage, IPage<DeptVo> deptVoIPage) {
        // 准备deptId方便批量查询用户信息
        List<Integer> deptIds = xDeptPage.getRecords().stream().map(Dept::getDeptId).collect(Collectors.toList());
        // 用批量deptId查询用户信息
        List<User> users = userMapper.selectList(Wrappers.lambdaQuery(User.class).in(User::getDeptId, deptIds));
        // 重点：将用户按照deptId分组
        Map<Integer, List<User>> hashMap = users.stream().collect(Collectors.groupingBy(User::getDeptId));
        // 合并结果，构造Vo，添加集合列表
        deptVoIPage.convert(e -> e.setUsers(hashMap.get(e.getDeptId())));
    }
}
