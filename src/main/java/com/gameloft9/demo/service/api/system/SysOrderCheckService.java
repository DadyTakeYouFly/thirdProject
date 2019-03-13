package com.gameloft9.demo.service.api.system;

import com.gameloft9.demo.dataaccess.model.system.SysOrderCheck;

import java.util.List;

public interface SysOrderCheckService {

    //获取id
    SysOrderCheck selectByPrimaryKey(String id);

    //增加
    SysOrderCheck insert(String id,String checkId,Integer orderType,String goodsId,
                         String goodsNumber,String auditUser,String state);

    //删除
    boolean deleteByPrimaryKey(String id);

    //修改
    boolean update(String id,String checkId,Integer orderType,String goodsId, String goodsNumber,
                   String auditUser,String state);

    //获取所有
    List<SysOrderCheck> getAll(String page,String limit,String state,String goodsId);

    //获取个数
    int countGetAll(String state,String goodsId);

    //获取菜单列表下拉框
    List<SysOrderCheck> getFirstClassListState();
    List<SysOrderCheck> getFirstClassListGoods();
    List<SysOrderCheck> getFirstClassListCheck();
}
