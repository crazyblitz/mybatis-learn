package com.ley.mybatis.learn.plugin;

import com.ley.mybatis.learn.utils.SqlFormatter;
import com.ley.mybatis.learn.utils.SqlUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import javax.security.auth.login.Configuration;
import java.sql.Connection;
import java.util.Properties;

/**
 * @see org.apache.ibatis.plugin.Plugin
 **/
@Slf4j
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
public class MyPlugin implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) PluginUtils.realTarget(invocation.getTarget());
        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
        String originalSql = (String) metaObject.getValue(PluginUtils.DELEGATE_BOUNDSQL_SQL);
        String formatSql = SqlUtils.sqlFormat(originalSql, true);
        metaObject.setValue(PluginUtils.DELEGATE_BOUNDSQL_SQL, formatSql);

//        log.info("format sql: {}", formatSql);
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
