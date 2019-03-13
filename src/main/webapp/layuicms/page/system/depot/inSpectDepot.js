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

        var url = $tool.getContext()+'depot/order/get.do';
        var req = {
            id:id
        };

        $api.getDepot(req,function (res) {
            var data = res.data;
            //console.log(data)
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
            //depotIds = data.depotIds;//保存菜单所属角色id列表，初始化选中时用
            //加载角色列表
            loadRoleList();
            form.render();//重新绘制表单，让修改生效
        });
    }

    /**
     * 加载角色列表
     * */
    function loadRoleList() {
        var url = $tool.getContext()+'depot/order/list.do';
        var req =  {
            page:1,
            limit:10
        };

        $api.getDepotList(req,function (res) {
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

                    //depotIdList.push(data[i].id);//保存id列表
                }

                $('.role-check-list').append($(depotHtml));
                form.render();//重新绘制表单，让修改生效
            }
        });
    }

    /**
     * 表单提交
     * */
    form.on("submit(successDepot)", function (data) {
        var id = data.field.id;
        var orderType = data.field.orderType;
        var goodsId = data.field.goodsId;
        var goodsNumber = data.field.goodsNumber;
        var applyUser = data.field.applyUser;
        var applyTime = data.field.applyTime;
        var state = $(this).html();
        var orderAuditUser = data.field.orderAuditUser;
        var orderAuditTime = data.field.orderAuditTime;
        var applyDescribe = data.field.applyDescribe;
        var auditDescribe = data.field.auditDescribe;
        var idList = new Array();



        //请求
        var url = $tool.getContext()+'depot/order/update.do';
        var req = {
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

        $api.updateDepot(req,function (data) {
            layer.msg("提交成功！",{time:1000},function () {
                layer.closeAll("iframe");
                //刷新父页面
                parent.location.reload();
            });
        });

        return false;
    })

});


