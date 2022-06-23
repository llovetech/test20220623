package com.bjpowernode;

import com.bjpowernode.service.BabyService;
import com.bjpowernode.service.impl.BabyServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTest {
    @Test
    public void testSpecialService() {
        BabyService service = new BabyServiceImpl();
        service.specialService();
    }

    @Test
    public void testSpecialService02() {
        // 使用Spring容器创建的对象
        // 1、指定Spring配置文件
        String config = "beans.xml"; // 从类的根路径classes开始找
        // 2、创建表示Spring容器的对象，ApplicationContext表示Spring容器
        // ClassPathXmlApplicationContext表示从类路径中加载Spring配置文件
        // FileSystemXmlApplicationContext表示从硬盘中加载Spring配置文件（很少用）
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        // 3、从容器中获取某个对象,根据对象名（配置文件中的bean的id值）
        BabyService babyService = (BabyService) ac.getBean("babyService");

        // 4、使用Spring创建好的对象
        babyService.specialService();
    }

    @Test
    public void testSpecialService03() {
        String config = "beans.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        int num = ac.getBeanDefinitionCount();
        System.out.println("容器中定义的对象的数量:" + num);
        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        Date myDate = (Date) ac.getBean("myDate");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String dateStr = df.format(myDate);
        System.out.println(dateStr);
    }
}
