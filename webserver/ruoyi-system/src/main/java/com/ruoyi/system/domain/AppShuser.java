package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户对象 app_shuser
 * 
 * @author ruoyi
 * @date 2022-12-14
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

    /** 名字 */
    @Excel(name = "名字")
    private String name;

    /** 身份证 */
    @Excel(name = "身份证")
    private String ic;

    /** 身份类型 */
    @Excel(name = "身份类型")
    private Long icType;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 逻辑删除 */
    private Long delFlag;

    /** 性别 */
    @Excel(name = "性别")
    private Long sex;

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
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setIc(String ic) 
    {
        this.ic = ic;
    }

    public String getIc() 
    {
        return ic;
    }
    public void setIcType(Long icType) 
    {
        this.icType = icType;
    }

    public Long getIcType() 
    {
        return icType;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setDelFlag(Long delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Long getDelFlag() 
    {
        return delFlag;
    }
    public void setSex(Long sex) 
    {
        this.sex = sex;
    }

    public Long getSex() 
    {
        return sex;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("username", getUsername())
            .append("password", getPassword())
            .append("name", getName())
            .append("ic", getIc())
            .append("icType", getIcType())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("sex", getSex())
            .toString();
    }
}
