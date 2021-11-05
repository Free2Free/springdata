package xin.altitude.redis.cluster.mybatisplus.join.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import xin.altitude.redis.cluster.mybatisplus.join.entity.Dept;

import java.util.List;

/**
 * @author explore
 * @date 2020/10/31 10:57
 */
// @Mapper
public interface DeptMapper extends BaseMapper<Dept> {

    /**
     * 按照id查询部门信息
     * @param id
     */
    public Dept getDeptInfoById(@Param("id") String id);

    /**
     * 查询所有部门的信息
     * @return
     */
    public List<Dept> getAllDeptInfoById();
}
