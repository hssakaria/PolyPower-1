
<html>
<head>

<style>
	#header
	{
		background-color:black;
		color:red;
		text-align:center;
		padding:5px;
	}
	#footer
	{
		background-color:black;
		color:red;
		text-align:center;
		padding:5px;
	}
	
	table
	{		 
		 align="center";
		 border: 1px solid black; 
	}	
	th
	{
		padding: 5px;
    	text-align: left;
    	color: white;
       	border: 1px solid black;
       	background-color: DimGray;       				 
	}
	td
	{
		padding: 5px;
    	text-align: left;
       	border: 1px solid black;	
       	color: DimGray;	
    }

    <title> <h2><> CSS Code Submission </title>
    
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>    
    <script src="/js/home-control.js"></script>
	
	
</style>
</head>

<body>    
    <div id="header">
    	<h2>CSS Code Submission form! </h2>              
    </div>

    <br><br><br><br><br><br><br><br>
    
	<table 	 width="100%">
		<tr>
			<th> Week </th>
			<th> UserID </th>
			<th> ProbemID </th>
			<th> Description </th>
			<th> File </th>
			<th> Status </th>
			<th> Date </th>
			<th> Score </th>
		</tr>
		
		<tr>
			<#list users as user>
				<tr>
					<td>${user.userId}</td>
					<td>${user.problemId}</td>
					<td><a href = "http://localhost:8080/user/${user.userId}/download ">${user.file}</td> 
									
				</tr>		
			</#list>
		</tr>
		
		
	</table>
		
	
<br><br>
	<table width="100">
	
		<form method="POST" enctype="multipart/form-data" action="/cs480/codeSubmit" onSubmit="confirmSubmission()"> 
			<tr>
				<td>UserID: </td>
				<td> <input type="text" name="userId" autofocus> </td>	
			</tr>
			<tr>
				<td>ProblemID: </td>
				<td> <input type="text" name="problemId"> </td>				
			</tr>
			
			<tr>
				<td>Please specify a file			
		    		<input type="file" name="file" id="input_file" size="40">		   	   		
		    	</td>
		    	<td><input style="background-color:lightgreen; width:80px; height:30px;font-size:17px;"
		    		 type="submit" onClick="submitcode()" value="Upload"></td>
		    </tr>
   		</form>
	</table>
     
<script>

	function confirmSubmission(){
	 alert("You successfully uploaded!");
	}
	
	function reload(){
	 	location.reload();
	}
</script>
<br>
    <div id="footer">
    	Copypright © PolyPower	
    </div>	   
</body>

</html>