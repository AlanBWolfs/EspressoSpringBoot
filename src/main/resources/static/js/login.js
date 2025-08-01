document.addEventListener("DOMContentLoaded", function () {
  const form = document.getElementById("login-form");
  const emailInput = document.getElementById("email");
  const passwordInput = document.getElementById("password");
  const loginError = document.getElementById("loginError");

  form.addEventListener("submit", async function (event) {
    event.preventDefault();

    // Limpieza visual previa
    emailInput.classList.remove("is-invalid");
    passwordInput.classList.remove("is-invalid");
    loginError.style.display = "none";
    loginError.textContent = "";

    let valid = true;

    // Validación de campos vacíos
    if (!emailInput.value) {
      emailInput.classList.add("is-invalid");
      valid = false;
    }
    if (!passwordInput.value) {
      passwordInput.classList.add("is-invalid");
      valid = false;
    }
    if (!valid) {
      loginError.textContent = "Por favor, completa todos los campos.";
      loginError.style.display = "block";
      return;
    }

    try {
      // 🔗 Llamada al backend Spring Boot
      const response = await fetch("http://localhost:8080/api/usuarios/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          correoElectronico: emailInput.value,
          contrasena: passwordInput.value,
        }),
      });

      if (response.ok) {
        const usuario = await response.json();

        // Guardar datos en localStorage (para mantener sesión)
        localStorage.setItem("clienteLogueado", "true");
        localStorage.setItem("clienteNombre", usuario.nombre || "Usuario");
        localStorage.setItem("clienteCorreo", usuario.correoElectronico);

        // Separación de roles (admin / cliente)
        const correoAdmin = "atencion.cafeespresso@gmail.com";
        const rolAsignado =
          usuario.correoElectronico === correoAdmin ? "admin" : "cliente";
        localStorage.setItem("rolUsuario", rolAsignado);

        alert("¡Inicio de sesión exitoso!");
        window.location.href = "/index.html"; // redirigir a home
      } else {
        const errorMsg = await response.text();
        loginError.textContent = errorMsg || "Correo o contraseña incorrectos.";
        loginError.style.display = "block";
        emailInput.classList.add("is-invalid");
        passwordInput.classList.add("is-invalid");
      }
    } catch (err) {
      loginError.textContent = "Error de conexión con el servidor.";
      loginError.style.display = "block";
    }
  });
});
