package com.ctbu.mapper;

import com.ctbu.pojo.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author : TangHao
 * @description :
 * @InterfaceName :CourseMapper
 * @createTime : 2022/6/21 15:56
 */
@Mapper
public interface CourseMapper {
    /**
     * 修改课程
     * @param course
     * @return
     */
    int updateCourse(Course course);

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
     * @return
     */
    List<Course> queryCourseByPage();

    /**
     * 条件查询
     * @param name
     * @return
     */
    List<Course> queryByCondition(String name);
}
