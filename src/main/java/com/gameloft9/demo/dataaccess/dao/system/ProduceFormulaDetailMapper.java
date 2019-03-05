package com.gameloft9.demo.dataaccess.dao.system;

import com.gameloft9.demo.dataaccess.model.system.ProduceFormulaDetailTest;

import java.util.List;

public interface ProduceFormulaDetailMapper {
    //获取id
    ProduceFormulaDetailTest selectByPrimaryKey(String id);

    //查询所有
    List<ProduceFormulaDetailTest> selectAll();

    //增加
    int insert(ProduceFormulaDetailTest record);

    //删除
    int deleteByPrimaryKey(String id);

    //修改
    int updateByPrimaryKey(ProduceFormulaDetailTest record);
}
