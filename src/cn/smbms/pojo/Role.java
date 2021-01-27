package cn.smbms.pojo;

import java.util.Date;

/**
 * @Auther:haha
 * @Date:2021/1/27 - 01 - 27 17:40
 * @Description:cn.smbms.pojo
 * @Version: 1.0
 */
public class Role {
    private int id;
    private String roleCode;
    private String roleName;
    private int createBy;
    private Date creationDate;
    private int modifyBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getCreateBy() {
        return createBy;
    }

    public void setCreateBy(int createBy) {
        this.createBy = createBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(int modifyBy) {
        this.modifyBy = modifyBy;
    }

    public int getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(int modifyDate) {
        this.modifyDate = modifyDate;
    }

    private int modifyDate;
}
