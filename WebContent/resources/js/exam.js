function go(url)
{
	window.location = url;
}

function newExam()
{
	window.location = "saveExam.do";
}
function newQuestion()
{
	window.location = "saveQuestion.do";
}
function showQuestion(){
	window.location="showQuetions.do";
}
function executeDelete(url)
{
	var isOK = confirm("Are you sure to delete?");
	if(isOK)
	{
		go(url);
	}
}

function addQuestion() {
    //Create an input type dynamically.
    var element = document.createElement("input");
    //Assign different attributes to the element.
    element.setAttribute("id", "classe");
    element.setAttribute("type", "text");
    document.body.appendChild(element);
}


