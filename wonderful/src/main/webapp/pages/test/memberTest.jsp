<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.15/css/dataTables.bootstrap.min.css">
<!--jQuery-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!--jQuery UI-->
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.15/js/dataTables.bootstrap.min.js"></script>
    <script src="http://malsup.github.com/jquery.form.js"></script>
<script
	src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
<link
	href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css"
	rel="stylesheet">
<style type="text/css">
body {
	background-color: lightblue;
	font-family: 微軟正黑體;
	
}
.timeline {
	position: relative;
	padding: 4px 0 0 0;
	margin-top: 22px;
	list-style: none;
}
.timeline>li:nth-child(even) {
	position: relative;
	margin-bottom: 50px;
	height: 180px;
	right: -100px;
}
.timeline>li:nth-child(odd) {
	position: relative;
	margin-bottom: 50px;
	height: 180px;
	left: -100px;
}
.timeline>li:before, .timeline>li:after {
	content: " ";
	display: table;
}
.timeline>li:after {
	clear: both;
	min-height: 170px;
}
.timeline>li .timeline-panel {
	position: relative;
	float: left;
	width: 41%;
	padding: 0 20px 20px 30px;
	text-align: right;
}
.timeline>li .timeline-panel:before {
	right: auto;
	left: -15px;
	border-right-width: 15px;
	border-left-width: 0;
}
.timeline>li .timeline-panel:after {
	right: auto;
	left: -14px;
	border-right-width: 14px;
	border-left-width: 0;
}
.timeline>li .timeline-image {
	z-index: 100;
	padding: 40px 65px 35px 35px;
	line-height: 0;
	position: absolute;
	left: 50%;
	border: 7px solid #c3d7f7;
	border-radius: 100%;
	background-color: pink;
	color: white;
	box-shadow: 0 0 5px #c3d7f7;
	width: 150px;
	height: 150px;
	font-size: 46px;
	margin-left: -100px;
	transition: background 1s, transform 1s 1s ease-in;
	/*separate transition effect in one property*/
	cursor: pointer;
	position: absolute;
	left: 50%;
	border: 7px solid #c3d7f7;
	border-radius: 100%;
	background-color: pink;
	color: white;
	box-shadow: 0 0 5px #c3d7f7;
	width: 150px;
	height: 150px;
	font-size: 46px;
	margin-left: -100px;
	transition: background 1s, transform 1s 1s ease-in;
	margin-left: -100px;
}
.timeline>li .timeline-image a {
	color: white;
	text-decoration: none;
}
.timeline>li .timeline-image:HOVER {
	background: salmon;
	transform: rotate(360deg);
}
.timeline>li .timeline-image h4 {
	margin-top: 12px;
	font-size: 10px;
	line-height: 14px;
}
.timeline>li.timeline-inverted>.timeline-panel {
	float: right;
	padding: 0 30px 20px 20px;
	text-align: left;
}
.timeline>li.timeline-inverted>.timeline-panel:before {
	right: auto;
	left: -15px;
	border-right-width: 15px;
	border-left-width: 0;
}
.timeline>li.timeline-inverted>.timeline-panel:after {
	right: auto;
	left: -14px;
	border-right-width: 14px;
	border-left-width: 0;
}
.timeline>li:last-child {
	margin-bottom: 0;
}
.timeline .timeline-heading h4 {
	margin-top: 22px;
	margin-bottom: 4px;
	padding: 0;
	color: #b3b3b3;
}
.timeline .timeline-heading h4.subheading {
	margin: 0;
	padding: 0;
	text-transform: none;
	font-size: 18px;
	color: #333333;
}
.timeline .timeline-body>p, .timeline .timeline-body>ul {
	margin-bottom: 0;
	color: #808080;
}
/*Style for even div.line*/
.timeline>li:nth-child(odd) .line:before {
	content: "";
	position: absolute;
	top: 60px;
	bottom: 0;
	left: 680px;
	width: 4px;
	height: 300px;
	background-color: #c3d7f7;
	-ms-transform: rotate(-44deg); /* IE 9 */
	-webkit-transform: rotate(-44deg); /* Safari */
	transform: rotate(-44deg);
	box-shadow: 0 0 5px #c3d7f7;
}
/*Style for odd div.line*/
.timeline>li:nth-child(even) .line:before {
	content: "";
	position: absolute;
	top: 60px;
	bottom: 0;
	left: 430px;
	width: 4px;
	height: 300px;
	background-color: #c3d7f7;
	-ms-transform: rotate(44deg); /* IE 9 */
	-webkit-transform: rotate(44deg); /* Safari */
	transform: rotate(44deg);
	box-shadow: 0 0 5px #c3d7f7;
}
/* Medium Devices, .visible-md-* */
@media ( min-width : 992px) and (max-width: 1199px) {
	.timeline>li:nth-child(even) {
		margin-bottom: 0px;
		min-height: 0px;
		right: 0px;
	}
	.timeline>li:nth-child(odd) {
		margin-bottom: 0px;
		min-height: 0px;
		left: 0px;
	}
	.timeline>li:nth-child(even) .timeline-image {
		left: 0;
		margin-left: 0px;
	}
	.timeline>li:nth-child(odd) .timeline-image {
		left: 690px;
		margin-left: 0px;
	}
	.timeline>li:nth-child(even) .timeline-panel {
		width: 76%;
		padding: 0 0 20px 0px;
		text-align: left;
	}
	.timeline>li:nth-child(odd) .timeline-panel {
		width: 70%;
		padding: 0 0 20px 0px;
		text-align: right;
	}
	.timeline>li .line {
		display: none;
	}
}
/* Small Devices, Tablets */
@media ( min-width : 768px) and (max-width: 991px) {
	.timeline>li:nth-child(even) {
		margin-bottom: 0px;
		min-height: 0px;
		right: 0px;
	}
	.timeline>li:nth-child(odd) {
		margin-bottom: 0px;
		min-height: 0px;
		left: 0px;
	}
	.timeline>li:nth-child(even) .timeline-image {
		left: 0;
		margin-left: 0px;
	}
	.timeline>li:nth-child(odd) .timeline-image {
		left: 520px;
		margin-left: 0px;
	}
	.timeline>li:nth-child(even) .timeline-panel {
		width: 70%;
		padding: 0 0 20px 0px;
		text-align: left;
	}
	.timeline>li:nth-child(odd) .timeline-panel {
		width: 70%;
		padding: 0 0 20px 0px;
		text-align: right;
	}
	.timeline>li .line {
		display: none;
	}
}
/* Custom, iPhone Retina */
@media only screen and (max-width: 767px) {
	.timeline>li:nth-child(even) {
		margin-bottom: 0px;
		min-height: 0px;
		right: 0px;
	}
	.timeline>li:nth-child(odd) {
		margin-bottom: 0px;
		min-height: 0px;
		left: 0px;
	}
	.timeline>li .timeline-image {
		position: static;
		width: 150px;
		height: 150px;
		margin-bottom: 0px;
	}
	.timeline>li:nth-child(even) .timeline-image {
		left: 0;
		margin-left: 0;
	}
	.timeline>li:nth-child(odd) .timeline-image {
		float: right;
		left: 0px;
		margin-left: 0;
	}
	.timeline>li:nth-child(even) .timeline-panel {
		width: 100%;
		padding: 0 0 20px 14px;
	}
	.timeline>li:nth-child(odd) .timeline-panel {
		width: 100%;
		padding: 0 14px 20px 0px;
	}
	.timeline>li .line {
		display: none;
	}
}
.modal-dialog {
	width: 600px;
}
.modal-footer {
	height: 90px;
	margin: 0;
}
.modal-footer .btn {
	font-weight: bold;
}
.modal-footer .progress {
	display: none;
	height: 32px;
	margin: 0;
}
.input-group-addon {
	color: #fff;
	background: #3276B1;
}
.input-group-addon.glyphicon {
	font-size: 20px;
	background-color: #80beb0;
	/* 	font-family: 微軟正黑體; */
}
.form-control.btn {
	font-weight: 300;
	color: white;
	height: 50px;
	font-size: 18px;
	background-color: #80beb0;
}
.modal-title {
	font-weight: 500;
	color: #808080;
}
.progress-bar {
	background-color: #808080;
}
/* .dataTables_wrapper .dataTables_paginate .paginate_button { */
/*     background-color: #80beb0; */
/* } */
/* .dataTables_wrapper .dataTables_paginate .paginate_button:hover { */
/*     border: 0px; */
/* } */
.material-switch > input[type="checkbox"] {
    display: none;   
}
.material-switch > label {
    cursor: pointer;
    height: 0px;
    position: relative; 
    width: 40px;  
}
.material-switch > label::before {
    background: rgb(0, 0, 0);
    box-shadow: inset 0px 0px 10px rgba(0, 0, 0, 0.5);
    border-radius: 8px;
    content: '';
    height: 16px;
    margin-top: -8px;
    position:absolute;
    opacity: 0.3;
    transition: all 0.4s ease-in-out;
    width: 40px;
}
.material-switch > label::after {
    background: rgb(255, 255, 255);
    border-radius: 16px;
    box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.3);
    content: '';
    height: 24px;
    left: -4px;
    margin-top: -8px;
    position: absolute;
    top: -4px;
    transition: all 0.3s ease-in-out;
    width: 24px;
}
.material-switch > input[type="checkbox"]:checked + label::before {
    background: inherit;
    opacity: 0.5;
}
.material-switch > input[type="checkbox"]:checked + label::after {
    background: inherit;
    left: 20px;
}
</style>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						var trigger = $('.hamburger'), overlay = $('.overlay'), isClosed = false;
						trigger.click(function() {
							hamburger_cross();
						});
						function hamburger_cross() {
							if (isClosed == true) {
								overlay.hide();
								trigger.removeClass('is-open');
								trigger.addClass('is-closed');
								isClosed = false;
							} else {
								overlay.show();
								trigger.removeClass('is-closed');
								trigger.addClass('is-open');
								isClosed = true;
							}
						}
						$('[data-toggle="offcanvas"]').click(function() {
							$('#wrapper').toggleClass('toggled');
						});
					});
	$(document).ready(
			function() {
				$('.modal-footer button').click(
						function() {
							var button = $(this);
							if (button.attr("data-dismiss") != "modal") {
								var inputs = $('form input');
								var title = $('.modal-title');
								var progress = $('.progress');
								var progressBar = $('.progress-bar');
								// 												inputs.attr("disabled",
								// 														"disabled");
								button.hide();
								progress.show();
								progressBar.animate({
									width : "100%"
								}, 100);
								progress.delay(1000).fadeOut(600);
								button.text("關閉").removeClass("btn-primary")
										.addClass("btn-success").blur().delay(
												1600).fadeIn(
												function() {
													button.attr("data-dismiss",
															"modal");
												});
							}
						});
				$('#myInsert').on(
						'hidden.bs.modal',
						function(e) {
							// 									var inputs = $('#insertform input');
							var title = $('#NewModalTitle');
							var progressBar = $('#progress1');
							var button = $('#newbutton');
							// 									inputs.removeAttr("disabled");
							title.text("新增。愛柚人");
							progressBar.css({
								"width" : "0%"
							});
							button.removeClass("btn-success").addClass(
									"btn-primary").text("確定。新增").removeAttr(
									"data-dismiss");
						});
				$('#myQuery').on(
						'hidden.bs.modal',
						function(e) {
							// 									var inputs = $('#queryform input');
							var title = $('#QueryModalTitle');
							var progressBar = $('#progress2');
							var button = $('#querybutton');
							// 									inputs.removeAttr("disabled");
							title.text("查詢享。閱人");
							progressBar.css({
								"width" : "0%"
							});
							button.removeClass("btn-success").addClass(
									"btn-primary").text("享。詢人").removeAttr(
									"data-dismiss");
						});
				$('#myUpdate').on(
						'hidden.bs.modal',
						function(e) {
							// 									var inputs = $('#updateform input');
							var title = $('#UpdateModalTitle');
							var progressBar = $('#progress3');
							var button = $('#updatebutton');
							// 									inputs.removeAttr("disabled");
							title.text("更新享。閱人");
							progressBar.css({
								"width" : "0%"
							});
							button.removeClass("btn-success").addClass(
									"btn-primary").text("確定。修").removeAttr(
									"data-dismiss");
						});
			});
