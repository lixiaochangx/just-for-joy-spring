package com.xc.justforjoy.jdbc.dao;

import com.xc.justforjoy.jdbc.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * @author lxcecho
 * @since 2020/7/26
 * <p>
 * 不推荐使用JdbcDaoSupport，而推荐直接使用JdbcTmeplate作为Dao类的成员变量。（了解）
 */
@Repository
public class DepartmentDao extends JdbcDaoSupport {

    @Autowired
    public void setDataSource2(DataSource dataSource) {
        setDataSource(dataSource);
    }

    public Department get(Integer id) {
        String sql = "select id,name from dept where id =?";
        RowMapper<Department> rowMapper = new BeanPropertyRowMapper<>(Department.class);
        return getJdbcTemplate().queryForObject(sql, rowMapper, id);

    }

}
