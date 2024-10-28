package com.entity.vo;

import com.entity.JiaolianEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 教练
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiaolian")
public class JiaolianVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 教练编号
     */

    @TableField(value = "jiaolian_uuid_number")
    private String jiaolianUuidNumber;


    /**
     * 教练名称
     */

    @TableField(value = "jiaolian_name")
    private String jiaolianName;


    /**
     * 头像
     */

    @TableField(value = "jiaolian_photo")
    private String jiaolianPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 联系方式
     */

    @TableField(value = "jiaolian_phone")
    private String jiaolianPhone;


    /**
     * 赞
     */

    @TableField(value = "zan_number")
    private Integer zanNumber;


    /**
     * 踩
     */

    @TableField(value = "cai_number")
    private Integer caiNumber;


    /**
     * 教练类型
     */

    @TableField(value = "jiaolian_types")
    private Integer jiaolianTypes;


    /**
     * 教练热度
     */

    @TableField(value = "jiaolian_clicknum")
    private Integer jiaolianClicknum;


    /**
     * 教练介绍
     */

    @TableField(value = "jiaolian_content")
    private String jiaolianContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "jiaolian_delete")
    private Integer jiaolianDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：教练编号
	 */
    public String getJiaolianUuidNumber() {
        return jiaolianUuidNumber;
    }


    /**
	 * 获取：教练编号
	 */

    public void setJiaolianUuidNumber(String jiaolianUuidNumber) {
        this.jiaolianUuidNumber = jiaolianUuidNumber;
    }
    /**
	 * 设置：教练名称
	 */
    public String getJiaolianName() {
        return jiaolianName;
    }


    /**
	 * 获取：教练名称
	 */

    public void setJiaolianName(String jiaolianName) {
        this.jiaolianName = jiaolianName;
    }
    /**
	 * 设置：头像
	 */
    public String getJiaolianPhoto() {
        return jiaolianPhoto;
    }


    /**
	 * 获取：头像
	 */

    public void setJiaolianPhoto(String jiaolianPhoto) {
        this.jiaolianPhoto = jiaolianPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：联系方式
	 */
    public String getJiaolianPhone() {
        return jiaolianPhone;
    }


    /**
	 * 获取：联系方式
	 */

    public void setJiaolianPhone(String jiaolianPhone) {
        this.jiaolianPhone = jiaolianPhone;
    }
    /**
	 * 设置：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 获取：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 设置：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 获取：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 设置：教练类型
	 */
    public Integer getJiaolianTypes() {
        return jiaolianTypes;
    }


    /**
	 * 获取：教练类型
	 */

    public void setJiaolianTypes(Integer jiaolianTypes) {
        this.jiaolianTypes = jiaolianTypes;
    }
    /**
	 * 设置：教练热度
	 */
    public Integer getJiaolianClicknum() {
        return jiaolianClicknum;
    }


    /**
	 * 获取：教练热度
	 */

    public void setJiaolianClicknum(Integer jiaolianClicknum) {
        this.jiaolianClicknum = jiaolianClicknum;
    }
    /**
	 * 设置：教练介绍
	 */
    public String getJiaolianContent() {
        return jiaolianContent;
    }


    /**
	 * 获取：教练介绍
	 */

    public void setJiaolianContent(String jiaolianContent) {
        this.jiaolianContent = jiaolianContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getJiaolianDelete() {
        return jiaolianDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setJiaolianDelete(Integer jiaolianDelete) {
        this.jiaolianDelete = jiaolianDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
