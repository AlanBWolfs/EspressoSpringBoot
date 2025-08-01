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

-- =========================
-- CATEGORÍAS
-- =========================
INSERT INTO categorias (nombre) VALUES
('Alimentos'),
('Bebidas');

-- =========================
-- SUBCATEGORÍAS
-- =========================
INSERT INTO subcategorias (nombre, id_categoria) VALUES
('Desayunos', 1),
('Especiales', 1),
('Extras', 1),
('Bebidas Calientes', 2),
('Bebidas Frías', 2),
('Especiales1', 2);

-- =========================
-- SUB-SUBCATEGORÍAS
-- =========================
-- Alimentos -> Desayunos
INSERT INTO subsubcategorias (nombre, id_subcategoria) VALUES
('Huevos', 1),
('Chilaquiles', 1);

-- Alimentos -> Especiales
INSERT INTO subsubcategorias (nombre, id_subcategoria) VALUES
('Toast', 2),
('Bagels', 2),
('Dogopizza', 2),
('Ensalada', 2);

-- Alimentos -> Extras
INSERT INTO subsubcategorias (nombre, id_subcategoria) VALUES
('Productos Extras', 3);

-- Bebidas -> Bebidas Frías
INSERT INTO subsubcategorias (nombre, id_subcategoria) VALUES
('Frozen', 5),
('Refresh', 5),
('Bebidas Frías', 5),
('Pre Workout', 5);

-- Bebidas -> Bebidas Calientes
INSERT INTO subsubcategorias (nombre, id_subcategoria) VALUES
('Bebidas Calientes', 4);

-- Bebidas -> Especiales
INSERT INTO subsubcategorias (nombre, id_subcategoria) VALUES
('Shots', 6);

-- =========================
-- PRODUCTOS
-- =========================

-- Alimentos -> Desayunos -> Huevos
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Alimentos','2 huevos batidos, rellenos de champiñones, tomate cherry y queso Monterrey Jack acompañados de salsa a elegir (roja o verde), frijoles refritos y totoposte de la región.',1,'/assets/menuItems/ommelette.jpg',90.00,'Desayunos','Plato','Omelette de jamón y queso Monterrey Jack',1),
('Alimentos','2 huevos revueltos con jamón de pavo acompañados de frijoles fritos, plátanos y totopos de la región.',1,'/assets/menuItems/huevos-clasicos.png',80.00,'Desayunos','Plato','Huevos clásicos',1),
('Alimentos','2 huevos revueltos con salchicha de res acompañados de frijoles fritos, plátanos y totopos de la región.',1,'/assets/menuItems/huevos-beff.png',85.00,'Desayunos','Plato','Huevos beef',1),
('Alimentos','2 huevos revueltos con tomate, cebolla y chile serrano acompañados de frijoles fritos, plátanos y totopos de la región.',1,'/assets/menuItems/huevos-mexicana.png',80.00,'Desayunos','Plato','Huevos a la Mexicana',1),
('Alimentos','2 huevos revueltos con longaniza de la región acompañados de frijoles fritos, plátanos y totopos de la región.',1,'/assets/menuItems/huevos-jabali.png',85.00,'Desayunos','Plato','Huevos Jabalí',1),
('Alimentos','2 huevos estrellados sobre una cama de tortilla, queso y jamón, bañados con salsa a elegir (verde o roja) y chícharos, acompañados de frijoles fritos y plátanos fritos.',1,'/assets/menuItems/huevos-motuleños.png',100.00,'Desayunos','Plato','Huevos Motuleños',1);

-- Alimentos -> Desayunos -> Chilaquiles
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Alimentos','Tortilla frita bañada con la salsa de su preferencia, crema, queso Monterrey Jack, aguacate y cebolla curtida.',1,'/assets/menuItems/chilaquiles.png',100.00,'Desayunos','Plato','Chilaquiles rojos o verdes',2);

-- Alimentos -> Especiales -> Toast
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Alimentos', '2 rebanadas de pan de masa madre con semillas montado en aguacate, queso crema, tomate cherry, hojas verdes y aderezo de la casa', 1, '/assets/menuItems/toastjamon.png', 90.00, 'Especiales', 'Plato', 'Jamón Serrano', 2),
('Alimentos', '2 rebanadas de masa madre con semillas montado en guacamole, queso crema, tomate cherry, hojas verdes y aderezo de la casa.', 1, '/assets/menuItems/toastsalmon.png', 100.00, 'Especiales', 'Plato', 'Salmon Ahumado', 2),
('Alimentos', '2 rebanadas de pan de masa madre con semillas montado en aguacate, queso crema, tomate cherry, hojas verdes y aderezo de la casa', 1, '/assets/menuItems/toasthuevo.png', 90.00, 'Especiales', 'Plato', 'Huevos estrellados', 2),
('Alimentos', '2 rebanadas de pan de masa madre con semillas montado en queso crema con coulis de frutas (durazno, fresa, maracuya, piña o moras)', 1, '/assets/menuItems/dulces.png', 75.00, 'Especiales', 'Plato', 'Dulces', 2);

