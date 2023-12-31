CREATE TABLE Customers (
    customer_id integer PRIMARY KEY,
    customer_name varchar(32),
    email varchar(256),
    phone_number varchar(16),
    address varchar(124)
);
COMMENT ON TABLE Customers IS '購入者テーブル';
COMMENT ON COLUMN Customers.customer_id IS '顧客ID';
COMMENT ON COLUMN Customers.customer_name IS '顧客の名前';
COMMENT ON COLUMN Customers.email IS 'メールアドレス';
COMMENT ON COLUMN Customers.phone_number IS '電話番号';
COMMENT ON COLUMN Customers.address IS '住所';

CREATE TABLE Products (
    product_id integer PRIMARY KEY,
    product_name varchar(32),
    price integer
);
COMMENT ON TABLE Products IS '商品テーブル';
COMMENT ON COLUMN Products.product_id IS '商品ID';
COMMENT ON COLUMN Products.product_name IS '商品の名前';
COMMENT ON COLUMN Products.price IS '商品の価格';

CREATE TABLE Purchase_History (
    purchase_id integer PRIMARY KEY,
    customer_id integer REFERENCES Customers(customer_id) NOT NULL,
    product_id integer REFERENCES Products(product_id) NOT NULL,
    purchase_datetime timestamp NOT NULL,
    quantity integer NOT NULL
);
COMMENT ON TABLE Purchase_History IS '購入履歴テーブル';
COMMENT ON COLUMN Purchase_History.purchase_id IS '購入履歴ID';
COMMENT ON COLUMN Purchase_History.customer_id IS '顧客ID';
COMMENT ON COLUMN Purchase_History.product_id IS '商品ID';
COMMENT ON COLUMN Purchase_History.purchase_datetime IS '購入日時';
COMMENT ON COLUMN Purchase_History.quantity IS '購入数量';
