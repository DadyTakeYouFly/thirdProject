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
    form.on("submit(totalAddCheck)", function (data) {
        var id = data.field.id;
        var sourceUser = data.field.sourceUser;
        var sourceTime = data.field.sourceTime;
        var recordNumber = data.field.recordNumber;
        var stats = data.field.stats;

        //请求
        var req = {
            id:id,
            sourceUser:sourceUser,
            sourceTime:sourceTime,
            recordNumber:recordNumber,
            stats:stats
        };

        $api.totalAddCheck(req,function (data) {
            //top.layer.close(index);(关闭遮罩已经放在了ajaxExtention里面了)
            layer.msg("角色添加成功！",{time:1000},function () {
                layer.closeAll("iframe");
                //刷新父页面
                parent.location.reload();
            });
        });

        return false;
    })

});


