<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script>
    $(function () {
        $('#logTable').datagrid({
            remoteSort: false,
            singleSelect: true,
            nowrap: false,
            fitColumns: true,
            fitRows:true,
            url: "${pageContext.request.contextPath}/log/queryAllLog",
            columns: [[
                {field: 'logId', title: '日志编号', width: 80},
                {field: 'logUser', title: '操作用户', width: 100,},
                {field: 'logTime', title: '操作时间', width: 80,},
                {field: 'logResource', title: '操作类别', width: 80,},
                {field: 'logAction', title: '动作Action', width: 80,},
                {field: 'logMessage', title: '操作信息', width: 80,},
                {field: 'logResult', title: '操作结果', width: 80,},
            ]],
            pagination: true,
            pageSize: 4,
            pageList: [4, 8, 12],
        });
    })
</script>
<table id="logTable"></table>



