package com.ctbu.mapper;

import com.alibaba.druid.proxy.jdbc.ResultSetProxy;
import com.ctbu.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author : TangHao
 * @description :
 * @InterfaceName :StudentMapper
 * @createTime : 2022/6/21 15:56
 */
@Mapper()
public interface StudentMapper {
    /**
     * 分页查询学生信息
     * @return
     */
    List<Student> queryStudent();

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
    List<Student> queryStudentByCondition(Student student, Integer gender);

    /**
     * 修改学生信息
     * @param student
     * @param gender
     * @return
     */
    int updateStudent(Student student,int gender);
}
