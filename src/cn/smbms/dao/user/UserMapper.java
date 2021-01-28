package cn.smbms.dao.user;

import cn.smbms.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Auther:haha
 * @Date:2021/1/26 - 01 - 26 20:43
 * @Description:cn.smbms.dao.user
 * @Version: 1.0
 */
public interface UserMapper {

    public List<User> getUserList(@Param("userName") String userName, @Param("userRole") Integer roleId);

    public List<User> getUserListByMap(Map<String, String> userMap);

    public List<User> getUserListByUserName(String userName);

    public int add(User user);

    public int update(User user);

    public int delete(@Param("id") Integer id);

    public int updatePwd(@Param("id") Integer id, @Param("userPassword") String userPassword);

    /*根据角色id查询对应的id*/
    public List<User> getUserListRoleId(@Param("userRole") Integer id);

    public List<User> getAddressByid(@Param("id") Integer id);

    /*根据角色列表 获取角色列表和用户下列表信息*/
    public List<User> getUser_foreach(Integer[] roleIds);

    public List<User> getUser_foreachList(List<Integer> roleList);

    //多惨入参用map
    public List<User> getUser_foreachMap(Map<String, Object> roleMap);

    public List<User> getUser_Map(Map<String, Object> roleMap);

    //choose的用法
    public List<User> getUser_choose(@Param("userName") String userName,
                                     @Param("userCode") String userCode,
                                     @Param("userRole") Integer userRole,
                                     @Param("creationDate") Date creationDate);


}
