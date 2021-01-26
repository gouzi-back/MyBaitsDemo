package cn.smbms.dao.user;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class UserMapperTest {
	
	private Logger logger = Logger.getLogger(UserMapperTest.class);
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		String resource = "mybatis-config.xml";
		int count = 0;
		SqlSession sqlSession = null;
		try {
			//1 ��ȡmybatis-config.xml��������
			InputStream is = Resources.getResourceAsStream(resource);
			//2 ����SqlSessionFactory������ɶ������ļ��Ķ�ȡ
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			//3 ����sqlSession
			sqlSession = factory.openSession();
			//4 ����mapper�ļ��������ݽ��в����������Ȱ�mapper�ļ����뵽mybatis-config.xml��
			count = sqlSession.selectOne("cn.smbms.dao.user.UserMapper.count");
			logger.debug("UserMapperTest count---> " + count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
	}

}
