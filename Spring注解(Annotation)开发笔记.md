## 1.注解(Annotation)开发

* 定义：通过Spring框架提供的一系列相关注解完成项目中快速开发

* 注解：Annotation时java中一种特殊类 类似于interface  使用时：@注解类名(属性=参数)

##  2.spring中注解

* 前置条件：必须在工厂配置文件中完成注解扫描
  * <context:components-scan base-package="com.yuanfang" />

### 1）创建对象相关注解

* @component注解  通用组件创建注解
  * 作用：用来负责对象的创建       ============> <bean id="" class="" />
  * 修饰范围：只能用来类上

**注意：默认使用这个注解在工厂中创建的对象的唯一标识为：类名首字母小写** 

**value属性作用：用来指定创建的对象在工厂中唯一标识 	推荐：存在接口使用接口首字母小写 | 不存在使用默认**

### 2）控制对象在工厂中创建次数

* a.配置文件修改  <bean id="" class="" scope="singleton|propotype"

* b.注解修改

* @Scope
  * 作用：	用来指定对象的创建次数默认单例
  * 修饰范围：只能加在类上
  * value属性：singleton 单例（默认） | propotype（多例）

**注意：在管理struts的action时必须加入@Scope注解值必须为propotype**

### 3）属性注入的相关注解

* a.spring框架提供的  	@Autowired ：默认根据类型进行注入（推荐）

* b.javaEE中本身中就有     @Resource   ：默认根据名字注入，名称找不到时根据类型注入

修饰范围：用在类中的成员变量，或者是成员变量中的SET方法上

作用：用来完成成员变量的赋值|注入操作

**注意：使用注解进行注入时，日后注入的成员变量可以不再提供SET方法**

### 4）控制事务注解

**@Transactional**

* 作用：用来给类中方法加入事务控制， 简化事务通知及事务细粒度控制配置和事务切面配置

* 修饰范围：类|方法上 采用局部优先原则
  * 1.加在类上，代表类中所有方法加入事务控制
  * 2.加在方法上，代表当前方法加入事务控制
  * 3.类和方法上同时存在，方法优先

**使用要求：若想让@Transactional这个注解生效，必须在配置中如下配置**

* **<tx:annotation-driven transaction-manager="transactionManager" />**

注解属性：

@Transactional(propagation = Propagation.SUPPORTS....)