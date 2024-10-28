package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 教练
 *
 * @author 
 * @email
 */
@TableName("jiaolian")
public class JiaolianEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiaolianEntity() {

	}

	public JiaolianEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 账户
     */
    @ColumnInfo(comment="账户",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @ColumnInfo(comment="密码",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * 教练编号
     */
    @ColumnInfo(comment="教练编号",type="varchar(200)")
    @TableField(value = "jiaolian_uuid_number")

    private String jiaolianUuidNumber;


    /**
     * 教练名称
     */
    @ColumnInfo(comment="教练名称",type="varchar(200)")
    @TableField(value = "jiaolian_name")

    private String jiaolianName;


    /**
     * 头像
     */
    @ColumnInfo(comment="头像",type="varchar(200)")
    @TableField(value = "jiaolian_photo")

    private String jiaolianPhoto;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 联系方式
     */
    @ColumnInfo(comment="联系方式",type="varchar(200)")
    @TableField(value = "jiaolian_phone")

    private String jiaolianPhone;


    /**
     * 赞
     */
    @ColumnInfo(comment="赞",type="int(11)")
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 踩
     */
    @ColumnInfo(comment="踩",type="int(11)")
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 教练类型
     */
    @ColumnInfo(comment="教练类型",type="int(11)")
    @TableField(value = "jiaolian_types")

    private Integer jiaolianTypes;


    /**
     * 教练热度
     */
    @ColumnInfo(comment="教练热度",type="int(11)")
    @TableField(value = "jiaolian_clicknum")

    private Integer jiaolianClicknum;


    /**
     * 教练介绍
     */
    @ColumnInfo(comment="教练介绍",type="longtext")
    @TableField(value = "jiaolian_content")

    private String jiaolianContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "jiaolian_delete")

    private Integer jiaolianDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 设置：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 设置：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：教练编号
	 */
    public String getJiaolianUuidNumber() {
        return jiaolianUuidNumber;
    }
    /**
	 * 设置：教练编号
	 */

    public void setJiaolianUuidNumber(String jiaolianUuidNumber) {
        this.jiaolianUuidNumber = jiaolianUuidNumber;
    }
    /**
	 * 获取：教练名称
	 */
    public String getJiaolianName() {
        return jiaolianName;
    }
    /**
	 * 设置：教练名称
	 */

    public void setJiaolianName(String jiaolianName) {
        this.jiaolianName = jiaolianName;
    }
    /**
	 * 获取：头像
	 */
    public String getJiaolianPhoto() {
        return jiaolianPhoto;
    }
    /**
	 * 设置：头像
	 */

    public void setJiaolianPhoto(String jiaolianPhoto) {
        this.jiaolianPhoto = jiaolianPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 设置：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：联系方式
	 */
    public String getJiaolianPhone() {
        return jiaolianPhone;
    }
    /**
	 * 设置：联系方式
	 */

    public void setJiaolianPhone(String jiaolianPhone) {
        this.jiaolianPhone = jiaolianPhone;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }
    /**
	 * 设置：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }
    /**
	 * 设置：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：教练类型
	 */
    public Integer getJiaolianTypes() {
        return jiaolianTypes;
    }
    /**
	 * 设置：教练类型
	 */

    public void setJiaolianTypes(Integer jiaolianTypes) {
        this.jiaolianTypes = jiaolianTypes;
    }
    /**
	 * 获取：教练热度
	 */
    public Integer getJiaolianClicknum() {
        return jiaolianClicknum;
    }
    /**
	 * 设置：教练热度
	 */

    public void setJiaolianClicknum(Integer jiaolianClicknum) {
        this.jiaolianClicknum = jiaolianClicknum;
    }
    /**
	 * 获取：教练介绍
	 */
    public String getJiaolianContent() {
        return jiaolianContent;
    }
    /**
	 * 设置：教练介绍
	 */

    public void setJiaolianContent(String jiaolianContent) {
        this.jiaolianContent = jiaolianContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getJiaolianDelete() {
        return jiaolianDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setJiaolianDelete(Integer jiaolianDelete) {
        this.jiaolianDelete = jiaolianDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Jiaolian{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", jiaolianUuidNumber=" + jiaolianUuidNumber +
            ", jiaolianName=" + jiaolianName +
            ", jiaolianPhoto=" + jiaolianPhoto +
            ", sexTypes=" + sexTypes +
            ", jiaolianPhone=" + jiaolianPhone +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", jiaolianTypes=" + jiaolianTypes +
            ", jiaolianClicknum=" + jiaolianClicknum +
            ", jiaolianContent=" + jiaolianContent +
            ", jiaolianDelete=" + jiaolianDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
