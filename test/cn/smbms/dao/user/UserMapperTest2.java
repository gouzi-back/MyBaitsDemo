package cn.smbms.dao.user;

import cn.smbms.utils.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class UserMapperTest2 {
	
	private Logger logger = Logger.getLogger(UserMapperTest2.class);
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		int count = 0;
		SqlSession sqlSession = null;
		try {
			sqlSession= MybatisUtil.createSqlSession();
			//4 ����mapper�ļ��������ݽ��в����������Ȱ�mapper�ļ����뵽mybatis-config.xml��
			count = sqlSession.selectOne("cn.smbms.dao.user.UserMapper.count");
			logger.debug("UserMapperTest count-------------++++++++++----------------> " + count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			MybatisUtil.closedSqlSession(sqlSession);
		}
	}

}
