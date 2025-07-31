-- Vaciar tablas
DELETE FROM productos;
DELETE FROM subsubcategorias;
DELETE FROM subcategorias;
DELETE FROM categorias;

-- Resetear AUTO_INCREMENT
ALTER TABLE productos AUTO_INCREMENT = 1;
ALTER TABLE subsubcategorias AUTO_INCREMENT = 1;
ALTER TABLE subcategorias AUTO_INCREMENT = 1;
ALTER TABLE categorias AUTO_INCREMENT = 1;

-- Insertar Categorías
INSERT INTO categorias (id_categoria, nombre) VALUES
(1, 'Alimentos'),
(2, 'Bebidas');

-- Insertar Subcategorías
INSERT INTO subcategorias (id, nombre, id_categoria) VALUES
(1, 'Desayunos', 1),
(2, 'Chilaquiles', 1),
(3, 'Toast', 1),
(4, 'Bagels', 1),
(5, 'Dogopizza', 1),
(6, 'Ensalada', 1),
(7, 'Extras', 1),
(10, 'Especiales', 2),
(11, 'Frias', 2),
(12, 'Calientes', 2);

-- Insertar Sub-subcategorías
INSERT INTO subsubcategorias (id, nombre, id_subcategoria) VALUES
(1, 'Frozen', 11),
(2, 'Refresh', 11),
(3, 'Bebidas Frias', 11),
(4, 'Pre Workout', 11),
(5, 'Especiales', 10),
(6, 'Calientes', 12);

-- Insertar Productos

-- Alimentos -> Desayunos -> Huevos
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Alimentos', '2 huevos batidos, rellenos de champiñones, tomate cherry y queso Monterrey Jack acompañados de salsa a elegir (roja o verde) frijoles refritos y totoposte de la región', 1, '/assets/menuItems/ommelette.jpg', 90.00, 'Desayunos', 'Plato', 'Omelette de jamón y queso Monterrey Jack', NULL),
('Alimentos', '2 huevos revueltos con jamón de pavo acompañados de frijoles fritos platanos y totoposte de la región', 1, '/assets/menuItems/huevos2.png', 80.00, 'Desayunos', 'Plato', 'Huevos clasicos', NULL),
('Alimentos', '2 huevos revueltos con salchicha de res acompañados de frijoles fritos platanos y totoposte de la región', 1, '/assets/menuItems/huevos.png', 85.00, 'Desayunos', 'Plato', 'Huevos beef', NULL),
('Alimentos', '2 huevos revueltos con tomate, cebolla y chile serrano acompañados de frijoles fritos platanos y totoposte de la región', 1, '/assets/menuItems/huevos.png', 80.00, 'Desayunos', 'Plato', 'Huevos a la Mexicana', NULL),
('Alimentos', '2 huevos revueltos con longaniza de la región acompañados de frijoles fritos platanos y totoposte de la región', 1, '/assets/menuItems/huevos.png', 85.00, 'Desayunos', 'Plato', 'Huevos Jabali', NULL),
('Alimentos', '2 huevos revueltos con jamón de pavo acompañados de frijoles fritos platanos y totoposte de la región', 1, '/assets/menuItems/huevos.png', 85.00, 'Desayunos', 'Plato', 'Huevos clasicos', NULL),
('Alimentos', '2 huevos estrellados sobre una cama de tortilla, queso y jamón, bañados con salsa a elegir (verde o roja) y chicharos, acompañados de frijoles fritos y platanos fritos.', 1, '/assets/menuItems/huevos.png', 100.00, 'Desayunos', 'Plato', 'Huevos Motuleños', NULL);

-- Alimentos -> Chilaquiles
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Alimentos', 'Tortilla frita bañada con la salsa de su preferencia, crema, queso Monterrey Jack, aguacate y cebolla curtida.', 1, '/assets/menuItems/chilaquiles.png', 100.00, 'Chilaquiles', 'Plato', 'Chilaquiles rojos o verdes', NULL);

