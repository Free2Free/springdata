import org.junit.jupiter.api.Test;
import xin.altitude.lombok.domain.XUser;

/**
 * @Author explore
 * @Date 2021/05/18 16:11
 **/
public class STest {
    @Test
    public void test7() {
//        XUser xUser = new XUser();
//        System.out.println("xUser = " + xUser);
    }
    
    @Test
    public void test16() {
        // 用简洁的方式实例化实体类并完成赋值操作
//        XUser xUser = XUser.builder().userId(1).userName("AAAAA").build();
    }
    
    @Test
    public void test22() {
//        XUser xUser = new XUser();
//        System.out.println(xUser.toString());
//        System.out.println(xUser.toString());
    }
    
    @Test
    public void test29() {
        System.out.println(new XUser(1, "AAAAA").toString());
        System.out.println(new XUser(1, "AAAAA").toString());
    }
    
    @Test
    public void test35() {
        // 判断引用是否相等
        boolean bl = new XUser(1, "AAAAA").equals(new XUser(1, "AAAAA"));
        System.out.println(bl);
    }
    
    
    @Test
    public void test43() {
        XUser xUser1 = new XUser(1, "AAAAA");
        XUser xUser2 = xUser1;
        // 在同一个JVM中，相同的引用对象实例相同（输出为true）
        boolean bl = xUser1.equals(xUser2);
        System.out.println(bl);
    }
    
    @Test
    public void test42() {
        // 对象的属性值是否相等（输出是true）
        boolean bl = new XUser(1, "AAAAA").equals(new XUser(1, "AAAAA"));
        System.out.println(bl);
    }
}
