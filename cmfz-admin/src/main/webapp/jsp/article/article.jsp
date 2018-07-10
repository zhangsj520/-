<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script>
    $(function () {
        $('#articleTable').datagrid({
            remoteSort: false,
            singleSelect: true,
            nowrap: false,
            fitColumns: true,
            fitRows:true,
            url: "${pageContext.request.contextPath}/article/queryArticles",
            columns: [[
                {field: 'articleId', title: '文章编号', width: 80},
                {field: 'articleTitle', title: '文章标题', width: 100,},
                {field: 'articleIntroduce', title: '文章介绍', width: 80,hidden:true,},
                {field: 'articleDate', title: '文章上传日期', width: 80,},
                {
                    field: 'articleStatus', title: '轮播图状态', width: 150,
                    styler: function (value, row, index) {
                        if ($.trim(value) == "上架") {
                            return 'color:red;';
                        }
                    }
                },
                {field:'g.guruReligionName',title:'所属上师',width:80},
                {field:'opt',title:'操作',width:150,formatter: function(value,row,index){
                        return "<a class='btn1'></a><a class='btn2'></a>";
                    }
                }
            ]],
            onLoadSuccess:function(){
              $(".btn1").linkbutton({
                  iconCls:'icon-application_split',
                  text:'文章详情',
                  onClick:function(){
                      $("#articleTable").datagrid({
                         onClickRow:function(index, row){
                             $("#articleDialog").dialog({
                                 title: "文章信息",
                                 width: 700,
                                 height: 560,
                                 modal: true,
                                 collapsible: true,
                                 minimizable: true,
                                 maximizable: true,
                                 onOpen:function(){
                                     $("#articleDialog").html(row.articleIntroduce);
                                 }
                             });
                         },
                      });
                  },
              });
                $(".btn2").linkbutton({
                    iconCls:'icon-edit',
                    text:'修改内容',
                    onClick:function(){
                        alert("asdf12");
                    },
                });
            },
            pagination: true,
            pageSize: 4,
            pageList: [4, 8, 12],
        });
    })
</script>
<table id="articleTable"></table>
<div id="articleDialog"></div>

