package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户对象 app_shuser
 * 
 * @author ruoyi
 * @date 2022-12-24
 */
public class AppShuser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 用户名 */
    @Excel(name = "用户名")
    private String username;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    /** 身份证 */
    @Excel(name = "身份证")
    private String ic;

    /** 性别 */
    @Excel(name = "性别")
    private String usersex;

    /** 证件类型 */
    @Excel(name = "证件类型")
    private Long icType;

    /** 权限类别 */
    @Excel(name = "权限类别")
    private Long userRole;

    /** 工号id */
    @Excel(name = "工号id")
    private String wordId;

    /** 逻辑删除 */
    private Long delFlag;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setIc(String ic) 
    {
        this.ic = ic;
    }

    public String getIc() 
    {
        return ic;
    }
    public void setUsersex(String usersex) 
    {
        this.usersex = usersex;
    }

    public String getUsersex() 
    {
        return usersex;
    }
    public void setIcType(Long icType) 
    {
        this.icType = icType;
    }

    public Long getIcType() 
    {
        return icType;
    }
    public void setUserRole(Long userRole) 
    {
        this.userRole = userRole;
    }

    public Long getUserRole() 
    {
        return userRole;
    }
    public void setWordId(String wordId) 
    {
        this.wordId = wordId;
    }

    public String getWordId() 
    {
        return wordId;
    }
    public void setDelFlag(Long delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Long getDelFlag() 
    {
        return delFlag;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("username", getUsername())
            .append("password", getPassword())
            .append("ic", getIc())
            .append("usersex", getUsersex())
            .append("icType", getIcType())
            .append("userRole", getUserRole())
            .append("wordId", getWordId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .append("status", getStatus())
            .toString();
    }
}
