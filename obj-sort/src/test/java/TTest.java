import org.junit.jupiter.api.Test;
import xin.altitude.domain.SUser;
import xin.altitude.domain.XUser;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author explore
 * @Date 2021/05/22 19:27
 **/
public class TTest {
    @Test
    public void test7() {
        // 模拟生成集合
        List<XUser> userList = Stream.of(new XUser(1, "A", 12), new XUser(2, "B", 10), new XUser(3, "C", 15)).collect(Collectors.toList());
        // 对集合按照年龄排序(正序排列)
        Collections.sort(userList, Comparator.comparingInt(XUser::getAge));
        // 打印排序后结果
        userList.forEach(System.out::println);
        // 对集合按照年龄排序（逆序排列）
        Collections.sort(userList, Comparator.comparingInt(XUser::getAge).reversed());
        // 打印排序后结果
        userList.forEach(System.out::println);
    }
    
    @Test
    public void test30() {
        // 模拟生成集合
        List<XUser> userList = Stream.of(new XUser(1, "A", 12), new XUser(2, "B", null), new XUser(3, "C", 15)).filter(e -> e.getAge() != null).collect(Collectors.toList());
        // 对集合按照年龄排序(正序排列)
        Collections.sort(userList, Comparator.comparingInt(XUser::getAge));
        // 打印排序后结果
        userList.forEach(System.out::println);
        // 对集合按照年龄排序（逆序排列）
        Collections.sort(userList, Comparator.comparingInt(XUser::getAge).reversed());
        // 打印排序后结果
        userList.forEach(System.out::println);
    }
    
    
    @Test
    public void test45() {
        // 模拟生成集合
        List<SUser> userList = Stream.of(new SUser(1, "A", "12.4"), new SUser(2, "B", "10.7"), new SUser(3, "C", "15.9")).collect(Collectors.toList());
        // 对集合按照年龄排序(正序排列)
        Collections.sort(userList, Comparator.comparingDouble(e -> new Double(e.getScore())));
        // 打印排序后结果
        userList.forEach(System.out::println);
        // 对集合按照年龄排序(逆序排列)
        Collections.sort(userList, Comparator.comparingDouble(e -> -1 * new Double(e.getScore())));
        // 打印排序后结果
        userList.forEach(System.out::println);
    }
}
