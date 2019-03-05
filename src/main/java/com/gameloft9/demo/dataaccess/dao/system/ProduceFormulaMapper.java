package com.gameloft9.demo.dataaccess.dao.system;

import com.gameloft9.demo.dataaccess.model.system.ProduceFormulaTest;

import java.util.List;

public interface ProduceFormulaMapper {
    //获取id
    ProduceFormulaTest selectByPrimaryKey(String id);

    //查询所有
    List<ProduceFormulaTest> selectAll();

    //增加
    int insert(ProduceFormulaTest record);

    //删除
    int deleteByPrimaryKey(String id);

    //修改
    int updateByPrimaryKey(ProduceFormulaTest record);
}
