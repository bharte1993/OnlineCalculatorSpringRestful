 var decimal=false;
 var lastOperationCall=false;
 function getDataOfCalculator() {
		
		$.ajax({
			type: "POST",
			url: "http://localhost:8080/OnlineCalculatorSpringRestful/calculator/onlinecalculator",
			contentType:"application/json; charset=utf-8",
			data: JSON.stringify({"expString":$("#display").val()}),
			success: function(response){
			var myJSON = JSON.stringify(response); 
			console.log(myJSON);
			var obj = JSON.parse(myJSON);                  
	        $('#result1').html("expString:- " + obj.expString +"</br>expMessage:- " + obj.expMessage  + "</br>result:- " + obj.result.Answer+"</br>Error:- " + obj.result.Error);
	        $('#display').val(obj.result.Answer);
		},
			error:function(){
				console.log("data");
	                	 alert('Error while request..');
			}
		});
	}
 
 function clearDisplay()
{
   document.getElementById("display").value ="";
   decimal=false;
   lastOperationCall=false;
   lastOperation=" ";
}


function deleteLastDigit(){
   
   if(document.getElementById("display").value.includes("Syntex Error")){
       document.getElementById("display").value ="";
   }
      
   document.getElementById("display").value=document.getElementById("display").value.substr(0,document.getElementById("display").value.length-1);

}


function numInput(val)
{
   if(document.getElementById("display").value.includes("Syntex Error")){
         return false;
   }
     document.getElementById("display").value += val;
}


function insertDecimal(dec) {
 if(document.getElementById("display").value.includes("Syntex Error")){
         return false;
   }
   if (decimal===true) {
           return;
        }
      document.getElementById("display").value += dec;
      decimal=true;
     }


function setOperator(op){
 if(document.getElementById("display").value.includes("Syntex Error")){
         return false;
   }
 lastOperationCall=false;
   var display = document.getElementById("display");
   l=display.value.charAt(display.value.length-1);
   const set = new Set(["+", ".", "-", "*", "/"]);
    if(set.has(l)){
          return;
     }
  display.value += op;
      decimal=false;


    }

function keydown(e){
var key=(e.which) ? (e.which) : (e.keyCode) || (e.charCode);
console.log(String.fromCharCode(key));
if(key===37||key===39){
 return true;
}
if(key===13){
	getDataOfCalculator();
}
if(key>95&&key<106){
 return true;
}
if(String.fromCharCode(key)==='n'||String.fromCharCode(key)==='k'||String.fromCharCode(key)==='m'||String.fromCharCode(key)==='j'||String.fromCharCode(key)==='o'){

if(String.fromCharCode(key)==='n'){
   insertDecimal('.');
  }
if(String.fromCharCode(key)==='m'){
   setOperator('-');
  }
if(String.fromCharCode(key)==='o'){
   setOperator('/');
  }
if(String.fromCharCode(key)==='j'){
   setOperator('*');
  }
if(String.fromCharCode(key)==='k'){
   setOperator('+');
  }
}
if(key>31&&(key<48||key>57)){
  return false;
 }

}