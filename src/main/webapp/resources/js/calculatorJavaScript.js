function getDataOfCalculator() {
	
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/OnlineCalculatorSpringRestful/calculator/ajaxJquery?exp=2*3",
		contentType:"application/json; charset=utf-8",
		data: "" ,
		success: function(response){
			var myJSON = JSON.stringify(response); 
			console.log(myJSON);
			
                        var obj = JSON.parse(myJSON);                  
  $('#result1').html("expString:- " + obj.expString +"</br>expMessage:- " + obj.expMessage  + "</br>result:- " + obj.result);
		},
		error:function(){
			console.log("data");
                	 alert('Error while request..');
		}
	
			
		 });
}