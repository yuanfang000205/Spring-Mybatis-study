## Spring整合Mybatis

整合步骤：

### 1>导入相关依赖

#### 	spring mybatis mybatis-spring druid mysql ...

```xml
    <!--spring核心及相关依赖-->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-core</artifactId>
      <version>4.3.2.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-beans</artifactId>
      <version>4.3.2.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-web</artifactId>
      <version>4.3.2.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-expression</artifactId>
      <version>4.3.2.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-aop</artifactId>
      <version>4.3.2.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>4.3.2.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context-support</artifactId>
      <version>4.3.2.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-aspects</artifactId>
      <version>4.3.2.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-jdbc</artifactId>
      <version>4.3.2.RELEASE</version>
    </dependency>

    <!--mysql-->
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>8.0.21</version>
    </dependency>

    <!--mybatis-->
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis</artifactId>
      <version>3.5.4</version>
    </dependency>

    <!--mybatis-spring-->
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis-spring</artifactId>
      <version>2.0.4</version>
    </dependency>

    <!--druid 数据源配置-->
    <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>druid</artifactId>
      <version>1.1.19</version>
    </dependency>
```

### 2>建表

* 略

### 3>实体类

* 略

### 4>接口

* 略

### 5>mapper.xml

* ```xml
  <?xml version="1.0" encoding="utf-8" ?>
  <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
          "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
  <mapper namespace="com.yuanfang.dao.UserDAO">
      <select id="queryAll" resultType="com.yuanfang.entity.User">
          select id,name,age,bir from t_uesr
      </select>
  </mapper>
  ```

### 6>配置文件：spring.xml

- 数据源配置

```xml
<bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
    <property name="driverClassName" value="com.mysql.cj.jdbc.Driver"/>
    <property name="url" value="jdbc:mysql://localhost:3333/mybatis?serverTimezone=Asia/Shanghai"/>
    <property name="username" value="root"/>
    <property name="password" value="root"/>
</bean>
```

- SqlSessionFactory配置 ，在其中注入数据源和mapper.xml

  ```xml
  <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
      <!--依赖数据源-->
      <property name="dataSource" ref="dataSource"/>
      <!--注入mapper配置文件-->
      <property name="mapperLocations">
          <array>
              <value>classpath:com/yuanfang/mapper/UserDAOMapper.xml</value>
          </array>
      </property>
  </bean>
  ```

- DAO配置

  ```xml
  <bean id="userDAO" class="org.mybatis.spring.mapper.MapperFactoryBean">
      <!--注入sqlSessionFactory-->
      <property name="sqlSessionFactory" ref="sqlSessionFactory"/>
      <!--注入接口:全限定名-->
      <property name="mapperInterface" value="com.yuanfang.dao.UserDAO"/>
  </bean>
  ```


### 7>编写测试类

* ```java
  ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
  UserDAO  userDAO = (UserDAO) context.getBean("userDAO");
  ```

**UserDAO：需要什么接口就写接口名，context.getBean("userDAO")：括号里跟的是之前spring.xml中DAO配置时所注入的接口相应的id**