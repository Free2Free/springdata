package xin.altitude.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import xin.altitude.mybatisplus.entity.joinquery.XUser;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
class MybatisplusApplicationTests {
    
    @Test
    void contextLoads() {
        Collectors.groupingBy(XUser::getDeptId, Collectors.mapping(XUser::getUserName, Collectors.toList()));
    }
    
    @Test
    public void test18() {
        List<XUser> xUsers = null;
        Map<Integer, List<String>> hashMap = xUsers.stream().collect(Collectors.groupingBy(XUser::getDeptId, Collectors.mapping(XUser::getUserName, Collectors.toList())));
    }
    
    
    @Test
    public void test27() {
        LambdaQueryWrapper<XUser> wrapper = Wrappers.lambdaQuery(XUser.class);
        wrapper.nonEmptyOfWhere();
    }
}
