package cn.itcast.web.servlet;

import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.domain.User;
import cn.itcast.domain.UserRecycle;
import cn.itcast.service.UserRecycleService;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserRecycleServiceImpl;
import cn.itcast.service.impl.UserServiceImpl;
import com.sun.org.apache.bcel.internal.generic.NEW;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/RecoverUserServlet")
public class RecoverUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取id
        String id = request.getParameter("id");
        UserRecycleService service = new UserRecycleServiceImpl();
        UserService service1 = new UserServiceImpl();

        if(service.findUserRecycleById(id)==null){
            System.out.println("错误");
        }
        String name = service.findUserRecycleById(id).getName();
//判断数据是否存在
        List<User> User1 = new UserDaoImpl().findByName(name);
        if(User1.size()!=0 && User1.get(0).getName()!=null){
            request.setAttribute("recycle_msg","用户已存在,请删除！");
            request.getRequestDispatcher("/UserRecycleList.jsp").forward(request,response);
        }else {
            //添加到原表
            UserRecycle userRecycle = service.findUserRecycleById(id);
            User user = new User();
            user.setAddress(userRecycle.getAddress());
            user.setAge(userRecycle.getAge());
            user.setQq(userRecycle.getQq());
            user.setEmail(userRecycle.getEmail());
            user.setGender(userRecycle.getGender());
            user.setId(userRecycle.getId());
            user.setName(userRecycle.getName());
            user.setPassword(userRecycle.getPassword());
            new UserDaoImpl().addLzw(user);

            //2.调用service删除

            service.deleteUserRecycle(id);

            //3.跳转到查询所有Servlet
            response.sendRedirect(request.getContextPath()+"/FindUserRecycleServlet");
        }



    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
