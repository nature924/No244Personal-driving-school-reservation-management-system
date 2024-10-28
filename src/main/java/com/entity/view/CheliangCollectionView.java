package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.CheliangCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 车辆收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("cheliang_collection")
public class CheliangCollectionView extends CheliangCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String cheliangCollectionValue;

	//级联表 车辆
		/**
		* 车辆编号
		*/

		@ColumnInfo(comment="车辆编号",type="varchar(200)")
		private String cheliangUuidNumber;
		/**
		* 车辆牌号
		*/

		@ColumnInfo(comment="车辆牌号",type="varchar(200)")
		private String cheliangName;
		/**
		* 车辆图片
		*/

		@ColumnInfo(comment="车辆图片",type="varchar(200)")
		private String cheliangPhoto;
		/**
		* 车辆类型
		*/
		@ColumnInfo(comment="车辆类型",type="int(11)")
		private Integer cheliangTypes;
			/**
			* 车辆类型的值
			*/
			@ColumnInfo(comment="车辆类型的字典表值",type="varchar(200)")
			private String cheliangValue;
		/**
		* 车辆热度
		*/

		@ColumnInfo(comment="车辆热度",type="int(11)")
		private Integer cheliangClicknum;
		/**
		* 车辆介绍
		*/

		@ColumnInfo(comment="车辆介绍",type="longtext")
		private String cheliangContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer cheliangDelete;
	//级联表 用户
		/**
		* 用户名称
		*/

		@ColumnInfo(comment="用户名称",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer yonghuDelete;



	public CheliangCollectionView() {

	}

	public CheliangCollectionView(CheliangCollectionEntity cheliangCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, cheliangCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getCheliangCollectionValue() {
		return cheliangCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setCheliangCollectionValue(String cheliangCollectionValue) {
		this.cheliangCollectionValue = cheliangCollectionValue;
	}


	//级联表的get和set 车辆

		/**
		* 获取： 车辆编号
		*/
		public String getCheliangUuidNumber() {
			return cheliangUuidNumber;
		}
		/**
		* 设置： 车辆编号
		*/
		public void setCheliangUuidNumber(String cheliangUuidNumber) {
			this.cheliangUuidNumber = cheliangUuidNumber;
		}

		/**
		* 获取： 车辆牌号
		*/
		public String getCheliangName() {
			return cheliangName;
		}
		/**
		* 设置： 车辆牌号
		*/
		public void setCheliangName(String cheliangName) {
			this.cheliangName = cheliangName;
		}

		/**
		* 获取： 车辆图片
		*/
		public String getCheliangPhoto() {
			return cheliangPhoto;
		}
		/**
		* 设置： 车辆图片
		*/
		public void setCheliangPhoto(String cheliangPhoto) {
			this.cheliangPhoto = cheliangPhoto;
		}
		/**
		* 获取： 车辆类型
		*/
		public Integer getCheliangTypes() {
			return cheliangTypes;
		}
		/**
		* 设置： 车辆类型
		*/
		public void setCheliangTypes(Integer cheliangTypes) {
			this.cheliangTypes = cheliangTypes;
		}


			/**
			* 获取： 车辆类型的值
			*/
			public String getCheliangValue() {
				return cheliangValue;
			}
			/**
			* 设置： 车辆类型的值
			*/
			public void setCheliangValue(String cheliangValue) {
				this.cheliangValue = cheliangValue;
			}

		/**
		* 获取： 车辆热度
		*/
		public Integer getCheliangClicknum() {
			return cheliangClicknum;
		}
		/**
		* 设置： 车辆热度
		*/
		public void setCheliangClicknum(Integer cheliangClicknum) {
			this.cheliangClicknum = cheliangClicknum;
		}

		/**
		* 获取： 车辆介绍
		*/
		public String getCheliangContent() {
			return cheliangContent;
		}
		/**
		* 设置： 车辆介绍
		*/
		public void setCheliangContent(String cheliangContent) {
			this.cheliangContent = cheliangContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getCheliangDelete() {
			return cheliangDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setCheliangDelete(Integer cheliangDelete) {
			this.cheliangDelete = cheliangDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户名称
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户名称
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getYonghuDelete() {
			return yonghuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setYonghuDelete(Integer yonghuDelete) {
			this.yonghuDelete = yonghuDelete;
		}


	@Override
	public String toString() {
		return "CheliangCollectionView{" +
			", cheliangCollectionValue=" + cheliangCollectionValue +
			", cheliangUuidNumber=" + cheliangUuidNumber +
			", cheliangName=" + cheliangName +
			", cheliangPhoto=" + cheliangPhoto +
			", cheliangClicknum=" + cheliangClicknum +
			", cheliangContent=" + cheliangContent +
			", cheliangDelete=" + cheliangDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", yonghuDelete=" + yonghuDelete +
			"} " + super.toString();
	}
}