</script>
</head>
<body>


<div class="container"
		style="height: 460px; background: url('http://images.clipartpanda.com/clouds-background-png-CloudImage.png'); background-repeat: no-repeat">
		<div class="row">
			<div class="col-lg-12">
				<h3 class="text-center" style="color: #ff8c9b">Wonderful&nbsp;會員資料管理</h3>
				<ul class="timeline">
					<li>
						<button class="timeline-image" data-toggle="modal" data-target="#myInsert">新。</button>
						<div class="timeline-panel">
							<div class="timeline-heading">
								<h4>新增</h4>
								<h4 class="subheading">新增。愛柚人</h4>
							</div>
						</div>
						<div class="line"></div>
					</li>
					<li class="timeline-inverted">
						<button class="timeline-image" data-toggle="modal" data-target="#myQuery">詢。</button>
						<div class="timeline-panel">
							<div class="timeline-heading">
								<h4>查詢</h4>
								<h4 class="subheading">查詢。愛柚人</h4>
							</div>
						</div>
<!-- 						<div class="line"></div> -->
					</li>
<!-- 					<li> -->
<!-- 						<button class="timeline-image" data-toggle="modal" data-target="#myUpdate">修。</button> -->
<!-- 						<div class="timeline-panel"> -->
<!-- 							<div class="timeline-heading"> -->
<!-- 								<h4>更新</h4> -->
<!-- 								<h4 class="subheading">更新。愛柚人</h4> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</li> -->
				</ul>
			</div>
		</div>
	</div>



