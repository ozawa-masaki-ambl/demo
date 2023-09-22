CREATE TABLE Customers (
    customer_id integer PRIMARY KEY,
    customer_name varchar(32),
    email varchar(256),
    phone_number varchar(16),
    address varchar(124)
);

CREATE TABLE Products (
    product_id integer PRIMARY KEY,
    product_name varchar(32),
    price integer
);

CREATE TABLE Purchase_History (
    purchase_id integer PRIMARY KEY,
    customer_id integer REFERENCES Customers(customer_id) NOT NULL,
    product_id integer REFERENCES Products(product_id) NOT NULL,
    purchase_datetime timestamp NOT NULL,
    quantity integer NOT NULL
);
