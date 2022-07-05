<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>${dto.idx}</td>
			<td>${dto.title}</td>
			<td>조회수: ${dto.viewCnt}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${dto.content}</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${dto.writer}</td>
		</tr>	
	</table>
</body>
</html>