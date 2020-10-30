package xin.altitude.rabbitmq.entity;

import java.io.Serializable;

/**
 * @author explore
 * @date 2020/10/29 10:43
 */
public class ImageEntity implements Serializable {
    private int id;
    private String rpath;

    public ImageEntity(int id, String rpath) {
        this.id = id;
        this.rpath = rpath;
    }

    public String getRpath() {
        return rpath;
    }

    public void setRpath(String rpath) {
        this.rpath = rpath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ImageEntity{" +
                "id=" + id +
                ", rpath='" + rpath + '\'' +
                '}';
    }
}
