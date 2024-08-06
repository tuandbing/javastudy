import com.eagles.mybatis.mapper.UserMapper;
import com.eagles.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;

public class TestMybatis {

    InputStream inputStream = null;
    SqlSession sqlSession = null;

    String resource = "mybatis-config.xml";

    @Before
    public void mybatisBefore(){
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        sqlSession = factory.openSession();
    }

    @After
    public void mybatisAfter(){

        if(inputStream != null){
            try {
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if(sqlSession != null){

            sqlSession.commit();
            sqlSession.close();

        }
    }

    @Test
    public void getUserList(){

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = mapper.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

    }

    @Test
    public void getUserById(){

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        mapper.updateUser(user);

    }

    @Test
    public void updateUser(){

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(1,"馒头","江西省萍乡市");
        mapper.updateUser(user);

    }

    @Test
    public void insertUser(){

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("张三");
        user.setAddress("湖南省长沙市");
        mapper.insertUser(user);

    }

    @Test
    public void deleteUserById(){

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUserById(109);

    }

    @Test
    public void selectUserByLikeName(){

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserByLikeName("文");

        System.out.println(user);

    }

    @Test
    public void selectUserByMap(){

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, String> map = new HashMap<>();

        map.put("likeName","文");

        User user = mapper.selectUserByMap(map);

        System.out.println(user);

    }

    @Test
    public void limitUserList(){

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Object> map = new HashMap<>();

        map.put("startIndex",1);
        map.put("pageSize",3);

        List<User> userList = mapper.limitUserList(map);

        for (User user : userList) {
            System.out.println(user);
        }

    }

    @Test
    public void insertUserGetId(){

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("老刘");
        user.setAddress("湖南省长沙市");
        mapper.insertUserGetId(user);
        System.out.println(user);

    }

    @Test
    public void test09(){

        UserMapper proxy = (UserMapper) getProxy();

        List<User> userList = proxy.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

    }

    @Test
    public void getList(){

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("likeName","刘");
        map.put("indexStart",1);
        map.put("pageSize",4);
        List<User> userList = mapper.getList(map);
        for (User user : userList) {

            System.out.println(user);

        }


    }

    public Object getProxy(){

        return Proxy.newProxyInstance(UserMapper.class.getClassLoader(), new Class[]{UserMapper.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                Object invoke = method.invoke(new UserMapper() {
                    @Override
                    public List<User> getUserList() {
                        return sqlSession.selectList("com.eagles.mybatis.mapper.UserMapper.getUserList");
                    }

                    @Override
                    public User getUserById(Integer id) {
                        return null;
                    }

                    @Override
                    public Integer updateUser(User user) {
                        return null;
                    }

                    @Override
                    public Integer insertUser(User user) {
                        return null;
                    }

                    @Override
                    public Integer deleteUserById(Integer id) {
                        return null;
                    }

                    @Override
                    public User selectUserByLikeName(String likeName) {
                        return null;
                    }

                    @Override
                    public User selectUserByMap(HashMap<String, String> map) {
                        return null;
                    }

                    @Override
                    public List<User> limitUserList(HashMap<String, Object> map) {
                        return null;
                    }

                    @Override
                    public Integer insertUserGetId(User user) {
                        return null;
                    }

                    @Override
                    public List<User> getList(HashMap<String, Object> map) {
                        return null;
                    }
                }, args);

                return invoke;
            }
        });
    }

    @Test
    public void test00(){

        User user = new User();

        System.out.println(user);

    }
}