-- Alimentos -> Especiales -> Toast
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Alimentos', '2 rebanadas de pan de masa madre con semillas Montado en una cama de aguacate, queso crema Tomate cherry, hojas verdes y aderezo de la casa', 1, '/assets/menuItems/toastjamon.png', 90.00, 'Toast', 'Plato', 'Jamon Serrano', NULL),
('Alimentos', '2 rebanadas de masa madre con semillas montado en una cama de huacamole, queso crema tomate cherry, hojas verdes y aderezo de la casa.', 1, '/assets/menuItems/toastsalmon.png', 100.00, 'Toast', 'Plato', 'Salmon Ahumado', NULL),
('Alimentos', '2 rebanadas de pan de masa madre con semillas Montado en una cama de aguacate, queso crema Tomate cherry, hojas verdes y aderezo de la casa', 1, '/assets/menuItems/toasthuevo.png', 90.00, 'Toast', 'Plato', 'Huevos estrellados', NULL),
('Alimentos', '2 rebanadas de pan de masa madre con semillas Montado en una cama de queso crema con coulis de frutas(durazno, fresa, maracuya, piña o moras)', 1, '/assets/menuItems/dulces.png', 75.00, 'Toast', 'Plato', 'Dulces', NULL);

-- Alimentos -> Especiales -> Bagels
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Alimentos', '1 pieza de bagels de parmesano, montado en una cama de guacamole, queso crema, hojas verdes y aderezo de la casa.', 1, '/assets/menuItems/dulces.png', 85.00, 'Bagels', 'Plato', 'Jamon Serrano', NULL),
('Alimentos', '1 pieza de bagels de parmesano, montado en una cama de guacamole, queso crema, hojas verdes y aderezo de la casa.', 1, '/assets/menuItems/bagelsalmon.png', 95.00, 'Bagels', 'Plato', 'Slamon ahumado', NULL),
('Alimentos', '1 pieza de bagels de parmesano, montado en una cama de guacamole, queso crema, hojas verdes y aderezo de la casa.', 1, '/assets/menuItems/bagelhuevo.png', 85.00, 'Bagels', 'Plato', 'Huevos estrellados', NULL),
('Alimentos', '1 pieza de bagels de parmesano, montado en una cama de guacamole, queso crema, hojas verdes y aderezo de la casa.', 1, '/assets/menuItems/dulces.png', 80.00, 'Bagels', 'Plato', 'Clasico', NULL);

-- Alimentos -> Especiales -> Dogopizza
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Alimentos', 'Combinación de hotdog con nuestra salsa para pizza, cubierto de queso Monterrey Jack y aderezo de la casa', 1, '/assets/menuItems/hotdogcham.png', 75.00, 'Dogopizza', 'Plato', 'Champiñon', NULL),
('Alimentos', 'Combinación de hotdog con nuestra salsa para pizza, cubierto de queso Monterrey Jack y aderezo de la casa', 1, '/assets/menuItems/hot.png', 75.00, 'Dogopizza', 'Plato', 'Hawaiano', NULL),
('Alimentos', 'Combinación de hotdog con nuestra salsa para pizza, cubierto de queso Monterrey Jack y aderezo de la casa', 1, '/assets/menuItems/hot.png', 75.00, 'Dogopizza', 'Plato', 'Pepperoni', NULL);

-- Alimentos -> Especiales -> Ensalada
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Alimentos', 'Mezcla de espinaca baby, bolitas de queso crema, arandanos deshidratados, nueces, trozos de durazno y aderezo de miel con mostaza.', 1, '/assets/menuItems/Ensalada.png', 75.00, 'Ensalada', 'Plato', 'Espresso', NULL);

-- Extras -> ProductosExtras
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Extras', 'Snack ligero y crujiente, ideal para compartir', 1, '/assets/menuItems/logo-verde.png', 25.00, 'ProductosExtras', 'Extra', 'Palomitas', NULL),
('Extras', 'Líquido puro y refrescante para hidratación', 1, '/assets/menuItems/water.png', 16.00, 'ProductosExtras', 'Extra', 'Agua', NULL),
('Extras', 'Bebida tropical con notas suaves y frescas', 1, '/assets/menuItems/water.png', 37.00, 'ProductosExtras', 'Extra', 'Amper, agua de coco', NULL),
('Extras', 'Modificación vegetal o sin lactosa de la leche', 1, '/assets/menuItems/logo-verde.png', 12.00, 'ProductosExtras', 'Extra', 'Cambio de leche', NULL),
('Extras', 'Jugo natural o procesado con sabor frutal', 1, '/assets/menuItems/frozen.png', 18.00, 'ProductosExtras', 'Extra', 'Jugos', NULL),
('Extras', 'Bebida isotónica para rehidratar y energizar', 1, '/assets/menuItems/frozenmango.png', 30.00, 'ProductosExtras', 'Extra', 'Powerade', NULL),
('Extras', 'Gaseosa o agua con gas para refrescar', 1, '/assets/menuItems/water.png', 25.00, 'ProductosExtras', 'Extra', 'Refresco, agua mineral', NULL),
('Extras', 'Porción adicional de café para mayor intensidad', 1, '/assets/menuItems/espresso.png', 15.00, 'ProductosExtras', 'Extra', 'Shot extra café', NULL);

