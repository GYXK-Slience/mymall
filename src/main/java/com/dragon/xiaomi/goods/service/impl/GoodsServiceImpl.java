package com.dragon.xiaomi.goods.service.impl;

import com.dragon.xiaomi.goods.pojo.Goods;
import com.dragon.xiaomi.goods.pojo.GoodsType;
import com.dragon.xiaomi.goods.service.GoodsService;
import com.dragon.xiaomi.mapper.GoodsMapper;
import com.dragon.xiaomi.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jackiechan on 10/16/18/7:25 PM
 *
 * @Author jackiechan
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;


    public List<GoodsType> getGoodsTypeList() {
        return goodsMapper.getGoodsTypeList();
    }


    public PageBean getGoodsByTypeId(Integer typeId, Integer pageNum, Integer pageSize) {
        //PageHelper.startPage(pageNum,pageSize);//开始分页,pagenum等于当前页数,pagesize 每页页数
        List<Goods> goodsList = goodsMapper.getGoodsByTypeId(typeId,pageNum,pageSize);
        long totalCount=goodsMapper.getCount(typeId);
        //PageInfo<Goods> pageInfo = new PageInfo<>(goodsList);//存放数据
        PageBean pageBean = new PageBean(pageNum,pageSize,totalCount);
        pageBean.setData(goodsList);
        return pageBean;
    }


    public Goods getGoodsDetailById(Integer id) {
        Goods goods = goodsMapper.getGoodsDetailById(id);

        GoodsType goodsType  = goodsMapper.getGoodsListByTypeId(goods.getTypeid());
        goods.setGoodsType(goodsType);
        return goods;
    }


    public Goods findById(int id) {
        Goods goods = goodsMapper.findById(id);
        GoodsType goodsType  = goodsMapper.getGoodsListByTypeId(goods.getTypeid());
        goods.setGoodsType(goodsType);

        return goods;
    }


    public List<Goods> searchByName(String goodsname) {
        return goodsMapper.findByName(goodsname);
    }


    public void addGoods(Goods goods) {
        goodsMapper.addGoods(goods);
    }


    public List<GoodsType> findAllGoodsType() {
        List<GoodsType> allGoodsType = goodsMapper.findAllGoodsType();
        return allGoodsType;
    }


    public String getParentNameByParentId(int parent) {
        return goodsMapper.getParentNameByParentId(parent);
    }


    public List<Goods> fingAllGoods() {
        //PageHelper.startPage(pageNum, pageSize);
        List<Goods> goodsList=goodsMapper.fingAllGoods();
        //PageInfo<Goods> pageInfo=new PageInfo<>(goodsList);
        return goodsList;
    }


    public String getGoodsTypeName(int typeid) {
        return goodsMapper.findGoodsTypeName(typeid);
    }


    public void addGoodsType(GoodsType goodsType) {
        goodsMapper.addGoodsType(goodsType);
    }


    public List<Goods> queryGoods(String name, String pubdate) {
        List<Goods> goodsList=goodsMapper.queryGoods(name,pubdate);
        return goodsList;
    }


    public void deleteGoodsById(int goodsid) {
        goodsMapper.deleteGoodsById(goodsid);
    }


    public int getGoodstyidByTypeName(String typeName) {
        return goodsMapper.getGoodstyidByTypeName(typeName);
    }


    public void updateGoods(Goods goods) {
        goodsMapper.updateGoods(goods);
    }


}
