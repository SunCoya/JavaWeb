package org.example.servlet.crud;
import org.example.pojo.Brand;
import org.example.service.BrandService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[DEBUG]用户选择修改数据,修改数据库内容");
        req.setCharacterEncoding("UTF-8");
        Brand brand=new Brand(null,
                req.getParameter("brandName"),
                req.getParameter("brandName"),
                Integer.parseInt(req.getParameter("ordered")),
                req.getParameter("description"),
                Integer.parseInt(req.getParameter("status")));
        new BrandService().update(brand);
        req.getRequestDispatcher("/selectAllServlet").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