<!-- 以下區塊為新增彈跳區塊 -->
	<div class="modal fade" id="myInsert" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
					<h3 class="modal-title" id="NewModalTitle">新增。愛柚人</h3>
				</div>

				<div class="modal-body">
					<form id="insertform" enctype="multipart/form-data" role="form">
<!-- 						<div class="form-group"> -->
<!-- 							<div class="input-group"> -->
<!-- 								<input style='color:red' type="text" name="MemID" class="form-control" placeholder="請輸入會員編號">  -->
<!-- 								<label class="input-group-addon glyphicon glyphicon-user"></label> -->
<!-- 							</div> -->
<!-- 						</div> -->

						<div class="form-group">
							<div class="input-group">
								<input type="text" name="Email" class="form-control" placeholder="請輸入電子郵件"> 
								<label class="input-group-addon glyphicon glyphicon-envelope"></label>
							</div>
						</div>

						<div class="form-group">
							<div class="input-group">
								<input type="password" name="Pwd" class="form-control" placeholder="請輸入密碼"> 
								<label class="input-group-addon glyphicon glyphicon-lock"></label>
							</div>
						</div>

						<div class="form-group">
							<div class="input-group">
								<input type="text" name="Name" class="form-control" placeholder="請輸入姓名"> 
								<label class="input-group-addon glyphicon glyphicon-user"></label>
							</div>
						</div>

						<div class="form-group">
							<div class="input-group">
								<input type="text" name="Addr" class="form-control" placeholder="請輸入通訊地址"> 
								<label class="input-group-addon glyphicon glyphicon-align-justify"></label>
							</div>
						</div>

						<div class="form-group">
							<div class="input-group">
								<input type="text" name="Cell" class="form-control" placeholder="請輸入手機"> 
								<label class="input-group-addon glyphicon glyphicon-phone"></label>
							</div>
						</div>

						<div class="modal-footer">
							<button type="submit" id="newbutton" class="form-control btn">確定。新增</button>
						</div>
					</form>
				</div>
				<!--/.modal-body -->
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<script type="text/javascript">
	
		//Ajax Insert表單的選項
		$('#insertform').submit(
			function(event){
				event.preventDefault();
				var data = reassemble();		
				$.post('/wonderful/test/member.controller/Insert', data,
						function(data){
						console.log(data);
						$('#insertform').resetForm();
						$('#myInsert').modal('toggle');
						$('#insertSuccess').modal('toggle');
						return false;
				});
			}
		);
		
		//將空白的欄位剃除
		function reassemble(){
			var form = $('form');
			var data = {};
			var formData = form.serializeArray();
			$.each( formData
					, function(index, value){
				var dataName = formData[index].name;
				var dataValue = formData[index].value;
				if(dataValue !== ""){
					data[dataName] = dataValue;
				}
			})
			return data;
		};

