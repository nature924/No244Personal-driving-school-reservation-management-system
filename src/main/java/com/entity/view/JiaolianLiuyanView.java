package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JiaolianLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 教练留言
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jiaolian_liuyan")
public class JiaolianLiuyanView extends JiaolianLiuyanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 教练
		/**
		* 教练编号
		*/

		@ColumnInfo(comment="教练编号",type="varchar(200)")
		private String jiaolianUuidNumber;
		/**
		* 教练名称
		*/

		@ColumnInfo(comment="教练名称",type="varchar(200)")
		private String jiaolianName;
		/**
		* 头像
		*/

		@ColumnInfo(comment="头像",type="varchar(200)")
		private String jiaolianPhoto;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String jiaolianPhone;
		/**
		* 赞
		*/

		@ColumnInfo(comment="赞",type="int(11)")
		private Integer zanNumber;
		/**
		* 踩
		*/

		@ColumnInfo(comment="踩",type="int(11)")
		private Integer caiNumber;
		/**
		* 教练类型
		*/
		@ColumnInfo(comment="教练类型",type="int(11)")
		private Integer jiaolianTypes;
			/**
			* 教练类型的值
			*/
			@ColumnInfo(comment="教练类型的字典表值",type="varchar(200)")
			private String jiaolianValue;
		/**
		* 教练热度
		*/

		@ColumnInfo(comment="教练热度",type="int(11)")
		private Integer jiaolianClicknum;
		/**
		* 教练介绍
		*/

		@ColumnInfo(comment="教练介绍",type="longtext")
		private String jiaolianContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer jiaolianDelete;
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

	//重复字段
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer sexTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String sexValue;


	public JiaolianLiuyanView() {

	}

	public JiaolianLiuyanView(JiaolianLiuyanEntity jiaolianLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, jiaolianLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 教练

		/**
		* 获取： 教练编号
		*/
		public String getJiaolianUuidNumber() {
			return jiaolianUuidNumber;
		}
		/**
		* 设置： 教练编号
		*/
		public void setJiaolianUuidNumber(String jiaolianUuidNumber) {
			this.jiaolianUuidNumber = jiaolianUuidNumber;
		}

		/**
		* 获取： 教练名称
		*/
		public String getJiaolianName() {
			return jiaolianName;
		}
		/**
		* 设置： 教练名称
		*/
		public void setJiaolianName(String jiaolianName) {
			this.jiaolianName = jiaolianName;
		}

		/**
		* 获取： 头像
		*/
		public String getJiaolianPhoto() {
			return jiaolianPhoto;
		}
		/**
		* 设置： 头像
		*/
		public void setJiaolianPhoto(String jiaolianPhoto) {
			this.jiaolianPhoto = jiaolianPhoto;
		}

		/**
		* 获取： 联系方式
		*/
		public String getJiaolianPhone() {
			return jiaolianPhone;
		}
		/**
		* 设置： 联系方式
		*/
		public void setJiaolianPhone(String jiaolianPhone) {
			this.jiaolianPhone = jiaolianPhone;
		}

		/**
		* 获取： 赞
		*/
		public Integer getZanNumber() {
			return zanNumber;
		}
		/**
		* 设置： 赞
		*/
		public void setZanNumber(Integer zanNumber) {
			this.zanNumber = zanNumber;
		}

		/**
		* 获取： 踩
		*/
		public Integer getCaiNumber() {
			return caiNumber;
		}
		/**
		* 设置： 踩
		*/
		public void setCaiNumber(Integer caiNumber) {
			this.caiNumber = caiNumber;
		}
		/**
		* 获取： 教练类型
		*/
		public Integer getJiaolianTypes() {
			return jiaolianTypes;
		}
		/**
		* 设置： 教练类型
		*/
		public void setJiaolianTypes(Integer jiaolianTypes) {
			this.jiaolianTypes = jiaolianTypes;
		}


			/**
			* 获取： 教练类型的值
			*/
			public String getJiaolianValue() {
				return jiaolianValue;
			}
			/**
			* 设置： 教练类型的值
			*/
			public void setJiaolianValue(String jiaolianValue) {
				this.jiaolianValue = jiaolianValue;
			}

		/**
		* 获取： 教练热度
		*/
		public Integer getJiaolianClicknum() {
			return jiaolianClicknum;
		}
		/**
		* 设置： 教练热度
		*/
		public void setJiaolianClicknum(Integer jiaolianClicknum) {
			this.jiaolianClicknum = jiaolianClicknum;
		}

		/**
		* 获取： 教练介绍
		*/
		public String getJiaolianContent() {
			return jiaolianContent;
		}
		/**
		* 设置： 教练介绍
		*/
		public void setJiaolianContent(String jiaolianContent) {
			this.jiaolianContent = jiaolianContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getJiaolianDelete() {
			return jiaolianDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setJiaolianDelete(Integer jiaolianDelete) {
			this.jiaolianDelete = jiaolianDelete;
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

	//重复字段
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getSexTypes() {
			return sexTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setSexTypes(Integer sexTypes) {
			this.sexTypes = sexTypes;
			}
				public String getSexValue() {
				return sexValue;
				}
				public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
				}

	@Override
	public String toString() {
		return "JiaolianLiuyanView{" +
			", jiaolianUuidNumber=" + jiaolianUuidNumber +
			", jiaolianName=" + jiaolianName +
			", jiaolianPhoto=" + jiaolianPhoto +
			", jiaolianPhone=" + jiaolianPhone +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", jiaolianClicknum=" + jiaolianClicknum +
			", jiaolianContent=" + jiaolianContent +
			", jiaolianDelete=" + jiaolianDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", yonghuDelete=" + yonghuDelete +
			"} " + super.toString();
	}
}
