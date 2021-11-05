package xin.altitude.redis.cluster.mybatisplus.join;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import xin.altitude.redis.cluster.mybatisplus.join.entity.User;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
class MybatisplusJoinApplicationTests {
    
    @Test
    void contextLoads() {
        Collectors.groupingBy(User::getDeptId, Collectors.mapping(User::getUserName, Collectors.toList()));
    }
    
    @Test
    public void test18() {
        List<User> users = null;
        Map<Integer, List<String>> hashMap = users.stream().collect(Collectors.groupingBy(User::getDeptId, Collectors.mapping(User::getUserName, Collectors.toList())));
    }
    
    
    @Test
    public void test27() {
        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery(User.class);
        wrapper.nonEmptyOfWhere();
    }
}
