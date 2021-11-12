package cn.itcast.service;

import cn.itcast.domain.PageBean;
import cn.itcast.domain.UserRecycle;

import java.util.List;
import java.util.Map;

/**
 * 用户管理的业务接口
 */
public interface UserRecycleService {

    /**
     * 查询所有用户信息
     * @return
     */
    public List<UserRecycle> findAll();


//    User login(User user);
//
//    /**
//     * 保存User
//     * @param user
//     */
    void addUserRecycle(UserRecycle userRecycle);
//
    /**
     * 根据id删除User
     * @param id
     */
    void deleteUserRecycle(String id);
//
//    /**
//     * 根据id查询
//     * @param id
//     * @return
//     */
     UserRecycle findUserRecycleById(String id);
//
//    /**
//     * 修改用户信息
//     * @param user
//     */
//    void updateUser(User user);
//
//    /**
//     * 批量删除用户
//     * @param ids
//     */
//    void delSelectedUser(String[] ids);

    /**
     * 分页条件查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<UserRecycle> findUserRecycleByPage(String currentPage, String rows, Map<String, String[]> condition);
}
