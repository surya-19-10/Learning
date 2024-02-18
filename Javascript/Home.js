function change() {
    document.getElementById('intro').innerHTML = 'Go ahead keep Learning!'
}

function displayfruits() {
    const fruits = ['orange','watermelon','apple']
    var text = "<ul>";
    for(let i=0; i<fruits.length; i++) {
        text+="<li>"+fruits[i]+"</li>";
    } 
    text+="</ul>";
    document.getElementById('fruits').innerHTML = text;
}

function displayNumbers() {
    const numbers = new Set([1,2,3,4])
    let text = "<ul>";
    for(let x of numbers) {
        text += "<li>"+x+"</li>";
    }
    text+="</ul>";
    document.getElementById("numbers").innerHTML = text;
}

function json() {
    let text = "{\"name\":\"Surya\",\"age\":\"23\"}";
    const obj = JSON.parse(text)
    document.getElementById("numbers").innerHTML = obj.name;
    document.getElementById("fruits").innerHTML = obj.age;
}