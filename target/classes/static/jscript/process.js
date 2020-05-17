var name;
var score=0;

function passvalue()
{ 
    
    name=document.getElementById("name").value;
    
}
function action()
{
    
        document.getElementById("myText").innerHTML = name;
        document.getElementById("result").innerHTML=score;
}
function gameq() {
    if (document.getElementById("kaulder").checked)

    {
        score += 100;
        
    }
}


