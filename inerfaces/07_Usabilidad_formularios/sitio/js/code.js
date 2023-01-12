let datos = new URLSearchParams(window.location.search);
document.info.nombre.value = datos.get("nombre");
document.info.pass.value = datos.get("pass");
console.log(datos.get("nombre"));

document.info.onsubmit  = function(){
    if(document.getElementById("salida")){
        document.getElementById("salida").remove;
    }
    let ExpRegNombre="^[A-ZÑÇa-zñçáéíóúÁÉÍÓÚ']+$"; 
    let ExpRegPass="^[A-ZÑÇa-zñçáéíóúÁÉÍÓÚ':$¡!¿?@º#)]+$"; 
    let nombre = document.info.nombre.value.match(ExpRegNombre) ? true:false;
    let pass = document.info.pass.value.match(ExpRegPass) ? true:false;
    
    if (nombre == false || pass == false){
        
        let ul = document.createElement("ul");
        let att = document.createAttribute("id");
        att.value = "salida";
        ul.setAttributeNode(att);
        
        /*ul.innerHTML = "<li>Cuidado. Hay campos erróneos</li>";*/
        document.info.appendChild(ul);
        if(nombre == false){
            let liErrNombre = document.createElement("li");
            liErrNombre.innerHTML = "El nombre que introdujo no está admitido, pruebe con otro";
            ul.appendChild(liErrNombre);
            document.info.nombre.style.border = "2px solid red"
        }
        if(pass == false){
            let liErrPass = document.createElement("li");
            liErrPass.innerHTML = "La contraseña que introdujo no está admitida, pruebe con otra";
            ul.appendChild(liErrPass);
            document.info.pass.style.border = "2px solid red"
        }
        /*
        document.getElementById("salida").innerHTML = 
        "<strong>Cuidado. Hay campos erróneos</strong>";
        */
        return false
    }

}
