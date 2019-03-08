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
     * 表单提交
     * */
    form.on("submit(inAddDepot)", function (data) {
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

        //请求
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
            auditDescribe:auditDescribe
        };

        $api.listAddUseless(req,function (data) {
            //top.layer.close(index);(关闭遮罩已经放在了ajaxExtention里面了)
            layer.msg("报销单添加成功！",{time:1000},function () {
                layer.closeAll("iframe");
                //刷新父页面
                parent.location.reload();
            });
        });

        return false;
    })

});


