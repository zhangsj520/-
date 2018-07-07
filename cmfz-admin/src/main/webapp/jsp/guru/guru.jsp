<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <title>Document</title>
</head>
<body>

<table id="guruTable">
</table>
<div id="guruDialog"></div>

<div id="search" <%--style="float: right;"--%>> <!--   若想调整搜索框位置，加一个div层 -->
    <input id="sss"></input>
    <div id="mm" style="width:100px">
        <!-- 搜索选项，若上面的初始化中有相关内容则不需要下面的内容 -->
        <div data-options="name:'g_religionName'">上师法名</div>
        <div data-options="name:'g_id'">上师编号</div>
        <%--<div data-options="name:'departmentName'">部门</div>
        <div data-options="name:'majorName'">专业</div>--%>
    </div>
</div>
<script>
    $(function () {
        $('#guruTable').datagrid({
            remoteSort: false,
            singleSelect: true,
            nowrap: false,
            fitColumns: true,
            url: "${pageContext.request.contextPath}/guru/queryGuru",
            columns: [[
                {field: 'guruId', title: '上师编号', width: 80},
                {field: 'guruReligionName', title: '上师法名', width: 100,},
                {field: 'guruPicture', title: '上师头像', width: 80,},
                {field: 'guruDescription', title: '上师简介', width: 80,}
            ]],
            toolbar: [{
                iconCls: 'icon-add',
                text: "添加上师",
                handler: function () {
                    //添加上师
                    $("#guruDialog").dialog({
                        title: "添加上师",
                        width: 400,
                        height: 260,
                        modal: true,
                        collapsible: true,
                        minimizable: true,
                        maximizable: true,
                        href: "${pageContext.request.contextPath}/jsp/guru/uploadGuru.jsp",
                        //=========================================================================================
                        //消失框取消
                        buttons: [{
                            text: '取消',
                            iconCls: "icon-cross",
                            handler: function () {
                                $.messager.show({
                                    title: "取消",
                                    msg: "您已经取消添加，窗口3秒后消失",
                                    timeout: 3000,
                                });
                                $("#guruDialog").dialog("close", {});
                            }
                        }, {
                            //消息框保存
                            //============================================================
                            text: '保存',
                            iconCls: "icon-disk",
                            handler: function () {
                                $("#uploadGuru").form("submit", {
                                    url: "${pageContext.request.contextPath}/guru/addguru",
                                    onSubmit: function () {
                                        return $(this).form("validate");
                                    },
                                    success: function (data) {
                                        if (data == "success") {
                                            $("#guruTable").datagrid("reload", {});
                                            $.messager.show({
                                                title: "提示消息",
                                                msg: "上传成功，窗口3秒后消失",
                                                timeout: 3000,
                                            });
                                            $("#guruDialog").dialog("close", {});
                                        } else {
                                            $.messager.show({
                                                title: "提示消息",
                                                msg: "上传失败",
                                                timeout: 3000,
                                            });
                                        }
                                    },
                                });
                            }
                        }],
                    });
                }
            }, {
                //帮助====================================================
                iconCls: 'icon-user_b',
                text: "帮助",
            }, {
                //修改上师====================================================================
                iconCls: 'icon-edit',
                text: "修改上师信息",
                handler: function () {
                    var rows = $("#guruTable").datagrid("getSelected");
                    if (rows == null) {
                        alert("您还没选择要修改的行");
                    } else {
                        $("#guruDialog").dialog({
                            title: "修改上师",
                            width: 400,
                            height: 260,
                            modal: true,
                            collapsible: true,
                            minimizable: true,
                            maximizable: true,
                            href: "${pageContext.request.contextPath}/jsp/guru/uploadGuru.jsp",
                            buttons: [{
                                text: '取消',
                                iconCls: "icon-cross",
                                handler: function () {
                                    $.messager.show({
                                        title: "取消",
                                        msg: "您已经取消修改，窗口3秒后消失",
                                        timeout: 3000,
                                    });
                                    $("#guruDialog").dialog("close", {});
                                }
                            }, {
                                text: '修改',
                                iconCls: "icon-edit",
                                handler: function () {
                                    $("#uploadGuru").form("submit", {
                                        url: "${pageContext.request.contextPath}/guru/modifyGuru",
                                        onSubmit: function () {
                                            return $(this).form("validate");
                                        },
                                        success: function (data) {
                                            if (data == "success") {
                                                $("#guruTable").datagrid("reload", {});
                                                $.messager.show({
                                                    title: "提示消息",
                                                    msg: "修改成功，窗口3秒后消失",
                                                    timeout: 3000,
                                                });
                                                $("#guruDialog").dialog("close", {});
                                            } else {
                                                $.messager.show({
                                                    title: "提示消息",
                                                    msg: "修改失败",
                                                    timeout: 3000,
                                                });
                                            }
                                        },
                                    });
                                }
                            }],
                            onLoad: function () {
                                $("#uploadGuru").form("load", rows);
                            }
                        });

                    }
                }
            }],
        //显示一行信息===============================================================
        view : detailview,
            detailFormatter : function (rowIndex, rowData) {
            return '<table><tr>' +
                '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/' + rowData.guruPicture + '" style="height:300px;"></td>' +
                '<td style="border:0">' +
                '<p>上师法号: ' + rowData.guruReligionName + '</p>' +
                '<p>上师简介: ' + rowData.guruDescription + '</p>' +
                '</td>' +
                '</tr></table>';
        },
        //显示分页====================================================================
        pagination:true,
            pageSize:4,
            pageList:[4, 8, 12],
    });
        $("#search").css("display","block");
        $('#sss').searchbox({
            menu : '#mm',
            prompt : '请输入要搜索的信息...',
            searcher : function(value, name) {
                $("#guruTable").datagrid("load",{
                    key : name,
                    value : value,
                });
                $('#guruTable').datagrid({
                    url:"${pageContext.request.contextPath}/guru/queryGuruByKey",
                });
            },
        });
        $('#search').prependTo('.datagrid-toolbar');

    })
</script>


</body>
</html>
