package com.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Long-666
 * @create 2022-09-09 13:46
 */
public class SqlSessionFactoryUtils {

    private static SqlSessionFactory sqlSessionFactory;

    //静态代码块，只会执行一次，随着类的加载而加载
    static {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSessionFactory getSqlSessionFactory(){return sqlSessionFactory;}
}
