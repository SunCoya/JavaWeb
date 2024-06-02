package org.example.servlet.login;

import org.example.util.CheckCodeUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//通过响应数据的输出流生成图片,并且把验证码设置为Session的键值对
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String checkCode= CheckCodeUtil.outputVerifyImage(100,50,response.getOutputStream(),4);
        System.out.println("[DEBUG]验证码为:"+checkCode);
        System.out.println("[DEBUG]返回生成的图片...");
        request.getSession().setAttribute("checkCodeGen",checkCode);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
