$(document).ready(function(){
    var counter = 2;
    $("#addButton").click(function () {
	if(counter>10){
            alert("Only 10 questions allowed in one survey");
            return false;
	}  
 	var newTextBoxDiv = $(document.createElement('div'))
	     .attr("id", 'TextBoxDiv' + counter);

newTextBoxDiv.after().html('<label>Question #'+ counter + ' : </label>' + 
	      '<textarea name="comments" cols="29" rows="5"> </textarea>' +'<br><br>'+ 
'Answer #1 :&nbsp;&nbsp; <input type="textbox" id="textbox1" size="50" >' + '<br><br>'+
'Answer #2 :&nbsp;&nbsp; <input type="textbox" id="textbox2" size="50" >'+ '<br><br>'+
'Answer #3 :&nbsp;&nbsp; <input type="textbox" id="textbox3" size="50" >'+ '<br><br>'+
'Answer #4 :&nbsp;&nbsp; <input type="textbox" id="textbox4" size="50" >');


	newTextBoxDiv.appendTo("#TextBoxesGroup");

 	counter++;

     });

     $("#removeButton").click(function () {
	if(counter==1){
          alert("No question to remove");
          return false;
       }   
	counter--;
         $("#TextBoxDiv" + counter).remove();
      });

    	  alert(msg);
       });
