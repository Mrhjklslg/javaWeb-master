package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户操作的DAO
 */
public interface UserDao {


    public List<User> findAll();

    User findUserByUsernameAndPassword(String name, String password);

    void add(User user);

    void addLzw(User user);
    User findUserByUsername(String name);
    void addAdmin(User user);

    void delete(int id);

    User findById(int i);

    List<User> findByName(String name);

    void update(User user);

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
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
