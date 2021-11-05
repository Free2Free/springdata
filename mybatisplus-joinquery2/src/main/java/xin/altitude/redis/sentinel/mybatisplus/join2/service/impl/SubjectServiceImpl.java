package xin.altitude.redis.cluster.mybatisplus.join2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.altitude.redis.cluster.mybatisplus.join2.domain.Subject;
import xin.altitude.redis.cluster.mybatisplus.join2.mapper.SubjectMapper;
import xin.altitude.redis.cluster.mybatisplus.join2.service.ISubjectService;

@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements ISubjectService {
    @Autowired
    private SubjectMapper subjectMapper;
}
