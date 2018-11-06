package com.blackfat.netty.http.util;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/11/6-15:53
 */
public class PathUtil {

    /**
     * Get Root Path
     * /cicada-example/demoAction
     * @param path
     * @return cicada-example
     */
    public static String getRootPath(String path){
        return "/"+path.split("/")[1];
    }

    /**
     * Get Action Path
     * /cicada-example/demoAction
     * @param path
     * @return demoAction
     */
    public static String getActionPath(String path){
        return "/"+path.split("/")[2];
    }
}
