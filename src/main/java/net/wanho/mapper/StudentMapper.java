package net.wanho.mapper;

import net.wanho.pjo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/12/10.
 */

public interface StudentMapper {
    void addstu(Student student);
    List<Student> getAllStus();
    void deleteById(Integer id);



    List<Student> getAllStusPage(@Param("gender") String gender, @Param("address") String address);

    Student getStuById(Integer id);

    void updateStu(Student student);
}
