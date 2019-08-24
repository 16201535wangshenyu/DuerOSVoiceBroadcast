package com.yscyber.duer.dao;

import com.yscyber.duer.entity.ViewSpotDescription;

/**
 * 
 */
public interface ViewSpotDescriptionDao {

    /**
     * 景点描述.
     *
     * @param viewSpot 景点名称
     * @return ViewSpotDescription
     */
    ViewSpotDescription getViewSpotDescription(String viewSpot);

}
