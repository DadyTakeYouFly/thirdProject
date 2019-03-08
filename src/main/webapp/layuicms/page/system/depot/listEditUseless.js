layui.config({
    base: $config.resUrl+'layuicms/common/js/'//定义基目录
}).extend({
    ajaxExtention:'ajaxExtention',//加载自定义扩展，每个业务js都需要加载这个ajax扩展
    $tool:'tool',
    $api:'api'
}).use(['form', 'layer', 'jquery','ajaxExtention','$tool','$api'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        laypage = layui.laypage,
        $ = layui.jquery,
        $tool = layui.$tool,
        $api = layui.$api;


    var depotIdList = new Array();//所有的角色id列表
    //var depotIds =[];//菜单所属角色列表

    /**
     * 初始化页面
     * */
    function init() {
        //初始化菜单信息
        initDepotInfo();
    }
    init();

    /**
     * 初始化菜单信息
     * */
    function initDepotInfo() {
        var queryArgs = $tool.getQueryParam();//获取查询参数
        var id = queryArgs['id'];

        var url = $tool.getContext()+'depot/useless/get.do';
        var req = {
            id:id
        };

        $api.getDepot(req,function (res) {
            var data = res.data;
            console.log(data)
            $("[name='id']").val(data.id);
            $("[name='orderType']").val(data.orderType);
            $("[name='goodsId']").val(data.goodsId);
            $("[name='goodsNumber']").val(data.goodsNumber);
            $("[name='applyUser']").val(data.applyUser);
            $("[name='applyTime']").val(data.applyTime);
            $("[name='state']").val(data.state);
            $("[name='orderAuditUser']").val(data.orderAuditUser);
            $("[name='orderAuditTime']").val(data.orderAuditTime);
            $("[name='applyDescribe']").val(data.applyDescribe);
            $("[name='auditDescribe']").val(data.auditDescribe);
            loadRoleList();
            form.render();//重新绘制表单，让修改生效
        });
    }

    /**
     * 加载角色列表
     * */
    function loadRoleList() {
        var url = $tool.getContext()+'depot/useless/list.do';
        var req =  {
            page:1,
            limit:10
        };

        $api.listGetUselessList(req,function (res) {
            var data = res.data;
            if(data.length > 0){
                var depotHtml = "";
                for(var i = 0;i<data.length;i++){
                    //是否初始化选中
                    if($.inArray(data[i].id) != -1){
                        depotHtml += '<input type="checkbox" checked name="'+data[i].id+'" title="'+data[i].applyUser+'">';
                    }else{
                        depotHtml += '<input type="checkbox" name="'+data[i].id+'" title="'+data[i].applyUser+'">';
                    }

                    depotIdList.push(data[i].id);//保存id列表
                }

                $('.role-check-list').append($(depotHtml));
                form.render();//重新绘制表单，让修改生效
            }
        });
    }

    /**
     * 表单提交
     * */
    form.on("submit(editDepot)", function (data) {
        var id = data.field.id;
        var orderType = data.field.orderType;
        var goodsId = data.field.goodsId;
        var goodsNumber = data.field.goodsNumber;
        var applyUser = data.field.applyUser;
        var applyTime = data.field.applyTime;
        var state = data.field.state;
        var orderAuditUser = data.field.orderAuditUser;
        var orderAuditTime = data.field.orderAuditTime;
        var applyDescribe = data.field.applyDescribe;
        var auditDescribe = data.field.auditDescribe;
        var idList = new Array();

        //获取选中的角色列表
        for(var i=0;i<depotIdList.length;i++){
            if(data.field[depotIdList[i]] === 'on'){
                idList.push(depotIdList[i]);
            }
        }

        //请求
        var url = $tool.getContext()+'depot/useless/update.do';
        var req = {
            //id:queryArgs['id'],
            id:id,
            orderType:orderType,
            goodsId:goodsId,
            goodsNumber:goodsNumber,
            applyUser:applyUser,
            applyTime:applyTime,
            state:state,
            orderAuditUser:orderAuditUser,
            orderAuditTime:orderAuditTime,
            applyDescribe:applyDescribe,
            auditDescribe:auditDescribe,
            depotIdList:idList
        };

        $api.listUpdateUseless(req,function (data) {
            layer.msg("修改成功！",{time:1000},function () {
                layer.closeAll("iframe");
                //刷新父页面
                parent.location.reload();
            });
        });

        return false;
    })

});


