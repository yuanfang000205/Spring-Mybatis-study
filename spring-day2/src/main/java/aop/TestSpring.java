package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import staticproxy.UserService;

/**
 * @ClassName TestSpring
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/8/27
 **/
public class TestSpring {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("aop/spring.xml");

        EmpService empService = (EmpService) context.getBean("empService");

        System.out.println(empService.getClass());
        empService.save("小陈");
    }
}