-- Bebidas -> Especiales -> shots (id_subsubcategoria = 5)
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Bebidas', 'Helado doble de vainilla con un shot de espresso.', 1, '/assets/menuItems/affogato.png', 70.00, 'Especiales', 'Bebida', 'Affogato', 5),
('Bebidas', 'Helado doble con un shot de espresso y un shot de Baileys', 1, '/assets/menuItems/affogato.png', 80.00, 'Especiales', 'Bebida', 'Affogato especial', 5),
('Bebidas', 'Vino espumo lambrusco, Coca-Cola y rodajas de limón', 1, '/assets/menuItems/carajillo.png', 70.00, 'Especiales', 'Bebida', 'Calimocho', 5),
('Bebidas', 'Mezcla de licor especiado con espresso doble.', 1, '/assets/menuItems/carajillo.png', 70.00, 'Especiales', 'Bebida', 'Carajillo', 5),
('Bebidas', 'Mezcla de licor especiado con espresso doble y con un shot de Baileys.', 1, '/assets/menuItems/carajillo.png', 80.00, 'Especiales', 'Bebida', 'Carajillo especial', 5),
('Bebidas', 'Vino espumo lambrusco, shot de limón, agua mineral y Gingerale', 1, '/assets/menuItems/frozenberry.png', 70.00, 'Especiales', 'Bebida', 'Tinto de verano', 5);

-- Bebidas -> Calientes -> bebidasCalientes (id_subsubcategoria = 6)
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Bebidas', 'Bebida caliente con sabor intenso y tostado', 1, '/assets/menuItems/espresso.png', 45.00, 'Calientes', 'Bebida', 'Americano', 6),
('Bebidas', 'Mezcla cremosa y dulce, perfecta para reconfortar', 1, '/assets/menuItems/espresso.png', 65.00, 'Calientes', 'Bebida', 'Chocolate', 6),
('Bebidas', 'Infusión especiada con café y notas dulces', 1, '/assets/menuItems/latte.png', 70.00, 'Calientes', 'Bebida', 'Dirty chai latte', 6),
('Bebidas', 'Combinación suave de espresso con leche y dulzor', 1, '/assets/menuItems/latte.png', 65.00, 'Calientes', 'Bebida', 'Español latte', 6),
('Bebidas', 'Preparación concentrada de café en formato corto', 1, '/assets/menuItems/espresso.png', 30.00, 'Calientes', 'Bebida', 'Espresso', 6),
('Bebidas', 'Espresso con un toque de leche para suavizar su sabor', 1, '/assets/menuItems/espresso.png', 40.00, 'Calientes', 'Bebida', 'Espresso doble cortado', 6),
('Bebidas', 'Método de extracción: V60, Chemex o prensa francesa.', 1, '/assets/menuItems/espresso.png', 70.00, 'Calientes', 'Bebida', 'Filtrado de especialidad', 6),
('Bebidas', 'Bebida cremosa con café y leche en equilibrio', 1, '/assets/menuItems/latte.png', 60.00, 'Calientes', 'Bebida', 'Latte', 6),
('Bebidas', 'Mocca, cajeta, crema irlandesa, vainilla, caramelo.', 1, '/assets/menuItems/latte.png', 65.00, 'Calientes', 'Bebida', 'Latte con sabor', 6),
('Bebidas', 'Té verde con leche y textura aterciopelada', 1, '/assets/menuItems/matcha.png', 65.00, 'Calientes', 'Bebida', 'Matcha latte', 6),
('Bebidas', 'Bebida suave con notas dulces y cremosas', 1, '/assets/menuItems/matcha.png', 65.00, 'Calientes', 'Bebida', 'Taro latte', 6),
('Bebidas', 'Infusión frutal y floral con aroma natural', 1, '/assets/menuItems/tea.png', 55.00, 'Calientes', 'Bebida', 'Tizana', 6);

