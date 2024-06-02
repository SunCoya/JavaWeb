package org.example.servlet;
import com.alibaba.fastjson.JSON;
import org.example.pojo.Brand;
import org.example.pojo.PageBean;
import org.example.service.BrandService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet{
    private final BrandService service =new BrandService();
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("add...");
        service.add(JSON.parseObject(request.getReader().readLine(),Brand.class));
        response.getWriter().write("success");
    }
    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("deleteById...");
        service.deleteById(Integer.parseInt(request.getParameter("id")));
        response.getWriter().write("success");
    }
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.print("update...");
        service.update(JSON.parseObject(request.getReader().readLine(),Brand.class));
        response.getWriter().write("success");
    }
    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.print("deleteMany...");
        service.deleteByIds(JSON.parseObject(request.getReader().readLine(),int[].class));
        response.getWriter().write("success");
    }
    //post+get方式来实现分页查询+条件查询，条件查询可有可无
    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("brand selectByPageAndCondition...");
        response.setContentType("text/json;charset=UTF-8");
        response.getWriter().write(
                JSON.toJSONString(
                        service.selectByPageAndCondition(
                                Integer.parseInt(request.getParameter("currentPage")),
                                Integer.parseInt(request.getParameter("pageSize")),
                                JSON.parseObject(request.getReader().readLine(),Brand.class)
                        )));
    }
}
