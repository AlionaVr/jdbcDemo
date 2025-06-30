CREATE TABLE CUSTOMERS
(
    id           serial PRIMARY KEY,
    name         VARCHAR(60) NOT NULL,
    surname      VARCHAR(60) NOT NULL,
    age          INT         NOT NULL CHECK ( age > 0 and age < 110),
    phone_number VARCHAR(10) NOT NULL
);

CREATE TABLE ORDERS
(
    id           serial PRIMARY KEY,
    date         DATE DEFAULT CURRENT_DATE,
    customer_id  INT          NOT NULL,
    product_name VARCHAR(100) NOT NULL,
    amount       INT          NOT NULL CHECK (amount > 0),
    FOREIGN KEY (customer_id) REFERENCES CUSTOMERS (id)
);
