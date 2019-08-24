package com.yscyber.duer.service.impl;

import com.yscyber.duer.constant.SimpleRouteBroadcastEnum;
import com.yscyber.duer.dao.SimpleRouteDao;
import com.yscyber.duer.dao.impl.SimpleRouteDaoImpl;
import com.yscyber.duer.entity.DuerCommunication;
import com.yscyber.duer.entity.SimpleRoute;
import com.yscyber.duer.service.SimpleRouteService;

/**
 * 
 */
public class SimpleRouteServiceImpl implements SimpleRouteService {

    private SimpleRouteDao simpleRouteDao = new SimpleRouteDaoImpl();

    @Override
    public DuerCommunication broadcastSimpleRoute(String startPoint, String endPoint) {
        DuerCommunication duerCommunication = new DuerCommunication();
        if (startPoint.equals(endPoint)) {
            duerCommunication.setBroadcast(SimpleRouteBroadcastEnum.REPEAT_POINT.getTip());
        } else {
            SimpleRoute simpleRoute = simpleRouteDao.getSimpleRoute(startPoint, endPoint);
            if (simpleRoute == null) {
                duerCommunication.setBroadcast(SimpleRouteBroadcastEnum.NON_ROUTE.getTip());
            } else {
                duerCommunication.setBroadcast(simpleRoute.getRouteDescription());
                duerCommunication.setKey(Integer.toHexString(Integer.parseInt(simpleRoute.getRouteKey())).toLowerCase());
            }
        }
        return duerCommunication;
    }

}
