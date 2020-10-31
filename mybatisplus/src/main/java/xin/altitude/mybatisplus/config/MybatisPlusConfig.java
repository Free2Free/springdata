package xin.altitude.mybatisplus.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
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
     * @return
     */
    @Bean
    public OptimisticLockerInnerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInnerInterceptor();
    }

    /**
     * 防止全表更新与删除
     * @return
     */
    @Bean BlockAttackInnerInterceptor getBlockAttackInnerInterceptor(){
        return new BlockAttackInnerInterceptor();
    }
}
