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
					<p>����</p>
					<input type="text" id="titleInput"/>
				</td>
			</tr>
			<tr>
				<td>
					<p>����</p>
					<input type="text" id="titleInput"/>
				</td>
			</tr>
		</tbody>
	</table>
	<button id="confirmBtn">Ȯ��</button>
	<button id="cancelBtn">���</button>
</body>
</html>