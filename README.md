#Mybatis学习
1:Mybatis如何通过接口即可实现数据库的访问

2:Mybatis插件机制

- Executor(调度执行器)
- StatementHandler(一般是拦截该Handler,根据情况修改SQL)
- ParameterHandler(参数处理器)
- ResultHandler(结果集处理器)
- MetaObject(Mybatis元信息获取)
- Plugin(Mybatis插件类)

3:Mybatis参数封装方式
Map封装,POJO封装,@Param注解

4:Mybatis一对一,一对多,多对多查询

5:Mybatis type handlers的开发
>通常实现BaseTypeHandler接口

6:Mybatis查询注解

7:Mybatis动态SQL

8:SqlSessionFactory和SqlSession工具类封装

- SqlSessionFactoryUtils(使用了单例模式)
- SqlSessionUtils(使用ThreadLocal进行管理)


