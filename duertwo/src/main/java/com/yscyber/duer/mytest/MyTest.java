package com.yscyber.duer.mytest;

import com.yscyber.duer.dao.ViewSpotDescriptionDao;
import com.yscyber.duer.dao.impl.ViewSpotDescriptionDaoImpl;
import com.yscyber.duer.entity.DuerCommunication;
import com.yscyber.duer.entity.ViewSpotDescription;
import com.yscyber.duer.service.ViewSpotDescriptionService;
import com.yscyber.duer.service.impl.ViewSpotDescriptionServiceImpl;
import org.junit.Test;

public class MyTest {

    @Test
    public void demo1() {
        ViewSpotDescriptionDao viewSpotDescriptionDao = new ViewSpotDescriptionDaoImpl();
        ViewSpotDescription description = viewSpotDescriptionDao.getViewSpotDescription("东门");
        System.out.println(description);
    }

    @Test
    public void demo2() {
        ViewSpotDescriptionService service = new ViewSpotDescriptionServiceImpl();
        DuerCommunication duer = service.broadcastViewSpotDescription("详细信息");
        System.out.println(duer.toString());
    }

}
