package xin.altitude.mybatisplus.join2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.HashBasedTable;
import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.altitude.mybatisplus.join2.domain.StuSubRelation;
import xin.altitude.mybatisplus.join2.domain.Student;
import xin.altitude.mybatisplus.join2.domain.Subject;
import xin.altitude.mybatisplus.join2.entity.bo.SubjectBo;
import xin.altitude.mybatisplus.join2.entity.vo.StudentVo;
import xin.altitude.mybatisplus.join2.mapper.StuSubRelationMapper;
import xin.altitude.mybatisplus.join2.mapper.StudentMapper;
import xin.altitude.mybatisplus.join2.mapper.SubjectMapper;
import xin.altitude.mybatisplus.join2.service.IStudentService;
import xin.altitude.mybatisplus.join2.util.ConvertUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static org.apache.commons.collections4.ListUtils.emptyIfNull;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StuSubRelationMapper stuSubRelationMapper;
    @Autowired
    private SubjectMapper subjectMapper;
    
    /**
     * 查询单个学生的成绩
     *
     * @param stuId
     * @return
     */
    @Override
    public StudentVo getStudent(Integer stuId) {
        // 通过主键查询学生信息
        StudentVo studentVo = ConvertUtils.convertObj(getById(stuId), StudentVo::new);
        LambdaQueryWrapper<StuSubRelation> wrapper = Wrappers.lambdaQuery(StuSubRelation.class).eq(StuSubRelation::getStuId, stuId);
        // 查询匹配关系
        List<StuSubRelation> stuSubRelations = stuSubRelationMapper.selectList(wrapper);
        Set<Integer> subIds = stuSubRelations.stream().map(StuSubRelation::getSubId).collect(toSet());
        if (studentVo != null && subIds.size() > 0) {
            List<Subject> subList = subjectMapper.selectList(Wrappers.lambdaQuery(Subject.class).in(Subject::getId, subIds));
            List<SubjectBo> subBoList = ConvertUtils.convertList(subList, SubjectBo::new);
            HashBasedTable<Integer, Integer, Integer> table = getHashBasedTable(stuSubRelations);
            subBoList.forEach(e -> e.setScore(table.get(stuId, e.getId())));
            studentVo.setSubList(subBoList);
        }
        return studentVo;
    }
    
    @Override
    public List<StudentVo> getStudentList() {
        // 通过主键查询学生信息
        List<StudentVo> studentVoList = ConvertUtils.convertList(list(), StudentVo::new);
        // 批量查询学生ID
        Set<Integer> stuIds = studentVoList.stream().map(Student::getId).collect(toSet());
        LambdaQueryWrapper<StuSubRelation> wrapper = Wrappers.lambdaQuery(StuSubRelation.class).in(StuSubRelation::getStuId, stuIds);
        List<StuSubRelation> stuSubRelations = stuSubRelationMapper.selectList(wrapper);
        // 批量查询课程ID
        Set<Integer> subIds = stuSubRelations.stream().map(StuSubRelation::getSubId).collect(toSet());
        if (stuIds.size() > 0 && subIds.size() > 0) {
            HashBasedTable<Integer, Integer, Integer> table = getHashBasedTable(stuSubRelations);
            List<Subject> subList = subjectMapper.selectList(Wrappers.lambdaQuery(Subject.class).in(Subject::getId, subIds));
            List<SubjectBo> subjectBoList = ConvertUtils.convertList(subList, SubjectBo::new);
            Map<Integer, List<Integer>> map = stuSubRelations.stream().collect(groupingBy(StuSubRelation::getStuId, mapping(StuSubRelation::getSubId, toList())));
            for (StudentVo studentVo : studentVoList) {
                // 获取课程列表
                List<SubjectBo> list = ListUtils.select(subjectBoList, e -> emptyIfNull(map.get(studentVo.getId())).contains(e.getId()));
                // 填充分数
                list.forEach(e -> e.setScore(table.get(studentVo.getId(), e.getId())));
                studentVo.setSubList(list);
            }
            
        }
        return studentVoList;
    }
    
    private HashBasedTable<Integer, Integer, Integer> getHashBasedTable(List<StuSubRelation> stuSubRelations) {
        HashBasedTable<Integer, Integer, Integer> table = HashBasedTable.create();
        stuSubRelations.forEach(e -> table.put(e.getStuId(), e.getSubId(), e.getScore()));
        return table;
    }
    
    @Override
    public IPage<StudentVo> getStudentPage(IPage<Student> page) {
        // 通过主键查询学生信息
        IPage<StudentVo> studentVoPage = ConvertUtils.convertPage(page(page), StudentVo::new);
        // 批量查询学生ID
        Set<Integer> stuIds = studentVoPage.getRecords().stream().map(Student::getId).collect(toSet());
        LambdaQueryWrapper<StuSubRelation> wrapper = Wrappers.lambdaQuery(StuSubRelation.class).in(StuSubRelation::getStuId, stuIds);
        // 通过学生ID查询课程分数
        List<StuSubRelation> stuSubRelations = stuSubRelationMapper.selectList(wrapper);
        // 批量查询课程ID
        Set<Integer> subIds = stuSubRelations.stream().map(StuSubRelation::getSubId).collect(toSet());
        if (stuIds.size() > 0 && subIds.size() > 0) {
            HashBasedTable<Integer, Integer, Integer> table = getHashBasedTable(stuSubRelations);
            // 学生ID查询课程ID组
            Map<Integer, List<Integer>> map = stuSubRelations.stream().collect(groupingBy(StuSubRelation::getStuId, mapping(StuSubRelation::getSubId, toList())));
            
            List<Subject> subList = subjectMapper.selectList(Wrappers.lambdaQuery(Subject.class).in(Subject::getId, subIds));
            List<SubjectBo> subBoList = ConvertUtils.convertList(subList, SubjectBo::new);
            for (StudentVo studentVo : studentVoPage.getRecords()) {
                List<SubjectBo> list = ListUtils.select(subBoList, e -> emptyIfNull(map.get(studentVo.getId())).contains(e.getId()));
                list.forEach(e -> e.setScore(table.get(studentVo.getId(), e.getId())));
                studentVo.setSubList(list);
            }
            
        }
        return studentVoPage;
    }
}
