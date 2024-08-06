import com.eagles.mapper.AccountMapper;
import com.eagles.mapper.RoleMapper;
import com.eagles.mapper.UserMapper;
import com.eagles.pojo.Account;
import com.eagles.pojo.Role;
import com.eagles.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    InputStream inputStream = null;
    SqlSession sqlSession = null;

    SqlSessionFactory factory = null;

    // 创建工厂对象
    @Before
    public void mybatisBefore() {
        // 读取配置文件
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 创建SqlSessionFactoryBuilder工厂实例
        factory = new SqlSessionFactoryBuilder().build(inputStream);

        // 创建SqlSession对象
        sqlSession = factory.openSession();
    }


    // 回收资源
    @After
    public void mybatisAfter() {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if (sqlSession != null) {

            sqlSession.commit();

            sqlSession.close();
        }
    }

    @Test
    public void test01(){

        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);

        List<Account> accounts = mapper.findAccounts();

        for (Account account : accounts) {
            System.out.println(account);
        }

    }

    @Test
    public void test02(){

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = mapper.getUserList();

        for (User user : users) {

            List<Account> accounts = user.getAccounts();

            System.out.println(user);

        }
    }

    @Test
    public void test03(){

        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);

        List<Role> roles = mapper.getRoleList();

        for (Role role : roles) {
            System.out.println(role);
        }

    }


    // TODO note
    @Test
    public void test04(){

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = mapper.getUserList();

        for (User user : users) {
            System.out.println(user);
        }

    }

    @Test
    public void test05(){

        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);

        List<Account> accounts = mapper.findAccounts();

        sqlSession.close();
        sqlSession = factory.openSession();

        mapper = sqlSession.getMapper(AccountMapper.class);

        List<Account> accountList = mapper.findAccounts();

        // 二级缓存只是将数据存储，而不是java对象
        System.out.println(accounts == accountList);

    }

}
