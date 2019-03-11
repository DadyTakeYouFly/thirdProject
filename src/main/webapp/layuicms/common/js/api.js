/**
 * api接口列表
 * Created by gameloft9 on 2018/7/19.
 */
layui.define(['$tool','jquery'], function (exports) {

    var $tool = layui.$tool,
        $ = layui.jquery;// 拿到模块变量

    /**
     * 封装一个post
     * */
    function doPost(url,req,successCallback,errorCallback) {
        $.ajax({
            url:url,
            data:req,
            method:"post",
            success:function (data) {
                successCallback(data);
            },
            error:function (error) {
                errorCallback(error);
            }
        });
    }

    /**
     * 封装一个get
     * */
    function doGet(url,req,successCallback,errorCallback) {
        $.ajax({
            url:url,
            data:req,
            method:"get",
            success:function (data) {
                successCallback(data);
            },
            error:function (error) {
                errorCallback(error);
            }
        });
    }

    /**
     * 封装一个支持更多参数的post
     * */
    function doComplexPost(url,req,config,successCallback,errorCallback) {
        var defaultConfig = {
            url:url,
            data:req,
            method:"post",
            success:function (data) {
                successCallback(data);
            },
            error:function (error) {
                errorCallback(error);
            }
        };
        var ajaxConfig = $.extend({},config,defaultConfig); // 合并参数

        $.ajax(ajaxConfig);
    }

    // API列表,工程庞大臃肿后可以将API拆分到单独的模块中
    var API = {
        Login: function(req,successCallback,errorCallback){ // 登录
            doPost($tool.getContext() + "login",req,successCallback,errorCallback);
        },
        LogOut:function(req,successCallback,errorCallback){ // 登出
            doPost($tool.getContext() + 'logout.do',req,successCallback,errorCallback);
        },
        ChangePwd:function(req,successCallback,errorCallback){ // 更改密码
            doPost($tool.getContext() + 'personCenter/changePwd.do',req,successCallback,errorCallback);
        },
        GetRoleList:function(req,successCallback,errorCallback){
            doPost($tool.getContext() + 'personCenter/roleList.do',req,successCallback,errorCallback);
        },
        DeleteLog:function(req,successCallback,errorCallback){
            doPost($tool.getContext() + 'log/delete.do',req,successCallback,errorCallback);
        },
        BatchDeleteLog:function(req,config,successCallback,errorCallback){
            doComplexPost($tool.getContext() + 'log/batchDelete.do',req,config,successCallback,errorCallback);
        },
        GetFirstClassMenus:function(req,successCallback,errorCallback){
            doPost($tool.getContext() + 'menu/firstClassMenus.do',req,successCallback,errorCallback);
        },
        AddMenu:function(req,successCallback,errorCallback){
            doPost($tool.getContext() + 'menu/add.do',req,successCallback,errorCallback);
        },
        DeleteMenu:function(req,successCallback,errorCallback){
            doPost($tool.getContext() + 'menu/delete.do',req,successCallback,errorCallback);
        },
        GetMenu:function(req,successCallback,errorCallback){
            doPost($tool.getContext()+'menu/get.do',req,successCallback,errorCallback);
        },
        UpdateMenu:function(req,config,successCallback,errorCallback){
            doComplexPost($tool.getContext()+'menu/update.do',req,config,successCallback,errorCallback);
        },
        GetAllOrg:function(req,successCallback,errorCallback){
            doPost($tool.getContext() + 'org/getAll.do',req,successCallback,errorCallback);
        },
        GetOrg:function(req,successCallback,errorCallback){
            doPost($tool.getContext() + 'org/get.do',req,successCallback,errorCallback);
        },
        AddOrg:function(req,successCallback,errorCallback){
            doPost($tool.getContext() + 'org/add.do',req,successCallback,errorCallback);
        },
        UpdateOrg:function(req,successCallback,errorCallback){
            doPost($tool.getContext() + 'org/update.do',req,successCallback,errorCallback);
        },
        DeleteOrg:function(req,successCallback,errorCallback){
            doPost($tool.getContext() + 'org/delete.do',req,successCallback,errorCallback);
        },
        AddRole:function(req,successCallback,errorCallback){
            doPost($tool.getContext()+'role/add.do',req,successCallback,errorCallback);
        },
        DeleteRole:function(req,successCallback,errorCallback){
            doPost($tool.getContext() + 'role/delete.do',req,successCallback,errorCallback);
        },
        GetRole:function(req,successCallback,errorCallback){
            doPost($tool.getContext()+'role/get.do',req,successCallback,errorCallback);
        },
        UpdateRole:function(req,successCallback,errorCallback){
            doPost($tool.getContext()+'role/update.do',req,successCallback,errorCallback);
        },
        AddUser:function(req,config,successCallback,errorCallback){
            doComplexPost($tool.getContext() + 'sysUser/add.do',req,config,successCallback,errorCallback);
        },
        DeleteUser:function(req,config,successCallback,errorCallback){
            doPost($tool.getContext() + 'sysUser/delete.do',req,config,successCallback,errorCallback);
        },
        InitPwd:function(req,successCallback,errorCallback){
            doPost($tool.getContext() + 'sysUser/initPwd.do',req,successCallback,errorCallback);
        },
        GetUser:function(req,successCallback,errorCallback){
            doPost($tool.getContext()+'sysUser/get.do',req,successCallback,errorCallback);
        },
        UpdateUser:function(req,config,successCallback,errorCallback){
            doComplexPost($tool.getContext() + 'sysUser/update.do',req,config,successCallback,errorCallback);
        },
        GetUserInfo:function(req,successCallback,errorCallback){
            doPost($tool.getContext()+'personCenter/get.do',req,successCallback,errorCallback);
        },
        UpdateUserInfo:function(req,config,successCallback,errorCallback){
            doComplexPost($tool.getContext() + 'personCenter/update.do',req,config,successCallback,errorCallback);
        },

        //allDepot仓库库存
        //删除
        allDeleteDepot:function(req,successCallback,errorCallback){
            doGet($tool.getContext()+'depot/inventory/delete.do',req,successCallback,errorCallback);
        },
        //增加
        allAddDepot:function(req,successCallback,errorCallback){
            doPost($tool.getContext()+'/depot/inventory/insert.do',req,successCallback,errorCallback);
        },
        //修改 获取id
        allGetDepot:function(req,successCallback,errorCallback){
            doPost($tool.getContext()+'depot/inventory/get.do',req,successCallback,errorCallback);
        },
        //修改 获取所有列表
        allGetDepotList:function(req,successCallback,errorCallback){
            doPost($tool.getContext() + 'depot/inventory/list.do',req,successCallback,errorCallback);
        },
        //修改
        allUpdateDepot:function(req,config,successCallback,errorCallback){
            doPost($tool.getContext()+'depot/inventory/update.do',req,config,successCallback,errorCallback);
        },

        //inAllDepot仓库入库单
        //删除
        deleteDepot:function(req,successCallback,errorCallback){
            doGet($tool.getContext()+'depot/order/delete.do',req,successCallback,errorCallback);
        },
        //增加
        addDepot:function(req,successCallback,errorCallback){
            doPost($tool.getContext()+'/depot/order/insert.do',req,successCallback,errorCallback);
        },
        //审核
        inspectDepot:function(req,successCallback,errorCallback){
            doPost($tool.getContext()+'depot/order/update.do',req,successCallback,errorCallback);
        },
        //修改 获取id
        getDepot:function(req,successCallback,errorCallback){
            doPost($tool.getContext()+'depot/order/get.do',req,successCallback,errorCallback);
        },
        //修改 获取所有列表
        getDepotList:function(req,successCallback,errorCallback){
            doPost($tool.getContext() + 'depot/order/list.do',req,successCallback,errorCallback);
        },
        //修改
        updateDepot:function(req,config,successCallback,errorCallback){
            doPost($tool.getContext()+'depot/order/update.do',req,config,successCallback,errorCallback);
        },

        //totalCheck 库存盘点
        //删除
        totalDeletcCheck:function(req,successCallback,errorCallback){
            doGet($tool.getContext()+'depot/check/delete.do',req,successCallback,errorCallback);
        },
        //增加
        totalAddCheck:function(req,successCallback,errorCallback){
            doPost($tool.getContext()+'/depot/check/insert.do',req,successCallback,errorCallback);
        },
        //审核
        /*totalInspectCheck:function(req,successCallback,errorCallback){
            doPost($tool.getContext()+'depot/check/update.do',req,successCallback,errorCallback);
        },*/
        //修改 获取id
        totalGetCheck:function(req,successCallback,errorCallback){
            doPost($tool.getContext()+'depot/check/get.do',req,successCallback,errorCallback);
        },
        //修改 获取所有列表
        totalGetCheckList:function(req,successCallback,errorCallback){
            doPost($tool.getContext() + 'depot/check/list.do',req,successCallback,errorCallback);
        },
        //修改
        totalUpdateCheck:function(req,config,successCallback,errorCallback){
            doPost($tool.getContext()+'depot/order/update.do',req,config,successCallback,errorCallback);
        },

        //uselessDepot库存报废
        //删除
        listDeleteUseless:function(req,successCallback,errorCallback){
            doGet($tool.getContext()+'depot/useless/delete.do',req,successCallback,errorCallback);
        },
        //增加
        listAddUseless:function(req,successCallback,errorCallback){
            doPost($tool.getContext()+'/depot/useless/insert.do',req,successCallback,errorCallback);
        },
        //修改 获取id
        listGetUseless:function(req,successCallback,errorCallback){
            doPost($tool.getContext()+'depot/useless/get.do',req,successCallback,errorCallback);
        },
        //修改 获取所有列表
        listGetUselessList:function(req,successCallback,errorCallback){
            doPost($tool.getContext() + 'depot/useless/list.do',req,successCallback,errorCallback);
        },
        //修改
        listUpdateUseless:function(req,config,successCallback,errorCallback){
            doPost($tool.getContext()+'depot/useless/update.do',req,config,successCallback,errorCallback);
        },

        //sysOC 订单库存一览表
        //删除
        ocDelete:function(req,successCallback,errorCallback){
            doGet($tool.getContext()+'sysOC/delete.do',req,successCallback,errorCallback);
        },
        //修改 获取id
        ocGet:function(req,successCallback,errorCallback){
            doPost($tool.getContext()+'sysOC/get.do',req,successCallback,errorCallback);
        },
        //修改 获取所有列表
        ocGetList:function(req,successCallback,errorCallback){
            doPost($tool.getContext() + 'sysOC/list.do',req,successCallback,errorCallback);
        },
        //修改
        ocUpdate:function(req,config,successCallback,errorCallback){
            doPost($tool.getContext()+'sysOC/update.do',req,config,successCallback,errorCallback);
        },
        GetFirstClassSysOrder:function(req,successCallback,errorCallback){
            doPost($tool.getContext() + 'sysOC/firstClassSysOrder.do',req,successCallback,errorCallback);
        },
        GetFirstClassSysGoods:function(req,successCallback,errorCallback){
            doPost($tool.getContext() + 'sysOC/firstClassSysGoods.do',req,successCallback,errorCallback);
        },
        //增加
        ocAdd:function(req,successCallback,errorCallback){
            doPost($tool.getContext()+'sysOC/insert.do',req,successCallback,errorCallback);
        },
    };




    //输出扩展模块
    exports('$api', API);
});


