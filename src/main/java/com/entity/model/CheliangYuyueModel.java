package com.entity.model;

import com.entity.CheliangYuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 车辆预约
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class CheliangYuyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 预约编号
     */
    private String cheliangYuyueUuidNumber;


    /**
     * 车辆
     */
    private Integer cheliangId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 备注
     */
    private String cheliangYuyueText;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date cheliangYuyueTime;


    /**
     * 预约状态
     */
    private Integer cheliangYuyueYesnoTypes;


    /**
     * 审核回复
     */
    private String cheliangYuyueYesnoText;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
