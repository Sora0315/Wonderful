<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!--jQuery-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!--jQuery UI-->
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>
<style type="text/css">
body {
	font-family: 微軟正黑體;
}
</style>
</head>
<body>
	<form id="insertform" method="post"
		action="<c:url value='/test/member.controller/Insert'/>" method='post'>
		<label>id</label>
		<input type='text' placeholder='輸入id' name='MemID'>
		<label>Name</label>
		<input type='text' placeholder='輸入Name' name='Name'>
		<label>Pwd</label>
		<input type='text' placeholder='輸入Pwd' name='Pwd'>
		<label>Addr</label>
		<input type='text' placeholder='輸入Addr' name='Addr'>
		<label>Cell</label>
		<input type='text' placeholder='輸入Cell' name='Cell'>
		<label>E-mail</label>
		<input type='text' placeholder='輸入E-mail' name='Email'>
		<button type="submit" id='newbutton' value='Insert'>送出</button>

	</form>

	<script type="text/javascript">
	
	$('#insertform').submit(
			function(event){
				event.preventDefault();
			    var _form = $(this);
			    var data = {};
			    var formData = _form.serializeArray();
			    $.each(formData, function (index, value) {
			        var data_name = formData[index].name;
			        var data_value = formData[index].value;
			        if (data_value !== "") {
			            data[data_name] = data_value;
			        }
				})
				
			    $.post('/wonderful/test/member.controller/Insert2', data,
						function(data){
						console.log(data);}
			    );
			});
	
	
	
	
// 	$(function(){
// 		$("form").submit(
// 				function(){
// 			        $(this).children(':input[value=""]').prop('disabled', true);
// 			        return true; // ensure form still submits
// 			    });
// 	});
	
	
// 	$('#newbutton').click(
// 			function(event){
// 				event.preventDefault();
				
// 				$(this).children(':input[value=""]').prop('disabled', true);								
				
// 				var data = $('#insertform').serialize();
				

				
// 				$.post('/wonderful/test/member.controller/Insert2', data,
// 					function(data){
// 					console.log(data);
// 				});
// 		});
	
// var options = {
// 			contentType: "application/json; charset=utf-8",
// 			type:'post',
// 			dataType : 'json',
// 			success : function(json) {
// 				$('#insertform').resetForm();
// 				console.log(json);
// 				return false;
// 			},
// 			error : function() {
// 				console.log('error happened');
// 				return false;
// 			}
// 		}

// $('#insertform').ajaxForm(options);

</script>


</body>
</html>