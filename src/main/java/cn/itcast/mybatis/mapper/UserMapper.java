package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by gh102 on 2017-08-03.
 */
public interface UserMapper {

    /**
     * 根据id获取用户信息
     */
    public User queryUserById(Long id);

    /**
     * 查询所有用户
     * @return
     */
    public List<User> queryUserAll(@Param("tableName") String tableName);

    /**
     * 模糊查询用户名
     * @return
     */
    public List<User> queryNameByLike(@Param("name") String name);

    /**
     * 新增用户
     * @param user
     */
    public void insertUser(User user);

    /**
     * 更新用户信息
     * @param user
     */
    public void updateUser(User user);

    /**
     * 根据id删除用户信息
     * @param id
     */
    public void deleteUserById(Long id);


                     //----------------------   动态sql     ---------------------------

    /**
     * 查询男性用户，如果输入了用户名，按用户名模糊查询
     */
    public List<User> queryUserListLikeUserName(@Param("name")String name);

    /**
     * 查询男性用户，如果输入了用户名则按照用户名模糊查找，否则如果输入了年龄则按照年龄查找，否则查找用户名为“zhangsan”的用户。
     */
    public List<User> queryUserListLikeUserNameOrAge(@Param("userName")String userName, @Param("age")Integer age);

    /**
     * 修改用户信息，如果参数user中的某个属性为null，则不修改。
     */
    public void updateUserSelective(User user);

    /**
     * 根据多个id查询用户信息
     */
    public List<User> queryUserListByIds(@Param("ids")Long[] ids);



}
