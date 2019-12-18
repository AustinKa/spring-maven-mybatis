package net.wanho.service.impl;

import net.wanho.mapper.ClassroomMapper;
import net.wanho.pjo.Classroom;
import net.wanho.service.ClassroomServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/12/17.
 */
@Service
public class ClassroomServiceImpl implements ClassroomServiceI {
    @Autowired
    private ClassroomMapper classroomMapper;
    @Override
    public List<Classroom> getAllClasses() {
        List<Classroom> classrooms = classroomMapper.getAllClasses();
        return classrooms;
    }
}
