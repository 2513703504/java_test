package com.ctbu.service;

import com.ctbu.pojo.Student;

import java.util.List;

/**
 * @author : TangHao
 * @description :
 * @InterfaceName :StudentService
 * @createTime : 2022/6/21 15:57
 */
public interface StudentService {
    /**
     * 查询所有学生
     * @param page
     * @return
     */
    List<Student> queryStudent(int page);

    /**
     * 删除学生
     * @param id
     * @return
     */
    int deleteStudent(int id);

    /**
     * 添加学生
     * @param student
     * @return
     */
    int addStudent(Student student,int gender);

    /**
     * 查询学生详细信息
     * @param id
     * @return
     */
    Student queryStudentDetail(int id);

    /**
     * 按条件查询学生信息
     * @param student
     * @param gender
     * @return
     */
    List<Student> queryStudentByCondition(Student student, Integer gender,Integer page);

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    int updateStudent(Student student);
}
