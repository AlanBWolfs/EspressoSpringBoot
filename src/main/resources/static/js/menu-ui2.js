import { mostrarModalPersonalizacion, inicializarPersonalizacion } from './modal-personalizacion.js';

// función para obtener datos desde backend
async function fetchMenuData(tipo, categoria) {
  try {
    const url = new URL('http://localhost:8080/api/productos');
    if (tipo) url.searchParams.append('tipo', tipo);
    if (categoria) url.searchParams.append('categoria', categoria);

    const response = await fetch(url);
    if (!response.ok) throw new Error('Error al cargar productos');
    const productos = await response.json();
    return productos;
  } catch (error) {
    console.error(error);
    return [];
  }
}

// función para renderizar el menú, que usa fetchMenuData
export async function renderMenu(isAdmin = false) {
  const container = document.getElementById('menu-container');
  if (!container) return;

  container.innerHTML = '';

  const params = new URLSearchParams(window.location.search);
  const tipo = params.get('tipo');
  const categoria = params.get('categoria');

  // Obtener productos desde backend
  const productos = await fetchMenuData(tipo, categoria);

  if (!productos.length) {
    container.innerHTML = '<p>No se encontraron productos para esta categoría.</p>';
    return;
  }

  // Agrupar productos por subcategoria (campo subcategoria o subCategoria según backend)
  const productosPorSubcategoria = productos.reduce((acc, producto) => {
    const subcat = producto.subcategoria || producto.subCategoria || 'Sin subcategoría';
    if (!acc[subcat]) acc[subcat] = [];
    acc[subcat].push(producto);
    return acc;
  }, {});

  // Renderizar cada grupo
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

// Crear la tarjeta de producto
function crearTarjeta(item, isAdmin) {
  const card = document.createElement('div');
  card.className = 'card';

  const nombre = item.productoNombre || item.name || item.nombre || 'Sin nombre';
  const descripcion = item.descripcion || item.description || item.descripcion || '';
  const precio = item.precio !== undefined ? item.precio : (item.price !== undefined ? item.price : 0);
  const imagen = item.imagen || item.image || item.imagen || '../assets/default.png';

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

// Evento global DOMContentLoaded para inicializar
document.addEventListener('DOMContentLoaded', () => {
  const params = new URLSearchParams(window.location.search);
  const isAdmin = params.get('admin') === 'true';

  // Llamar renderMenu que ahora es async
  renderMenu(isAdmin);

  // Solo inicializa personalización si está presente el modal
  if (document.getElementById('modalPersonalizacion')) {
    inicializarPersonalizacion();
  }

  // Clicks globales para carrito, editar y eliminar
  document.addEventListener('click', e => {
    if (e.target.matches('.btn-cart')) {
      const nombre = e.target.dataset.nombre;
      const precio = parseFloat(e.target.dataset.precio);
      const imagen = e.target.dataset.imagen;
      mostrarModalPersonalizacion(nombre, precio, imagen);
    }

    if (e.target.matches('.btn-edit')) {
      const card = e.target.closest('.card');
      const nombre = card.querySelector('.card-title').textContent;
      const descripcion = card.querySelector('.card-description').textContent;
      const precio = parseFloat(card.querySelector('.card-price').textContent.replace('$', ''));
      const imagen = card.querySelector('img').src;

      document.getElementById('nombreProducto').value = nombre;
      document.getElementById('descripcionProducto').value = descripcion;
      document.getElementById('precioProducto').value = precio;
      document.getElementById('imagenProducto').value = imagen;
      document.getElementById('productoActual').value = nombre;

      const modal = new bootstrap.Modal(document.getElementById('modalEditar'));
      modal.show();
    }

    if (e.target.matches('.btn-delete')) {
      const card = e.target.closest('.card');
      const nombre = card.querySelector('.card-title').textContent;
      if (confirm(`¿Seguro que quieres eliminar "${nombre}"?`)) {
        card.remove();
        console.log(`Producto eliminado: ${nombre}`);
      }
    }
  });

  // Submit del formulario de edición
  const formEditar = document.getElementById('formEditarProducto');
  if (formEditar) {
    formEditar.addEventListener('submit', e => {
      e.preventDefault();

      const nuevoNombre = document.getElementById('nombreProducto').value;
      const nuevaDescripcion = document.getElementById('descripcionProducto').value;
      const nuevoPrecio = parseFloat(document.getElementById('precioProducto').value).toFixed(2);
      const nuevaImagen = document.getElementById('imagenProducto').value;
      const productoOriginal = document.getElementById('productoActual').value;

      const cards = document.querySelectorAll('.card');
      cards.forEach(card => {
        const titulo = card.querySelector('.card-title');
        if (titulo.textContent === productoOriginal) {
          titulo.textContent = nuevoNombre;
          card.querySelector('.card-description').textContent = nuevaDescripcion;
          card.querySelector('.card-price').textContent = `$${nuevoPrecio}`;
          card.querySelector('img').src = nuevaImagen;
        }
      });

      bootstrap.Modal.getInstance(document.getElementById('modalEditar')).hide();
      e.target.reset();
    });
  }
});
