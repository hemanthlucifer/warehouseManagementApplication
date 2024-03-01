INSERT INTO goodown (goodown_Id,location,goodown_manager) VALUES ('GI-1','Ongole','Hemanth');
INSERT INTO goodown (goodown_Id,location,goodown_manager) VALUES ('GI-2','Hyderabad','Hemanth');
INSERT INTO goodown (goodown_Id,location,goodown_manager) VALUES ('GI-3','Banglore','Hemanth');
INSERT INTO goodown (goodown_Id,location,goodown_manager) VALUES ('GI-4','Chennai','Hemanth');
INSERT INTO goodown (goodown_Id,location,goodown_manager) VALUES ('GI-5','Mumbai','Hemanth');
INSERT INTO goodown (goodown_Id,location,goodown_manager) VALUES ('GI-6','Vizag','Hemanth');
INSERT INTO goodown (goodown_Id,location,goodown_manager) VALUES ('GI-7','Hyderabad','Hemanth');
INSERT INTO goodown (goodown_Id,location,goodown_manager) VALUES ('GI-8','Mumbai','Hemanth');
INSERT INTO goodown (goodown_Id,location,goodown_manager) VALUES ('GI-9','Banglore','Hemanth');
INSERT INTO goodown (goodown_Id,location,goodown_manager) VALUES ('GI-10','Chennai','Hemanth');
INSERT INTO category (category_id, goodown_id, goodown_capacity, occupied_capacity, available_capacity)
VALUES
('Laptop', 1, 100, 20, 80),
('Mobile', 1, 150, 50, 100),
('Desktop', 1, 200, 100, 100);

INSERT INTO store (store_id, store_name,store_location,no_of_order_for_store) VALUES(1,'product store','Hyderabad',10);
INSERT INTO goodown_product (product_id, product_manufacturer, product_version, product_description, goodown_id, category_id, quantity, store_id)
VALUES
('1', 'Lenovo', 'ideapad', '16 gb ram laptop', 1, 'Laptop', 10, 1),
('2', 'Iphone', '15 pro', 'Premium quality product', 1, 'Mobile', 20, 1),
('3', 'Dell', 'vostro', '16 gb ram desktop', 1, 'Desktop', 15, 1);

INSERT INTO warehouse_order (order_id, store_id, goodown_id, order_placed_date, received_date, is_on_time, quality)
VALUES
('ed50dbb0-d66d', 1, 'GI-1', '2023-01-15', '2023-01-20', true, 'GOOD'),
('73194319-3f09', 1, 'GI-1', '2023-01-16', '2023-01-21', false, 'GOOD'),
('d4e74b9a-4eab', 1, 'GI-1', '2023-01-17', '2023-01-22', true, 'POOR');

INSERT INTO order_product (product_id, category_id, product_name, manufacturer_id, product_price, quantity_ordered)
VALUES
('P001', 'Laptop', 'Ideapad Laptop', 'Lenovo', 40000, 10),
('P002', 'Mobile', 'Iphone 15 pro', 'Iphone', 100000, 15),
('P003', 'Desktop', 'Vostro', 'Dell', 45990, 20);

INSERT INTO order_group (group_id, order_id, product_id)
VALUES
(1, 'ed50dbb0-d66d', 'P001'),
(2, 'ed50dbb0-d66d', 'P002'),
(3, 'ed50dbb0-d66d', 'P003');

INSERT INTO user (email_id, user_name, password, role)
VALUES
('admin@warehouse.com', 'admin user', 'password123', 'ADMIN'),
('manager@warehouse.com', 'managing user', 'securepass', 'MANAGER'),
('support@warehouse.com', 'support', '123456', 'SUPPORT');

INSERT INTO user_goodown (user_goodown_id,email_id, goodown_id)
VALUES
(1,'admin@warehouse.com', 'GI-1'),
(2,'manager@warehouse.com', 'GI-1'),
(3,'support@warehouse.com', 'GI-1');





