package cn.itcast.dao;


import cn.itcast.domain.UserRecycle;

import java.util.List;
import java.util.Map;


/**
 * 用户操作的DAO
 */
public interface UserRecycleDao {


    public List<UserRecycle> findUserRecycleAll();

//    User findUserByUsernameAndPassword(String name, String password);
//u
    void add(UserRecycle userRecycle);
//
    void delete(int id);

    UserRecycle findById(int i);
//
//    void update(User user);
//
    /**
     * 查询总记录数
     * @return
     * @param condition
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 分页查询每页记录
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<UserRecycle> findByPage(int start, int rows, Map<String, String[]> condition);
}
