package com.ctbu.service;

import java.util.List;

/**
 * @author : TangHao
 * @description :
 * @InterfaceName :CourseAndStu
 * @createTime : 2022/6/21 21:03
 */
public interface CourseAndStu {
    /**
     * 删除选课关联信息
     * @param id
     * @return
     */
    int deleteInfo(int id);

    /**
     * 查询学生是否选课
     * @param id
     * @return
     */
    boolean queryChooseStatus(int id);

    /**
     * 学生选课
     * @param sid
     * @param courseId
     * @return
     */
    int addInfoOfChoose(int sid, List<Integer> courseId);
}
