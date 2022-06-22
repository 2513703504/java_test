package com.ctbu.controller;

import com.ctbu.common.Result;
import com.ctbu.pojo.Student;
import com.ctbu.service.CourseAndStu;
import com.ctbu.service.StudentService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author : TangHao
 * @description :
 * @ClassName :StudentController
 * @createTime : 2022/6/21 15:51
 * @updateTime : 2022/6/21 15:51
 * @updateRemark : [说明本次修改内容]
 */

@RestController
@RequestMapping("/students")
@Slf4j
public class StudentController {

    @Resource
    private StudentService studentService;

    @Resource
    private CourseAndStu courseAndStu;
    /**
     * 查询所有学生
     * @param page
     * @return
     */
    @GetMapping("/{page}")
    public Result<List<Student>> queryStudent(@PathVariable int page) {

        List<Student> students = studentService.queryStudent(page);
        PageInfo pageInfo=new PageInfo(students);
        return students.size()>0 ? Result.success(students,"pageInfo",pageInfo) : Result.error("未找到学生信息");
    }

    /**
     * 按条件查询
     * @param map
     * @return
     */
    @PostMapping("/query")
    public Result<List<Student>> queryStudentByCondition(@RequestBody Map<String,Object> map){
        Student student=new Student();
        if("".equals(map.get("stuName"))){
            student.setStuName(null);
        }else {
            student.setStuName((String) map.get("stuName"));
        }
        if("".equals(map.get("grade"))){
            student.setGrade(null);
        }else {
            student.setGrade((Integer) map.get("grade"));
        }
        Integer page= (Integer) map.get("page");
        log.debug(String.valueOf(student));
        log.debug(String.valueOf(page));
        Integer gender=null;
        if("男".equals(map.get("sex"))){
            gender=1;
        }
        if("女".equals(map.get("sex"))){
            gender=2;
        }
        List<Student> students=studentService.queryStudentByCondition(student,gender,page);
        PageInfo pageInfo=new PageInfo(students);
        return students.size()>0 ? Result.success(students,"pageInfo",pageInfo) : Result.error("未找到学生信息");
    }

    /**
     * 删除学生
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result<String> deleteStudent(@PathVariable int id){
        log.debug("{}",id);
        int result=studentService.deleteStudent(id);
        return result>0 ? Result.success("删除成功") : Result.error("删除失败");
    }

    /**
     * 添加学生
     * @param student
     * @return
     */
    @PostMapping()
    public Result<String> addStudent(@RequestBody Student student){
        log.debug("student:{}",student);
        int gender=1;
        if("女".equals(student.getSex())){
            gender=2;
        }
        int result=studentService.addStudent(student,gender);
        return result>0 ? Result.success("添加成功") : Result.error("添加失败");
    }

    /**
     * 根据id查询学生详细信息
     * @param id
     * @return
     */
    @GetMapping("/student/{id}")
    public Result<Student> queryStudentDetail(@PathVariable int id){
        Student student=studentService.queryStudentDetail(id);
        return student!=null ? Result.success(student):Result.error("没有该学生信息");
    }

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    @PutMapping
    public Result<String> updateStudent(@RequestBody Student student){
        log.debug(String.valueOf(student));
        int result=studentService.updateStudent(student);
        return result>0? Result.success("修改成功"):Result.error("修改失败");
    }

    /**
     * 学生选课
     * @param map
     * @return
     */
    @PostMapping("/course")
    public Result<String> chooseCourse(@RequestBody Map<String,Object> map){

        int sid= (int) map.get("sid");
        log.debug("sid==>{}",sid);
        List<Integer> courseId= (List<Integer>) map.get("courseId");
        log.debug("courseId==>{}",courseId);
        int result=courseAndStu.addInfoOfChoose(sid,courseId);
        return result>0 ? Result.success("选课成功"):Result.error("选课失败");
    }
}
