package xin.altitude.redis.cluster.mybatisplus.join.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.altitude.redis.cluster.mybatisplus.join.entity.Dept;
import xin.altitude.redis.cluster.mybatisplus.join.entity.User;
import xin.altitude.redis.cluster.mybatisplus.join.entity.vo.DeptVo;
import xin.altitude.redis.cluster.mybatisplus.join.mapper.DeptMapper;
import xin.altitude.redis.cluster.mybatisplus.join.mapper.UserMapper;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * @Author explore
 * @Date 2021/05/24 11:09
 **/
@Service
public class DeptService {
    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private DeptMapper deptMapper;
    
    /**
     * 查询单个部门（其中一个部门有多个用户）
     */
    public DeptVo getOneDept(Integer deptId) {
        // 查询部门基础信息
        LambdaQueryWrapper<Dept> wrapper = Wrappers.lambdaQuery(Dept.class).eq(Dept::getDeptId, deptId);
        DeptVo deptVo = Optional.ofNullable(deptMapper.selectOne(wrapper)).map(DeptVo::new).orElse(null);
        Optional.ofNullable(deptVo).ifPresent(this::addUserInfo);
        return deptVo;
    }
    
    private void addUserInfo(DeptVo deptVo) {
        // 根据部门deptId查询学生列表
        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery(User.class).eq(User::getDeptId, deptVo.getDeptId());
        List<User> users = userMapper.selectList(wrapper);
        deptVo.setUsers(users);
    }
    
    /**
     * 查询多个部门（其中一个部门有多个用户）
     */
    public List<DeptVo> getDeptByList() {
        // 按条件查询部门信息
        List<Dept> deptList = deptMapper.selectList(Wrappers.emptyWrapper());
        List<DeptVo> deptVos = deptList.stream().map(DeptVo::new).collect(toList());
        if (deptVos.size() > 0) {
            addUserInfo(deptVos);
        }
        return deptVos;
    }
    
    private void addUserInfo(List<DeptVo> deptVos) {
        // 准备deptId方便批量查询用户信息
        Set<Integer> deptIds = deptVos.stream().map(Dept::getDeptId).collect(toSet());
        // 用批量deptId查询用户信息
        List<User> users = userMapper.selectList(Wrappers.lambdaQuery(User.class).in(User::getDeptId, deptIds));
        // 重点：将用户按照deptId分组
        Map<Integer, List<User>> hashMap = users.stream().collect(groupingBy(User::getDeptId));
        // 合并结果，构造Vo，添加集合列表
        deptVos.forEach(e -> e.setUsers(hashMap.get(e.getDeptId())));
    }
    
    /**
     * 分页查询部门信息（其中一个部门有多个用户）
     */
    public IPage<DeptVo> getDeptByPage(Page<Dept> page) {
        // 按条件查询部门信息
        IPage<Dept> xDeptPage = deptMapper.selectPage(page, Wrappers.emptyWrapper());
        IPage<DeptVo> deptVoPage = xDeptPage.convert(DeptVo::new);
        if (deptVoPage.getRecords().size() > 0) {
            addUserInfo(deptVoPage);
        }
        return deptVoPage;
    }
    
    private void addUserInfo(IPage<DeptVo> deptVoPage) {
        // 准备deptId方便批量查询用户信息
        Set<Integer> deptIds = deptVoPage.getRecords().stream().map(Dept::getDeptId).collect(toSet());
        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery(User.class).in(User::getDeptId, deptIds);
        // 用批量deptId查询用户信息
        List<User> users = userMapper.selectList(wrapper);
        // 重点：将用户按照deptId分组
        Map<Integer, List<User>> hashMap = users.stream().collect(groupingBy(User::getDeptId));
        // 合并结果，构造Vo，添加集合列表
        deptVoPage.convert(e -> e.setUsers(hashMap.get(e.getDeptId())));
    }
}
