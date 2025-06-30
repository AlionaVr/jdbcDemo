INSERT INTO customers (name, surname, age, phone_number)
VALUES ('Alexey', 'Ivanov', 30, '1234567890'),
       ('alexey', 'Petrov', 25, '0987654321'),
       ('ALEXEY', 'Sidorov', 40, '1112223333'),
       ('Maria', 'Smirnova', 28, '2223334444'),
       ('John', 'Doe', 35, '3334445555');

INSERT INTO orders (customer_id, product_name, amount)
VALUES (1, 'Laptop', 1),
       (2, 'Smartphone', 2),
       (3, 'Headphones', 1),
       (4, 'Book', 3),
       (5, 'Tablet', 1);