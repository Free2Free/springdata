package xin.altitude.redis.cluster.caffeine.constants;

/**
 * 单位秒
 *
 * @author explore
 * @since 2021/07/05 15:52
 **/
public enum CacheNameTimeType {
    IZUUL(10), MUMU(5);
    private String cacheName;
    
    private int expires;
    
    CacheNameTimeType(int expires) {
        this.expires = expires;
    }
    
    public int getExpires() {
        return expires;
    }
    
    public void setExpires(int expires) {
        this.expires = expires;
    }
    
    public String getCacheName() {
        return cacheName;
    }
    
    public void setCacheName(String cacheName) {
        this.cacheName = cacheName;
    }
}