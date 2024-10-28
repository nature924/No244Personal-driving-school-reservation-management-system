package com.dao;

import com.entity.JiaolianCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiaolianCollectionView;

/**
 * 教练收藏 Dao 接口
 *
 * @author 
 */
public interface JiaolianCollectionDao extends BaseMapper<JiaolianCollectionEntity> {

   List<JiaolianCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
