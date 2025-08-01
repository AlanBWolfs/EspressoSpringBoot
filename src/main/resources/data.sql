-- =========================
-- RESET Y LIMPIEZA
-- =========================
SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE productos;
TRUNCATE TABLE subsubcategorias;
TRUNCATE TABLE subcategorias;
TRUNCATE TABLE categorias;

SET FOREIGN_KEY_CHECKS = 1;

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
('Especiales Bebidas', 2);

-- =========================
-- SUB-SUBCATEGORÍAS
-- =========================
-- Alimentos -> Desayunos
INSERT INTO subsubcategorias (nombre, id_subcategoria) VALUES
('Huevos', 1),         -- id = 1
('Chilaquiles', 1);    -- id = 2

-- Alimentos -> Especiales
INSERT INTO subsubcategorias (nombre, id_subcategoria) VALUES
('Toast', 2),          -- id = 3
('Bagels', 2),         -- id = 4
('Dogopizza', 2),      -- id = 5
('Ensalada', 2);       -- id = 6

-- Alimentos -> Extras
INSERT INTO subsubcategorias (nombre, id_subcategoria) VALUES
('Productos Extras', 3); -- id = 7

-- Bebidas -> Bebidas Frías
INSERT INTO subsubcategorias (nombre, id_subcategoria) VALUES
('Frozen', 5),         -- id = 8
('Refresh', 5),        -- id = 9
('Bebidas Frías', 5),  -- id = 10
('Pre Workout', 5);    -- id = 11

-- Bebidas -> Bebidas Calientes
INSERT INTO subsubcategorias (nombre, id_subcategoria) VALUES
('Bebidas Calientes', 4); -- id = 12

-- Bebidas -> Especiales
INSERT INTO subsubcategorias (nombre, id_subcategoria) VALUES
('Shots', 6);           -- id = 13

-- =========================
-- PRODUCTOS
-- =========================

-- Alimentos -> Desayunos -> Huevos
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Alimentos','2 huevos batidos con champiñones, tomate cherry y queso Monterrey Jack, acompañados de salsa a elegir (roja o verde), frijoles refritos y totoposte.',1,'/assets/menuItems/ommelette.jpg',90.00,'Desayunos','Plato','Omelette de jamón y queso Monterrey Jack',1),
('Alimentos','2 huevos revueltos con jamón de pavo acompañados de frijoles fritos, plátanos y totoposte.',1,'/assets/menuItems/huevos2.png',80.00,'Desayunos','Plato','Huevos clásicos',1),
('Alimentos','2 huevos revueltos con salchicha de res acompañados de frijoles fritos, plátanos y totoposte.',1,'/assets/menuItems/huevos.png',85.00,'Desayunos','Plato','Huevos beef',1),
('Alimentos','2 huevos revueltos con tomate, cebolla y chile serrano acompañados de frijoles fritos, plátanos y totoposte.',1,'/assets/menuItems/huevos.png',80.00,'Desayunos','Plato','Huevos a la Mexicana',1),
('Alimentos','2 huevos revueltos con longaniza de la región acompañados de frijoles fritos, plátanos y totoposte.',1,'/assets/menuItems/huevos.png',85.00,'Desayunos','Plato','Huevos Jabalí',1),
('Alimentos','2 huevos estrellados sobre tortilla, queso y jamón, bañados con salsa (verde o roja) y chícharos, con frijoles y plátanos fritos.',1,'/assets/menuItems/huevos.png',100.00,'Desayunos','Plato','Huevos Motuleños',1);

-- Alimentos -> Desayunos -> Chilaquiles
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Alimentos','Totopos fritos bañados en salsa roja o verde, con crema, queso Monterrey Jack, aguacate y cebolla curtida.',1,'/assets/menuItems/chilaquiles.png',100.00,'Desayunos','Plato','Chilaquiles rojos o verdes',2);

-- Alimentos -> Especiales -> Toast
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Alimentos','Toast con aguacate, queso crema, tomate cherry y jamón serrano.',1,'/assets/menuItems/toastjamon.png',90.00,'Especiales','Plato','Jamon Serrano',3),
('Alimentos','Toast con guacamole, queso crema, tomate cherry y salmón ahumado.',1,'/assets/menuItems/toastsalmon.png',100.00,'Especiales','Plato','Salmon Ahumado',3),
('Alimentos','Toast con aguacate, queso crema, tomate cherry y huevo estrellado.',1,'/assets/menuItems/toasthuevo.png',90.00,'Especiales','Plato','Huevos estrellados',3),
('Alimentos','Toast dulce con queso crema y coulis de frutas (durazno, fresa, maracuyá, piña o moras).',1,'/assets/menuItems/dulces.png',75.00,'Especiales','Plato','Dulces',3);

