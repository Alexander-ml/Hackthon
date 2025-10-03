document.addEventListener("DOMContentLoaded", async () => {
  // --- Validar sesión ---
  const token = localStorage.getItem("token");
  if (!token) {
    window.location.href = "../html/login.html";
    return;
  }

  // --- Mostrar saludo con el nombre real del usuario desde API ---
  const saludoUsuario = document.getElementById("saludoUsuario");
  if (saludoUsuario) {
    try {
      const response = await fetch("http://localhost:8085/api/auth/me", {
        method: "GET",
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${token}`,
        },
      });

      if (!response.ok) throw new Error("No se pudo obtener información del usuario");

      const data = await response.json();
      const nombreUsuario = data.nombre || data.usuario || "Usuario";
      saludoUsuario.textContent = `Hola, ${nombreUsuario}`;
    } catch (err) {
      console.error("Error obteniendo nombre del usuario:", err);
      saludoUsuario.textContent = `Hola, Usuario`;
    }
  }

  // --- Notificaciones toggle ---
  const bell = document.getElementById("bell");
  const notifications = document.getElementById("notifications");
  if (bell && notifications) {
    bell.addEventListener("click", () => {
      notifications.style.display =
        notifications.style.display === "block" ? "none" : "block";
    });
  }

  // --- Sidebar opciones activas y navegación SPA ---
  const items = document.querySelectorAll(".sidebar ul li");
  const content = document.querySelector(".content");

  if (items.length > 0) {
    items.forEach((item) => {
      item.addEventListener("click", () => {
        items.forEach((i) => i.classList.remove("active"));
        item.classList.add("active");

        if (item.textContent.includes("Mis proyectos")) {
          content.innerHTML = `
            <div class="proyectos-section">
              <div class="proyectos-header">
                <h2>Mis proyectos</h2>
                <select id="filtroProyectos">
                  <option value="todos">Todos los proyectos</option>
                  <option value="en_progreso">En progreso</option>
                  <option value="finalizados">Finalizados</option>
                  <option value="pendientes">Pendientes</option>
                </select>
              </div>
              <div class="proyectos-grid" id="proyectosGrid">
                <p>Cargando proyectos...</p>
              </div>
            </div>
          `;
          cargarProyectos();
        } else if (item.textContent.includes("Oportunidades")) {
          content.innerHTML = `
            <div class="oportunidades-section">
              <h2>💬 Oportunidades</h2>
              <div class="oportunidades-grid">
                <div class="oportunidad-card">
                  <h3>Oportunidad ejemplo 1</h3>
                  <p>Descripción breve de la oportunidad.</p>
                </div>
                <div class="oportunidad-card">
                  <h3>Oportunidad ejemplo 2</h3>
                  <p>Descripción breve de la oportunidad.</p>
                </div>
              </div>
            </div>
          `;
        }
      });
    });
  }

  // --- Menú usuario toggle ---
  const userIcon = document.getElementById("userIcon");
  const userMenu = document.getElementById("userMenu");
  if (userIcon && userMenu) {
    userIcon.addEventListener("click", () => {
      userMenu.style.display =
        userMenu.style.display === "block" ? "none" : "block";
    });
  }

  // --- Cerrar sesión ---
  const logoutBtn = document.getElementById("logoutBtn");
  if (logoutBtn) {
    logoutBtn.addEventListener("click", () => {
      localStorage.removeItem("token");
      window.location.href = "../html/login.html";
    });
  }

  // --- Función para cargar proyectos desde API ---
  async function cargarProyectos(filtro = "todos") {
    const proyectosGrid = document.getElementById("proyectosGrid");
    const filtroProyectos = document.getElementById("filtroProyectos");
    if (!proyectosGrid) return;

    try {
      const response = await fetch("http://localhost:8085/api/proyectos", {
        method: "GET",
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${token}`,
        },
      });

      if (!response.ok) throw new Error("Error al obtener proyectos");
      const proyectos = await response.json();

      proyectosGrid.innerHTML = "";
      const proyectosFiltrados =
        filtro === "todos"
          ? proyectos
          : proyectos.filter((p) => p.estado === filtro);

      if (proyectosFiltrados.length === 0) {
        proyectosGrid.innerHTML = `<p>No hay proyectos en esta categoría.</p>`;
        return;
      }

      proyectosFiltrados.forEach((proyecto) => {
        const card = document.createElement("div");
        card.classList.add("proyecto-card");
        card.innerHTML = `
          <h3>${proyecto.nombre}</h3>
          <p>${proyecto.descripcion || "Sin descripción disponible."}</p>
          <span class="estado">${proyecto.estado}</span>
        `;
        proyectosGrid.appendChild(card);
      });

      if (filtroProyectos) {
        filtroProyectos.addEventListener("change", (e) => {
          cargarProyectos(e.target.value);
        });
      }
    } catch (error) {
      console.error("Error cargando proyectos:", error);
      proyectosGrid.innerHTML =
        "<p>Error al cargar los proyectos. Intenta nuevamente.</p>";
    }
  }

  // --- Cargar proyectos por defecto ---
  cargarProyectos();
});
