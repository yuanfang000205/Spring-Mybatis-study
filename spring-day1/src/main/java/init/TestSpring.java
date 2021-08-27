package init;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName TestSpring
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/8/26
 **/
public class TestSpring {
    public static void main(String[] args) {
        //启动工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("init/spring.xml");
        //获取工厂中创建好的对象  参数：获取工厂中指定对应的唯一标识
        UserService userService = (UserService) context.getBean("userService");
        userService.save("xiaowang");
    }
}
