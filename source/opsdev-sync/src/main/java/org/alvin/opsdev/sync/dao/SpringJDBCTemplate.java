package org.alvin.opsdev.sync.dao;

import org.alvin.opsdev.sync.bean.Config;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by tangzhichao on 2016/12/20.
 */
public class SpringJDBCTemplate extends JdbcTemplate{

    public SpringJDBCTemplate(Config config) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(config.getUrl(), config.getUser(), config.getPassword());
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        setDataSource(dataSource);
    }



}
