document.addEventListener("DOMContentLoaded", function () {
  const togglePassword = document.getElementById("togglePassword");
  const passwordInput = document.getElementById("contrasena");
  const form = document.getElementById("registerForm");
  const mensaje = document.getElementById("mensaje");

  // --- Mostrar/ocultar contraseña ---
  if (togglePassword && passwordInput) {
    togglePassword.addEventListener("click", function () {
      passwordInput.type = passwordInput.type === "password" ? "text" : "password";
    });

    // Accesibilidad: Enter o Espacio
    togglePassword.addEventListener("keydown", (e) => {
      if (e.key === "Enter" || e.key === " ") {
        e.preventDefault();
        passwordInput.type = passwordInput.type === "password" ? "text" : "password";
      }
    });
  }

  // --- Validación y registro ---
  if (!form) return;

  form.addEventListener("submit", async function (e) {
    e.preventDefault();
    mensaje.textContent = "";
    mensaje.className = "mensaje";

    const nombres = document.getElementById("nombres").value.trim();
    const correo = document.getElementById("correo").value.trim();
    const contrasena = passwordInput.value.trim();
    const carrera = document.getElementById("carrera").value.trim();
    const intereses = document.getElementById("intereses").value.trim();

    // Aquí podrías agregar la lógica para enviar los datos al servidor
    // Por ejemplo usando fetch a tu endpoint de registro
    try {
      const response = await fetch("http://localhost:8085/api/auth/register", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ nombres, correo, contrasena, carrera, intereses })
      });

      if (!response.ok) {
        mensaje.textContent = "Error al registrarse, revisa tus datos.";
        mensaje.className = "mensaje error";
        return;
      }

      mensaje.textContent = "Registro exitoso";
      mensaje.className = "mensaje success";

      setTimeout(() => {
        window.location.href = "login.html";
      }, 900);

    } catch (err) {
      mensaje.textContent = "Error de conexión con el servidor.";
      mensaje.className = "mensaje error";
      console.error(err);
    }
  });
});
