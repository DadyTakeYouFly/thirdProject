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
     * 页面初始化
     * */
    function init() {
        //初始化下拉框
        initParentCheck();
        initParentGoods();

    }
    init();

    /**
     * 初始化下拉框
     * */
    function initParentCheck() {
        $api.GetFirstClassSysCheck(null,function (res) {
            var data = res.data;
            if (data.length > 0) {
                var html = '<option value="">--请选择--</option>';
                for (var i = 0; i < data.length; i++) {
                    html += '<option value="' + data[i] + '">' + data[i] + '</option>>';
                }
                $('#parentCheckId').append($(html));
                form.render();
            }
        });
    }
    function initParentGoods() {
        $api.GetFirstClassSysGoods(null,function (res) {
            var data = res.data;
            if (data.length > 0) {
                var html = '<option value="">--请选择--</option>';
                for (var i = 0; i < data.length; i++) {
                    html += '<option value="' + data[i] + '">' + data[i] + '</option>>';
                }
                $('#parentGoodsId').append($(html));
                form.render();
            }
        });
    }

    /**
     * 表单提交
     * */
    form.on("submit(outAddDepot)", function (data) {
        var id = data.field.id;
        var checkId = data.field.checkId;
        var orderType = data.field.orderType;
        var goodsId = data.field.goodsId;
        var goodsNumber = data.field.goodsNumber;
        var auditUser = data.field.auditUser;
        var state = data.field.state;

        //请求
        var req = {
            id:id,
            checkId:checkId,
            orderType:orderType,
            goodsId:goodsId,
            goodsNumber:goodsNumber,
            auditUser:auditUser,
            state:state
        };

        $api.ocAdd(req,function (data) {
            //top.layer.close(index);(关闭遮罩已经放在了ajaxExtention里面了)
            layer.msg("添加库存盘点成功！",{time:1000},function () {
                layer.closeAll("iframe");
                //刷新父页面
                parent.location.reload();
            });
        });

        return false;
    })

});


