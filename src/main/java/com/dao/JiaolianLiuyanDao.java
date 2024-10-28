package com.dao;

import com.entity.JiaolianLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiaolianLiuyanView;

/**
 * 教练留言 Dao 接口
 *
 * @author 
 */
public interface JiaolianLiuyanDao extends BaseMapper<JiaolianLiuyanEntity> {

   List<JiaolianLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
