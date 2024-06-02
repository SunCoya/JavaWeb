package org.example.servlet.crud;

import org.example.pojo.Brand;
import org.example.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/selectByIdServlet")
public class SelectByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[DEBUG]用户选择需修改数据,查询该id对应的对象...");
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("brand", new BrandService().selectById(Integer.parseInt(request.getParameter("id"))));
        request.getRequestDispatcher("/update.jsp").forward(request, response);
    }
}