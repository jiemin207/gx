$(function() {
	$("#testAjax").click(function() {
		$.ajax({
			type : "post",
			url : "ajaxTest",
			data : "age=2",
			success : function(result) {
				$("#myDiv").html('<h2>' + result.message + '</h2>');
			}

		});

	});
});
