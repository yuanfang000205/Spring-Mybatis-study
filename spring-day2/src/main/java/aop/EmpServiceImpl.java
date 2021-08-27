package aop;

/**
 * @ClassName EmpServiceImpl
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/8/27
 **/
public class EmpServiceImpl implements EmpService {
    @Override
    public void save(String name) {
        System.out.println("处理业务逻辑调用save DAO~~~ " + name);
    }

    @Override
    public String find(String name) {
        System.out.println("处理业务逻辑调用find DAO~~~ " + name);

        return name;
    }
}
