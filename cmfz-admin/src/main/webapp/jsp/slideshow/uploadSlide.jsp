<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/6/006
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<script type="text/javascript">
    $(function(){
        $("#cc").combobox({
           required:true,
            panelHeight:50,
            width:100,
        });
        $('#tb').textbox({
            prompt:"描述信息....",
            iconCls:'icon-man',
            iconAlign:'left',
            required:true,
        });
        $('#fb').filebox({
            buttonText: '选择文件',
            buttonAlign: 'left',
        });

    });
</script>
<form id="uploadForm" method="post" enctype="multipart/form-data">
    <table style="padding-left: 70px;padding-top: 50px;">
        <tr><input name="slideId" type="hidden"/></tr>
        <tr>
            <td>轮播图描述:</td>
            <td><input id="tb" name="slideDescription" type="text"></td>
        </tr>
        <tr>
            <td>轮播图状态:</td>
            <td><select id="cc" name="slideStatus">
                <option value="展示">展示</option>
                <option value="不展示">不展示</option>
            </select>
            </td>
        </tr><tr>
            <td>请选择图片：</td>
            <td><input id="fb" name="myFile" type="text"></td>
        </tr>
    </table>
</form>
