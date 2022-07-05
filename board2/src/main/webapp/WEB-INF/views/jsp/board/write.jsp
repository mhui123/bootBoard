<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		let update = "${update}";
		let insert = "${insert}";
	</script>
	<table>
		<tbody>
			<tr>
				<td>
					<p>제목</p>
					<input type="text" id="titleInput"/>
				</td>
			</tr>
			<tr>
				<td>
					<p>내용</p>
					<input type="text" id="titleInput"/>
				</td>
			</tr>
		</tbody>
	</table>
	<button id="confirmBtn">확인</button>
	<button id="cancelBtn">취소</button>
</body>
</html>