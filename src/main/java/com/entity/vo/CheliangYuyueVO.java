package com.entity.vo;

import com.entity.CheliangYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 车辆预约
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("cheliang_yuyue")
public class CheliangYuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 预约编号
     */

    @TableField(value = "cheliang_yuyue_uuid_number")
    private String cheliangYuyueUuidNumber;


    /**
     * 车辆
     */

    @TableField(value = "cheliang_id")
    private Integer cheliangId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 备注
     */

    @TableField(value = "cheliang_yuyue_text")
    private String cheliangYuyueText;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "cheliang_yuyue_time")
    private Date cheliangYuyueTime;


    /**
     * 预约状态
     */

    @TableField(value = "cheliang_yuyue_yesno_types")
    private Integer cheliangYuyueYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "cheliang_yuyue_yesno_text")
    private String cheliangYuyueYesnoText;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：预约编号
	 */
    public String getCheliangYuyueUuidNumber() {
        return cheliangYuyueUuidNumber;
    }


    /**
	 * 获取：预约编号
	 */

    public void setCheliangYuyueUuidNumber(String cheliangYuyueUuidNumber) {
        this.cheliangYuyueUuidNumber = cheliangYuyueUuidNumber;
    }
    /**
	 * 设置：车辆
	 */
    public Integer getCheliangId() {
        return cheliangId;
    }


    /**
	 * 获取：车辆
	 */

    public void setCheliangId(Integer cheliangId) {
        this.cheliangId = cheliangId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：备注
	 */
    public String getCheliangYuyueText() {
        return cheliangYuyueText;
    }


    /**
	 * 获取：备注
	 */

    public void setCheliangYuyueText(String cheliangYuyueText) {
        this.cheliangYuyueText = cheliangYuyueText;
    }
    /**
	 * 设置：预约时间
	 */
    public Date getCheliangYuyueTime() {
        return cheliangYuyueTime;
    }


    /**
	 * 获取：预约时间
	 */

    public void setCheliangYuyueTime(Date cheliangYuyueTime) {
        this.cheliangYuyueTime = cheliangYuyueTime;
    }
    /**
	 * 设置：预约状态
	 */
    public Integer getCheliangYuyueYesnoTypes() {
        return cheliangYuyueYesnoTypes;
    }


    /**
	 * 获取：预约状态
	 */

    public void setCheliangYuyueYesnoTypes(Integer cheliangYuyueYesnoTypes) {
        this.cheliangYuyueYesnoTypes = cheliangYuyueYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getCheliangYuyueYesnoText() {
        return cheliangYuyueYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setCheliangYuyueYesnoText(String cheliangYuyueYesnoText) {
        this.cheliangYuyueYesnoText = cheliangYuyueYesnoText;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
