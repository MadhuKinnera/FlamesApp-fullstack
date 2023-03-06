let displayDiv = document.getElementById("display");

displayDiv.style.visibility='hidden';

async function runFlames(event){
    event.preventDefault();
    console.log("Hello Madhu");
    let form = document.querySelector('form');
    let boyName = form.boyName.value;
    let girlName = form.girlName.value;
    let url = `http://localhost:8080/flames/${boyName}/${girlName}`;

   let res = await fetch(url);
   let data = await res.json();
   
    console.log(data);

    let boy = document.getElementById("boy");
    let girl = document.getElementById("girl");
    let relation = document.getElementById("relation");
    let time = document.getElementById("time");

    boy.innerText=data.boyName.toUpperCase();
    girl.innerText=data.girlName.toUpperCase();
    relation.innerText=data.relation.toUpperCase();
    time.innerText=data.time.substring(0,16);
    displayDiv.style.visibility='visible';

}