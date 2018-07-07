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
        $('#tb').textbox({
            prompt:"上师法名....",
            iconCls:'icon-user_red',
            iconAlign:'left',
            required:true,
        });
        $('#tb1').textbox({
            prompt:"上师简介....",
            iconCls:'icon-flag_bh',
            iconAlign:'left',
            required:true,
        });
        $('#fb').filebox({
            buttonText: '选择文件',
            buttonAlign: 'left',
        });

    });
</script>
<form id="uploadGuru" method="post" enctype="multipart/form-data">
    <table style="padding-left: 70px;padding-top: 50px;">
        <tr><input name="guruId" type="hidden"/></tr>
        <tr>
            <td>上师的法名:</td>
            <td><input id="tb" name="guruReligionName" type="text"></td>
        </tr>
        <tr>
            <td>上师的简介:</td>
            <td><input id="tb1" name="guruDescription" type="text">
            </td>
        </tr><tr>
            <td>请选择头像：</td>
            <td><input id="fb" name="myFile" type="text"></td>
        </tr>
    </table>
</form>
