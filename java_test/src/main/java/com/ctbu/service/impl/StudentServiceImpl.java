package com.ctbu.service.impl;

import com.ctbu.mapper.StudentMapper;
import com.ctbu.pojo.Student;
import com.ctbu.service.CourseAndStu;
import com.ctbu.service.StudentService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : TangHao
 * @description :
 * @ClassName :StudentServiceImpl
 * @createTime : 2022/6/21 15:58
 * @updateTime : 2022/6/21 15:58
 * @updateRemark : [说明本次修改内容]
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Resource
    private CourseAndStu courseAndStu;
    /**
     * 查询所有学生
     *
     * @param page
     * @return
     */
    @Override
    public List<Student> queryStudent(int page) {
        PageHelper.startPage(page,10);
        return studentMapper.queryStudent();
    }

    /**
     * 删除学生
     *
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteStudent(int id) {
        int result=courseAndStu.deleteInfo(id);
        return result>0 ? studentMapper.deleteStudent(id) : 0;
    }

    /**
     * 添加学生
     *
     * @param student
     * @return
     */
    @Override
    public int addStudent(Student student,int gender) {
        return studentMapper.addStudent(student,gender);
    }

    /**
     * 查询学生详细信息
     *
     * @param id
     * @return
     */
    @Override
    public Student queryStudentDetail(int id) {
        return studentMapper.queryStudentDetail(id);
    }

    /**
     * 按条件查询学生信息
     *
     * @param student
     * @param gender
     * @return
     */
    @Override
    public List<Student> queryStudentByCondition(Student student, Integer gender,Integer page) {
        PageHelper.startPage(page,10);
        return studentMapper.queryStudentByCondition(student,gender);
    }

    /**
     * 修改学生信息
     *
     * @param student
     * @return
     */
    @Override
    public int updateStudent(Student student) {
        int geder=1;
        if ("女".equals(student.getSex())){
            geder=2;
        }
        return studentMapper.updateStudent(student,geder);
    }
}