-- Alimentos -> Especiales -> Bagels
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Alimentos','Bagel con jamón serrano, guacamole, queso crema y hojas verdes.',1,'/assets/menuItems/dulces.png',85.00,'Especiales','Plato','Jamon Serrano',4),
('Alimentos','Bagel con salmón ahumado, guacamole y aderezo de la casa.',1,'/assets/menuItems/bagelsalmon.png',95.00,'Especiales','Plato','Salmon ahumado',4),
('Alimentos','Bagel con huevo estrellado, guacamole y queso crema.',1,'/assets/menuItems/bagelhuevo.png',85.00,'Especiales','Plato','Huevos estrellados',4),
('Alimentos','Bagel clásico con guacamole y aderezo.',1,'/assets/menuItems/dulces.png',80.00,'Especiales','Plato','Clasico',4);

-- Alimentos -> Especiales -> Dogopizza
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Alimentos','Hotdog estilo pizza con champiñón y queso Monterrey Jack.',1,'/assets/menuItems/hotdogcham.png',75.00,'Especiales','Plato','Champiñon',5),
('Alimentos','Hotdog estilo pizza hawaiano con piña y queso.',1,'/assets/menuItems/hot.png',75.00,'Especiales','Plato','Hawaiano',5),
('Alimentos','Hotdog estilo pizza con pepperoni y queso Monterrey Jack.',1,'/assets/menuItems/hot.png',75.00,'Especiales','Plato','Pepperoni',5);

-- Alimentos -> Especiales -> Ensalada
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Alimentos','Ensalada fresca con espinaca, queso crema, arándanos, nueces y aderezo miel-mostaza.',1,'/assets/menuItems/Ensalada.png',75.00,'Especiales','Plato','Ensalada fresca',6);

-- Alimentos -> Extras
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Alimentos','Snack ligero y crujiente, ideal para compartir.',1,'/assets/menuItems/logo-verde.png',25.00,'Extras','Extra','Palomitas',7),
('Alimentos','Agua natural 600ml.',1,'/assets/menuItems/water.png',16.00,'Extras','Extra','Agua',7),
('Alimentos','Agua de coco Amper.',1,'/assets/menuItems/water.png',37.00,'Extras','Extra','Amper agua de coco',7),
('Alimentos','Cambio de leche vegetal o deslactosada.',1,'/assets/menuItems/logo-verde.png',12.00,'Extras','Extra','Cambio de leche',7),
('Alimentos','Jugo natural de frutas.',1,'/assets/menuItems/frozen.png',18.00,'Extras','Extra','Jugos',7),
('Alimentos','Powerade isotónico.',1,'/assets/menuItems/frozenmango.png',30.00,'Extras','Extra','Powerade',7),
('Alimentos','Refresco o agua mineral.',1,'/assets/menuItems/water.png',25.00,'Extras','Extra','Refresco, agua mineral',7),
('Alimentos','Shot extra de café.',1,'/assets/menuItems/espresso.png',15.00,'Extras','Extra','Shot extra café',7);

-- Bebidas -> Especiales Bebidas -> Shots
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Bebidas','Helado doble de vainilla con un shot de espresso.',1,'/assets/menuItems/affogato.png',70.00,'Especiales Bebidas','Bebida','Affogato',13),
('Bebidas','Helado doble con espresso y un shot de Baileys.',1,'/assets/menuItems/affogato.png',80.00,'Especiales Bebidas','Bebida','Affogato especial',13),
('Bebidas','Vino espumoso lambrusco, Coca-Cola y rodajas de limón.',1,'/assets/menuItems/carajillo.png',70.00,'Especiales Bebidas','Bebida','Calimocho',13),
('Bebidas','Licor especiado con espresso doble.',1,'/assets/menuItems/carajillo.png',70.00,'Especiales Bebidas','Bebida','Carajillo',13),
('Bebidas','Licor especiado con espresso y Baileys.',1,'/assets/menuItems/carajillo.png',80.00,'Especiales Bebidas','Bebida','Carajillo especial',13),
('Bebidas','Vino espumoso lambrusco, limón, agua mineral y ginger ale.',1,'/assets/menuItems/frozenberry.png',70.00,'Especiales Bebidas','Bebida','Tinto de verano',13);

-- Bebidas -> Calientes -> Bebidas Calientes
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Bebidas','Bebida caliente con sabor intenso y tostado.',1,'/assets/menuItems/espresso.png',45.00,'Bebidas Calientes','Bebida','Americano',12),
('Bebidas','Mezcla cremosa y dulce de cacao.',1,'/assets/menuItems/espresso.png',65.00,'Bebidas Calientes','Bebida','Chocolate',12),
('Bebidas','Infusión especiada con café y notas dulces.',1,'/assets/menuItems/latte.png',70.00,'Bebidas Calientes','Bebida','Dirty chai latte',12),
('Bebidas','Espresso con leche y dulzor.',1,'/assets/menuItems/latte.png',65.00,'Bebidas Calientes','Bebida','Español latte',12),
('Bebidas','Preparación concentrada de café.',1,'/assets/menuItems/espresso.png',30.00,'Bebidas Calientes','Bebida','Espresso',12),
('Bebidas','Espresso con un toque de leche.',1,'/assets/menuItems/espresso.png',40.00,'Bebidas Calientes','Bebida','Espresso doble cortado',12),
('Bebidas','Método de extracción: V60, Chemex o prensa francesa.',1,'/assets/menuItems/espresso.png',70.00,'Bebidas Calientes','Bebida','Filtrado de especialidad',12),
('Bebidas','Café latte cremoso.',1,'/assets/menuItems/latte.png',60.00,'Bebidas Calientes','Bebida','Latte',12),
('Bebidas','Latte con sabores: mocca, cajeta, vainilla, caramelo, etc.',1,'/assets/menuItems/latte.png',65.00,'Bebidas Calientes','Bebida','Latte con sabor',12),
('Bebidas','Té verde con leche.',1,'/assets/menuItems/matcha.png',65.00,'Bebidas Calientes','Bebida','Matcha latte',12),
('Bebidas','Té de taro cremoso.',1,'/assets/menuItems/matcha.png',65.00,'Bebidas Calientes','Bebida','Taro latte',12),
('Bebidas','Infusión frutal y floral.',1,'/assets/menuItems/tea.png',55.00,'Bebidas Calientes','Bebida','Tizana',12);

