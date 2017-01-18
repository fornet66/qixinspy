var opts = {
  lines: 10 // The number of lines to draw
, length: 20 // The length of each line
, width: 8 // The line thickness
, radius: 20 // The radius of the inner circle
, scale: 1 // Scales overall size of the spinner
, corners: 1 // Corner roundness (0..1)
, color: '#000' // #rgb or #rrggbb or array of colors
, opacity: 0.25 // Opacity of the lines
, rotate: 40 // The rotation offset
, direction: 1 // 1: clockwise, -1: counterclockwise
, speed: 1 // Rounds per second
, trail: 60 // Afterglow percentage
, fps: 20 // Frames per second when using setTimeout() as a fallback for CSS
, zIndex: 2e9 // The z-index (defaults to 2000000000)
, className: 'spinner' // The CSS class to assign to the spinner
, top: '49%' // Top position relative to parent
, left: '50%' // Left position relative to parent
, shadow: false // Whether to render a shadow
, hwaccel: false // Whether to use hardware acceleration
, position: 'absolute' // Element positioning
};
var spinner = new Spinner(opts);
var result;
$(document).ready(function() {
	$("#go").click(function() {
		var cookies = $('#cookies').val();
		var company = $('#company').val();
		if (cookies === '') {
			$.notify("please input cookies", "error");
			return;
		}
		if (company === '') {
			$.notify("please input company", "error");
			return;
		}
		spy(cookies, company);
	});
});

function getBasePath() {
	var location = (window.location + '').split('/');
	var basePath = location[0] + '//' + location[2] + '/' + location[3];
	return basePath;
}

function spy(cookies, company) {
	var url = getBasePath() + "/spy.do/" + company;
	$.ajax({
		url : url,
		type : "POST",
		dataType : "json",
		contentType : "application/json",
		data : cookies,
		success : function(data) {
			$('#resultModal').modal('show');
			result = JSON.stringify(data);
			$('#resultModal').find('.modal-body textarea').readOnly = true;
		},
		error : function() {
			$.notify("spy error", "error");
		}
	});
}

function showResult() {
	$('#resultModal').find('.modal-body textarea').val('aaabbbcccddd');
	$('#resultModal').find('.modal-body textarea').readOnly = true;
	$('#resultModal').modal('show');
}