-- Bebidas -> Frias -> frozen (id_subsubcategoria = 1)
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Bebidas', 'Bebida congelada con especias y vainilla', 1, '/assets/menuItems/frozen.png', 85.00, 'Frias', 'Bebida', 'Chai vainilla frozen', 1),
('Bebidas', 'Bebida helada con especias y chocolate', 1, '/assets/menuItems/frozen.png', 85.00, 'Frias', 'Bebida', 'Chai chocolate frozen', 1),
('Bebidas', 'Bebida helada con sabor tropical a mango', 1, '/assets/menuItems/frozenmango.png', 75.00, 'Frias', 'Bebida', 'Mango frozen', 1),
('Bebidas', 'Combinación helada con frutos rojos y café', 1, '/assets/menuItems/frozenberry.png', 85.00, 'Frias', 'Bebida', 'Red berries frozen', 1);

-- Bebidas -> Frias -> refresh (id_subsubcategoria = 2)
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Bebidas', 'Bebida refrescante de frutos rojos con té verde', 1, '/assets/menuItems/icedtea.png', 75.00, 'Frias', 'Bebida', 'Frutos rojos tea', 2),
('Bebidas', 'Infusión fría de manzanilla con miel y cítricos', 1, '/assets/menuItems/icedtea.png', 65.00, 'Frias', 'Bebida', 'Manzanilla tea', 2),
('Bebidas', 'Té negro con leche fría para un sabor suave', 1, '/assets/menuItems/icedtea.png', 70.00, 'Frias', 'Bebida', 'Té negro con leche', 2);

-- Bebidas -> Frias -> bebidasFrias (id_subsubcategoria = 3)
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Bebidas', 'Versión fría de café con sabor robusto', 1, '/assets/menuItems/icedcoffee.png', 50.00, 'Frias', 'Bebida', 'Americano frío', 3),
('Bebidas', 'Combinación refrescante de espresso frío con leche', 1, '/assets/menuItems/icedcoffee.png', 65.00, 'Frias', 'Bebida', 'Español latte frío', 3),
('Bebidas', 'Mocca, cajeta, crema irlandesa, vainilla, caramelo.', 1, '/assets/menuItems/frappe.png', 65.00, 'Frias', 'Bebida', 'Late frío con sabor', 3),
('Bebidas', 'Bebida fría con café suave y textura cremosa', 1, '/assets/menuItems/frappe.png', 60.00, 'Frias', 'Bebida', 'Latte frío', 3),
('Bebidas', 'Té verde y coco combinados en una mezcla helada', 1, '/assets/menuItems/icedmatcha.png', 80.00, 'Frias', 'Bebida', 'Matcha / coco latte frío', 3),
('Bebidas', 'Té matcha con fresa en versión fría y cremosa', 1, '/assets/menuItems/icedmatcha.png', 75.00, 'Frias', 'Bebida', 'Matcha / fresa latte frío', 3),
('Bebidas', 'Bebida fría con sabor a té verde y acabado suave', 1, '/assets/menuItems/icedmatcha.png', 65.00, 'Frias', 'Bebida', 'Matcha latte frío', 3),
('Bebidas', 'Fusión helada de taro y coco con textura cremosa', 1, '/assets/menuItems/frappe.png', 80.00, 'Frias', 'Bebida', 'Taro / coco latte frío', 3),
('Bebidas', 'Mezcla fría de taro con un toque afrutado', 1, '/assets/menuItems/frappe.png', 75.00, 'Frias', 'Bebida', 'Taro / fresa latte frío', 3);

-- Bebidas -> Frias -> preWorkout (id_subsubcategoria = 4)
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Bebidas', 'Café frío con toque de ginger ale especiado', 1, '/assets/menuItems/icedcoffee.png', 70.00, 'Frias', 'Bebida', 'Cold brew Gingerale', 4),
('Bebidas', 'Café frío con leche para una mezcla suave', 1, '/assets/menuItems/icedcoffee.png', 70.00, 'Frias', 'Bebida', 'Cold brew latte', 4),
('Bebidas', 'Preparado frío con notas cítricas y tostadas', 1, '/assets/menuItems/icedcoffee.png', 70.00, 'Frias', 'Bebida', 'Cold brew Sunrise', 4),
('Bebidas', 'Bebida energética con café y sabor intenso', 1, '/assets/menuItems/icedcoffee.png', 70.00, 'Frias', 'Bebida', 'Monster americano', 4);

