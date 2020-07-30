package com.xc.justforjoy.mapper;

import com.xc.justforjoy.entity.Student;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * @author lxcecho
 * @since 2020/7/30
 */
public class StudentDaoImpl extends SqlSessionDaoSupport implements IStudentDao{

	@Override
	public Student queryStudentByNo(int stuNo) {
		SqlSession session = this.getSqlSession();
		IStudentDao studentMapper = session.getMapper(IStudentDao.class);
		Student student = studentMapper.queryStudentByNo(stuNo);
		return student;
	}

}
