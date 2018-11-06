package com.blackfat.netty.http.action.param;

import java.util.Map;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/11/6-17:31
 */
public interface Param extends Map<String,Object> {

    /**
     * get String
     * @param param
     * @return
     */
    String getString(String param);

    /**
     * get Integer
     * @param param
     * @return
     */
    Integer getInteger(String param);

    /**
     * get Long
     * @param param
     * @return
     */
    Long getLong(String param);

    /**
     * get Double
     * @param param
     * @return
     */
    Double getDouble(String param);

    /**
     * get Float
     * @param param
     * @return
     */
    Float getFloat(String param);

    /**
     * get Boolean
     * @param param
     * @return
     */
    Boolean getBoolean(String param) ;
}
