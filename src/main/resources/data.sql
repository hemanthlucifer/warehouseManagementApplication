INSERT INTO goodown (goodown_Id,location,goodown_manager,goodown_image) VALUES ('GI-1','Ongole','Hemanth','https://img.freepik.com/premium-photo/large-clean-warehouse-storage-room-with-boxes-merchandise-generative-ai_634358-850.jpg');
INSERT INTO goodown (goodown_Id,location,goodown_manager,goodown_image) VALUES ('GI-2','Hyderabad','Hemanth','https://t4.ftcdn.net/jpg/01/81/65/85/360_F_181658575_6gz3Gx96iRndmBtXv2llVsGOGsfdT1AP.jpg');
INSERT INTO goodown (goodown_Id,location,goodown_manager,goodown_image) VALUES ('GI-3','Banglore','Hemanth','https://c1.wallpaperflare.com/preview/504/595/594/warehouse-large-nice.jpg');
INSERT INTO goodown (goodown_Id,location,goodown_manager,goodown_image) VALUES ('GI-4','Chennai','Hemanth','https://img.freepik.com/free-photo/large-warehouse-with-bright-light-coming-through-door_123827-23506.jpg');
INSERT INTO goodown (goodown_Id,location,goodown_manager,goodown_image) VALUES ('GI-5','Mumbai','Hemanth','https://cdn.pixabay.com/photo/2017/02/05/21/12/abandoned-2041218_640.jpg');
INSERT INTO goodown (goodown_Id,location,goodown_manager,goodown_image) VALUES ('GI-6','Vizag','Hemanth','https://t3.ftcdn.net/jpg/04/61/05/50/360_F_461055011_7loYFoVN9ZnpZRCRJnoFgusfVMWacC4M.jpg');
INSERT INTO goodown (goodown_Id,location,goodown_manager,goodown_image) VALUES ('GI-7','Hyderabad','Hemanth','https://images.pexels.com/photos/236705/pexels-photo-236705.jpeg?cs=srgb&dl=pexels-pixabay-236705.jpg&fm=jpg');
INSERT INTO goodown (goodown_Id,location,goodown_manager,goodown_image) VALUES ('GI-8','Mumbai','Hemanth','https://wallpapercave.com/wp/wp3702624.jpg');
INSERT INTO goodown (goodown_Id,location,goodown_manager,goodown_image) VALUES ('GI-9','Banglore','Hemanth','https://c1.wallpaperflare.com/preview/599/926/330/factory-warehouse-boxes-capitalism.jpg');
INSERT INTO goodown (goodown_Id,location,goodown_manager,goodown_image) VALUES ('GI-10','Chennai','Hemanth','https://watermark.lovepik.com/photo/20220304/large/lovepik-logistics-warehouse-workers-work-exchange-picture_502363560.jpg');
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
(3,'manager@warehouse.com', 'GI-2'),
(4,'manager@warehouse.com', 'GI-3'),
(5,'manager@warehouse.com', 'GI-4'),
(6,'support@warehouse.com', 'GI-1');





