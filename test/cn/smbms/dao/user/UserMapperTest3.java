package cn.smbms.dao.user;

import cn.smbms.pojo.User;
import cn.smbms.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

public class UserMapperTest3 {
	
	private Logger logger = Logger.getLogger(UserMapperTest3.class);
	
	@Before
	public void setUp() throws Exception {
	}


	@Test
	public void testetUserListRoleId() {
		List<User> userList=new ArrayList<>();
		SqlSession sqlSession = null;
		Integer roleId=3;
		try {
			sqlSession= MybatisUtil.createSqlSession();
			//4 调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
			//userList = sqlSession.selectList("mapper.UserMapper.getUserList");
			userList=sqlSession.getMapper(UserMapper.class).getUserListRoleId(roleId);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			MybatisUtil.closedSqlSession(sqlSession);
		}

		for (User user1:userList){
			logger.debug("testGetUserList  userCode"+user1.getUserCode()+"and  userName"+user1.getUserName());
			logger.debug("testGetUserList  roleCode"+user1.getRole().getRoleCode()+"and  roleName"+user1.getRole().getRoleName());
		}
	}




}
