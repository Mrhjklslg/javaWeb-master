package cn.itcast.web.servlet;

import cn.itcast.domain.PageBean;
import cn.itcast.domain.UserRecycle;
import cn.itcast.service.UserRecycleService;
import cn.itcast.service.impl.UserRecycleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/FindUserRecycleServlet")
public class FindUserRecycleServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //1.获取参数
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示条数

        if(currentPage == null || "".equals(currentPage)){
            currentPage = "1";
        }


        if(rows == null || "".equals(rows)){
            rows = "5";
        }
        
        //获取条件查询参数
        Map<String, String[]> condition = request.getParameterMap();


        //2.调用service查询
        UserRecycleService service = new UserRecycleServiceImpl();
        PageBean<UserRecycle> pb = service.findUserRecycleByPage(currentPage,rows,condition);

        System.out.println(pb);

        //3.将PageBean存入request
        request.setAttribute("pb",pb);
        request.setAttribute("condition",condition);//将查询条件存入request
        //4.转发到list.jsp
        request.getRequestDispatcher("/UserRecycleList.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
