package com.zhang.springboot.servlet;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 通过代码注册Servlet示例代码：
 * Created by sm on 2016/11/8.
 */
//这个不需要添加.
//@WebServlet(urlPatterns="/myServlet1/*", description="Servlet的说明")
public class MyServlet01 extends HttpServlet {
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
        out.println("<h1>这是：MyServlet1</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
