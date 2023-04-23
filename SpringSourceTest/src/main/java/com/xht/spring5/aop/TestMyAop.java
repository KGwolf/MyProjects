package com.xht.spring5.aop;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Field;
import java.util.Properties;

/**
 * @ClassName: TestMyAop
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2023/4/23 10:43
 * @Version: V1.0
 */
public class TestMyAop {
    public static void main(String[] args) {
        try {
            saveGeneratedCGlibProxyFiles(System.getProperty("user.dir")+"/proxy");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ApplicationContext ac = new ClassPathXmlApplicationContext("myaop.xml");
        DealTaskProcessImpl bean = ac.getBean(DealTaskProcessImpl.class);
        System.out.println(bean.toString());

        bean.reviewTaskFromPass("123");

        bean.dealTaskByPrRules();

        bean.saveDataToDb();
    }

    public static void saveGeneratedCGlibProxyFiles(String dir) throws Exception {
        Field field = System.class.getDeclaredField("props");
        field.setAccessible(true);
        Properties props = (Properties) field.get(null);
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, dir);
        //dir为保存文件路径
        props.put("net.sf.cglib.core.DebuggingClassWriter.traceEnabled", "true");
    }
}

