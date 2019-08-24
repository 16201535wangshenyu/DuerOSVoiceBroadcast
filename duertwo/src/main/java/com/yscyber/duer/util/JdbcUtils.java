package com.yscyber.duer.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import java.sql.SQLException;

/**
 * JDBC 工具类.
 *
 * 基于 c3p0 DbUtils.
 *
 * 
 */
public final class JdbcUtils {

    private static QueryRunner queryRunner;
    private static final String C3P0_CONFIG_NAME = "duer-server-two";

    static {
        ComboPooledDataSource dataSource = new ComboPooledDataSource(C3P0_CONFIG_NAME);
        queryRunner = new QueryRunner(dataSource);
    }

    private JdbcUtils() {}

    /**
     * 执行查询语句.
     *
     * @param bean JavaBean.class
     * @param sql SQL 查询语句
     * @param args 可变参数
     * @param <T> JavaBean
     * @return JavaBean
     * @throws SQLException 异常
     */
    public static <T> T executeBeanQuery (Class<T> bean, String sql, Object... args) throws SQLException {
        ResultSetHandler<T> resultSetHandler = new BeanHandler<>(bean, new BasicRowProcessor(new GenerousBeanProcessor()));
        return queryRunner.query(sql, resultSetHandler, args);

    }

}
