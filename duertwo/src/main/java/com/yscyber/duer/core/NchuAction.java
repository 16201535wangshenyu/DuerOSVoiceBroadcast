package com.yscyber.duer.core;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 
 */
@WebServlet("/duer")
public class NchuAction extends HttpServlet {

    public NchuAction() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NchuBot bot = new NchuBot(request);
        bot.enableVerify();
        try {
            String responseJSON = bot.run();
            response.setCharacterEncoding("UTF-8");
            response.getWriter().append(responseJSON);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().append("{\"status\":1,\"msg\":\"\"}");
        }
    }
}
