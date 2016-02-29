<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css"
	href="jslib/jquery-easyui-1.4.4/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="jslib/jquery-easyui-1.4.4/themes/icon.css">
<script type="text/javascript"
	src="jslib/jquery-easyui-1.4.4/jquery.min.js"></script>
<script type="text/javascript"
	src="jslib/jquery-easyui-1.4.4/jquery.easyui.min.js"></script>
 <script>
  $(function(){  
	  $('#dg').datagrid({
			title : '信息',
		    url:'LoginAction',
			pagination : true,
			pagePosition : 'bottom',
			pageSize : 10,
			pageList : [ 10, 20, 30, 40 ],
			fit : true,
			fitColumns : true,
			nowrap : false,
			border : false,
			idField : 'hid',
			sortOrder : 'desc',
			checkOnSelect : true,
			selectOnCheck : true,
			singleSelect:true,
			
			
			frozenColumns:[[
		        {field:'articleNumber',title:'标号',width:200},
		        {field:'article_title',title:'标题',width:200},   
		        {field:'pv_times',title:'刷新次数',width:60},
		        {field:'isPapered',title:'状态',width:50},
		        {field:'username',title:'用户名',width:100,align:'left'}
		        ]],
		        
		  
		        toolbar : [  {
					text : '添加',
					iconCls : 'icon-add',
					handler : function() {
						add();
					}
				}, '-',  {
					text : '删除',
					iconCls : 'icon-remove',
					handler : function() {
						remove();
					}
				}, '-', {
					text : '修改',
					iconCls : 'icon-edit',
					handler : function() {
						edit();
					}
				}, '-', {
					text : '取消选中',
					iconCls : 'icon-undo',
					handler : function() {
						datagrid.datagrid('clearSelections');
						datagrid.datagrid('unselectAll');
					}
					}, '-' ],
					
			    	 	
		        
		});
  });//结束
  
  function add(){
	  $('#win').dialog({
		  	href:'${pageContext.request.contextPath}/add.jsp',
		    width:420,    
		    height:280,    
		    modal:true,
		    title:"添加",
		    buttons:[{
		    	text:'添加',
		    	handler:function(){
		    		var form = $('#win').find('form');
		    		form.form('submit',{
		    			url:'${pageContext.request.contextPath}/InsertAction',
		    			success:function(j){  //ajax返回的success是指接收到了服务器的返回。至于数据是否操作成功，还得自己判断（可由服务器存入返回的字符串中数据判断）
		    				var json =   $.parseJSON(j);
		    			if(json.success){
		    				  $('#win').window('close');
		    				 $('#dg').datagrid('reload');
		    			}
		    			$.messager.show({
		    				msg:json.message,
		    				title:'提示'
		    			});
		    			}
		    		})
		    	}
		    }]
		});  
  }
  
  function edit(){
	  var dialog
	  var row = $('#dg').datagrid('getSelected');
		if (row){
			alert('Item ID:'+row.article_title+"\nPrice:"+row.articleNumber);
		}
  }
  
 </script>
</head>


<body>
	<div id="win"></div>
	<table id="dg"></table>
</body>
</html>
