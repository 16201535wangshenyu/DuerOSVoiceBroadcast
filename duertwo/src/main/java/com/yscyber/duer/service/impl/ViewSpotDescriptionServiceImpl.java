package com.yscyber.duer.service.impl;

import com.yscyber.duer.constant.ViewspotDescriptionBroadcastEnum;
import com.yscyber.duer.dao.ViewSpotDescriptionDao;
import com.yscyber.duer.dao.impl.ViewSpotDescriptionDaoImpl;
import com.yscyber.duer.entity.DuerCommunication;
import com.yscyber.duer.entity.ViewSpotDescription;
import com.yscyber.duer.service.ViewSpotDescriptionService;

/**
 * 
 */
public class ViewSpotDescriptionServiceImpl implements ViewSpotDescriptionService {

    private ViewSpotDescriptionDao viewSpotDescriptionDao = new ViewSpotDescriptionDaoImpl();

    @Override
    public DuerCommunication broadcastViewSpotDescription(String viewSpot) {
        DuerCommunication duerCommunication = new DuerCommunication();
        ViewSpotDescription viewSpotDescription = viewSpotDescriptionDao.getViewSpotDescription(viewSpot);
        if (viewSpotDescription == null) {
            duerCommunication.setBroadcast(ViewspotDescriptionBroadcastEnum.NON_DESCRIPTION.getTip());
        } else {
            duerCommunication.setBroadcast(viewSpotDescription.getDescriptionDescription());
            duerCommunication.setKey(Integer.toHexString(Integer.parseInt(viewSpotDescription.getDescriptionId())).toLowerCase());
        }
        return duerCommunication;
    }
}
