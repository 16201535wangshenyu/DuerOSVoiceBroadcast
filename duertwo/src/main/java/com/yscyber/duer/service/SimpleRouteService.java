package com.yscyber.duer.service;

import com.yscyber.duer.entity.DuerCommunication;

/**
 * 
 */
public interface SimpleRouteService {

    /**
     * 简单寻路.
     *
     * @param startPoint 起点名称
     * @param endPoint 终点名称
     * @return DuerCommunication
     */
    DuerCommunication broadcastSimpleRoute(String startPoint, String endPoint);

}
