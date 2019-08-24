package com.yscyber.duer.dao.impl;

import com.yscyber.duer.dao.ViewSpotDescriptionDao;
import com.yscyber.duer.entity.ViewSpotDescription;
import com.yscyber.duer.util.JdbcUtils;

import java.sql.SQLException;

/**
 * 
 */
public class ViewSpotDescriptionDaoImpl implements ViewSpotDescriptionDao {

    @Override
    public ViewSpotDescription getViewSpotDescription(String viewSpot) {
        String sql = "SELECT * FROM view_spot_description_view WHERE description_view_spot_name=?";
        ViewSpotDescription viewSpotDescription = null;
        try {
            viewSpotDescription = JdbcUtils.executeBeanQuery(ViewSpotDescription.class, sql, viewSpot);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return viewSpotDescription;
    }

}
