layui.config({
    base: $config.resUrl+'layuicms/common/js/'//定义基目录
}).extend({
    ajaxExtention: 'ajaxExtention',//加载自定义扩展，每个业务js都需要加载这个ajax扩展
    $tool: 'tool',
    $api:'api'
}).use(['form', 'layer','$api', 'jquery', 'table', 'laypage','laytpl', 'ajaxExtention', '$tool'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        laypage = layui.laypage,
        $tool = layui.$tool,
        table = layui.table,
        $api = layui.$api;

    var tableIns;//表格实例
    /**
     * 定义表格
     * */
    function defineTable() {
        tableIns = table.render({
            elem: '#depot-data'
            , url: $tool.getContext() + 'sysOC/list.do' //数据接口
            , method: 'post'
            , height:415
            , page:true //开启分页
            , cols: [[ //表头
                {type:'id',field: 'id', title: '库存编号',fixed: 'left', width: 90}
                , {field: 'checkId', title: '盘点编号', width: 90}
                , {field: 'orderType', title: '货品类型(1.成品 2.原料)', width: 180}
                , {field: 'goodsId', title: '货品名称'}
                , {field: 'goodsNumber', title: '货品数量'}
                , {field: 'auditUser', title: '盘点负责人'}
                , {field: 'state', title: '盘点状态', width: 180}
                , {fixed: 'right', title: '操作', width: 250, align: 'center', toolbar: '#barDemo'} //这里的toolbar值是模板元素的选择器
            ]]
            , done: function (res, curr) {//请求完毕后的回调
            }
        });

        //为toolbar添加事件响应
        table.on('tool(roleFilter)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var row = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象

            //区分事件
            if (layEvent === 'del') { //删除
                delDepot(row.id);
            } else if (layEvent === 'edit') { //修改
                //do something
                editDepot(row.id);
            } else{
                checkDepot(row.id);
            }
        });
    }
    defineTable();

    /**
     * 页面初始化
     * */
    function init() {
        //初始化下拉框
        initParentGoods();
        initParentState();
    }
    init();

    /**
     * 初始化下拉框
     * */
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
    function initParentState() {
        $api.GetFirstClassSysState(null,function (res) {
            var data = res.data;
            if (data.length > 0) {
                var html = '<option value="">--请选择--</option>';
                for (var i = 0; i < data.length; i++) {
                    html += '<option value="' + data[i] + '">' + data[i] + '</option>>';
                }
                $('#parentState').append($(html));
                form.render();
            }
        });
    }

    //查询  insepectId单号查询
    form.on("submit(queryDepot)", function (data) {
        var state = data.field.state;
        var goodsId = data.field.goodsId;


        //表格重新加载
        tableIns.reload({
            where:{
                state:state,
                goodsId:goodsId
            }
        });

        return false;
    });

    //添加角色
    $(".usersAdd_btn").click(function () {
        var index = layui.layer.open({
            title: "添加盘点",
            type: 2,
            content: "sysOrderCheckAdd.html",
            success: function (layero, index) {
                setTimeout(function () {
                    layui.layer.tips('点击此处返回库存列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                }, 500)
            }
        });

        //改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
        $(window).resize(function () {
            layui.layer.full(index);
        });
        layui.layer.full(index);
    });

    //删除
    function delDepot(id){
        layer.confirm('确认删除吗？', function (confirmIndex) {
            layer.close(confirmIndex);//关闭confirm
            //向服务端发送删除指令
            var req = {
                id: id
            };

            $api.ocDelete(req,function (data) {
                layer.msg("删除成功",{time:1000},function(){
                    //obj.del(); //删除对应行（tr）的DOM结构
                    //重新加载表格
                    tableIns.reload();
                });
            });
        });
    }

    //修改
    function editDepot(id){
        var index = layui.layer.open({
            title:"管理库存",
            type:2,
            content:"sysOrderCheckEdit.html?id="+id,
            success: function (layero,index) {
                setTimeout(function () {
                    layui.layer.tips('点击此处返回库存列表', '.layui-layer-swtwin .layui-layer-close', {
                        tips: 3
                    });
                }, 500)
            }
        });

        //改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
        $(window).resize(function () {
            layui.layer.full(index);
        });
        layui.layer.full(index);
    }

    //盘点
    function checkDepot(id) {
        var index = layui.layer.open({
            title: "审核订单",
            type: 2,
            content: "sysOrderCheckCheck.html?id=" + id,
            success: function (layero, index) {
                setTimeout(function () {
                    layui.layer.tips('点击此处返回库存列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                }, 500)
            }
        });

        //改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
        $(window).resize(function () {
            layui.layer.full(index);
        });
        layui.layer.full(index);
    }
});
