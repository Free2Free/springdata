package xin.altitude.redis.cluster.mybatisplus.join2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.altitude.redis.cluster.mybatisplus.join2.domain.StuSubRelation;
import xin.altitude.redis.cluster.mybatisplus.join2.mapper.StuSubRelationMapper;
import xin.altitude.redis.cluster.mybatisplus.join2.service.IStuSubRelationService;

@Service
public class StuSubRelationServiceImpl extends ServiceImpl<StuSubRelationMapper, StuSubRelation> implements IStuSubRelationService {
    @Autowired
    private StuSubRelationMapper stuSubRelationMapper;
}
