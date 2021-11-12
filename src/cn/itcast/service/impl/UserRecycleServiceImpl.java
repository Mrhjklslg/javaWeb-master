package cn.itcast.service.impl;

import cn.itcast.dao.UserRecycleDao;
import cn.itcast.dao.impl.UserRecycleDaoImpl;
import cn.itcast.domain.PageBean;
import cn.itcast.domain.UserRecycle;
import cn.itcast.service.UserRecycleService;

import java.util.List;
import java.util.Map;

public class UserRecycleServiceImpl implements UserRecycleService {
    private UserRecycleDao dao = new UserRecycleDaoImpl();

    @Override
    public List<UserRecycle> findAll() {
        //调用Dao完成查询
        return dao.findUserRecycleAll();
    }

//    @Override
//    public User login(User user) {
//        return dao.findUserByUsernameAndPassword(user.getName(),user.getPassword());
//    }
//
    @Override
    public void addUserRecycle(UserRecycle userRecycle) {
        dao.add(userRecycle);
    }
//
//    @Override
//    public void deleteUser(String id) {
//        dao.delete(Integer.parseInt(id));
//    }
//
    @Override
    public UserRecycle findUserRecycleById(String id) {
        UserRecycle byId = dao.findById(Integer.parseInt(id));

        return byId;
    }
//
//    @Override
//    public void updateUser(User user) {
//        dao.update(user);
//    }
//
//    @Override
//    public void delSelectedUser(String[] ids) {
//        if(ids != null && ids.length > 0){
//            //1.遍历数组
//            for (String id : ids) {
//                //2.调用dao删除
//                dao.delete(Integer.parseInt(id));
//            }
//        }
//
//    }

    @Override
    public void deleteUserRecycle(String id) {
        dao.delete(Integer.parseInt(id));
    }


    @Override
    public PageBean<UserRecycle> findUserRecycleByPage(String _currentPage, String _rows, Map<String, String[]> condition) {

        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if(currentPage <=0) {
            currentPage = 1;
        }
        //1.创建空的PageBean对象
        PageBean<UserRecycle> pb = new PageBean<UserRecycle>();
        //2.设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //3.调用dao查询总记录数
        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);
        //4.调用dao查询List集合
        //计算开始的记录索引
        int start = (currentPage - 1) * rows;
        List<UserRecycle> list = dao.findByPage(start,rows,condition);
        System.out.println(list);
        pb.setList(list);

        //5.计算总页码
        int totalPage = (totalCount % rows)  == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);


        return pb;
    }
}
