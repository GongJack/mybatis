package cn.itcast.mybatis.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

/**
 * Created by gh102 on 2017-08-03.
 * 自定义拦截器
 */

@Intercepts({@Signature(
        type = Executor.class,
        method = "update",
        args = {MappedStatement.class,Object.class}

)})
public class MyInterceptor implements Interceptor{

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return invocation.proceed();            //执行被拦截的方法
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);        //返回代理对象,目标本身
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
