package cn.itcast.dao.impl;

import cn.itcast.dao.UserRecycleDao;
import cn.itcast.domain.UserRecycle;
import cn.itcast.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @program: javaWeb
 * @description: UserRecycleImpl
 * @author: 梁忠伟
 * @create: 2021-11-11 19:24
 **/
public class UserRecycleDaoImpl implements UserRecycleDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public List<UserRecycle> findUserRecycleAll() {
        String sql = "select * from userrecycle";
        List<UserRecycle> userRecycles = template.query(sql, new BeanPropertyRowMapper<UserRecycle>(UserRecycle.class));
        userRecycles.forEach(System.out::println);
        return userRecycles;
    }

    @Override
    public void add(UserRecycle userRecycle) {
        //1.定义sql
        String sql = "insert into userrecycle values(?,?,?,?,?,?,?,?)";
        //2.执行sql
        template.update(sql,userRecycle.getId(), userRecycle.getName(), userRecycle.getGender(), userRecycle.getAge(), userRecycle.getAddress(), userRecycle.getQq(), userRecycle.getEmail(),userRecycle.getPassword());
    }

    @Override
    public UserRecycle findById(int id) {
        String sql = "select * from userrecycle where id = ?";
        UserRecycle userRecycle = template.queryForObject(sql, new BeanPropertyRowMapper<UserRecycle>(UserRecycle.class), id);
        if (userRecycle==null){
            return new UserRecycle();
        }
        return userRecycle;
    }

    @Override
    public void delete(int id) {
        //1.定义sql
        String sql = "delete from userrecycle where id = ?";
        //2.执行sql
        template.update(sql, id);
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //1.定义模板初始化sql
        String sql = "select count(*) from userrecycle where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {

            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                //有值
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//？条件的值
            }
        }
        System.out.println(sb.toString());
        System.out.println(params);

        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    @Override
    public List<UserRecycle> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from userrecycle  where 1 = 1 ";

        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {

            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                //有值
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//？条件的值
            }
        }

        //添加分页查询
        sb.append(" limit ?,? ");
        //添加分页查询参数值
        params.add(start);
        params.add(rows);
        sql = sb.toString();
        System.out.println(sql);
        System.out.println(params);

        return template.query(sql,new BeanPropertyRowMapper<UserRecycle>(UserRecycle.class),params.toArray());
    }
}
