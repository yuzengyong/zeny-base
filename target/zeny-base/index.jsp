<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<script type="text/javascript" src="jquery-1.9.1.js"></script>
<body>
<h2>Hello World!</h2>
userId:<input type="text" name="userId" id="userId"/><br>
userName:<input type="text" name="userName" id="userName"/><br>
DATA:<textarea rows="10" cols="100" id="data"></textarea><br>
<button onclick="submit()">提交</button>
<div>-----------------------------------------------------<br>
response:<textarea rows="10" cols="100" id="response"></textarea>
</div>
</body>
<script type="text/javascript">

function submit(){
	//var data = $('#data').val();
	//var url = $('#url').val();
	$.ajax({ 
		url: '/onLogin2', 
		dataType:"json",  
		type:'POST',
		contentType:'application/json',
		data:JSON.stringify({
			id:$('#userId').val(),
			name:$('#userName').val()
		}), 
		success: function(rel){
       		$('#response').val(rel);
      }
	});
}

</script>
</html>
