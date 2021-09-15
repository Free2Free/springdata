package xin.altitude.mybatisplus.service.joinquery;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.altitude.mybatisplus.entity.joinquery.XDept;
import xin.altitude.mybatisplus.entity.joinquery.XUser;
import xin.altitude.mybatisplus.mapper.joinquery.XDeptMapper;
import xin.altitude.mybatisplus.mapper.joinquery.XUserMapper;
import xin.altitude.mybatisplus.vo.XUserVo;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
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
        LambdaQueryWrapper<XUser> wrapper = Wrappers.lambdaQuery(XUser.class).eq(!Objects.isNull(userId), XUser::getUserId, userId);
        XUser xUser = xUserMapper.selectOne(wrapper);
        // 构造Vo
        XUserVo userVo = new XUserVo(xUser);
        // 在部门表查询部门信息后封装到Vo
        addDetpNameInfo(xUser, userVo);
        // 从其它表查询其它信息再封装到Vo
        return userVo;
    }
    
    /**
     * 补充部门名称信息
     */
    private void addDetpNameInfo(XUser xUser, XUserVo userVo) {
        // 如果xUser不为空，则进行查询条件封装
        Optional.ofNullable(xUser).ifPresent(e -> {
            XDept xDept = xDeptMapper.selectOne(Wrappers.lambdaQuery(XDept.class).eq(XDept::getDeptId, xUser.getDeptId()));
            // 处理了xDept返回值空指针异常
            Optional.ofNullable(xDept).ifPresent(dept -> userVo.setDeptName(dept.getDeptName()));
        });
    }
    
    /**
     * 批量查询学生信息（一个学生对应一个部门）
     */
    public List<XUserVo> getUserByList() {
        // 先查询用户信息（表现形式为列表）
        List<XUser> xUser = xUserMapper.selectList(Wrappers.emptyWrapper());
        List<XUserVo> userVos = xUser.stream().map(XUserVo::new).collect(Collectors.toList());
        // 此步骤可以有多个
        addDeptNameInfo(xUser, userVos);
        // 查询其它信息
        return userVos;
    }
    
    private void addDeptNameInfo(List<XUser> xUser, List<XUserVo> userVos) {
        // 提取用户userId，方便批量查询
        List<Integer> deptIds = xUser.stream().map(XUser::getDeptId).collect(Collectors.toList());
        // 根据deptId查询deptName（查询前，先做非空判断）
        List<XDept> xDept = xDeptMapper.selectList(Wrappers.lambdaQuery(XDept.class).in(CollectionUtils.isNotEmpty(deptIds), XDept::getDeptId, deptIds));
        // 构造映射关系，方便匹配deptId与deptName
        Map<Integer, String> hashMap = xDept.stream().collect(Collectors.toMap(XDept::getDeptId, XDept::getDeptName));
        // 封装Vo，并添加到集合中(关键内容)
        userVos.stream().map(e -> e.setDeptName(hashMap.get(e.getDeptId()))).collect(Collectors.toList());
    }
    
    
    /**
     * 分页查询学生信息（一个学生对应一个部门）
     */
    public IPage<XUserVo> getUserByPage(Page<XUser> page) {
        // 先查询用户信息
        IPage<XUser> xUserPage = xUserMapper.selectPage(page, Wrappers.emptyWrapper());
        // 初始化Vo
        IPage<XUserVo> userVoIPage = xUserPage.convert(XUserVo::new);
        // 此步骤可以有多个
        addDeptNameInfo(xUserPage, userVoIPage);
        return userVoIPage;
    }
    
    private void addDeptNameInfo(IPage<XUser> xUserPage, IPage<XUserVo> userVoIPage) {
        // 提取用户userId，方便批量查询
        List<Integer> deptIds = xUserPage.getRecords().stream().map(XUser::getDeptId).collect(Collectors.toList());
        // 根据deptId查询deptName
        List<XDept> xDept = xDeptMapper.selectList(Wrappers.lambdaQuery(XDept.class).in(XDept::getDeptId, deptIds));
        // 构造映射关系，方便匹配deptId与deptName
        Map<Integer, String> hashMap = xDept.stream().collect(Collectors.toMap(XDept::getDeptId, XDept::getDeptName));
        // 将查询补充的信息添加到Vo中
        userVoIPage.convert(e -> e.setDeptName(hashMap.get(e.getDeptId())));
    }
}
