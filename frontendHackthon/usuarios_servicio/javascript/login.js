document.addEventListener("DOMContentLoaded", function () {
  const togglePassword = document.getElementById("togglePassword");
  const passwordInput = document.getElementById("contrasena");
  const form = document.getElementById("loginForm");
  const mensaje = document.getElementById("mensaje");

  // --- Mostrar/ocultar contraseña ---
  if (togglePassword && passwordInput) {
    const toggleVisibility = () => {
      passwordInput.type = passwordInput.type === "password" ? "text" : "password";
    };

    togglePassword.addEventListener("click", toggleVisibility);

    togglePassword.addEventListener("keydown", (e) => {
      if (e.key === "Enter" || e.key === " ") {
        e.preventDefault();
        toggleVisibility();
      }
    });
  }

  // --- Validación y login ---
  if (!form) return;
  form.addEventListener("submit", async function (e) {
  e.preventDefault();
  mensaje.textContent = "";
  mensaje.className = "mensaje";

  const correo = document.getElementById("correo").value.trim();
  const contrasena = passwordInput.value.trim();

  try {
    const response = await fetch("http://localhost:8085/api/auth/login", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ correo, contrasena })
    });

    let data = {};
    try {
      data = await response.json();
    } catch {
      console.warn("La respuesta no fue JSON válido.");
    }

    if (!response.ok) {
      mensaje.textContent = data.message || "Usuario o contraseña incorrectos.";
      mensaje.className = "mensaje error";
      return;
    }

    const token = data.token;
    if (!token || token.split(".").length !== 3) {
      mensaje.textContent = "No se pudo obtener un token válido.";
      mensaje.className = "mensaje error";
      return;
    }

    // Guardamos el token
    localStorage.setItem("token", token);
    mensaje.textContent = "Inicio de sesión exitoso";
    mensaje.className = "mensaje success";

    // Redirigimos al dashboard
    setTimeout(() => {
      window.location.href = "proyecto_servicio\misproyectos\dashboard.html"; // revisa esta ruta
    }, 1000);

  } catch (err) {
    mensaje.textContent = "Error de conexión con el servidor.";
    mensaje.className = "mensaje error";
    console.error("Error login:", err);
  }
});
});
