package xin.altitude.redis.cluster.mybatisplus.join.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.altitude.redis.cluster.mybatisplus.join.entity.Dept;
import xin.altitude.redis.cluster.mybatisplus.join.entity.User;
import xin.altitude.redis.cluster.mybatisplus.join.entity.vo.UserVo;
import xin.altitude.redis.cluster.mybatisplus.join.mapper.DeptMapper;
import xin.altitude.redis.cluster.mybatisplus.join.mapper.UserMapper;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

/**
 * @Author explore
 * @Date 2021/05/24 11:09
 **/
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private DeptMapper deptMapper;
    
    /**
     * 查询单个学生信息（一个学生对应一个部门）
     */
    public UserVo getOneUser(Integer userId) {
        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery(User.class)
                .eq(User::getUserId, userId);
        // 先查询用户信息
        User user = userMapper.selectOne(wrapper);
        // 转化为Vo
        UserVo userVo = Optional.ofNullable(user).map(UserVo::new).orElse(null);
        // 从其它表查询信息再封装到Vo
        Optional.ofNullable(userVo).ifPresent(this::addDetpNameInfo);
        return userVo;
    }
    
    /**
     * 补充部门名称信息
     */
    private void addDetpNameInfo(UserVo userVo) {
        LambdaQueryWrapper<Dept> wrapper = Wrappers.lambdaQuery(Dept.class).eq(Dept::getDeptId, userVo.getDeptId());
        Dept dept = deptMapper.selectOne(wrapper);
        Optional.ofNullable(dept).ifPresent(e -> userVo.setDeptName(e.getDeptName()));
    }
    
    /**
     * 批量查询学生信息（一个学生对应一个部门）
     */
    public List<UserVo> getUserByList() {
        // 先查询用户信息（表现形式为列表）
        List<User> user = userMapper.selectList(Wrappers.emptyWrapper());
        List<UserVo> userVos = user.stream().map(UserVo::new).collect(toList());
        // 此步骤可以有多个
        addDeptNameInfo(userVos);
        return userVos;
    }
    
    private void addDeptNameInfo(List<UserVo> userVos) {
        // 提取用户userId，方便批量查询
        Set<Integer> deptIds = userVos.stream().map(User::getDeptId).collect(toSet());
        // 根据deptId查询deptName（查询前，先做非空判断）
        List<Dept> dept = deptMapper.selectList(Wrappers.lambdaQuery(Dept.class).in(Dept::getDeptId, deptIds));
        // 构造映射关系，方便匹配deptId与deptName
        Map<Integer, String> hashMap = dept.stream().collect(toMap(Dept::getDeptId, Dept::getDeptName));
        // 封装Vo，并添加到集合中(关键内容)
        userVos.forEach(e -> e.setDeptName(hashMap.get(e.getDeptId())));
    }
    
    
    /**
     * 分页查询学生信息（一个学生对应一个部门）
     */
    public IPage<UserVo> getUserByPage(Page<User> page) {
        // 先查询用户信息
        IPage<User> xUserPage = userMapper.selectPage(page, Wrappers.emptyWrapper());
        // 初始化Vo
        IPage<UserVo> userVoPage = xUserPage.convert(UserVo::new);
        if (userVoPage.getRecords().size() > 0) {
            addDeptNameInfo(userVoPage);
        }
        return userVoPage;
    }
    
    private void addDeptNameInfo(IPage<UserVo> userVoPage) {
        // 提取用户userId，方便批量查询
        Set<Integer> deptIds = userVoPage.getRecords().stream().map(User::getDeptId).collect(toSet());
        // 根据deptId查询deptName
        List<Dept> dept = deptMapper.selectList(Wrappers.lambdaQuery(Dept.class).in(Dept::getDeptId, deptIds));
        // 构造映射关系，方便匹配deptId与deptName
        Map<Integer, String> hashMap = dept.stream().collect(toMap(Dept::getDeptId, Dept::getDeptName));
        // 将查询补充的信息添加到Vo中
        userVoPage.convert(e -> e.setDeptName(hashMap.get(e.getDeptId())));
    }
}
