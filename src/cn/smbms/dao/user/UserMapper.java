package cn.smbms.dao.user;

import cn.smbms.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Auther:haha
 * @Date:2021/1/26 - 01 - 26 20:43
 * @Description:cn.smbms.dao.user
 * @Version: 1.0
 */
public interface UserMapper {

    public List<User> getUserList(User user);

    public List<User> getUserListByMap(Map<String,String> userMap);

    public List<User> getUserListByUserName(String userName);

    public int add(User user);

    public int update(User user );

    public int delete(@Param("id") Integer id);

    public int updatePwd(@Param("id") Integer id, @Param("userPassword") String userPassword );
    /*根据角色id查询对应的id*/
    public List<User> getUserListRoleId(@Param("userRole")Integer id);

    public List<User> getAddressByid(@Param("id")Integer id);
}
