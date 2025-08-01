document.addEventListener("DOMContentLoaded", () => {
  const form = document.getElementById("registerForm");
  const firstNameInput = document.getElementById("firstName");
  const lastNameInput = document.getElementById("lastName");
  const emailInput = document.getElementById("email");
  const passwordInput = document.getElementById("password");
  const confirmPasswordInput = document.getElementById("confirmPassword");
  const confirmFeedback = document.getElementById("confirmPasswordFeedback");

  form.addEventListener("submit", async function (event) {
    event.preventDefault();

    let valid = true;

    // Limpiar estilos anteriores
    [firstNameInput, lastNameInput, emailInput, passwordInput, confirmPasswordInput].forEach(input => {
      input.classList.remove("is-invalid");
    });
    confirmFeedback.textContent = "";

    // Validar campos vacíos
    if (!firstNameInput.value.trim()) {
      firstNameInput.classList.add("is-invalid");
      valid = false;
    }
    if (!lastNameInput.value.trim()) {
      lastNameInput.classList.add("is-invalid");
      valid = false;
    }
    if (!emailInput.value.trim()) {
      emailInput.classList.add("is-invalid");
      valid = false;
    }

    const passwordValue = passwordInput.value.trim();
    const confirmValue = confirmPasswordInput.value.trim();

    // Validar contraseña: mínimo 6 caracteres, una mayúscula y un número
    const regexPassword = /^(?=.*[A-Z])(?=.*\d).{6,}$/;
    if (!regexPassword.test(passwordValue)) {
      passwordInput.classList.add("is-invalid");
      passwordInput.nextElementSibling.textContent =
        "La contraseña debe tener al menos 6 caracteres, una mayúscula y un número.";
      valid = false;
    }

    // Validar coincidencia de contraseñas
    if (passwordValue !== confirmValue) {
      confirmPasswordInput.classList.add("is-invalid");
      confirmFeedback.textContent = "Las contraseñas no coinciden.";
      valid = false;
    }

    if (!valid) return;

    // Preparar objeto para el backend
    const nombreCompleto = `${firstNameInput.value.trim()} ${lastNameInput.value.trim()}`;
    const usuarioDTO = {
      nombre: nombreCompleto,
      correoElectronico: emailInput.value.trim(),
      contrasena: passwordValue
    };

    try {
      // 🔗 Llamada al backend
      const response = await fetch("http://localhost:8080/api/usuarios/registro", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(usuarioDTO),
      });

      if (response.ok) {
        alert("✅ Registro exitoso. ¡Ya puedes iniciar sesión!");
        window.location.href = "/pages/login.html";
      } else if (response.status === 409) {
        // Conflicto: correo ya registrado
        emailInput.classList.add("is-invalid");
        emailInput.nextElementSibling.textContent = "El correo ya está registrado.";
      } else {
        const errorMsg = await response.text();
        alert(" Error en el registro: " + errorMsg);
      }
    } catch (error) {
      alert("Error de conexión con el servidor.");
    }
  });
});
