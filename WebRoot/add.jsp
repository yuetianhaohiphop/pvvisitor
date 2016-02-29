<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <style>
  #displayPlank{
  width:400px;
  height:auto;

  }
  .data{
  display:inline-block;
  width:100%;
  }
   .data span{
   float:left;
   }
    .data input{
    float:right;
    }
  </style>

  <form method="post">
   	<div id="displayPlank">
   		<div class="data">
   			<span>博客编号</span><input name="articleNumber" type="text"/>
   		</div>
   		<div class="data">
   			<span>用户名</span><input  name="username" type="text"/>
   		</div>
   		<div class="data">
   			<span>需要刷新的次数</span><input name="pv_times" type="text"/>
   		</div>
   		<div class="data">
   			<span>文章标题</span><input name="article_title" type="text"/>
   		</div>
   		<div class="data">
   			<span>是否准备好</span><input name="isPapered" type="text"/>
   		</div>
   		
   	</div>
  </form>
 

