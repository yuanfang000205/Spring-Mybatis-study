package factorybean;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.util.Calendar;

/**
 * @ClassName TestSpring
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/8/27
 **/
public class TestSpring {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("factorybean/spring.xml");
        Calendar calendar = (Calendar) context.getBean("calendarFactoryBean");
        Connection connection = (Connection) context.getBean("connectionFactoryBean");
        System.out.println(calendar.getTime());
        System.out.println(connection);

        SqlSessionFactory ssf = (SqlSessionFactory) context.getBean("sqlSessionFactory");
        System.out.println(ssf.openSession());
    }
}
