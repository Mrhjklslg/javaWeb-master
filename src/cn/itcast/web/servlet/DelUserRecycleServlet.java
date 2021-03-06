package cn.itcast.web.servlet;

import cn.itcast.service.UserRecycleService;
import cn.itcast.service.impl.UserRecycleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DelUserRecycleServlet")
public class DelUserRecycleServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取id
        String id = request.getParameter("id");
        //2.调用service删除
        UserRecycleService service = new UserRecycleServiceImpl();
        service.deleteUserRecycle(id);

        //3.跳转到查询所有Servlet
        response.sendRedirect(request.getContextPath()+"/FindUserRecycleServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
