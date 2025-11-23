CREATE TABLE address (
    id INT PRIMARY KEY,
    cep VARCHAR(11),
    state states,
    city VARCHAR(100),
    neighborhood VARCHAR(100),
    number VARCHAR(30)
);