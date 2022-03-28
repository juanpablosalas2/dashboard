$(document).ready(function() {
   // on ready
});


async function registrarUsuario() {
  let datos = {};
  datos.name = document.getElementById('txtNombre').value;
  datos.lastName = document.getElementById('txtApellido').value;
  datos.email = document.getElementById('txtEmail').value;
  datos.phone = document.getElementById('txttel').value;
  datos.pass = document.getElementById('txtPassword').value;

  let repetirPassword = document.getElementById('txtRepetirPassword').value;

  if (repetirPassword != datos.pass) {
    alert('La contraseña que escribiste es diferente.');
    return;
  }

  const request = await fetch('api/usuarios', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
  alert("La cuenta fue creada con exito!");
  window.location.href = 'login.html'

}
