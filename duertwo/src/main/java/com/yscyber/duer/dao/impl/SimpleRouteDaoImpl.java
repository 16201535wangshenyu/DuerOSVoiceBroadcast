package com.yscyber.duer.dao.impl;

import com.yscyber.duer.dao.SimpleRouteDao;
import com.yscyber.duer.entity.SimpleRoute;
import com.yscyber.duer.util.JdbcUtils;
import java.sql.SQLException;

/**
 * 
 */
public class SimpleRouteDaoImpl implements SimpleRouteDao {

    @Override
    public SimpleRoute getSimpleRoute(String startPoint, String endPoint) {
        String sql = "SELECT * FROM simple_route_navigation_view WHERE route_start_point_name=? AND route_end_point_name=?";
        SimpleRoute simpleRoute = null;
        try {
            simpleRoute = JdbcUtils.executeBeanQuery(SimpleRoute.class, sql, startPoint, endPoint);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return simpleRoute;
    }

}
