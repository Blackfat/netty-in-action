package com.blackfat.netty.common.pojo;

import java.io.Serializable;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/8/27-17:04
 */
public class CustomProtocol implements Serializable {

   private static final long serialVersionUID = 1L;

   private  long id;

   private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CustomProtocol() {
    }

    public CustomProtocol(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @Override
    public String toString() {
        return "CustomProtocol{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
