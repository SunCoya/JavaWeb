package org.example.web.response;

import org.apache.commons.io.IOUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
//如何响应字节数据（传图片）？
@WebServlet("/resp3")
public class Demo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("响应字节数据,需要用到字节输出流");
        FileInputStream fis = new FileInputStream("C:\\Users\\33428\\Pictures\\壁纸\\2.png");
        IOUtils.copy(fis,resp.getOutputStream());
        fis.close();
    }
}
