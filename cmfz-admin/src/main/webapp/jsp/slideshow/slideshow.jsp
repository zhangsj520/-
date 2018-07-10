<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script>
    $(function () {
        $('#slideTable').datagrid({
            remoteSort: false,
            singleSelect: true,
            nowrap: false,
            fitColumns: true,
            fitRows:true,
            url: "${pageContext.request.contextPath}/slide/querySlideByPage",
            columns: [[
                {field: 'slideId', title: '轮播图编号', width: 80},
                {field: 'slidePath', title: '轮播图路径', width: 100,},
                {field: 'slideDate', title: '轮播图上传时间', width: 80,},
                {field: 'slideDescription', title: '轮播图介绍', width: 80,},
                {
                    field: 'slideStatus', title: '轮播图状态', width: 150,
                    styler: function (value, row, index) {
                        if ($.trim(value) == "展示") {
                            return 'color:red;';
                        }
                    }
                },
            ]],
            toolbar: [{
                iconCls: 'icon-add',
                text: "添加轮播图",
                handler: function () {
                    $("#slideDialog").dialog({
                        title: "添加轮播图",
                        width: 400,
                        height: 260,
                        modal: true,
                        collapsible: true,
                        minimizable: true,
                        maximizable: true,
                        href: "${pageContext.request.contextPath}/jsp/slideshow/uploadSlide.jsp",
                        buttons: [{
                            text: '取消',
                            iconCls: "icon-cross",
                            handler: function () {
                                $.messager.show({
                                    title: "取消",
                                    msg: "您已经取消添加，窗口3秒后消失",
                                    timeout: 3000,
                                });
                                $("#slideDialog").dialog("close", {});
                            }
                        }, {
                            text: '保存',
                            iconCls: "icon-disk",
                            handler: function () {
                                $("#uploadForm").form("submit", {
                                    url: "${pageContext.request.contextPath}/slide/addSlideshow",
                                    onSubmit: function () {
                                        return $(this).form("validate");
                                    },
                                    success: function (data) {
                                        if (data == "success") {
                                            $("#slideTable").datagrid("reload",{});
                                            $.messager.show({
                                                title: "提示消息",
                                                msg: "上传成功，窗口3秒后消失",
                                                timeout: 3000,
                                            });
                                            $("#slideDialog").dialog("close", {});
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
                iconCls: 'icon-user_b',
                text: "帮助",
            }, {
                iconCls: 'icon-edit',
                text: "修改轮播图",
                handler: function () {
                    var rows = $("#slideTable").datagrid("getSelected");
                    if (rows == null) {
                        alert("您还没选择要修改的行");
                    } else {
                        $("#slideDialog").dialog({
                            title: "修改轮播图",
                            width: 400,
                            height: 260,
                            modal: true,
                            collapsible: true,
                            minimizable: true,
                            maximizable: true,
                            href: "${pageContext.request.contextPath}/jsp/slideshow/uploadSlide.jsp",
                            buttons: [{
                                text: '取消',
                                iconCls: "icon-cross",
                                handler: function () {
                                    $.messager.show({
                                        title: "取消",
                                        msg: "您已经取消修改，窗口3秒后消失",
                                        timeout: 3000,
                                    });
                                    $("#slideDialog").dialog("close", {});
                                }
                            }, {
                                text: '修改',
                                iconCls: "icon-edit",
                                handler: function () {
                                    $("#uploadForm").form("submit", {
                                        url: "${pageContext.request.contextPath}/slide/modifySlideshow",
                                        onSubmit: function () {
                                            return $(this).form("validate");
                                        },
                                        success: function (data) {
                                            if (data == "success") {
                                                $("#slideTable").datagrid("reload", {});
                                                $.messager.show({
                                                    title: "提示消息",
                                                    msg: "修改成功，窗口3秒后消失",
                                                    timeout: 3000,
                                                });
                                                $("#slideDialog").dialog("close", {});
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
                            //选中那一行，把数据回显在form表单中
                            onLoad: function () {
                                $("#uploadForm").form("load", rows);
                            }
                        });

                    }
                }
            }],
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/' + rowData.slidePath + '" style="height:300px;"></td>' +
                    '<td style="border:0">' +
                    '<p>轮播图状态: ' + rowData.slideStatus + '</p>' +
                    '<p>轮播图描述: ' + rowData.slideDescription + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },
            pagination: true,
            pageSize: 4,
            pageList: [4, 8, 12],
        });
    })
</script>
<table id="slideTable"></table>
<div id="slideDialog"></div>

