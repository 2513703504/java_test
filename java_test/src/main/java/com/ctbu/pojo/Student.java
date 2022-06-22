package com.ctbu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author : TangHao
 * @description : 学生
 * @ClassName :Student
 * @createTime : 2022/6/21 15:45
 * @updateTime : 2022/6/21 15:45
 * @updateRemark : [说明本次修改内容]
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    /**
     * 学生id
     */
    private Integer id;
    /**
     * 学生姓名
     */
    private String stuName;
    /**
     * 学生性别
     */
    private String sex;
    /**
     * 学生年级
     */
    private Integer grade;
    /**
     * 学生所选课程
     */
    private List<Course> courses;
}
