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

    /**
     * 页面初始化
     * */
    function init() {
        //初始化下拉框
        initParentCheck();
        initParentGoods();
    }
    init();


     /*初始化下拉框*/

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


            $api.ocGet(req, function (res) {
                var data = res.data;
                console.log(data)
                $("[name='id']").val(data.id);
                $("[name='checkId)']").val(data.checkId);
                $("[name='orderType']").val(data.orderType);
                $("[name='goodsId']").val(data.goodsId);
                $("[name='goodsNumber']").val(data.goodsNumber);
                $("[name='auditUser']").val(data.auditUser);
                //加载角色列表
                loadRoleList();
                form.render();//重新绘制表单，让修改生效
            });

        /**
         * 加载角色列表
         * */
        function loadRoleList() {
            var url = $tool.getContext() + 'sysOC/list.do';
            var req = {
                page: 1,
                limit: 10
            };

            $api.ocGetList(req, function (res) {
                var data = res.data;
                if (data.length > 0) {
                    var depotHtml = "";
                    for (var i = 0; i < data.length; i++) {
                        //是否初始化选中
                        if ($.inArray(data[i].id) != -1) {
                            depotHtml += '<input type="checkbox" checked name="' + data[i].id + '" title="' + data[i].applyUser + '">';
                        } else {
                            depotHtml += '<input type="checkbox" name="' + data[i].id + '" title="' + data[i].applyUser + '">';
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
            var checkId = data.field.checkId;
            var orderType = data.field.orderType;
            var goodsId = data.field.goodsId;
            var goodsNumber = data.field.goodsNumber;
            var auditUser = data.field.auditUser
            var idList = new Array();

            //请求
            var url = $tool.getContext() + 'sysOC/update.do';
            var req = {
                //id:queryArgs['id'],
                id: id,
                checkId:checkId,
                orderType: orderType,
                goodsId: goodsId,
                goodsNumber: goodsNumber,
                auditUser: auditUser
            };

            $api.ocUpdate(req, function (data) {
                layer.msg("修改成功！", {time: 1000}, function () {
                    layer.closeAll("iframe");
                    //刷新父页面
                    parent.location.reload();
                });
            });

            return false;
        })

});


