
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
 * 车辆
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/cheliang")
public class CheliangController {
    private static final Logger logger = LoggerFactory.getLogger(CheliangController.class);

    private static final String TABLE_NAME = "cheliang";

    @Autowired
    private CheliangService cheliangService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private CheliangCollectionService cheliangCollectionService;//车辆收藏
    @Autowired
    private CheliangLiuyanService cheliangLiuyanService;//车辆留言
    @Autowired
    private CheliangYuyueService cheliangYuyueService;//车辆预约
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
        params.put("cheliangDeleteStart",1);params.put("cheliangDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = cheliangService.queryPage(params);

        //字典表数据转换
        List<CheliangView> list =(List<CheliangView>)page.getList();
        for(CheliangView c:list){
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
        CheliangEntity cheliang = cheliangService.selectById(id);
        if(cheliang !=null){
            //entity转view
            CheliangView view = new CheliangView();
            BeanUtils.copyProperties( cheliang , view );//把实体数据重构到view中
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
    public R save(@RequestBody CheliangEntity cheliang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,cheliang:{}",this.getClass().getName(),cheliang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<CheliangEntity> queryWrapper = new EntityWrapper<CheliangEntity>()
            .eq("cheliang_name", cheliang.getCheliangName())
            .eq("cheliang_types", cheliang.getCheliangTypes())
            .eq("cheliang_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CheliangEntity cheliangEntity = cheliangService.selectOne(queryWrapper);
        if(cheliangEntity==null){
            cheliang.setCheliangClicknum(1);
            cheliang.setCheliangDelete(1);
            cheliang.setInsertTime(new Date());
            cheliang.setCreateTime(new Date());
            cheliangService.insert(cheliang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody CheliangEntity cheliang, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,cheliang:{}",this.getClass().getName(),cheliang.toString());
        CheliangEntity oldCheliangEntity = cheliangService.selectById(cheliang.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(cheliang.getCheliangPhoto()) || "null".equals(cheliang.getCheliangPhoto())){
                cheliang.setCheliangPhoto(null);
        }

            cheliangService.updateById(cheliang);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<CheliangEntity> oldCheliangList =cheliangService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<CheliangEntity> list = new ArrayList<>();
        for(Integer id:ids){
            CheliangEntity cheliangEntity = new CheliangEntity();
            cheliangEntity.setId(id);
            cheliangEntity.setCheliangDelete(2);
            list.add(cheliangEntity);
        }
        if(list != null && list.size() >0){
            cheliangService.updateBatchById(list);
        }

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
            List<CheliangEntity> cheliangList = new ArrayList<>();//上传的东西
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
                            CheliangEntity cheliangEntity = new CheliangEntity();
//                            cheliangEntity.setCheliangUuidNumber(data.get(0));                    //车辆编号 要改的
//                            cheliangEntity.setCheliangName(data.get(0));                    //车辆牌号 要改的
//                            cheliangEntity.setCheliangPhoto("");//详情和图片
//                            cheliangEntity.setCheliangTypes(Integer.valueOf(data.get(0)));   //车辆类型 要改的
//                            cheliangEntity.setCheliangClicknum(Integer.valueOf(data.get(0)));   //车辆热度 要改的
//                            cheliangEntity.setCheliangContent("");//详情和图片
//                            cheliangEntity.setCheliangDelete(1);//逻辑删除字段
//                            cheliangEntity.setInsertTime(date);//时间
//                            cheliangEntity.setCreateTime(date);//时间
                            cheliangList.add(cheliangEntity);


                            //把要查询是否重复的字段放入map中
                                //车辆编号
                                if(seachFields.containsKey("cheliangUuidNumber")){
                                    List<String> cheliangUuidNumber = seachFields.get("cheliangUuidNumber");
                                    cheliangUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> cheliangUuidNumber = new ArrayList<>();
                                    cheliangUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("cheliangUuidNumber",cheliangUuidNumber);
                                }
                        }

                        //查询是否重复
                         //车辆编号
                        List<CheliangEntity> cheliangEntities_cheliangUuidNumber = cheliangService.selectList(new EntityWrapper<CheliangEntity>().in("cheliang_uuid_number", seachFields.get("cheliangUuidNumber")).eq("cheliang_delete", 1));
                        if(cheliangEntities_cheliangUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(CheliangEntity s:cheliangEntities_cheliangUuidNumber){
                                repeatFields.add(s.getCheliangUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [车辆编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        cheliangService.insertBatch(cheliangList);
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
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<CheliangView> returnCheliangViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = cheliangCollectionService.queryPage(params1);
        List<CheliangCollectionView> collectionViewsList =(List<CheliangCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(CheliangCollectionView collectionView:collectionViewsList){
            Integer cheliangTypes = collectionView.getCheliangTypes();
            if(typeMap.containsKey(cheliangTypes)){
                typeMap.put(cheliangTypes,typeMap.get(cheliangTypes)+1);
            }else{
                typeMap.put(cheliangTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("cheliangTypes",type);
            PageUtils pageUtils1 = cheliangService.queryPage(params2);
            List<CheliangView> cheliangViewList =(List<CheliangView>)pageUtils1.getList();
            returnCheliangViewList.addAll(cheliangViewList);
            if(returnCheliangViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = cheliangService.queryPage(params);
        if(returnCheliangViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnCheliangViewList.size();//要添加的数量
            List<CheliangView> cheliangViewList =(List<CheliangView>)page.getList();
            for(CheliangView cheliangView:cheliangViewList){
                Boolean addFlag = true;
                for(CheliangView returnCheliangView:returnCheliangViewList){
                    if(returnCheliangView.getId().intValue() ==cheliangView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnCheliangViewList.add(cheliangView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnCheliangViewList = returnCheliangViewList.subList(0, limit);
        }

        for(CheliangView c:returnCheliangViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnCheliangViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = cheliangService.queryPage(params);

        //字典表数据转换
        List<CheliangView> list =(List<CheliangView>)page.getList();
        for(CheliangView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        CheliangEntity cheliang = cheliangService.selectById(id);
            if(cheliang !=null){

                //点击数量加1
                cheliang.setCheliangClicknum(cheliang.getCheliangClicknum()+1);
                cheliangService.updateById(cheliang);

                //entity转view
                CheliangView view = new CheliangView();
                BeanUtils.copyProperties( cheliang , view );//把实体数据重构到view中

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
    public R add(@RequestBody CheliangEntity cheliang, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,cheliang:{}",this.getClass().getName(),cheliang.toString());
        Wrapper<CheliangEntity> queryWrapper = new EntityWrapper<CheliangEntity>()
            .eq("cheliang_uuid_number", cheliang.getCheliangUuidNumber())
            .eq("cheliang_name", cheliang.getCheliangName())
            .eq("cheliang_types", cheliang.getCheliangTypes())
            .eq("cheliang_clicknum", cheliang.getCheliangClicknum())
            .eq("cheliang_delete", cheliang.getCheliangDelete())
//            .notIn("cheliang_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CheliangEntity cheliangEntity = cheliangService.selectOne(queryWrapper);
        if(cheliangEntity==null){
            cheliang.setCheliangClicknum(1);
            cheliang.setCheliangDelete(1);
            cheliang.setInsertTime(new Date());
            cheliang.setCreateTime(new Date());
        cheliangService.insert(cheliang);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

