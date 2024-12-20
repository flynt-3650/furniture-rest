DROP TABLE IF EXISTS order_item CASCADE;
DROP TABLE IF EXISTS client_order CASCADE;
DROP TABLE IF EXISTS item CASCADE;
DROP TABLE IF EXISTS item_category CASCADE;
DROP TABLE IF EXISTS client CASCADE;

-- Client Table
CREATE TABLE client (
    id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone_number VARCHAR(20),
    address VARCHAR(255)
);

-- Item Category Table
CREATE TABLE item_category (
    id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    category_name VARCHAR(50) NOT NULL
);

-- Item Table
CREATE TABLE item (
    id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    item_name VARCHAR(100) NOT NULL,
    price NUMERIC(10, 2) NOT NULL CHECK (price >= 0),
    category_id INTEGER REFERENCES item_category(id)
);

-- Client Order Table (Renamed)
CREATE TABLE client_order (
    id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    client_id INTEGER REFERENCES client(id) ON DELETE CASCADE,
    order_date DATE NOT NULL DEFAULT CURRENT_DATE,
    total_amount NUMERIC(10, 2) NOT NULL CHECK (total_amount >= 0)
);

-- Order Item Table
CREATE TABLE order_item (
    id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    order_id INTEGER REFERENCES client_order(id) ON DELETE CASCADE,
    item_id INTEGER REFERENCES item(id) ON DELETE CASCADE,
    quantity INTEGER NOT NULL CHECK (quantity > 0)
);

-- Insert Clients
INSERT INTO client (first_name, last_name, email, phone_number, address) VALUES
('Ivan', 'Repilov', 'ivan.repilov@example.com', '+7916678345', '1 Arbat, Moscow, Russia'),
('Olga', 'Ivanova', 'olga.ivanova@example.com', '+79165891234', '12 Pushkin St, Moscow, Russia'),
('Sergey', 'Petrov', 'sergey.petrov@example.com', '+79161234567', '5 Tverskaya St, St. Petersburg, Russia'),
('Anna', 'Sidorova', 'anna.sidorova@example.com', '+79161239876', '10 Nevsky Ave, St. Petersburg, Russia'),
('Dmitry', 'Kuznetsov', 'dmitry.kuznetsov@example.com', '+79161234568', '4 Tverskaya St, Moscow, Russia'),
('Maria', 'Smirnova', 'maria.smirnova@example.com', '+79165892345', '6 Lenin St, Moscow, Russia'),
('Alexey', 'Volkov', 'alexey.volkov@example.com', '+79165897654', '20 Red Square, Moscow, Russia');

-- Insert Item Categories
INSERT INTO item_category (category_name) VALUES
('Chairs'), ('Tables'), ('Sofas'), ('Beds'), ('Wardrobes');

-- Insert Items
INSERT INTO item (item_name, price, category_id) VALUES
('Wooden Chair', 45.00, 1),
('Dining Table', 120.00, 2),
('Leather Sofa', 300.00, 3),
('King Bed', 500.00, 4),
('Sliding Wardrobe', 200.00, 5),
('Plastic Chair', 15.00, 1),
('Coffee Table', 60.00, 2),
('Fabric Sofa', 250.00, 3);

-- Insert Client Orders with client_id references
INSERT INTO client_order (id, client_id, order_date, total_amount) VALUES
(1, 1, '2024-10-01', 90.00),
(2, 2, '2024-10-02', 300.00),
(3, 3, '2024-10-03', 540.00),
(4, 4, '2024-10-04', 360.00),
(5, 5, '2024-10-05', 60.00),
(6, 6, '2024-10-06', 500.00),
(7, 7, '2024-10-07', 250.00);

-- Insert Order Items
INSERT INTO order_item (order_id, item_id, quantity) VALUES
(1, 1, 2), -- Ivan ordered 2 Wooden Chairs
(2, 3, 1), -- Olga ordered 1 Leather Sofa
(3, 4, 1), -- Sergey ordered 1 King Bed
(3, 5, 1), -- Sergey ordered 1 Sliding Wardrobe
(4, 6, 4), -- Anna ordered 4 Plastic Chairs
(5, 7, 1), -- Dmitry ordered 1 Coffee Table
(6, 4, 1), -- Maria ordered 1 King Bed
(7, 8, 1); -- Alexey ordered 1 Fabric Sofa


--SELECT * FROM client;
--SELECT * FROM client_order;
--SELECT * FROM order_item;
--SELECT * FROM item;
--SELECT * FROM item_category;
--
--SELECT
--    co.id AS order_id,
--    c.id AS client_id,
--    c.first_name,
--    c.last_name,
--    c.address,
--    oi.quantity,
--    i.item_name,
--    i.price,
--    ic.category_name
--FROM
--    client c
--JOIN
--    client_order co ON c.id = co.client_id
--JOIN
--    order_item oi ON co.id = oi.order_id
--JOIN
--    item i ON oi.item_id = i.id
--JOIN
--    item_category ic ON i.category_id = ic.id