// 		var options = {
// 			contentType : false,
// 			type : 'post',
// 			url : '/wonderful/test/member.controller/Insert',
// 			dataType : 'json',
// 			success : function(json) {
// 				$('#insertform').resetForm();
// 				$('#myInsert').modal('toggle');
// 				$('#insertSuccess').modal('toggle');
// 				console.log(json);
// 				return false;
// 			},
// 			error : function() {
// 				console.log('error happened');
// 				return false;
// 			}
// 		};
// 	    $('#insertform').ajaxForm(options);
	</script>
	
	<!--新會員確認畫面 -->
	<div class="modal fade" id="insertSuccess" tabindex="-1" role="dialog"	aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="padding-top:200px">
			<div class="modal-content">
				<div class="panel-login">
					<div class="panel-body">
						<div>
							<h3 class="modal-title">成功新增。愛柚人</h3>
							<div>
								<button id="insertSuccessBtn" class="btn" style="background-color:#80beb0 ; color: white">確定。</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$('#insertSuccessBtn').click(
			function(event) {
				event.preventDefault();
				$('#insertSuccess').modal('toggle');
			})
	</script>
	
	<!-- 以下區塊為查詢彈跳區塊 -->
	<div class="modal fade" id="myQuery" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
					<h4 class="modal-title" id="QueryModalTitle">查詢。愛柚人</h4>
				</div>
				<!-- /.modal-header -->

				<div class="modal-body">
					<form role="form" id="queryform">
						<div class="form-group">
							<div class="input-group">
								<input type="text" name="Email" class="form-control"	placeholder="請輸入會員帳號(E-mail)查詢"> 
								<label class="input-group-addon glyphicon glyphicon-search"></label>
							</div>
						</div>

						<div class="modal-footer">
							<button type="submit" id="querybutton" class="form-control btn btn-primary" name="memaction" value="Show">詢。Yes!</button>
						</div>
						<!-- /.modal-footer -->
					</form>
				</div>
				<!-- /.modal-body -->
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->

	<!-- 以下區塊為修改彈跳區塊 -->
	<div class="modal fade" id="myUpdate" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
					<h4 class="modal-title" id="UpdateModalTitle">修改。愛柚人</h4>
				</div>
				<!-- /.modal-header -->

				<div class="modal-body">
					<form id="updateform" enctype="multipart/form-data" role="form">
						<div class="form-group">
							<div class="input-group">
								<input type="text" id="updMemID" name="MemID" class="form-control" placeholder="請輸入會員編號"> 
								<label class="input-group-addon glyphicon glyphicon-user"></label>
							</div>
						</div>

						<div class="form-group">
							<div class="input-group">
								<input type="password" id="updPwd" name="Pwd" class="form-control" placeholder="請輸入密碼"> 
								<label class="input-group-addon glyphicon glyphicon-lock"></label>
							</div>
						</div>

						<div class="form-group">
							<div class="input-group">
								<input type="text" id="updName" name="Name" class="form-control" placeholder="請輸入姓名"> 
								<label class="input-group-addon glyphicon glyphicon-user"></label>
							</div>
						</div>

						<div class="form-group">
							<div class="input-group">
								<input type="text" id="updAddr" name="Addr" class="form-control" placeholder="請輸入通訊地址"> 
								<label class="input-group-addon glyphicon glyphicon-align-justify"></label>
							</div>
						</div>

						<div class="form-group">
							<div class="input-group">
								<input type="text" id="updCell" name="Cell" class="form-control" placeholder="請輸入手機"> 
								<label class="input-group-addon glyphicon glyphicon-phone"></label>
							</div>
						</div>
						
						<div class="form-group">
							<div class="input-group">
								<input type="text" id="updEmail" name="Email" class="form-control" placeholder="請輸入電子郵件"> 
								<label class="input-group-addon glyphicon glyphicon-envelope"></label>
							</div>
						</div>
						
						<div class="form-group">
							<div class="input-group">
								<input type="text" id="updRegDate" name="RegDate" class="form-control" placeholder="請輸入電子郵件"> 
								<label class="input-group-addon glyphicon glyphicon-calendar"></label>
							</div>
						</div>

						<div class="modal-footer">
							<button id="updatebutton" class="form-control btn btn-primary"	name="memaction" value="Update">確定。修</button>
						</div>
						<!-- /.modal-footer -->
					</form>
				</div>
				<!-- /.modal-body -->
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	
	<script type="text/javascript">
	
	//Ajax Update表單的選項
	$('#updateform').submit(
		function(event){
			event.preventDefault();
			var data = reassemble();		
			$.post('/wonderful/test/member.controller/Update', data,
					function(data){
					console.log(data);
					$('#updateform').resetForm();
					$('#myUpdate').modal('toggle');
					$('#updateSuccess').modal('toggle');
					return false;
			});
		}
	);
	
