package net.wanho.service;

import com.github.pagehelper.PageInfo;
import net.wanho.pjo.Student;

import java.util.List;

public interface StudentServiceI {

    void addStu(Student student);

    List<Student> getAllStus();
    void deleteById(Integer id);
    void delStuById(Integer id);

    Student getStuById(Integer id);

    void updateStu(Student student);

    PageInfo<Student> getAllStusPage(Integer pageNum, String gender, String address);
}
