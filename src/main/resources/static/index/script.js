var containerTarefa = document.getElementById("containerTarefa")
var inputTarefa = document.getElementById("tarefa")
var alertaAviso = document.getElementById("alerta")

function setCookie(nome, valor, dias) {
    let expires = "";
    if (dias) {
        let date = new Date();
        date.setTime(date.getTime() + (dias * 24 * 60 * 60 * 1000));
        expires = "; expires=" + date.toUTCString();
    }
    document.cookie = nome + "=" + (valor || "") + expires + "; path=/; secure";
}

function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1);
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

function getTarefa(){
    for(var i= 1; i < document.cookie.length; i++) {
        var span = document.createElement("span")
        var cookie = getCookie("task"+i)
        span.textContent = cookie
        containerTarefa.appendChild(span)
        if(cookie == ""){
            return
        }
    }
}


function createTarefa(){
    if(inputTarefa.value == ""){
        alertaAviso.textContent = "Digite alguma tarefa!!"
        alertaAviso.style.backgroundColor = "red"
    }else{
        var span = document.createElement("span")
        var num = containerTarefa.children.length + 1
        setCookie("task"+num, inputTarefa.value, 30)
        span.textContent = inputTarefa.value
        containerTarefa.appendChild(span)
        alertaAviso.textContent = "Tarefa adicionada com sucesso!!"
        alertaAviso.style.backgroundColor = "green"
    }
}

window.onload = function(){
    for(var i= 1; i <= document.cookie.length; i++) {
        var span = document.createElement("span")
        var cookie = getCookie("task"+i)
        span.textContent = cookie
        containerTarefa.appendChild(span)
        if(cookie == ""){
            containerTarefa.querySelector("span:last-child").remove()
            return
        }
    }
}

function confirmTask(){
    createTarefa()
}
