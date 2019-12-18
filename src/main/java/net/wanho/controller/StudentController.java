package net.wanho.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import net.wanho.pjo.Classroom;
import net.wanho.pjo.Stu;
import net.wanho.pjo.Student;
import net.wanho.service.ClassroomServiceI;
import net.wanho.service.StudentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/12/12.
 */
@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentServiceI studentServiceI;
    @Autowired
    private ClassroomServiceI classroomServiceI;
    @RequestMapping("selectStu")
    @ResponseBody
    public List<Student> selectStu(){
        List<Student> studento = studentServiceI.getAllStus();
            return studento;
    }

    @RequestMapping("deleteStu")
    @ResponseBody
    public List<Student>  deleteStu(@RequestBody Stu stu){
        studentServiceI.deleteById(stu.getId());
        List<Student> studento = studentServiceI.getAllStus();
        return studento;

    }
    @RequestMapping("toStu")
    public String toStu(){
        return "stu";
    }


    @RequestMapping("stus")
    public String stus(Map map) {

        List<Student> stus = studentServiceI.getAllStus();
        map.put("stus", stus);
        return "student";
    }

    @RequestMapping("getAllStus")
    public String getAllStus(@RequestParam(defaultValue = "1") Integer pageNum,String gender,String address,Map map) {
        PageInfo<Student> pageInfo = studentServiceI.getAllStusPage(pageNum, gender, address);
        System.out.println(pageInfo);
        map.put("pageInfo", pageInfo);
        map.put("gender", gender);
        map.put("address", address);
        return "student";
    }


    @RequestMapping("addStu")
    public String addStu(Student student) {
        studentServiceI.addStu(student);

        return "redirect:/getAllStus";
    }


    @RequestMapping("toAddStu")
    public String toAddStu(Map map) {
        List<Classroom> allClasses = classroomServiceI.getAllClasses();
        map.put("classes", allClasses);
        return "addStu";
    }


    @RequestMapping("delStu")
    public String delStu(Integer id) {
        studentServiceI.delStuById(id);
        return "redirect:/getAllStus";
    }

    @RequestMapping("toUpdateStu")
    public String toUpdateStu(Integer id,Map map) {


        Student stu = studentServiceI.getStuById(id);
        List<Classroom> allClasses = classroomServiceI.getAllClasses();


        map.put("stu", stu);
        map.put("classes", allClasses);

        return "updateStu";
    }

    @RequestMapping("updateStu")
    public String updateStu(Student student) {

        studentServiceI.updateStu(student);

        return "redirect:/getAllStus";
    }


}
