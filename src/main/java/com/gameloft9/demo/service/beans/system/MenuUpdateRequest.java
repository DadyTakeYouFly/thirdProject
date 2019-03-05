package com.gameloft9.demo.service.beans.system;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 更新菜单请求bean
 * Created by gameloft9 on 2017/12/14.
 */
@Data
public class MenuUpdateRequest implements Serializable{

    /**菜单id*/
    private String id;
    /**菜单名称*/
    private String menuName;
    /**菜单访问链接*/
    private String menuUrl;
    /**后台访问路径*/
    private String requestUrl;
    /**排序号*/
    private String sort;
    /**角色id列表*/
    private List<String> roleIdList;

    //190304添加getter和setter方法
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public List<String> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<String> roleIdList) {
        this.roleIdList = roleIdList;
    }
}
