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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
		/*User user = new User();
		user.setUserName("赵");
		user.setUserRole(2);*/
		String userName="";
		Integer roleId=null;
		Integer cunPageNo=0;
		Integer pageSize=5;
		List<User> userList=null;
		SqlSession sqlSession = null;
		try {
			sqlSession= MybatisUtil.createSqlSession();
			//4 调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
			//userList = sqlSession.selectList("mapper.UserMapper.getUserList");
			userList=sqlSession.getMapper(UserMapper.class).getUserList(userName,roleId,cunPageNo,pageSize);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			MybatisUtil.closedSqlSession(sqlSession);
		}

		for (User user1:userList){
			logger.debug("testGetUserList  userRoleName"+user1.getUserRoleName()+"and  userName"+user1.getUserName()+"年龄："+user1.getAge()+"地址："+user1.getAddress());
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

	@Test
	public  void testAdd(){
		logger.debug("testAdd-----------------------------------------------");
		SqlSession sqlSession=null;
		int count=0;

		try {
			sqlSession=MybatisUtil.createSqlSession();
			User user =new User();
			user.setUserCode("0001");
			user.setUserName("测试用户001");
			user.setAddress("测试用户地址");
			user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1984-12-12"));
			user.setGender(1);
			user.setUserPassword("123456");
			user.setUserRole(1);
			user.setCreatedBy(1);
			user.setCreationDate(new Date());
			count=sqlSession.getMapper(UserMapper.class).add(user);

			sqlSession.commit();
		}catch (Exception e){
			e.printStackTrace();
			sqlSession.rollback();
			count=0;
		}finally {
		MybatisUtil.closedSqlSession(sqlSession);
		}
		logger.debug("testAdd cout++++++++++++++++"+count);
	}


	@Test
	public  void testupdate(){
		logger.debug("testupdate-----------------------------------------------");
		SqlSession sqlSession=null;
		int count=0;

		try {
			sqlSession=MybatisUtil.createSqlSession();
			User user =new User();
			//user.setUserCode("我笑笑");
			user.setUserName("测试什么啊");
			user.setUserPassword("123hh6");
			user.setModifyBy(1);
			user.setModifyDate(new SimpleDateFormat("yyyy-MM-dd").parse("2011-2-1"));
			user.setId(11);
			count=sqlSession.getMapper(UserMapper.class).update(user);

			sqlSession.commit();
		}catch (Exception e){
			e.printStackTrace();
			sqlSession.rollback();
			count=0;
		}finally {
			MybatisUtil.closedSqlSession(sqlSession);
		}
		logger.debug("testAdd cout++++++++++++++++"+count);
	}



	@Test
	public  void testdelete(){
		logger.debug("testdelete-----------------------------------------------");
		SqlSession sqlSession=null;
		int count=0;

		try {
			sqlSession=MybatisUtil.createSqlSession();
			User user =new User();
			user.setId(19);
			count=sqlSession.getMapper(UserMapper.class).delete(1);

			sqlSession.commit();
		}catch (Exception e){
			e.printStackTrace();
			sqlSession.rollback();
			count=0;
		}finally {
			MybatisUtil.closedSqlSession(sqlSession);
		}
		logger.debug("testAdd cout++++++++++++++++"+count);
	}





	@Test
	public  void testUpdatePwd(){
		logger.debug("testupdatePwd-----------------------------------------------");
		SqlSession sqlSession=null;
		int count=0;

		try {
			sqlSession=MybatisUtil.createSqlSession();

			count=sqlSession.getMapper(UserMapper.class).updatePwd(1,"hyy123");

			sqlSession.commit();
		}catch (Exception e){
			e.printStackTrace();
			sqlSession.rollback();
			count=0;
		}finally {
			MybatisUtil.closedSqlSession(sqlSession);
		}
		logger.debug("testAdd cout++++++++++++++++"+count);
	}


	@Test
	public void testGetUser_foreach() {
		/*User user = new User();
		user.setUserName("赵");
		user.setUserRole(2);*/
		String userName="";
		Integer[] roleId={2,3};
		List<User> userList=null;
		SqlSession sqlSession = null;
		try {
			sqlSession= MybatisUtil.createSqlSession();
			//4 调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
			//userList = sqlSession.selectList("mapper.UserMapper.getUserList");
			userList=sqlSession.getMapper(UserMapper.class).getUser_foreach(roleId);

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
	public void testGetUser_foreachList() {
		/*User user = new User();
		user.setUserName("赵");
		user.setUserRole(2);*/
		String userName="";
		List<Integer> roleId=new ArrayList<Integer>();
		roleId.add(2);
		roleId.add(3);
		List<User> userList=null;
		SqlSession sqlSession = null;
		try {
			sqlSession= MybatisUtil.createSqlSession();
			//4 调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
			//userList = sqlSession.selectList("mapper.UserMapper.getUserList");
			userList=sqlSession.getMapper(UserMapper.class).getUser_foreachList(roleId);

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
	public void testGetUser_foreachMap() {
		/*User user = new User();
		user.setUserName("赵");
		user.setUserRole(2);*/
		String userName="";
		Map<String,Object> conMap=new HashMap<String,Object>();
		List<Integer> roleId=new ArrayList<Integer>();
		roleId.add(2);
		roleId.add(3);
		conMap.put("gender",1);
		conMap.put("roleIds",roleId);
		List<User> userList=null;
		SqlSession sqlSession = null;
		try {
			sqlSession= MybatisUtil.createSqlSession();
			//4 调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
			//userList = sqlSession.selectList("mapper.UserMapper.getUserList");
			userList=sqlSession.getMapper(UserMapper.class).getUser_foreachMap(conMap);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			MybatisUtil.closedSqlSession(sqlSession);
		}

		for (User user1:userList){
			logger.debug("testGetUserList  gender"+user1.getGender()+"and  userName"+user1.getUserName());
		}
	}


	@Test
	public void testGetUser_Map() {
		/*User user = new User();
		user.setUserName("赵");
		user.setUserRole(2);*/
		String userName="";
		Map<String,Object> conMap=new HashMap<String,Object>();
		List<Integer> roleId=new ArrayList<Integer>();
		roleId.add(2);
		roleId.add(3);
		conMap.put("roleIds",roleId);
		List<User> userList=null;
		SqlSession sqlSession = null;
		try {
			sqlSession= MybatisUtil.createSqlSession();
			//4 调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
			//userList = sqlSession.selectList("mapper.UserMapper.getUserList");
			userList=sqlSession.getMapper(UserMapper.class).getUser_Map(conMap);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			MybatisUtil.closedSqlSession(sqlSession);
		}

		for (User user1:userList){
			logger.debug("and  userName"+user1.getUserName());
		}
	}


	@Test
	public void testChoose()  {
		/*User user = new User();
		user.setUserName("赵");
		user.setUserRole(2);*/
		List<User> userList=null;
		SqlSession sqlSession = null;
		String userName=" ";
		String userCode=" ";
		Integer userRole=1;
		try {
			Date creationDate=new SimpleDateFormat("yyyy-MM-dd").parse("2021-1-1");
			sqlSession= MybatisUtil.createSqlSession();
			//4 调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
			//userList = sqlSession.selectList("mapper.UserMapper.getUserList");
			userList=sqlSession.getMapper(UserMapper.class).getUser_choose(userName,userCode,userRole,creationDate);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			MybatisUtil.closedSqlSession(sqlSession);
		}

		for (User user1:userList){
			logger.debug("and  userName"+user1.getUserName());
		}
	}
}
