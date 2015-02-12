
function healthCheck() {
	$.ajax(
			{
				type : "GET",
				url  : "/cs480/ping",
				data : {
				},
				success : function(result) {
					$('#status').text(result);
				},
				error: function (jqXHR, exception) {
					$('#status').text("Failed to get the status");
				}
			});
}

function deleteUser(userId) {
	$.ajax(
			{
				type : "DELETE",
				url  : "/cs480/user/" + userId,
				data : {
				},
				success : function(result) {
					location.reload();
				},
				error: function (jqXHR, exception) {
					alert("Failed to delete the photo.");
				}
			});
}

function submitcode()
{	
	var userId =$('#input_userId').val();
	var problemId =$('#input_problemId').val();
	var userfile = $('#input_file').val();
	if(userId)
		{
			$.ajax({
						type: "POST",
						url : "/cs480/codeSubmit/" + userId,
						data: { 
								"User": userId,
								"ProblemId": problemId,
								"file" : file
							  },
						success : function(result)
						{
							location.reload();
						},
						error: function (jqXHR, exception) {
							alert("Failed to add the file. Please resubmit!.");
						}
					});
		} 
		else {
		alert("Invalid userId");
		}
	}


}
function addUser() {

	var userId = $('#input_userId').val();
	var problemId = $('#input_problemId').val();
	var userfile = $('#input_file').val();
	
	if (userId) {
		$.ajax(
				{
					type : "POST",
					url  : "/cs480/codeSubmit/",
					data : {
								"User": userId,
								"ProblemId": problemId,
								"file": userfile
								
					},
					success : function(result) {
						location.reload();
					},
					error: function (jqXHR, exception) {
						alert("Failed to add the user. Please check the inputs.");
					}
				});
	} else {
		alert("Invalid user Id");
	}
}

function getUser(userId) {
	var userId = $('#query_userId').val();
	if (userId) {
		$.ajax(
				{
					type : "GET",
					url  : "/cs480/user/",
					data : {
					},
					success : function(result) {
						$('#result_userId').text(result.userId);
						$('#result_problemId').text(result.problemId);
						$('#result_file').text(result.file);
					},
					error: function (jqXHR, exception) {
						alert("Failed to get the user.");
					}
				});
	} else {
		alert("Invalid user Id");
	}
}