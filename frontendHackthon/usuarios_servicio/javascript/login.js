document.addEventListener("DOMContentLoaded", function () {
  const togglePassword = document.getElementById("togglePassword");
  const passwordInput = document.getElementById("contrasena");
  const form = document.getElementById("loginForm");
  const mensaje = document.getElementById("mensaje");

  // --- Mostrar/ocultar costraseña (ojo único) ---
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
        headers: {
          "Content-Type": "application/json",
          "Accept": "application/json,text/plain"
        },
        body: JSON.stringify({ correo, contrasena })
      });

      if (!response.ok) {
        mensaje.textContent = "Usuario o contraseña incorrectos.";
        mensaje.className = "mensaje error";
        console.log("login failed status:", response.status);
        return;
      }

      const contentType = (response.headers.get("content-type") || "").toLowerCase();
      let token = null;

      if (contentType.includes("application/json")) {
        const data = await response.json();
        token = data.token || data.accessToken || data.jwt || data.authorization || (data.data && data.data.token) || null;
      } else {
        const text = await response.text();
        const match = text.match(/([A-Za-z0-9_-]+\.[A-Za-z0-9_-]+\.[A-Za-z0-9_-]+)/);
        if (match) token = match[1];
        else {
          const maybe = text.replace(/^Token de acceso:\s*/i, "").trim();
          if (maybe.split(".").length === 3) token = maybe;
        }
      }

      if (!token) {
        mensaje.textContent = "No se pudo obtener token del servidor.";
        mensaje.className = "mensaje error";
        console.log("token not found, content-type:", contentType);
        return;
      }

      localStorage.setItem("token", token);
      mensaje.textContent = "Inicio de sesión exitoso";
      mensaje.className = "mensaje success";
      console.log("token saved:", token);

      setTimeout(() => {
        window.location.href = "dashboard.html";
      }, 900);

    } catch (err) {
      mensaje.textContent = "Error de conexión con el servidor.";
      mensaje.className = "mensaje error";
      console.error(err);
    }
  });
});
