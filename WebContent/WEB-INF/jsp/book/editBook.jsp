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
<c:if test="${allErrors!=null }">
	<c:forEach items="${allErrors }"  var="error">
		${error.defaultMessage }
	</c:forEach>
</c:if>
<form action="${pageContext.request.contextPath }/books/editBookSubmit.action" method="post">
	<input type="hidden" name="id" value="${bookCustom.id }"/>
	<table style="border: 1px solid;">
		<tr style="border: 1px solid;">
			<td style="border: 1px solid;">书名</td>
			<td style="border: 1px solid;">出版社</td>
			<td style="border: 1px solid;">作者</td>
			<td style="border: 1px solid;">价格</td>
			<td style="border: 1px solid;">操作</td>
		</tr>
		<%-- <c:forEach items="${bCustom }" var="a"> --%>
		
			<tr style="border: 1px solid;">
				<td style="border: 1px solid;"><input name="bookname" value="${bookCustom.bookname }" /></td>
				<td style="border: 1px solid;"><input name="comefrom" value="${bookCustom.comefrom }" /></td>
				<td style="border: 1px solid;"><input name="author" value="${bookCustom.author }" /></td>
				<td style="border: 1px solid;"><input name="price" value="${bookCustom.price }" /></td>
				<td style="border: 1px solid;"><input type="submit" value="提交"/></td>
			</tr>
		<%-- </c:forEach> --%>
	</table>
</form>
</body>
</html>