-- Bebidas -> Frías -> Frozen
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Bebidas','Frozen chai vainilla.',1,'/assets/menuItems/frozen.png',85.00,'Bebidas Frías','Bebida','Chai vainilla frozen',8),
('Bebidas','Batido de fresa con yogurt.',1,'/assets/menuItems/malteada.png',75.00,'Bebidas Frías','Bebida','Fresa yogurt',8),
('Bebidas','Yogurt batido con frutos rojos.',1,'/assets/menuItems/malteada.png',75.00,'Bebidas Frías','Bebida','Frutos rojos yogurt',8),
('Bebidas','Combinación cremosa de maracuyá y coco.',1,'/assets/menuItems/frozenmango.png',75.00,'Bebidas Frías','Bebida','Maracoco yogurt',8),
('Bebidas','Yogurt de maracuyá tropical.',1,'/assets/menuItems/frozenmango.png',75.00,'Bebidas Frías','Bebida','Maracuyá yogurt',8),
('Bebidas','Matcha frozen.',1,'/assets/menuItems/icedmatcha.png',85.00,'Bebidas Frías','Bebida','Matcha Frozen',8),
('Bebidas','Frozen taro.',1,'/assets/menuItems/icedmatcha.png',85.00,'Bebidas Frías','Bebida','Taro frozen',8),
('Bebidas','Frozen zarzamora con yogurt.',1,'/assets/menuItems/frozenberry.png',75.00,'Bebidas Frías','Bebida','Zarzamora yogurt',8);

-- Bebidas -> Frías -> Refresh
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Bebidas','Refresh de fresa, base a elegir: limonada, agua mineral o leche.',1,'/assets/menuItems/frozen.png',55.00,'Bebidas Frías','Bebida','Fresa refresh',9),
('Bebidas','Refresh de mango, base a elegir.',1,'/assets/menuItems/frozenmango.png',55.00,'Bebidas Frías','Bebida','Mango refresh',9),
('Bebidas','Refresh de manzana verde.',1,'/assets/menuItems/frozenberry.png',55.00,'Bebidas Frías','Bebida','Manzana verde refresh',9),
('Bebidas','Refresh de moras.',1,'/assets/menuItems/frozenberry.png',55.00,'Bebidas Frías','Bebida','Moras refresh',9);

-- Bebidas -> Frías -> Bebidas Frías
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Bebidas','Americano frío.',1,'/assets/menuItems/icedcoffee.png',50.00,'Bebidas Frías','Bebida','Americano frío',10),
('Bebidas','Español latte frío.',1,'/assets/menuItems/icedcoffee.png',65.00,'Bebidas Frías','Bebida','Español latte frío',10),
('Bebidas','Latte frío con sabores.',1,'/assets/menuItems/frappe.png',65.00,'Bebidas Frías','Bebida','Late frío con sabor',10),
('Bebidas','Latte frío clásico.',1,'/assets/menuItems/frappe.png',60.00,'Bebidas Frías','Bebida','Latte frío',10),
('Bebidas','Matcha con coco frío.',1,'/assets/menuItems/icedmatcha.png',80.00,'Bebidas Frías','Bebida','Matcha / coco latte frío',10),
('Bebidas','Matcha con fresa frío.',1,'/assets/menuItems/icedmatcha.png',75.00,'Bebidas Frías','Bebida','Matcha / fresa latte frío',10),
('Bebidas','Cold brew Gingerale.',1,'/assets/menuItems/icedcoffee.png',70.00,'Bebidas Frías','Bebida','Cold brew Gingerale',10),
('Bebidas','Taro latte frío.',1,'/assets/menuItems/frappe.png',65.00,'Bebidas Frías','Bebida','Taro latte frío',10);

-- Bebidas -> Frías -> Pre Workout
INSERT INTO productos (categoria, descripcion, en_menu, imagen, precio, subcategoria, tipo, nombre, id_subsubcategoria) VALUES
('Bebidas','A base de betabel, miel de agave y naranja.',1,'/assets/menuItems/icedcoffee.png',60.00,'Bebidas Frías','Bebida','Pre Workout',11);
