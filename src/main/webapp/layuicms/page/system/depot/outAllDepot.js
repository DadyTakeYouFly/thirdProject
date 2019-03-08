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
            , height: 415
            , url: $tool.getContext() + 'depot/order/list.do' //数据接口
            , method: 'post'
            , page:true //开启分页
            , cols: [[ //表头
                  //{title:'订单单号',width: '8%'},
                  {type:'id',field: 'id', title: '订单单号',fixed: 'left', width: '8%'}
                , {field: 'orderType', title: '订单类型', width: '8%'}
                , {field: 'goodsId', title: '原料/成品ID', width: '10%'}
                , {field: 'goodsNumber', title: '货品数量', width: '8%'}
                , {field: 'applyUser', title: '申请人', width: '8%'}
                , {field: 'applyTime', title: '申请时间', width: '12%'}
                , {field: 'state', title: '订单状态', width: '8%',templet: '#tmp'}
                , {field: 'orderAuditUser', title: '审核人', width: '8%'}
                , {field: 'orderAuditTime', title: '审核时间', width: '12%'}
                , {field: 'applyDescribe', title: '申请描述', width: '12%'}
                , {field: 'auditDescribe', title: '审核描述', width: '12%'}
                , {fixed: 'right', title: '操作', width: 250, align: 'center', toolbar: '#barDemo'} //这里的toolbar值是模板元素的选择器
            ]]
            , done: function (res, curr) {//请求完毕后的回调
            // 如果是异步请求数据方式，res即为你接口返回的信息.curr：当前页码
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
            }
            else{  //审核
                inspectDepot(row.id);
            }
        });
    }
    defineTable();


    //查询  insepectId单号查询
    form.on("submit(queryDepot)", function (data) {
        var orderType = data.field.orderType;
        //var state = data.field.state;

        //表格重新加载
        tableIns.reload({
            where:{
                orderType:orderType,
                //state:state
            }
        });

        return false;
    });

    //添加角色
    $(".usersAdd_btn").click(function () {
        var index = layui.layer.open({
            title: "申请入库单",
            type: 2,
            content: "outAddDepot.html",
            success: function (layero, index) {
                setTimeout(function () {
                    layui.layer.tips('点击此处返回出库单列表', '.layui-layer-setwin .layui-layer-close', {
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

            $api.deleteDepot(req,function (data) {
                layer.msg("删除成功",{time:1000},function(){
                    //obj.del(); //删除对应行（tr）的DOM结构
                    //重新加载表格
                    tableIns.reload();
                });
            });
        });
    }

    //审核
    function inspectDepot(id) {
        var index = layui.layer.open({
            title: "审核订单",
            type: 2,
            content: "inSpectDepot.html?id=" + id,
            success: function (layero, index) {
                setTimeout(function () {
                    layui.layer.tips('点击此处返回出库单列表', '.layui-layer-setwin .layui-layer-close', {
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

    //修改
    function editDepot(id) {
        var index = layui.layer.open({
            title: "修改订单",
            type: 2,
            content: "outEditDepot.html?id=" + id,
            success: function (layero, index) {
                setTimeout(function () {
                    layui.layer.tips('点击此处返回出库单列表', '.layui-layer-swtwin .layui-layer-close', {
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
