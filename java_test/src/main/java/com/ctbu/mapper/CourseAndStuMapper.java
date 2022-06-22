package com.ctbu.mapper;


import com.ctbu.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author : TangHao
 * @description :
 * @InterfaceName :CourseAndStuMapper
 * @createTime : 2022/6/21 21:07
 */
@Mapper
public interface CourseAndStuMapper {

    /**
     * 删除关联信息
     * @param id
     * @return
     */
    int deleteInfo(int id);

    /**
     * 查询是否选课
     * @param id
     * @return
     */
    List<Student> queryStudent(int id);

    /**
     * 学生选课
     * @param sid
     * @param courseId
     * @return
     */
    int addInfoOfChoose(int sid, List<Integer> courseId);
}
