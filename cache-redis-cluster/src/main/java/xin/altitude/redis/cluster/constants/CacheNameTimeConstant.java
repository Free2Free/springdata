package xin.altitude.redis.cluster.constants;

/**
 * 定义标准CacheName名称列表
 * 不同名有不同的过期时间
 *
 * @Author explore
 * @Date 2021/05/12 16:34
 **/
public interface CacheNameTimeConstant {
    // 24小时
    String DEFAULT = "DEFAULT";
    // 一天
    String ONE_DAY = "ONE_DAY";
    // 6小时
    String SIX_HOURS = "SIX_HOURS";
    // 1小时
    String ONE_HOURS = "ONE_HOURS";
    // 30分钟
    String HALF_HOURS = "HALF_HOURS";
    // 15分钟
    String QUARTER_HOURS = "QUARTER_HOURS";
    // 5分钟
    String FIVE_MINS = "FIVE_MINS";
    // 1分钟
    String ONE_MINS = "ONE_MINS";
}
