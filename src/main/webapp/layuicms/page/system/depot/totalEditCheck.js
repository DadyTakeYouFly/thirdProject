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


    var checkIdList = new Array();//所有的角色id列表
    //var depotIds =[];//菜单所属角色列表

    /**
     * 初始化页面
     * */
    function init() {
        //初始化菜单信息
        initCheckInfo();
    }
    init();

    /**
     * 初始化菜单信息
     * */
    function initCheckInfo() {
        var queryArgs = $tool.getQueryParam();//获取查询参数
        var id = queryArgs['id'];

        var url = $tool.getContext()+'/depot/check/get.do';
        var req = {
            id:id
        };

        $api.totalGetCheck(req,function (res) {
            var data = res.data;
            console.log(data)
            $("[name='id']").val(data.id);
            $("[name='sourceUser']").val(data.sourceUser);
            $("[name='sourceTime']").val(data.sourceTime);
            $("[name='recordNumber']").val(data.recordNumber);
            $("[name='state']").val(data.state);
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
        var url = $tool.getContext()+'/depot/check/list.do';
        var req =  {
            page:1,
            limit:10
        };

        $api.totalGetCheckList(req,function (res) {
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

                    checkIdList.push(data[i].id);//保存id列表
                }

                $('.role-check-list').append($(depotHtml));
                form.render();//重新绘制表单，让修改生效
            }
        });
    }

    /*form.on('radio(orgTypeFilter)', function (data) {
        //console.log(data.elem); //得到radio原始DOM对象
        var goodsType = data.goodsType;
    });*/

    /**
     * 表单提交
     * */
    form.on("submit(editCheck)", function (data) {
        //var queryArgs = $tool.getQueryParam();//获取查询参数
        var id = data.field.id;
        var sourceUser = data.field.sourceUser;
        var sourceTime = data.field.sourceTime;
        var recordNumber = data.field.recordNumber;
        var state = data.field.state;
        var idList = new Array();

        //获取选中的角色列表
        for(var i=0;i<checkIdList.length;i++){
            if(data.field[checkIdList[i]] === 'on'){
                idList.push(checkIdList[i]);
            }
        }

        //请求
        var url = $tool.getContext()+'depot/inventory/update.do';
        var req = {
            //id:queryArgs['id'],
            id:id,
            sourceUser:sourceUser,
            sourceTime:sourceTime,
            recordNumber:recordNumber,
            state:state
        };

        $api.totalUpdateCheck(req,function (data) {
            layer.msg("修改成功！",{time:1000},function () {
                layer.closeAll("iframe");
                //刷新父页面
                parent.location.reload();
            });
        });

        return false;
    })

});


