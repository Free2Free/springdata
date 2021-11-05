package xin.altitude.redis.cluster.mybatisplus.join.config;

import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author explore
 * @date 2020/10/30 14:04
 */
@Configuration
public class MybatisPlusConfig {
    /**
     * 乐观锁配置
     *
     * @return
     */
    @Bean
    public OptimisticLockerInnerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInnerInterceptor();
    }
    
    /**
     * 防止全表更新与删除
     *
     * @return
     */
    @Bean
    BlockAttackInnerInterceptor getBlockAttackInnerInterceptor() {
        return new BlockAttackInnerInterceptor();
    }
    
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customizer() {
        return builder -> builder.featuresToEnable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
    }
}
