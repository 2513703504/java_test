package com.ctbu.service.impl;

import com.ctbu.mapper.CourseMapper;
import com.ctbu.pojo.Course;
import com.ctbu.service.CourseService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : TangHao
 * @description :
 * @ClassName :CourseServiceImpl
 * @createTime : 2022/6/21 15:58
 * @updateTime : 2022/6/21 15:58
 * @updateRemark : [说明本次修改内容]
 */
@Service("courseService")
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
    /**
     * 添加课程
     *
     * @param course
     * @return
     */
    @Override
    public int addCourse(Course course) {
        return courseMapper.addCourse(course);
    }

    /**
     * 删除课程
     *
     * @param id
     * @return
     */
    @Override
    public int deleteCourse(int id) {
        return courseMapper.deleteCourse(id);
    }

    /**
     * 分页展示
     *
     * @param page
     * @return
     */
    @Override
    public List<Course> queryCourseByPage(int page) {
        PageHelper.startPage(page,10);
        return courseMapper.queryCourseByPage();
    }

    /**
     * 修改课程
     *
     * @param course
     * @return
     */
    @Override
    public int updateCourse(Course course) {
        return courseMapper.updateCourse(course);
    }

    /**
     * 按条件查询课程
     *
     * @param name
     * @param page
     * @return
     */
    @Override
    public List<Course> queryByCondition(String name, int page) {
        PageHelper.startPage(page,10);
        return courseMapper.queryByCondition(name);
    }
}
