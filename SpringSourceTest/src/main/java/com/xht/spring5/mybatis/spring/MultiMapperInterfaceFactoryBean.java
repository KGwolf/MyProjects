package com.xht.spring5.mybatis.spring;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName: MultiMapperInterfaceFactoryBean
 * @Description: N个Mapper接口的FactoryBean，
 *
 * 在哪里进行引用呢？
 *      1.refresh之前，手动进行beanDefinition的注册。
 *      2.定义1个BeanDefinitionRegistryPostProcessor，重写postProcessBeanDefinitionRegistry 方法。但是这样也需要手动添加。
 *      3.实现自动扫描并且自动注册beanDefinition：自定义一个类，实现 ImportBeanDefinitionRegistrar 。自定义一个扫描注解，在注解上通过@Import来导入刚刚的自定义类。
 *
 * 我们这里获取代理类：
 *      1.用jdk实现动态代理，这只是一种模拟，并不能得到一个真实的mybatis代理类。
 *      2.mybatis自己内部产生一个代理类。这是我们真正要获取到的，这样才能链接数据库进行查询。
 *             1) 看官网，首先要构建一个 SqlSessionFactory（可以从xml中构建，可以写java代码）
 *                  这里只需要一个就行了。可以在配置类里面生成@Bean。
 *             2）根据sqlSessionFactory.openSession()方法来获取一个 sqlSession。
 *             3）sqlSession.getMapper(xxxMapper.class) 获取一个mapper。后续就调用mapper方法进行数据库操作即可。
 *
 * @Author: xiahaitao
 * @Date: 2024/11/8 9:37
 * @Version: V1.0
 */
@Component
public class MultiMapperInterfaceFactoryBean implements FactoryBean {

    private Class targetClass;

//    private SqlSession sqlSession;

    public MultiMapperInterfaceFactoryBean(Class classTarget){
        targetClass = classTarget;
    }


//    @Autowired
//    public void setSqlSession(SqlSessionFactory sqlSessionFactory){
//        sqlSessionFactory.getConfiguration().addMapper(targetClass);
//        sqlSession = sqlSessionFactory.openSession();
//    }

    @Override
    public Object getObject() throws Exception {
        //这里我们用jdk的动态代理来获得一个代理类。真实用MyBatis，肯定是MyBatis自己内部实现的一个代理类。
        Object o = Proxy.newProxyInstance(MultiMapperInterfaceFactoryBean.class.getClassLoader(), new Class[]{targetClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });

//        return sqlSession.getMapper(targetClass);


        return o;
    }

    @Override
    public Class<?> getObjectType() {
        return targetClass;
    }
}
