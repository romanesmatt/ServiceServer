package nz.ac.vuw.swen301.tuts.service.server;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class OddServicesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int i = 0;

        try{
            String number = req.getParameter("number");
            i = Integer.parseInt(number);
        }catch(NumberFormatException e){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        boolean isOdd = i % 2 == 1;

        resp.setContentType("plain/text");
        PrintWriter out = resp.getWriter();
        out.println(isOdd ? "yes": "no");
        out.close();

    }
}