-- Alimentos -> Especiales -> Bagels
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Alimentos', 'Bagel de parmesano montado en guacamole, queso crema, hojas verdes y aderezo de la casa.', 1, '/assets/menuItems/jamon-serrano.png', 85.00, 'Especiales', 'Plato', 'Jamón Serrano', 2),
('Alimentos', 'Bagel de parmesano montado en guacamole, queso crema, hojas verdes y aderezo de la casa.', 1, '/assets/menuItems/bagelsalmon.png', 95.00, 'Especiales', 'Plato', 'Salmón ahumado', 2),
('Alimentos', 'Bagel de parmesano montado en guacamole, queso crema, hojas verdes y aderezo de la casa.', 1, '/assets/menuItems/bagelhuevo.png', 85.00, 'Especiales', 'Plato', 'Huevos estrellados', 2),
('Alimentos', 'Bagel de parmesano montado en guacamole, queso crema, hojas verdes y aderezo de la casa.', 1, '/assets/menuItems/bagle-clasico.png', 80.00, 'Especiales', 'Plato', 'Clásico', 2);

-- Alimentos -> Especiales -> Dogopizza
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Alimentos', 'Hotdog con salsa para pizza, cubierto de queso Monterrey Jack, champiñones y aderezo de la casa', 1, '/assets/menuItems/dogo-champiñon.png', 75.00, 'Especiales', 'Plato', 'Champiñón', 2),
('Alimentos', 'Hotdog con salsa para pizza, cubierto de queso Monterrey Jack, piña y aderezo de la casa', 1, '/assets/menuItems/dogo-hawaiano.png', 75.00, 'Especiales', 'Plato', 'Hawaiano', 2),
('Alimentos', 'Hotdog con salsa para pizza, cubierto de queso Monterrey Jack, pepperoni y aderezo de la casa', 1, '/assets/menuItems/dogo-pepperoni.png', 75.00, 'Especiales', 'Plato', 'Pepperoni', 2);

-- Alimentos -> Especiales -> Ensalada
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Alimentos', 'Mezcla de espinaca baby, bolitas de queso crema, arándanos, nueces, durazno y aderezo de miel con mostaza.', 1, '/assets/menuItems/Ensalada.png', 75.00, 'Especiales', 'Plato', 'Ensalada fresca', 2);


-- Alimentos -> Extras
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Alimentos','Snack ligero y crujiente, ideal para compartir.',1,'/assets/menuItems/palomitas.png',25.00,'Extras','Extra','Palomitas',7),
('Alimentos','Agua natural 600ml.',1,'/assets/menuItems/agua.png',16.00,'Extras','Extra','Agua',7),
('Alimentos','Agua de coco Amper.',1,'/assets/menuItems/agua-coco.png',37.00,'Extras','Extra','Amper agua de coco',7),
('Alimentos','Cambio de leche vegetal o deslactosada.',1,'/assets/menuItems/cambio-leche.png',12.00,'Extras','Extra','Cambio de leche',7),
('Alimentos','Jugo natural de frutas.',1,'/assets/menuItems/jugos.png',18.00,'Extras','Extra','Jugos',7),
('Alimentos','Powerade isotónico.',1,'/assets/menuItems/powerade.png',30.00,'Extras','Extra','Powerade',7),
('Alimentos','Refresco o agua mineral.',1,'/assets/menuItems/refresco-mineral.png',25.00,'Extras','Extra','Refresco, agua mineral',7),
('Alimentos','Shot extra de café.',1,'/assets/menuItems/espresso.png',15.00,'Extras','Extra','Shot extra café',7);

