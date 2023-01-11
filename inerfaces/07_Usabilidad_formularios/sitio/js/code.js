let datos = new URLSearchParams(window.location.search);
document.info.nombre.value = datos.get("nombre");
document.info.pass.value = datos.get("pass");
console.log(datos.get("nombre"));

