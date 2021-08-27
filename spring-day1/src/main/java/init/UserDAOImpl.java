package init;

/**
 * @ClassName UserDAOImpl
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/8/26
 **/
public class UserDAOImpl implements UserDAO{

    @Override
    public void save(String name) {
        System.out.println("UserDAO name = " + name);
    }
}
