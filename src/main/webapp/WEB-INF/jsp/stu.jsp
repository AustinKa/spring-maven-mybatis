<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Bruce陈
  Date: 2019/12/10
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/css/plugins/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/bootstrap-table/src/bootstrap-table.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/plugins/jquery-treegrid/css/jquery.treegrid.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/diycss/zTreeStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/diycss/zTreeStyle/img/zTreeStandard.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <script src="/js/jquery-3.2.1.js" ></script>
</head>
<body>
<button onclick="query()">查找</button>
<table id="reportTable" ></table>
<div class="modal" id="modalOne">
    <div class="modal-dialog modal-content">
        <div class="modal-header">
            <h5 class="model modal-title" id="h5"></h5>
            <button class="close" data-dismiss= "modal">&times;</button>
        </div>
        <div class="modal-body">
            <form action="" method="post" class="form-horizontal">
                <div class="form-group">
                    <lable for="stuid" class="control-label col-md-2">学生ID</lable>
                    <div class="col-md-3 has-feedback">
                        <input type="text" id="stuid" name="stuid" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <lable for="sname" class="control-label col-md-2">学生姓名</lable>
                    <div class="col-md-3 has-feedback">
                        <input type="text" id="sname" name="sname" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <lable for="sage" class="control-label col-md-2">学生年龄</lable>
                    <div class="col-md-3 has-feedback">
                        <input type="text" id="sage" name="sage" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <lable for="gender" class="control-label col-md-2">学生性别</lable>
                    <div class="col-md-3 has-feedback">
                        <input type="text" id="gender" name="gender" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <lable for="address" class="control-label col-md-2">学生地址</lable>
                    <div class="col-md-3 has-feedback">
                        <input type="text" id="address" name="address" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <lable for="classid" class="control-label col-md-2">学生班级</lable>
                    <div class="col-md-3 has-feedback">
                        <input type="text" id="classid" name="classid" class="form-control">
                    </div>
                </div>
            </form>
        </div>
        <div class="modal-footer">
            <input type="submit" class="btn btn-danger" value="提交" >
            <button class="btn btn-danger">取消</button>
        </div>
    </div>
</div>


<div class="modal" id="modalTwo">
    <div class="modal-dialog modal-content">
        <div class="modal-header">
            <h5 class="model modal-title" id="h51"></h5>
            <button class="close" data-dismiss= "modal">&times;</button>
        </div>
        <div class="modal-body">
        <div class="modal-footer">
            <button class="btn btn-danger">新增</button>
            <button class="btn btn-danger" onclick="updatel()">修改</button>
        </div>
    </div>
</div>
</div>
</body>
<script src="${pageContext.request.contextPath}/js/plugins/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/plugins/bootstrap/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/plugins/bootstrap-table/src/bootstrap-table.js"></script>
<script src="${pageContext.request.contextPath}/js/plugins/bootstrap-table/src/extensions/treegrid/bootstrap-table-treegrid.js"></script>
<script src="${pageContext.request.contextPath}/js/plugins/jquery-treegrid/js/jquery.treegrid.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/diy/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/diy/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/diy/js/jquery.ztree.exedit.js"></script>
<script>
    $(function () {
        tableTwo();
    })
    function query() {
        $.ajax({
            url:'/student/selectStu',
            type:'post',
            dataType:'json',
            contentType:"application/json;charset=utf-8",
            success:function (resule){
            $.each(resule,function (i,e) {
                console.info(e);
            })
            },
            error:function () {
                alert("没有连接错误")
            }
        })
    }

    function tableTwo() {
        $("#reportTable").bootstrapTable({ // 对应table标签的id
            method: 'post',
            url: '/student/selectStu',
            contentType:'application/x-www-form-urlencoded; charset=UTF-8',
            sidePagination: 'server', // 设置为服务器端分页
            columns:[
                {field:"id", title:"学生ID"},
                {field:"sname", title:"学生姓名"},
                {field:"age", title:"学生年龄"},
                {field:"gender", title:"学生性别"},
                {field:"address", title:"学生地址"},
                {field:"classId", title:"学生班级"},
                {formatter: fom,title:"修改"}
            ],
            onLoadSuccess: function () {  //加载成功时执行
                // console.info("加载成功");
            },
            onLoadError: function () {  //加载失败时执行
                // console.info("加载数据失败");
                showTips("数据加载失败！");
            }
        })
    }

    function fom(a,row,c) {
        var buttons = [];
        buttons.push("<a name='bianji' class='btn btn-success btn-xs' onclick='update("+row.id+")' style='border-radius: 10px'><i class='fa fa-edit'></i>编辑</a> ");
        buttons.push("<a class='btn btn-danger btn-xs btnRemove'  onclick='del("+row.id+")' style='border-radius: 10px'><i class='fa fa-remove'></i>删除</a> ");
        buttons.push("<a class='btn btn-info btn-xs btnRefresh' style='border-radius: 10px' onclick='reset("+row.id+")'><i class='fa fa-key'></i>重置</a>");
        return buttons.join("")
    }

    function update(sid) {
        $("#modalTwo").modal("toggle");
    }

    function updatel(sid) {
        $("#modalOne").modal("toggle");
        $.ajax({
            url:'/student/selectStu',
            type:'post',
            dataType:'json',
            contentType:"application/json;charset=utf-8",
            success:function (resule){
                $.each(resule,function (i,e) {
                    if(e.id==sid){
                        $("#stuid").val(e.id);
                        $("#sname").val(e.sname);
                        $("#sage").val(e.age);
                        $("#gender").val(e.gender);
                        $("#address").val(e.address);
                        $("#classid").val(e.classId);
                    }
                })
            },
            error:function () {
                alert("没有连接错误")
            }
        })

    }


    function del(sid) {
        var id={"id":sid}
        $.ajax({
            url:'/student/deleteStu',
            method:'post',
            dataType:'json',
            data:JSON.stringify(id),
            contentType:"application/json",
            success:function (resule){
                console.info(resule)
                $('#reportTable').bootstrapTable('destroy');
                $("#reportTable").bootstrapTable({ // 对应table标签的id
                    method: 'post',
                    url: '/student/selectStu',
                    contentType:'application/x-www-form-urlencoded; charset=UTF-8',
                    sidePagination: 'server', // 设置为服务器端分页
                    columns:[
                        {field:"id", title:"学生ID"},
                        {field:"sname", title:"学生姓名"},
                        {field:"age", title:"学生年龄"},
                        {field:"gender", title:"学生性别"},
                        {field:"address", title:"学生地址"},
                        {field:"classId", title:"学生班级"},
                        {formatter: fom,title:"修改"}
                    ],
                    onLoadSuccess: function () {  //加载成功时执行
                        // console.info("加载成功");
                    },
                    onLoadError: function () {  //加载失败时执行
                        // console.info("加载数据失败");
                        showTips("数据加载失败！");
                    }
                })

            },
            error:function () {
                alert("没有连接错误")
            }
        })
    }
</script>
</html>
