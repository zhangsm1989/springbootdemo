package com.zhang.springboot.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.URIParameter;

/**
 * 使用注解注册Servlet示例代码
 * 在application中添加@ServletComponentScan//这个就是扫描相应的Servlet包;
 * Created by sm on 2016/11/8.
 */
@WebServlet(urlPatterns = "/MyServlet02/*",description = "Servlet 注解注册方式")
public class MyServlet02 extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info(">>>>>>>>>>doGet()<<<<<<<<<<<");
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info(">>>>>>>>>>doPost()<<<<<<<<<<<");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>这是：MyServlet02</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
