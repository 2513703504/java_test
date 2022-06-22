package com.ctbu.service;

import com.ctbu.pojo.Course;

import java.util.List;

/**
 * @author : TangHao
 * @description :
 * @InterfaceName :CourseService
 * @createTime : 2022/6/21 15:57
 */
public interface CourseService {
    /**
     * 添加课程
     * @param course
     * @return
     */
    int addCourse(Course course);

    /**
     * 删除课程
     * @param id
     * @return
     */
    int deleteCourse(int id);

    /**
     * 分页展示
     * @param page
     * @return
     */
    List<Course> queryCourseByPage(int page);

    /**
     * 修改课程
     * @param course
     * @return
     */
    int updateCourse(Course course);

    /**
     * 按条件查询课程
     * @param name
     * @param page
     * @return
     */
    List<Course> queryByCondition(String name, int page);
}
