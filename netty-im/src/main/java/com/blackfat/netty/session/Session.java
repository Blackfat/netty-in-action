package com.blackfat.netty.session;

import com.google.common.base.MoreObjects;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/11/5-10:15
 */
@Data
@NoArgsConstructor
public class Session {

    private String userId;

    private String userName;

    public Session(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    @Override
    public String toString(){
        return MoreObjects.toStringHelper(this).add("userId", this.getUserId()).
                add("userName", this.getUserName()).toString();
    }
}
