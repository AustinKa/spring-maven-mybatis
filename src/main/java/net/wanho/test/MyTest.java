package net.wanho.test;

import net.wanho.pjo.Student;
import net.wanho.service.StudentServiceI;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2019/12/10.
 */
public class MyTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        StudentServiceI studentServiceI = ctx.getBean(StudentServiceI.class);
        studentServiceI.addStu(new Student(null,"zhangsan",12,"男","北京",1));
        List<Student> stus = studentServiceI.getAllStus();
        System.out.println(stus);
    }
}
