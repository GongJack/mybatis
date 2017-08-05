package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by gh102 on 2017-08-03.
 */
public class UserMapperImplTest {

    private UserMapper userMapper;
    @Before
    public void setUp() throws Exception {
        String resource ="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession( true);
        userMapper=sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void queryUserById() throws Exception {
        User user = userMapper.queryUserById(1L);
        System.out.println(user);
    }

    @Test
    public void queryNameByLike() throws Exception {
        List<User> users = userMapper.queryNameByLike("李");
        System.out.println(users);
    }

    @Test
    public void queryUserAll() throws Exception {
        List<User> users = userMapper.queryUserAll("tb_user");
        System.out.println(users);
    }

    @Test
    public void insertUser() throws Exception {
        User user = new User();
        user.setAge(19);
        user.setName("柳小岩");
        user.setPassword("123456");
        user.setUserName("yany");
        user.setSex(3);
        user.setBirthday(new Date());
        userMapper.insertUser(user);
        System.out.println(user.getId());
    }

    @Test
    public void updateUser() throws Exception {
        User user = userMapper.queryUserById(10L);
        user.setAge(18);
        userMapper.updateUser(user);

    }

    @Test
    public void deleteUserById() throws Exception {
        userMapper.deleteUserById(10L);

    }



                //----------------      动态sql        --------------------
    @Test           //查询男性用户，如果输入了用户名，按用户名模糊查询
    public void queryUserListLikeUserName(){
        List<User> users = userMapper.queryUserListLikeUserName("李");
        for (User user:users
             ) {
            System.out.println(user);
        }
    }


    /**
     * 查询男性用户，如果输入了用户名则按照用户名模糊查找，否则如果输入了年龄则按照年龄查找，否则查找用户名为“zhangsan”的用户。
     */
    @Test
    public void queryUserListLikeUserNameOrAge(){
        List<User> users =userMapper.queryUserListLikeUserNameOrAge("li",19);
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 修改用户信息，如果参数user中的某个属性为null，则不修改。
     */
    @Test
    public void updateUserSelective(){
        User user = new User();
        user.setId(9l);
        user.setAge(78);
        user.setName("柳小岩");
        userMapper.updateUserSelective(user);
    }

    /**
     * 根据多个id查询用户信息
     */
    @Test
    public void queryUserListByIds(){
        Long[] arr ={1l,6l,8l,9l};
        List<User> users =userMapper.queryUserListByIds(arr);
        for (User user : users) {
            System.out.println(user);
        }
    }
}