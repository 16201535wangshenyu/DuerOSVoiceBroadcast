package com.yscyber.duer.service;

import com.yscyber.duer.entity.DuerCommunication;

/**
 * 
 */
public interface ViewSpotDescriptionService {

    /**
     * 景点介绍.
     *
     * @param viewSpot 景点名称.
     * @return DuerCommunication
     */
    DuerCommunication broadcastViewSpotDescription(String viewSpot);

}
