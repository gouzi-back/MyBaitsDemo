package cn.smbms.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther:haha
 * @Date:2021/1/26 - 01 - 26 20:04
 * @Description:cn.smbms.utils
 * @Version: 1.0
 */
public class MybatisUtil {
    private static SqlSessionFactory factory;

    static {
        String resource = "mybatis-config.xml";

        try {
            //1 获取mybatis-config.xml的输入流
            InputStream is = Resources.getResourceAsStream(resource);
            //2 创建SqlSessionFactory对象，完成对配置文件的读取
             factory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public  static SqlSession createSqlSession(){
        return  factory.openSession(false);//开启事务
    }

    public static  void closedSqlSession(SqlSession sqlSession){
        if (null!=sqlSession){
            sqlSession.close();
        }
    }
}
