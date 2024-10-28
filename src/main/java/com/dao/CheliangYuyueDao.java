package com.dao;

import com.entity.CheliangYuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.CheliangYuyueView;

/**
 * 车辆预约 Dao 接口
 *
 * @author 
 */
public interface CheliangYuyueDao extends BaseMapper<CheliangYuyueEntity> {

   List<CheliangYuyueView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