-- Bebidas -> Especiales Bebidas -> Shots
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Bebidas', 'Helado doble de vainilla con un shot de espresso.', 1, '/assets/menuItems/afogatto.png', 70.00, 'Especiales Bebidas', 'Bebida', 'Affogato', 6),
('Bebidas', 'Helado doble con un shot de espresso y un shot de Baileys', 1, '/assets/menuItems/affogato-especial.png', 80.00, 'Especiales Bebidas', 'Bebida', 'Affogato especial', 6),
('Bebidas', 'Vino espumo lambrusco, Coca-Cola y rodajas de limón', 1, '/assets/menuItems/calimocho.png', 70.00, 'Especiales Bebidas', 'Bebida', 'Calimocho', 6),
('Bebidas', 'Mezcla de licor especiado con espresso doble.', 1, '/assets/menuItems/carajillo.png', 70.00, 'Especiales Bebidas', 'Bebida', 'Carajillo', 6),
('Bebidas', 'Mezcla de licor especiado con espresso doble y con un shot de Baileys.', 1, '/assets/menuItems/carajillo-especial.png', 80.00, 'Especiales Bebidas', 'Bebida', 'Carajillo especial', 6),
('Bebidas', 'Vino espumo lambrusco, shot de limón, agua mineral y Gingerale', 1, '/assets/menuItems/tinto-verano.png', 70.00, 'Especiales Bebidas', 'Bebida', 'Tinto de verano', 6);


-- Bebidas -> Calientes -> Bebidas Calientes
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Bebidas', 'Bebida caliente con sabor intenso y tostado', 1, '/assets/menuItems/espresso.png', 45.00, 'Bebidas Calientes', 'Bebida', 'Americano', 4),
('Bebidas', 'Mezcla cremosa y dulce, perfecta para reconfortar', 1, '/assets/menuItems/taza-chocolate.png', 65.00, 'Bebidas Calientes', 'Bebida', 'Chocolate', 4),
('Bebidas', 'Infusión especiada con café y notas dulces', 1, '/assets/menuItems/dirty-chai-latte.png', 70.00, 'Bebidas Calientes', 'Bebida', 'Dirty chai latte', 4),
('Bebidas', 'Combinación suave de espresso con leche y dulzor', 1, '/assets/menuItems/español-latte.png', 65.00, 'Bebidas Calientes', 'Bebida', 'Español latte', 4),
('Bebidas', 'Preparación concentrada de café en formato corto', 1, '/assets/menuItems/espresso.png', 30.00, 'Bebidas Calientes', 'Bebida', 'Espresso', 4),
('Bebidas', 'Espresso con un toque de leche para suavizar su sabor', 1, '/assets/menuItems/espresso-doble.png', 40.00, 'Bebidas Calientes', 'Bebida', 'Espresso doble cortado', 4),
('Bebidas', 'Método de extracción: V60, Chemex o prensa francesa.', 1, '/assets/menuItems/filtrado.png', 70.00, 'Bebidas Calientes', 'Bebida', 'Filtrado de especialidad', 4),
('Bebidas', 'Bebida cremosa con café y leche en equilibrio', 1, '/assets/menuItems/latte.png', 60.00, 'Bebidas Calientes', 'Bebida', 'Latte', 4),
('Bebidas', 'Mocca, cajeta, crema irlandesa, vainilla, caramelo.', 1, '/assets/menuItems/latte.png', 65.00, 'Bebidas Calientes', 'Bebida', 'Latte con sabor', 4),
('Bebidas', 'Té verde con leche y textura aterciopelada', 1, '/assets/menuItems/matcha.png', 65.00, 'Bebidas Calientes', 'Bebida', 'Matcha latte', 4),
('Bebidas', 'Bebida suave con notas dulces y cremosas', 1, '/assets/menuItems/taro-latte.png', 65.00, 'Bebidas Calientes', 'Bebida', 'Taro latte', 4),
('Bebidas', 'Infusión frutal y floral con aroma natural', 1, '/assets/menuItems/tea.png', 55.00, 'Bebidas Calientes', 'Bebida', 'Tizana', 4);

-- Bebidas -> Frías -> Frozen
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Bebidas', 'Bebida congelada con especias y vainilla', 1, '/assets/menuItems/chai-vainilla-frozen.png', 85.00, 'Bebidas Frías', 'Bebida', 'Chai vainilla frozen', 11),
('Bebidas', 'Batido dulce con sabor a fresa', 1, '/assets/menuItems/fresa-yogurt.png', 75.00, 'Bebidas Frías', 'Bebida', 'Fresa yogurt', 11),
('Bebidas', 'Yogurt batido con frutos rojos y notas ácidas', 1, '/assets/menuItems/malteada.png', 75.00, 'Bebidas Frías', 'Bebida', 'Frutos rojos yogurt', 11),
('Bebidas', 'Combinación cremosa de maracuyá y coco', 1, '/assets/menuItems/maracoco-yogurt.png', 75.00, 'Bebidas Frías', 'Bebida', 'Maracoco yogurt', 11),
('Bebidas', 'Bebida tropical con acidez refrescante', 1, '/assets/menuItems/maracuya-yogurt.png', 75.00, 'Bebidas Frías', 'Bebida', 'Maracuyá yogurt', 11),
('Bebidas', 'Té verde congelado con textura cremosa', 1, '/assets/menuItems/icedmatcha.png', 85.00, 'Bebidas Frías', 'Bebida', 'Matcha Frozen', 11),
('Bebidas', 'Batido espeso y dulce con sabor a taro', 1, '/assets/menuItems/taro-frozen.png', 85.00, 'Bebidas Frías', 'Bebida', 'Taro frozen', 11),
('Bebidas', 'Bebida sabor a yogurt con un intenso toque a zarzamora', 1, '/assets/menuItems/frozenberry.png', 75.00, 'Bebidas Frías', 'Bebida', 'Zarzamora yogurt', 11);

