package xin.altitude.redis.cluster.mybatisplus.join.service.joinquery;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.altitude.redis.cluster.mybatisplus.join.entity.joinquery.Dept;
import xin.altitude.redis.cluster.mybatisplus.join.entity.joinquery.User;
import xin.altitude.redis.cluster.mybatisplus.join.entity.vo.UserVo;
import xin.altitude.redis.cluster.mybatisplus.join.mapper.joinquery.DeptMapper;
import xin.altitude.redis.cluster.mybatisplus.join.mapper.joinquery.UserMapper;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author explore
 * @Date 2021/05/24 11:09
 **/
@Service
public class XUserService {
    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private DeptMapper deptMapper;
    
    /**
     * 查询单个学生信息（一个学生对应一个部门）
     */
    public UserVo getOneUser(Integer userId) {
        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery(User.class).eq(User::getUserId, userId);
        // 先查询用户信息
        User user = userMapper.selectOne(wrapper);
        // 转化为Vo
        UserVo userVo = Optional.ofNullable(user).map(UserVo::new).orElse(null);
        // 从其它表查询其它信息再封装到Vo
        Optional.ofNullable(userVo).ifPresent(this::addDetpNameInfo);
        return userVo;
    }
    
    /**
     * 补充部门名称信息
     */
    private void addDetpNameInfo(UserVo userVo) {
        Dept dept = deptMapper.selectOne(Wrappers.lambdaQuery(Dept.class).eq(Dept::getDeptId, userVo.getDeptId()));
        Optional.ofNullable(dept).ifPresent(e -> userVo.setDeptName(e.getDeptName()));
    }
    
    /**
     * 批量查询学生信息（一个学生对应一个部门）
     */
    public List<UserVo> getUserByList() {
        // 先查询用户信息（表现形式为列表）
        List<User> user = userMapper.selectList(Wrappers.emptyWrapper());
        List<UserVo> userVos = user.stream().map(UserVo::new).collect(Collectors.toList());
        // 此步骤可以有多个
        addDeptNameInfo(user, userVos);
        // 查询其它信息
        return userVos;
    }
    
    private void addDeptNameInfo(List<User> user, List<UserVo> userVos) {
        // 提取用户userId，方便批量查询
        List<Integer> deptIds = user.stream().map(User::getDeptId).collect(Collectors.toList());
        // 根据deptId查询deptName（查询前，先做非空判断）
        List<Dept> dept = deptMapper.selectList(Wrappers.lambdaQuery(Dept.class).in(CollectionUtils.isNotEmpty(deptIds), Dept::getDeptId, deptIds));
        // 构造映射关系，方便匹配deptId与deptName
        Map<Integer, String> hashMap = dept.stream().collect(Collectors.toMap(Dept::getDeptId, Dept::getDeptName));
        // 封装Vo，并添加到集合中(关键内容)
        userVos.stream().map(e -> e.setDeptName(hashMap.get(e.getDeptId()))).collect(Collectors.toList());
    }
    
    
    /**
     * 分页查询学生信息（一个学生对应一个部门）
     */
    public IPage<UserVo> getUserByPage(Page<User> page) {
        // 先查询用户信息
        IPage<User> xUserPage = userMapper.selectPage(page, Wrappers.emptyWrapper());
        // 初始化Vo
        IPage<UserVo> userVoIPage = xUserPage.convert(UserVo::new);
        // 此步骤可以有多个
        addDeptNameInfo(xUserPage, userVoIPage);
        return userVoIPage;
    }
    
    private void addDeptNameInfo(IPage<User> xUserPage, IPage<UserVo> userVoIPage) {
        // 提取用户userId，方便批量查询
        List<Integer> deptIds = xUserPage.getRecords().stream().map(User::getDeptId).collect(Collectors.toList());
        // 根据deptId查询deptName
        List<Dept> dept = deptMapper.selectList(Wrappers.lambdaQuery(Dept.class).in(Dept::getDeptId, deptIds));
        // 构造映射关系，方便匹配deptId与deptName
        Map<Integer, String> hashMap = dept.stream().collect(Collectors.toMap(Dept::getDeptId, Dept::getDeptName));
        // 将查询补充的信息添加到Vo中
        userVoIPage.convert(e -> e.setDeptName(hashMap.get(e.getDeptId())));
    }
}
