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
        // 初始化Vo
        XDeptVo deptVo = new XDeptVo(xDept);
        addUserInfo(xDept, deptVo);
        return deptVo;
    }
    
    private void addUserInfo(XDept xDept, XDeptVo deptVo) {
        // 根据部门deptId查询学生列表
        List<XUser> xUsers = xUserMapper.selectList(Wrappers.lambdaQuery(XUser.class).eq(XUser::getDeptId, xDept.getDeptId()));
        deptVo.setXUsers(xUsers);
    }
    
    /**
     * 查询多个部门（其中一个部门有多个用户）
     */
    public List<XDeptVo> getDeptByList() {
        // 按条件查询部门信息
        List<XDept> xDepts = xDeptMapper.selectList(Wrappers.emptyWrapper());
        List<XDeptVo> deptVos = xDepts.stream().map(XDeptVo::new).collect(Collectors.toList());
        addUserInfo(xDepts, deptVos);
        return deptVos;
    }
    
    private void addUserInfo(List<XDept> xDepts, List<XDeptVo> deptVos) {
        // 准备deptId方便批量查询用户信息
        List<Integer> deptIds = xDepts.stream().map(XDept::getDeptId).collect(Collectors.toList());
        // 用批量deptId查询用户信息
        List<XUser> xUsers = xUserMapper.selectList(Wrappers.lambdaQuery(XUser.class).in(XUser::getDeptId, deptIds));
        // 重点：将用户按照deptId分组
        Map<Integer, List<XUser>> hashMap = xUsers.stream().collect(Collectors.groupingBy(XUser::getDeptId));
        // 合并结果，构造Vo，添加集合列表
        deptVos.stream().map(e -> e.setXUsers(hashMap.get(e.getDeptId()))).collect(Collectors.toList());
    }
    
    /**
     * 分页查询部门信息（其中一个部门有多个用户）
     */
    public IPage<XDeptVo> getDeptByPage(Page page) {
        // 按条件查询部门信息
        IPage<XDept> xDeptPage = xDeptMapper.selectPage(page, Wrappers.emptyWrapper());
        IPage<XDeptVo> deptVoIPage = xDeptPage.convert(XDeptVo::new);
        addUserInfo(xDeptPage, deptVoIPage);
        return deptVoIPage;
    }
    
    private void addUserInfo(IPage<XDept> xDeptPage, IPage<XDeptVo> deptVoIPage) {
        // 准备deptId方便批量查询用户信息
        List<Integer> deptIds = xDeptPage.getRecords().stream().map(XDept::getDeptId).collect(Collectors.toList());
        // 用批量deptId查询用户信息
        List<XUser> xUsers = xUserMapper.selectList(Wrappers.lambdaQuery(XUser.class).in(XUser::getDeptId, deptIds));
        // 重点：将用户按照deptId分组
        Map<Integer, List<XUser>> hashMap = xUsers.stream().collect(Collectors.groupingBy(XUser::getDeptId));
        // 合并结果，构造Vo，添加集合列表
        deptVoIPage.convert(e -> e.setXUsers(hashMap.get(e.getDeptId())));
    }
}
