package com.xc.justforjoy.mapper;

import com.xc.justforjoy.entity.Student;

/**
 * @author lxcecho
 * @since 2020/7/30
 */
public interface IStudentDao {

    /**
     * 根据学号查学生
     *
     * @param stuNo
     * @return
     * @throws
     * @author lxcecho
     * @since 2020/7/30
     */
    Student queryStudentByNo(int stuNo);

}
