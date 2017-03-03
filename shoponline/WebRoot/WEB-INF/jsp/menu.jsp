<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="span24">
		<ul class="mainNav">
					<li>
						<a href="./index.htm">首页</a>
					
					</li>
					<!-- 遍历一次集合 -->
					<s:iterator  var="c" value="#session.categoryList">  
					<li>
						<a href="${pageContext.request.contextPath}/product_findByCid.action?cid=<s:property value="#c.cid" /> }"><s:property value="#c.cname" /></a>
						|
					</li>
					</s:iterator >
					
		</ul>
	</div>