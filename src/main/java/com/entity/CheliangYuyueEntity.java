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
 * 车辆预约
 *
 * @author 
 * @email
 */
@TableName("cheliang_yuyue")
public class CheliangYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public CheliangYuyueEntity() {

	}

	public CheliangYuyueEntity(T t) {
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
     * 预约编号
     */
    @ColumnInfo(comment="预约编号",type="varchar(200)")
    @TableField(value = "cheliang_yuyue_uuid_number")

    private String cheliangYuyueUuidNumber;


    /**
     * 车辆
     */
    @ColumnInfo(comment="车辆",type="int(11)")
    @TableField(value = "cheliang_id")

    private Integer cheliangId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 备注
     */
    @ColumnInfo(comment="备注",type="longtext")
    @TableField(value = "cheliang_yuyue_text")

    private String cheliangYuyueText;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="预约时间",type="timestamp")
    @TableField(value = "cheliang_yuyue_time")

    private Date cheliangYuyueTime;


    /**
     * 预约状态
     */
    @ColumnInfo(comment="预约状态",type="int(11)")
    @TableField(value = "cheliang_yuyue_yesno_types")

    private Integer cheliangYuyueYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "cheliang_yuyue_yesno_text")

    private String cheliangYuyueYesnoText;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="添加时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
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
	 * 获取：预约编号
	 */
    public String getCheliangYuyueUuidNumber() {
        return cheliangYuyueUuidNumber;
    }
    /**
	 * 设置：预约编号
	 */

    public void setCheliangYuyueUuidNumber(String cheliangYuyueUuidNumber) {
        this.cheliangYuyueUuidNumber = cheliangYuyueUuidNumber;
    }
    /**
	 * 获取：车辆
	 */
    public Integer getCheliangId() {
        return cheliangId;
    }
    /**
	 * 设置：车辆
	 */

    public void setCheliangId(Integer cheliangId) {
        this.cheliangId = cheliangId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：备注
	 */
    public String getCheliangYuyueText() {
        return cheliangYuyueText;
    }
    /**
	 * 设置：备注
	 */

    public void setCheliangYuyueText(String cheliangYuyueText) {
        this.cheliangYuyueText = cheliangYuyueText;
    }
    /**
	 * 获取：预约时间
	 */
    public Date getCheliangYuyueTime() {
        return cheliangYuyueTime;
    }
    /**
	 * 设置：预约时间
	 */

    public void setCheliangYuyueTime(Date cheliangYuyueTime) {
        this.cheliangYuyueTime = cheliangYuyueTime;
    }
    /**
	 * 获取：预约状态
	 */
    public Integer getCheliangYuyueYesnoTypes() {
        return cheliangYuyueYesnoTypes;
    }
    /**
	 * 设置：预约状态
	 */

    public void setCheliangYuyueYesnoTypes(Integer cheliangYuyueYesnoTypes) {
        this.cheliangYuyueYesnoTypes = cheliangYuyueYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getCheliangYuyueYesnoText() {
        return cheliangYuyueYesnoText;
    }
    /**
	 * 设置：审核回复
	 */

    public void setCheliangYuyueYesnoText(String cheliangYuyueYesnoText) {
        this.cheliangYuyueYesnoText = cheliangYuyueYesnoText;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "CheliangYuyue{" +
            ", id=" + id +
            ", cheliangYuyueUuidNumber=" + cheliangYuyueUuidNumber +
            ", cheliangId=" + cheliangId +
            ", yonghuId=" + yonghuId +
            ", cheliangYuyueText=" + cheliangYuyueText +
            ", cheliangYuyueTime=" + DateUtil.convertString(cheliangYuyueTime,"yyyy-MM-dd") +
            ", cheliangYuyueYesnoTypes=" + cheliangYuyueYesnoTypes +
            ", cheliangYuyueYesnoText=" + cheliangYuyueYesnoText +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
