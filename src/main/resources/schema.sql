CREATE TABLE user(id BIGINT NOT NULL PRIMARY KEY,
email VARCHAR(255),
is_admin BOOLEAN NOT NULL,
is_seller BOOLEAN NOT NULL,
name VARCHAR(255)
);


CREATE TABLE product_category(category_name VARCHAR(255) NOT NULL PRIMARY KEY);

CREATE TABLE product_type(product_type VARCHAR(255) NOT NULL PRIMARY KEY,
product_category_category_name VARCHAR(255));

ALTER TABLE product_type ADD FOREIGN KEY (product_category_category_name) REFERENCES product_category(category_name);