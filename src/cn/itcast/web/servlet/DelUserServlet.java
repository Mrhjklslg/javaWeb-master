package cn.itcast.web.servlet;

import cn.itcast.domain.User;
import cn.itcast.domain.UserRecycle;
import cn.itcast.service.UserRecycleService;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserRecycleServiceImpl;
import cn.itcast.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delUserServlet")
public class DelUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取id
        String id = request.getParameter("id");

        UserService service = new UserServiceImpl();
        UserRecycleService service1 = new UserRecycleServiceImpl();

        //添加到回收表
        User user = service.findUserById(id);
        System.out.println("ffffffffffff"+user.toString());
        UserRecycle userRecycle = new UserRecycle();
        userRecycle.setAddress(user.getAddress());
        userRecycle.setAge(user.getAge());
        userRecycle.setQq(user.getQq());
        userRecycle.setEmail(user.getEmail());
        userRecycle.setGender(user.getGender());
        userRecycle.setId(user.getId());
        userRecycle.setName(user.getName());
        userRecycle.setPassword(user.getPassword());
        System.out.println("ffffffffffdddddff"+userRecycle.toString());
        service1.addUserRecycle(userRecycle);

        //2.调用service删除

        service.deleteUser(id);

        //3.跳转到查询所有Servlet
        response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
