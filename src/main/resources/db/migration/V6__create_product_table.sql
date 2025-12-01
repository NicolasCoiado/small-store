CREATE TABLE product (
    id int PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    stock_quantity INTEGER NOT NULL DEFAULT 0,
    company_id INTEGER NOT NULL,
    FOREIGN KEY (company_id) REFERENCES company(id)
);