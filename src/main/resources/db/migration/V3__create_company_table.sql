CREATE TABLE company (
    id INT PRIMARY KEY,
    cnpj VARCHAR(20) NOT NULL UNIQUE,
    name VARCHAR(255) NOT NULL,
    address_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (address_id) REFERENCES address(id)
);