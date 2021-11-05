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
import xin.altitude.redis.cluster.mybatisplus.join2.domain.Subject;
import xin.altitude.redis.cluster.mybatisplus.join2.mapper.SubjectMapper;
import xin.altitude.redis.cluster.mybatisplus.join2.service.ISubjectService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/front/subject")
public class SubjectController {
    @Autowired
    private ISubjectService subjectService;
    @Autowired
    private SubjectMapper subjectMapper;
    
    @GetMapping("/page")
    public AjaxResult list(PageEntity pageEntity, Subject subject) {
        return AjaxResult.success(subjectMapper.selectPage(pageEntity.toPage(), Wrappers.lambdaQuery(subject)));
    }
    
    @GetMapping("/list")
    public AjaxResult list(Subject subject) {
        List<Subject> list = subject.selectList(Wrappers.lambdaQuery(subject));
        return AjaxResult.success(list);
    }
    
    @PostMapping("/add")
    public AjaxResult add(@RequestBody Subject subject) {
        return AjaxResult.success(subject.insert());
    }
    
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody Subject subject) {
        return AjaxResult.success(subject.updateById());
    }
    
    @DeleteMapping("/delete/{ids}")
    public AjaxResult delete(@PathVariable Integer[] ids) {
        return AjaxResult.success(subjectMapper.deleteBatchIds(Arrays.asList(ids)));
    }
    
    @GetMapping(value = "/detail/{id}")
    public AjaxResult detail(@PathVariable("id") Integer id) {
        return AjaxResult.success(subjectMapper.selectById(id));
    }
}
