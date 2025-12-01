CREATE TABLE sale (
    id INT PRIMARY KEY,
    customer_id INTEGER,
    company_id INTEGER NOT NULL,
    sale_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    total_value DECIMAL(12,2) NOT NULL DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (customer_id) REFERENCES customer(id),
    FOREIGN KEY (company_id) REFERENCES company(id)
);