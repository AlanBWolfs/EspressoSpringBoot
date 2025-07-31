import { mostrarModalPersonalizacion, inicializarPersonalizacion } from './modal-personalizacion.js';

// Función para obtener productos desde backend con filtros tipo y categoria (subcategoria en este caso)
async function fetchMenuData(tipo, subcategoria) {
  try {
    const url = new URL('http://localhost:8080/api/productos');
    if (tipo) url.searchParams.append('tipo', tipo);
    if (subcategoria) url.searchParams.append('subcategoria', subcategoria);

    const response = await fetch(url);
    if (!response.ok) throw new Error('Error al cargar productos');
    const productos = await response.json();
    return productos;
  } catch (error) {
    console.error(error);
    return [];
  }
}

// Crear tarjeta HTML de producto
function crearTarjeta(item, isAdmin) {
  const card = document.createElement('div');
  card.className = 'card';

  const nombre = item.productoNombre || item.name || item.nombre || 'Sin nombre';
  const descripcion = item.descripcion || item.description || '';
  const precio = item.precio !== undefined ? item.precio : (item.price !== undefined ? item.price : 0);
  const imagen = item.imagen || item.image || '../assets/default.png';

  let botonesHTML = '';

  if (!isAdmin) {
    botonesHTML += `<button class="btn btn-cart" data-nombre="${nombre}" data-precio="${precio}" data-imagen="${imagen}">Agregar al carrito</button>`;
  } else {
    botonesHTML += `
      <button class="btn btn-edit">Editar</button>
      <button class="btn btn-delete">Eliminar</button>
    `;
  }

  card.innerHTML = `
    <div class="card-img-wrapper">
      <img src="${imagen}" alt="${nombre}" class="card-img">
    </div>
    <div class="card-content">
      <h4 class="card-title">${nombre}</h4>
      <p class="card-description">${descripcion}</p>
      <p class="card-price">$${precio.toFixed(2)}</p>
      <div class="card-buttons">
        ${botonesHTML}
      </div>
    </div>
  `;

  return card;
}

// Función principal para renderizar menú, mostrando sólo la subcategoría seleccionada
export async function renderMenu(isAdmin = false) {
  const container = document.getElementById('menu-container');
  if (!container) return;

  container.innerHTML = '';

  const params = new URLSearchParams(window.location.search);
  const tipo = params.get('tipo');
  const categoriaRaw = params.get('categoria');

  // Mapeo para normalizar el nombre de la subcategoría según URL (sin tildes, con guiones, etc)
// Mapeo para normalizar el nombre de la subcategoría según URL
const nombreSubcategoriaMap = {
    'bebidas-frias': 'Bebidas Frías',
    'frias': 'Bebidas Frías',
    'frías': 'Bebidas Frías',
    'bebidas-calientes': 'Bebidas Calientes',
    'calientes': 'Bebidas Calientes',
    'especiales': 'Especiales',   // 👈 aquí lo dejamos
    'desayunos': 'Desayunos',
    'extras': 'Extras',
  };



  const categoria = nombreSubcategoriaMap[categoriaRaw?.toLowerCase()] || categoriaRaw;

  const productos = await fetchMenuData(tipo, categoria);

  if (!productos.length) {
    container.innerHTML = `<p>No se encontraron productos para la subcategoría "${categoria}".</p>`;
    return;
  }

  // Agrupar productos por subcategoría
  const productosPorSubcategoria = productos.reduce((acc, producto) => {
    const subcat = producto.subcategoria || producto.subCategoria || 'Sin subcategoría';
    if (!acc[subcat]) acc[subcat] = [];
    acc[subcat].push(producto);
    return acc;
  }, {});

  if (categoria) {
    const productosFiltrados = productosPorSubcategoria[categoria];

    if (!productosFiltrados || productosFiltrados.length === 0) {
      container.innerHTML = `<p>No se encontraron productos para la subcategoría "${categoria}".</p>`;
      return;
    }

    const h2 = document.createElement('h2');
    h2.textContent = categoria;
    container.appendChild(h2);

    const grid = document.createElement('div');
    grid.className = 'subcategoria';

    productosFiltrados.forEach(item => {
      grid.appendChild(crearTarjeta(item, isAdmin));
    });

    container.appendChild(grid);

  } else {
    // Si no hay categoría, mostrar todas agrupadas
    for (const subcategoria in productosPorSubcategoria) {
      const h2 = document.createElement('h2');
      h2.textContent = subcategoria;
      container.appendChild(h2);

      const grid = document.createElement('div');
      grid.className = 'subcategoria';

      productosPorSubcategoria[subcategoria].forEach(item => {
        grid.appendChild(crearTarjeta(item, isAdmin));
      });

      container.appendChild(grid);
    }
  }
}

// Listener global para clicks en botones dentro del menú
document.addEventListener('click', e => {
  if (e.target.matches('.btn-cart')) {
    const nombre = e.target.dataset.nombre;
    const precio = parseFloat(e.target.dataset.precio);
    const imagen = e.target.dataset.imagen;
    mostrarModalPersonalizacion(nombre, precio, imagen);
  }
});
