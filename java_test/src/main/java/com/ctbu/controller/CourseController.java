package com.ctbu.controller;

import com.ctbu.common.Result;
import com.ctbu.pojo.Course;
import com.ctbu.service.CourseAndStu;
import com.ctbu.service.CourseService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author : TangHao
 * @description :
 * @ClassName :CourseController
 * @createTime : 2022/6/21 16:00
 * @updateTime : 2022/6/21 16:00
 * @updateRemark : [说明本次修改内容]
 */
@RestController
@RequestMapping("/course")
@Slf4j
public class CourseController {

    @Resource
    private CourseService courseService;

    @Resource
    private CourseAndStu courseAndStu;

    /**
     * 添加课程
     * @param course
     * @return
     */
    @PostMapping
    public Result<String> addCourse(@RequestBody Course course){
        int result=courseService.addCourse(course);
        return result>0 ? Result.success("添加成功") : Result.error("添加失败");
    }

    /**
     * 删除课程
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result<String> deleteCourse(@PathVariable int id){
        boolean flag=courseAndStu.queryChooseStatus(id);
        if (flag){
            int result=courseService.deleteCourse(id);
            return result>0 ? Result.success("删除成功") : Result.error("删除失败");
        }else {
            return Result.error("该课学生正在选修，不能删除");
        }
    }

    /**
     * 分页展示
     * @param page
     * @return
     */
    @GetMapping("/{page}")
    public Result<List<Course>> queryCourse(@PathVariable int page){
        List<Course> courses=courseService.queryCourseByPage(page);
        PageInfo pageInfo=new PageInfo(courses);
        log.debug("pageInfo==>{}",pageInfo);
        return courses.size()>0 ? Result.success(courses,"pageInfo",pageInfo) : Result.error("暂无数据");
    }

    /**
     * 修改课程信息
     * @param course
     * @return
     */
    @PutMapping
    public Result<String> updateCourse(@RequestBody Course course){
        log.debug("course==>{}",course);
        int result=courseService.updateCourse(course);
        return result>0 ? Result.success("修改成功") : Result.error("修改失败");
    }

    /**
     * 条件查询
     * @param map
     * @return
     */
    @PostMapping("/query")
    public Result<List<Course>> queryCourseByCondition(@RequestBody Map<String,Object> map){
        String name= (String) map.get("courseName");

        int page= (int) map.get("page");
        log.debug("page==>{}",page);
        log.debug("name==>{}",name);
        List<Course> courses=courseService.queryByCondition(name,page);
        PageInfo pageInfo=new PageInfo(courses);
        log.debug("pageInfo==>{}",pageInfo);
        return courses.size()>0 ? Result.success(courses,"pageInfo",pageInfo) : Result.error("课程信息不存在");

    }
}
