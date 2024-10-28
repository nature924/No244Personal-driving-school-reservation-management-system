package com.entity.model;

import com.entity.JiaolianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 教练
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiaolianModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 教练编号
     */
    private String jiaolianUuidNumber;


    /**
     * 教练名称
     */
    private String jiaolianName;


    /**
     * 头像
     */
    private String jiaolianPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 联系方式
     */
    private String jiaolianPhone;


    /**
     * 赞
     */
    private Integer zanNumber;


    /**
     * 踩
     */
    private Integer caiNumber;


    /**
     * 教练类型
     */
    private Integer jiaolianTypes;


    /**
     * 教练热度
     */
    private Integer jiaolianClicknum;


    /**
     * 教练介绍
     */
    private String jiaolianContent;


    /**
     * 逻辑删除
     */
    private Integer jiaolianDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
