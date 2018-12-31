<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/books/queryBook.action" method="post">
查询条件：输入出版社：<input name="bCustom.comefrom" /><input type="submit" value="查询"/>
	<table style="border: 1px solid;">
		<tr style="border: 1px solid;">
			<td style="border: 1px solid;">书名</td>
			<td style="border: 1px solid;">出版社</td>
			<td style="border: 1px solid;">作者</td>
			<td style="border: 1px solid;">价格</td>
			<td style="border: 1px solid;">操作</td>
		</tr>
		<c:forEach items="${bookList }" var="book">
			<tr style="border: 1px solid;">
				<td style="border: 1px solid;">${book.bookname }</td>
				<td style="border: 1px solid;">${book.comefrom }</td>
				<td style="border: 1px solid;">${book.author }</td>
				<td style="border: 1px solid;">${book.price }</td>
				<td style="border: 1px solid;"><a
					href="${pageContext.request.contextPath }/books/editBook.action?id=${book.id}">修改</a></td>
			</tr>
		</c:forEach>
	</table>
</form>
</body>
</html>