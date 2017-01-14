<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Qixin Spy Tool</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/spy.css">
<script src="js/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="js/notify.min.js"></script>
<script src="js/spin.min.js"></script>
<script src="js/spy.js"></script>
</head>
<body>
	<div class="container" id="how" style="margin-top: 80px">
		<div class="row" style="margin-bottom: 50px">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 text-center">
				<h1>Qixin Spy Tool</h1>
			</div>
		</div>
		<div id="loading"></div>
		<div class="row mt text-center" style="margin-bottom: 20px">
			<div class="col-sm-4 click" data-toggle="modal"
				data-target="#cookiesModal">
				<img class="grow" src="img/airlift-store.png" width="240px" alt="">
				<h3 style="font-weight: bold;">1. Set cookies</h3>
			</div>
			<div class="col-sm-4 click" data-toggle="modal"
				data-target="#companyModal">
				<img class="grow" src="img/airlift-sale.png" width="240px" alt="">
				<h3 style="font-weight: bold;">2. Set company</h3>
			</div>
			<div class="col-sm-4 click" id="go">
				<img class="grow" src="img/airlift-ship.png" width="240px" alt="">
				<h3 style="font-weight: bold;">3. Let's go</h3>
			</div>
		</div>

		<div class="modal fade" id="cookiesModal" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span>×</span>
						</button>
						<h4 class="modal-title">Cookies</h4>
					</div>
					<div class="modal-body">
						<p align="center">
							<textarea class="form-control spyinput" id="cookies" rows="10"></textarea>
						</p>
					</div>
					<div class="modal-footer">
						<p align="center">
							<button type="button" class="btn btn-danger" data-dismiss="modal">Submit</button>
						</p>
					</div>
				</div>
			</div>
		</div>
		<div class="modal fade" id="companyModal" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span>×</span>
						</button>
						<h4 class="modal-title">Company Name</h4>
					</div>
					<div class="modal-body">
						<p align="center">
							<input class="form-control input-lg spyinput" id="company"
								placeholder="Enter an company name" name="company">
						</p>
					</div>
					<div class="modal-footer">
						<p align="center">
							<button type="button" class="btn btn-danger" data-dismiss="modal">Submit</button>
						</p>
					</div>
				</div>
			</div>
		</div>
</body>
</html>