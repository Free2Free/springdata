package xin.altitude.redis.cluster.mybatisplus.join2.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.altitude.redis.cluster.mybatisplus.join2.base.common.AjaxResult;
import xin.altitude.redis.cluster.mybatisplus.join2.base.entity.PageEntity;
import xin.altitude.redis.cluster.mybatisplus.join2.domain.StuSubRelation;
import xin.altitude.redis.cluster.mybatisplus.join2.mapper.StuSubRelationMapper;
import xin.altitude.redis.cluster.mybatisplus.join2.service.IStuSubRelationService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/front/stu/sub/relation")
public class StuSubRelationController {
    @Autowired
    private IStuSubRelationService stuSubRelationService;
    @Autowired
    private StuSubRelationMapper stuSubRelationMapper;
    
    @GetMapping("/page")
    public AjaxResult list(PageEntity pageEntity, StuSubRelation stuSubRelation) {
        return AjaxResult.success(stuSubRelationMapper.selectPage(pageEntity.toPage(), Wrappers.lambdaQuery(stuSubRelation)));
    }
    
    @GetMapping("/list")
    public AjaxResult list(StuSubRelation stuSubRelation) {
        List<StuSubRelation> list = stuSubRelation.selectList(Wrappers.lambdaQuery(stuSubRelation));
        return AjaxResult.success(list);
    }
    
    @PostMapping("/add")
    public AjaxResult add(@RequestBody StuSubRelation stuSubRelation) {
        return AjaxResult.success(stuSubRelation.insert());
    }
    
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody StuSubRelation stuSubRelation) {
        return AjaxResult.success(stuSubRelation.updateById());
    }
    
    @DeleteMapping("/delete/{ids}")
    public AjaxResult delete(@PathVariable Integer[] ids) {
        return AjaxResult.success(stuSubRelationMapper.deleteBatchIds(Arrays.asList(ids)));
    }
    
    @GetMapping(value = "/detail/{id}")
    public AjaxResult detail(@PathVariable("id") Integer id) {
        return AjaxResult.success(stuSubRelationMapper.selectById(id));
    }
}