// 		var options = {
// 			contentType : false,
// 			type : 'post',
// 			dataType : 'json',
// 			success : function(json) {
// 				$('#updateform').resetForm();
// 				$('#myUpdate').modal('toggle');
// 				$('#updateSuccess').modal('toggle');
// 				console.log(json);
// 				return false;
// 			},
// 			error : function() {
// 				console.log('error happened');
// 				return false;
// 			}
// 		}

// 		$('#updateform').ajaxForm(options);
	</script>
	
	<!--已修改確認畫面 -->
	<div class="modal fade" id="updateSuccess" tabindex="-1" role="dialog"	aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="padding-top:200px">
			<div class="modal-content">
				<div class="panel-login">
					<div class="panel-body">
						<div>
							<h3 class="modal-title">成功修改。愛柚人</h3>
							<div>
								<button id="updateSuccessBtn" class="btn" style="background-color:#80beb0 ; color: white">確定。</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$('#updateSuccessBtn').click(
			function(event) {
				event.preventDefault();
				$('#updateSuccess').modal('toggle');
				location.reload();
			})
	</script>

	<!-- 顯示會員資料的跳視窗 -->
	<div class="modal fade" id="queryResult" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width:1350px">
			<div class="modal-content">
				<div class="modal-header">
					<button id="xxx" type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
					<h4 class="modal-title" id="UpdateModalTitle">愛柚人s</h4>
				</div>
				<!-- /.modal-header -->

				<div class="modal-body" style="max-height: 800px;overflow-y: auto">
					<form role="form" id="showform" method="POST" enctype="multipart/form-data">
						<table id="memTable">
							<thead>
								<tr>
									<th style="width:150px; padding:10px; text-align: center;">愛柚人。編號</th>
									<th style="width:150px; padding:10px">姓名</th>
									<th style="width:450px; padding:10px">住在</th>
									<th style="width:150px; padding:10px">手機</th>
									<th style="width:250px; padding:10px">帳號(E-mail)</th>
									<th style="width:150px; padding:10px">註冊日期</th>
									<th style="width:50px; padding:5px">修改</th>
								</tr>
							</thead>
							<tbody id = "showmem">	
							</tbody>
						</table>

						<div class="modal-footer">
							<button id="ShowClosebutton" class="form-control btn btn-primary" style="width: 200px" data-dismiss="modal" aria-hidden="true">關閉</button>
						</div>
						<!-- /.modal-footer -->
					</form>
				</div>
				<!-- /.modal-body -->
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->

	<script type="text/javascript">
	//將空白的欄位剃除
	function reassemble(){
		var form = $('form');
		var data = {};
		var formData = form.serializeArray();
		$.each( formData
				, function(index, value){
			var dataName = formData[index].name;
			var dataValue = formData[index].value;
			if(dataValue !== ""){
				data[dataName] = dataValue;
			}
		})
		return data;
	};
	
	function updateTransfer(email){
		$.ajax({
		    type: 'POST',
		    url: '/wonderful/test/member.controller/QueryRepost',
		    data: {
		        'email':email
		    },
		    success: function(json){
		        $('#updMemID').val(json[0].MemID).prop('readonly',true).css('background-color','LightGray');
		        $('#updName').val(json[0].Name);
		        $('#updPwd').val(json[0].Pwd);
		        $('#updAddr').val(json[0].Addr);
		        $('#updCell').val(json[0].Cell);
		        $('#updEmail').val(json[0].Email).prop('readonly',true).css('background-color','LightGray');
		        $('#updRegDate').val(json[0].RegDate).prop('readonly',true).css('background-color','LightGray');
		        $('#queryResult').modal('toggle');
		        $('#myUpdate').modal('toggle');
		    }
		});
	}
	
	$(function() {
		
			
			function destroyTable(){
				if($('#queryResult').modal('hide')){
					$('#memTable').DataTable().destroy();
				}
			}
			
			$('#ShowClosebutton, #xxx').click(
				function(event) {
					event.preventDefault();
					$('#showmem').text('');
					$('#queryResult').modal('toggle');
					destroyTable();
				}		
			)
			

					
			$('#querybutton').click(
					function(event) {
						event.preventDefault();
						
						var data = $('#queryform').serialize();
						$.post('/wonderful/test/member.controller/Query', data,
								function(data) {
									var tb =  $('#showmem');
									tb.text('');			
									$.each(data, function(i, value) {
										console.log(value);
										var tdidmem = 'cellmem' + i;
										var cell1 = $('<td></td>').attr('id',tdidmem).text(value.MemID).attr('padding','10px').attr('margin','10px').css('text-align','center');
										var cell2 = $('<td></td>').text(value.Name).attr('padding','10px').attr('margin','10px');
										var cell3 = $('<td></td>').text(value.Addr).attr('padding','10px').attr('width','500px').attr('margin','10px');
										var cell4 = $('<td></td>').text(value.Cell).attr('padding','10px').attr('margin','10px');
										var cell5 = $('<td></td>').text(value.Email).attr('padding','10px').attr('margin','10px');
										var cell6 = $('<td></td>').text(value.RegDate).attr('padding','10px').attr('margin','10px');
										var moveSpan= $('<span/>').addClass('glyphicon').addClass('glyphicon-edit');
										var moveBlock = $('<a/>').attr('href', 'javascript:void(0)').attr('onclick','updateTransfer("' + value.Email + '")').append(moveSpan);
										var idvar = 'cell' + i;
										var cell7 = $('<td></td>').css('text-align', 'center').attr('id', idvar).append(moveBlock);
										var row = $('<tr></tr>').append([cell1, cell2, cell3, cell4, cell5, cell6, cell7]).attr('height','90px').css('margin','10px').css('border-bottom','solid 1px #D3D3D3');
										if(i%2==0){
											row.css('background-color','#d1ffe5')
										}
										tb.append(row);
									});
									
									$('#memTable').DataTable({
										"paging":true,
										"searching":false
									});
									$('#myQuery').modal('hide');
									$('#queryResult').modal('toggle');
								})

					})

		})
	</script>
	

</body>
</html>