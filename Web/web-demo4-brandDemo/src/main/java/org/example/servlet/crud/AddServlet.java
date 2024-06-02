package org.example.servlet.crud;
import org.example.pojo.Brand;
import org.example.service.BrandService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[DEBUG]用户添加数据...");
        req.setCharacterEncoding("UTF-8");
        new BrandService().add(new Brand(null,
                req.getParameter("brandName"),
                req.getParameter("brandName"),
                Integer.parseInt(req.getParameter("ordered")),
                req.getParameter("description"),
                Integer.parseInt(req.getParameter("status"))));
        resp.sendRedirect("/web_demo4_brandDemo_war/selectAllServlet");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