-- Bebidas -> Frías -> Refresh
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Bebidas', 'Base a elegir: limonada, agua mineral o leche.', 1, '/assets/menuItems/frozen.png', 55.00, 'Bebidas Frías', 'Bebida', 'Fresa refresh', 12),
('Bebidas', 'Base a elegir: limonada, agua mineral o leche.', 1, '/assets/menuItems/frozenmango.png', 55.00, 'Bebidas Frías', 'Bebida', 'Mango refresh', 12),
('Bebidas', 'Base a elegir: limonada, agua mineral o leche.', 1, '/assets/menuItems/manzana-refresh.png', 55.00, 'Bebidas Frías', 'Bebida', 'Manzana verde refresh', 12),
('Bebidas', 'Base a elegir: limonada, agua mineral o leche.', 1, '/assets/menuItems/mora-refresh.png', 55.00, 'Bebidas Frías', 'Bebida', 'Moras refresh', 12);

-- Bebidas -> Frías -> Bebidas Frías
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Bebidas', 'Versión fría de café con sabor robusto', 1, '/assets/menuItems/americano-frio.png', 50.00, 'Bebidas Frías', 'Bebida', 'Americano frío', 13),
('Bebidas', 'Combinación refrescante de espresso frío con leche', 1, '/assets/menuItems/español-latte-frio.png', 65.00, 'Bebidas Frías', 'Bebida', 'Español latte frío', 13),
('Bebidas', 'Mocca, cajeta, crema irlandesa, vainilla, caramelo.', 1, '/assets/menuItems/latte-frio-sabor.png', 65.00, 'Bebidas Frías', 'Bebida', 'Latte frío con sabor', 13),
('Bebidas', 'Bebida fría con café suave y textura cremosa', 1, '/assets/menuItems/latte-frio.png', 60.00, 'Bebidas Frías', 'Bebida', 'Latte frío', 13),
('Bebidas', 'Té verde y coco combinados en una mezcla helada', 1, '/assets/menuItems/matcha-coco-frio.png', 80.00, 'Bebidas Frías', 'Bebida', 'Matcha coco latte frío', 13),
('Bebidas', 'Té matcha con fresa en versión fría y cremosa', 1, '/assets/menuItems/matcha-fresa.png', 75.00, 'Bebidas Frías', 'Bebida', 'Matcha fresa latte frío', 13),
('Bebidas', 'Bebida fría con sabor a té verde y acabado suave', 1, '/assets/menuItems/matcha-latte-frio.png', 65.00, 'Bebidas Frías', 'Bebida', 'Matcha latte frío', 13),
('Bebidas', 'Fusión helada de taro y coco con textura cremosa', 1, '/assets/menuItems/taro-coco-latte.png', 80.00, 'Bebidas Frías', 'Bebida', 'Taro coco latte frío', 13),
('Bebidas', 'Mezcla fría de taro con un toque afrutado', 1, '/assets/menuItems/taro-fresa-latte.png', 75.00, 'Bebidas Frías', 'Bebida', 'Taro fresa latte frío', 13),
('Bebidas', 'Mezcla fría de taro', 1, '/assets/menuItems/taro-latte-frio.png', 65.00, 'Bebidas Frías', 'Bebida', 'Taro latte frío', 13);

INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Bebidas', 'Café frío con toque de ginger ale especiado', 1, '/assets/menuItems/coldbrew-gingerel.png', 70.00, 'Frias', 'Bebida', 'Cold brew Gingerale', 5);

INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Bebidas', 'Café frío con leche para una mezcla suave', 1, '/assets/menuItems/coldbrew-latte', 70.00, 'Frias', 'Bebida', 'Cold brew latte', 5);

INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Bebidas', 'Preparado frío con notas cítricas y tostadas', 1, '/assets/menuItems/coldbrew-sunrise.png', 70.00, 'Frias', 'Bebida', 'Cold brew Sunrise', 5);

INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Bebidas', 'Bebida energética con café y sabor intenso', 1, '/assets/menuItems/monster.png', 70.00, 'Frias', 'Bebida', 'Monster americano', 5);