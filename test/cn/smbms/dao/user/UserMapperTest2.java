package cn.smbms.dao.user;

import cn.smbms.pojo.User;
import cn.smbms.utils.MybatisUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
			//4 调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
			count = sqlSession.selectOne("cn.smbms.dao.user.UserMapper.count");
			logger.debug("UserMapperTest count-------------++++++++++----------------> " + count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			MybatisUtil.closedSqlSession(sqlSession);
		}
	}


	@Test
	public void testGetUserList() {
		User user = new User();
		user.setUserName("赵");
		user.setUserRole(2);
		List<User> userList=null;
		SqlSession sqlSession = null;
		try {
			sqlSession= MybatisUtil.createSqlSession();
			//4 调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
			//userList = sqlSession.selectList("mapper.UserMapper.getUserList");
			userList=sqlSession.getMapper(UserMapper.class).getUserList(user);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			MybatisUtil.closedSqlSession(sqlSession);
		}

		for (User user1:userList){
			logger.debug("testGetUserList  userRoleName"+user1.getUserRoleName()+"and  userName"+user1.getUserName());
		}
	}


	@Test
	public void testGetUserListByUserName() {

		List<User> userList=null;
		SqlSession sqlSession = null;

		String username="赵";
		try {
			sqlSession= MybatisUtil.createSqlSession();
			//4 调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
			//userList = sqlSession.selectList("mapper.UserMapper.getUserList");
			userList=sqlSession.getMapper(UserMapper.class).getUserListByUserName(username);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			MybatisUtil.closedSqlSession(sqlSession);
		}

		for (User user1:userList){
			logger.debug("testGetUserList  userCode"+user1.getUserCode()+"and  userName+++++++++++++"+user1.getUserName());
		}
	}


	@Test
	public void testGetUserListByMap() {
		List<User> userList=null;
		SqlSession sqlSession = null;
		Map<String ,String> userMap=new HashMap<>();
		userMap.put("uName","赵");
		userMap.put("uRole","2");
		try {
			sqlSession= MybatisUtil.createSqlSession();
			//4 调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
			//userList = sqlSession.selectList("mapper.UserMapper.getUserList");
			userList=sqlSession.getMapper(UserMapper.class).getUserListByMap(userMap);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			MybatisUtil.closedSqlSession(sqlSession);
		}

		for (User user1:userList){
			logger.debug("testGetUserList  userCode"+user1.getUserCode()+"and  userName"+user1.getUserName());
		}
	}

}
