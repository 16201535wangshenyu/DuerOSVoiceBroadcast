package com.yscyber.duer.dao;

import com.yscyber.duer.entity.SimpleRoute;

/**
 * 
 */
public interface SimpleRouteDao {

    /**
     * 简单寻路.
     *
     * @param startPoint 起点名称
     * @param endPoint 终点名称
     * @return SimpleRoute
     */
    SimpleRoute getSimpleRoute(String startPoint, String endPoint);

}
