package com.ctbu.service.impl;

import com.ctbu.mapper.CourseAndStuMapper;
import com.ctbu.pojo.Student;
import com.ctbu.service.CourseAndStu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : TangHao
 * @description :
 * @ClassName :CourseAndStuImpl
 * @createTime : 2022/6/21 21:06
 * @updateTime : 2022/6/21 21:06
 * @updateRemark : [说明本次修改内容]
 */
@Service("courseAndStu")
public class CourseAndStuImpl implements CourseAndStu {

    @Autowired
    private CourseAndStuMapper courseAndStuMapper;
    /**
     * 删除选课关联信息
     *
     * @param id
     * @return
     */
    @Override
    public int deleteInfo(int id) {
        return courseAndStuMapper.deleteInfo(id);
    }

    /**
     * 查询学生是否选课
     *
     * @param id
     * @return
     */
    @Override
    public boolean queryChooseStatus(int id) {
        List<Student> students=courseAndStuMapper.queryStudent(id);
        return students.size()==0;
    }

    /**
     * 学生选课
     *
     * @param sid
     * @param courseId
     * @return
     */
    @Override
    public int addInfoOfChoose(int sid, List<Integer> courseId) {
        return courseAndStuMapper.addInfoOfChoose(sid,courseId);
    }
}
