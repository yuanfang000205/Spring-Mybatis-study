package staticproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestDynamicProxy {
    public static void main(String[] args) {

        //使用动态代理对象：     指的是在程序运行过程中动态通过代码的方式为指定的类生成动态代理对象

        // 目标类
        UserService userService = new UserServiceImpl();
        //proxy 用来生成动态对象的类

        //参数一：classLoader 类加载器
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        //参数二：Class[] 目标对象的接口类型的数组
        Class[] classes = {UserService.class};

        //参数三：InvocationHandler接口类型  invoke方法：用来书写额外功能 附加操作

        //返回值：创建好的动态代理对象
        UserService proxy = (UserService) Proxy.newProxyInstance(classLoader, classes, new InvocationHandler() {
            @Override
            //通过动态代理对象调用自己里面代理方法时会优先进入invocationHandler里的invoke方法
            //参数一：当前创建好的代理对象  参数二：当前代理对象执行的方法对象  参数三：当前代理对象执行方法的参数
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("当前执行的方法： " + method.getName());
                System.out.println("当前执行方法的参数： " + args[0]);
                try {
                    System.out.println("开启事务！");
                    //调用目标类中的业务方法  通过反射机制，调用目标类当前方法
                    Object invoke = method.invoke(new UserServiceImpl(), args);
                    System.out.println("提交事务！");
                    return invoke;
                }catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("回滚事务！");
                }
                return null;
            }
        });

        System.out.println(proxy.getClass());
        proxy.findAll("陈建军");

    }
}
