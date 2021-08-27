package factorybean;

import org.springframework.beans.factory.FactoryBean;

import java.util.Calendar;

/**
 * @ClassName CalendarFactoryBean
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/8/27
 **/
public class CalendarFactoryBean implements FactoryBean<Calendar> {
    /** 用来书写复杂对象的创建形式 */
    @Override
    public Calendar getObject() throws Exception {
        return Calendar.getInstance();
    }

    /** 指定复杂对象创建的类型*/
    @Override
    public Class<?> getObjectType() {
        return Calendar.class;
    }

    /** 指定创建的对象模式 true：单例 false：多例*/
    @Override
    public boolean isSingleton() {
        return true;
    }
}
