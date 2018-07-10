<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/8/008
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<style type="text/css">
    .articleBg{
        height: 540px;
    }


    .toolbar {
        border: 1px solid #ccc;
        height: 30px;
    }
    .text {
        border: 1px solid #ccc;
        height: 400px;
        background-color: beige;
    }
</style>
<script type="text/javascript">
    $(function(){
        /*加载上师信息*/
        $('#guruName').combobox({
            url:'${pageContext.request.contextPath}/guru/queryName',
            valueField:'guruId',
            textField:'guruReligionName'
        })
        /*重置*/
        $('#resetArticlebtn').click(function(){
            $('#articleForm').form('reset');
            editor.txt.html('<p>请输入内容</p>');
        })
        /*保存文章信息*/
        $('#createArticlebtn').click(function(){
            $('#articleForm').form('submit', {
                url:'${pageContext.request.contextPath}/article/addArticle',
                onSubmit: function(param){
                    param.articleIntroduce= editor.txt.html();
                    return $(this).form('validate');
                },
                success:function(data){
                    if(data=='1'){
                        alert("上传成功");


                    }else{
                        alert("上传失败")
                    }
                }
            });
        })

    })

</script>
<div class="articleBg" style="padding-left: 10px; background-image: linear-gradient(to top,#5adaff,#fff69a)">
<form id="articleForm" method="post">
    <table>
        <tr>
            <td><span>文章标题：</span></td>
            <td><input class="easyui-textbox" name="articleTitle" style="width:200px" data-options="required:true"></td>
        </tr>
        <tr>
            <td><span>文章作者：</span></td>
            <td>
                <select id="guruName" name="guruId" style="width:200px;" class="easyui-combobox" data-options="required:true" >
                    <option>暂无</option>
                </select>
            </td>
        </tr>
        <tr>
            <td><span>文章状态</span></td>
            <td><input class="easyui-switchbutton" name="articleStatus" data-options="onText:'上架',offText:'下架',required:true" ></td>
        </tr>
    </table>
</form>
    <div id="texttop" class="toolbar"></div>
<div id="editor" class="text">
    <p>在此输入内容.....</p>
</div>
    <a id="createArticlebtn"  class="easyui-linkbutton" data-options="iconCls:'icon-add'">创建内容</a>
    <a id="resetArticlebtn"  class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">重置内容</a>
</div>
<!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/wangEditor.min.js"></script>
<script type="text/javascript">
    var E = window.wangEditor
    var editor = new E('#editor');
    // 或者 var editor = new E( document.getElementById('editor') )
    editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}/article/upload';  // 上传图片到服务器
    editor.customConfig.uploadFileName = 'files'; //上传图片的名称
    editor.create()
</script>

