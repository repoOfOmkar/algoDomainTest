INSERT INTO user(id, email, is_admin, is_seller, name) VALUES(1111, 'abcd@xyz.com', false, false, 'Rohit');
INSERT INTO user(id, email, is_admin, is_seller, name) VALUES(2222, 'abc@xyz.com', true, false, 'Rohan');
INSERT INTO user(id, email, is_admin, is_seller, name) VALUES(3333, 'ab@xyz.com', false, true, 'Karan');

INSERT INTO product_category(category_name) VALUES('electronics');
INSERT INTO product_category(category_name) VALUES('health');
INSERT INTO product_category(category_name) VALUES('food');

INSERT INTO product_type(product_type, product_category_category_name) VALUES('laptop', 'electronics');
INSERT INTO product_type(product_type, product_category_category_name) VALUES('headset', 'electronics');

INSERT INTO product_type(product_type, product_category_category_name) VALUES('medicine', 'health');
INSERT INTO product_type(product_type, product_category_category_name) VALUES('cream', 'health');

INSERT INTO product_type(product_type, product_category_category_name) VALUES('chips', 'food');
INSERT INTO product_type(product_type, product_category_category_name) VALUES('cake', 'food');