
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 车辆预约
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/cheliangYuyue")
public class CheliangYuyueController {
    private static final Logger logger = LoggerFactory.getLogger(CheliangYuyueController.class);

    private static final String TABLE_NAME = "cheliangYuyue";

    @Autowired
    private CheliangYuyueService cheliangYuyueService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private CheliangService cheliangService;//车辆
    @Autowired
    private CheliangCollectionService cheliangCollectionService;//车辆收藏
    @Autowired
    private CheliangLiuyanService cheliangLiuyanService;//车辆留言
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private JiaolianService jiaolianService;//教练
    @Autowired
    private JiaolianCollectionService jiaolianCollectionService;//教练收藏
    @Autowired
    private JiaolianLiuyanService jiaolianLiuyanService;//教练留言
    @Autowired
    private JiaolianYuyueService jiaolianYuyueService;//教练预约
    @Autowired
    private NewsService newsService;//公告资讯
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("教练".equals(role))
            params.put("jiaolianId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = cheliangYuyueService.queryPage(params);

        //字典表数据转换
        List<CheliangYuyueView> list =(List<CheliangYuyueView>)page.getList();
        for(CheliangYuyueView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        CheliangYuyueEntity cheliangYuyue = cheliangYuyueService.selectById(id);
        if(cheliangYuyue !=null){
            //entity转view
            CheliangYuyueView view = new CheliangYuyueView();
            BeanUtils.copyProperties( cheliangYuyue , view );//把实体数据重构到view中
            //级联表 车辆
            //级联表
            CheliangEntity cheliang = cheliangService.selectById(cheliangYuyue.getCheliangId());
            if(cheliang != null){
            BeanUtils.copyProperties( cheliang , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setCheliangId(cheliang.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(cheliangYuyue.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody CheliangYuyueEntity cheliangYuyue, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,cheliangYuyue:{}",this.getClass().getName(),cheliangYuyue.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            cheliangYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<CheliangYuyueEntity> queryWrapper = new EntityWrapper<CheliangYuyueEntity>()
            .eq("cheliang_id", cheliangYuyue.getCheliangId())
            .eq("yonghu_id", cheliangYuyue.getYonghuId())
            .in("cheliang_yuyue_yesno_types", new Integer[]{1,2})
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CheliangYuyueEntity cheliangYuyueEntity = cheliangYuyueService.selectOne(queryWrapper);
        if(cheliangYuyueEntity==null){
            cheliangYuyue.setCheliangYuyueYesnoTypes(1);
            cheliangYuyue.setInsertTime(new Date());
            cheliangYuyue.setCreateTime(new Date());
            cheliangYuyueService.insert(cheliangYuyue);
            return R.ok();
        }else {
            if(cheliangYuyueEntity.getCheliangYuyueYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(cheliangYuyueEntity.getCheliangYuyueYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody CheliangYuyueEntity cheliangYuyue, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,cheliangYuyue:{}",this.getClass().getName(),cheliangYuyue.toString());
        CheliangYuyueEntity oldCheliangYuyueEntity = cheliangYuyueService.selectById(cheliangYuyue.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            cheliangYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            cheliangYuyueService.updateById(cheliangYuyue);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody CheliangYuyueEntity cheliangYuyueEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,cheliangYuyueEntity:{}",this.getClass().getName(),cheliangYuyueEntity.toString());

        CheliangYuyueEntity oldCheliangYuyue = cheliangYuyueService.selectById(cheliangYuyueEntity.getId());//查询原先数据

//        if(cheliangYuyueEntity.getCheliangYuyueYesnoTypes() == 2){//通过
//            cheliangYuyueEntity.setCheliangYuyueTypes();
//        }else if(cheliangYuyueEntity.getCheliangYuyueYesnoTypes() == 3){//拒绝
//            cheliangYuyueEntity.setCheliangYuyueTypes();
//        }
        cheliangYuyueService.updateById(cheliangYuyueEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<CheliangYuyueEntity> oldCheliangYuyueList =cheliangYuyueService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        cheliangYuyueService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<CheliangYuyueEntity> cheliangYuyueList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            CheliangYuyueEntity cheliangYuyueEntity = new CheliangYuyueEntity();
//                            cheliangYuyueEntity.setCheliangYuyueUuidNumber(data.get(0));                    //预约编号 要改的
//                            cheliangYuyueEntity.setCheliangId(Integer.valueOf(data.get(0)));   //车辆 要改的
//                            cheliangYuyueEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            cheliangYuyueEntity.setCheliangYuyueText(data.get(0));                    //备注 要改的
//                            cheliangYuyueEntity.setCheliangYuyueTime(sdf.parse(data.get(0)));          //预约时间 要改的
//                            cheliangYuyueEntity.setCheliangYuyueYesnoTypes(Integer.valueOf(data.get(0)));   //预约状态 要改的
//                            cheliangYuyueEntity.setCheliangYuyueYesnoText(data.get(0));                    //审核回复 要改的
//                            cheliangYuyueEntity.setInsertTime(date);//时间
//                            cheliangYuyueEntity.setCreateTime(date);//时间
                            cheliangYuyueList.add(cheliangYuyueEntity);


                            //把要查询是否重复的字段放入map中
                                //预约编号
                                if(seachFields.containsKey("cheliangYuyueUuidNumber")){
                                    List<String> cheliangYuyueUuidNumber = seachFields.get("cheliangYuyueUuidNumber");
                                    cheliangYuyueUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> cheliangYuyueUuidNumber = new ArrayList<>();
                                    cheliangYuyueUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("cheliangYuyueUuidNumber",cheliangYuyueUuidNumber);
                                }
                        }

                        //查询是否重复
                         //预约编号
                        List<CheliangYuyueEntity> cheliangYuyueEntities_cheliangYuyueUuidNumber = cheliangYuyueService.selectList(new EntityWrapper<CheliangYuyueEntity>().in("cheliang_yuyue_uuid_number", seachFields.get("cheliangYuyueUuidNumber")));
                        if(cheliangYuyueEntities_cheliangYuyueUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(CheliangYuyueEntity s:cheliangYuyueEntities_cheliangYuyueUuidNumber){
                                repeatFields.add(s.getCheliangYuyueUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [预约编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        cheliangYuyueService.insertBatch(cheliangYuyueList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = cheliangYuyueService.queryPage(params);

        //字典表数据转换
        List<CheliangYuyueView> list =(List<CheliangYuyueView>)page.getList();
        for(CheliangYuyueView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        CheliangYuyueEntity cheliangYuyue = cheliangYuyueService.selectById(id);
            if(cheliangYuyue !=null){


                //entity转view
                CheliangYuyueView view = new CheliangYuyueView();
                BeanUtils.copyProperties( cheliangYuyue , view );//把实体数据重构到view中

                //级联表
                    CheliangEntity cheliang = cheliangService.selectById(cheliangYuyue.getCheliangId());
                if(cheliang != null){
                    BeanUtils.copyProperties( cheliang , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setCheliangId(cheliang.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(cheliangYuyue.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody CheliangYuyueEntity cheliangYuyue, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,cheliangYuyue:{}",this.getClass().getName(),cheliangYuyue.toString());
        Wrapper<CheliangYuyueEntity> queryWrapper = new EntityWrapper<CheliangYuyueEntity>()
            .eq("cheliang_yuyue_uuid_number", cheliangYuyue.getCheliangYuyueUuidNumber())
            .eq("cheliang_id", cheliangYuyue.getCheliangId())
            .eq("yonghu_id", cheliangYuyue.getYonghuId())
            .eq("cheliang_yuyue_text", cheliangYuyue.getCheliangYuyueText())
            .in("cheliang_yuyue_yesno_types", new Integer[]{1,2})
            .eq("cheliang_yuyue_yesno_text", cheliangYuyue.getCheliangYuyueYesnoText())
//            .notIn("cheliang_yuyue_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CheliangYuyueEntity cheliangYuyueEntity = cheliangYuyueService.selectOne(queryWrapper);
        if(cheliangYuyueEntity==null){
            cheliangYuyue.setCheliangYuyueYesnoTypes(1);
            cheliangYuyue.setInsertTime(new Date());
            cheliangYuyue.setCreateTime(new Date());
        cheliangYuyueService.insert(cheliangYuyue);

            return R.ok();
        }else {
            if(cheliangYuyueEntity.getCheliangYuyueYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(cheliangYuyueEntity.getCheliangYuyueYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

}

