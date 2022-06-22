package com.ctbu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author : TangHao
 * @description : 课程
 * @ClassName :Course
 * @createTime : 2022/6/21 15:48
 * @updateTime : 2022/6/21 15:48
 * @updateRemark : [说明本次修改内容]
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    /**
     * 课程表id
     */
    private Integer id;
    /**
     *课程名
     */
    private String courseName;
    /**
     * 课程学分
     */
    private float credit;
    /**
     * 学生
     */
    private List<Student> students;
}

