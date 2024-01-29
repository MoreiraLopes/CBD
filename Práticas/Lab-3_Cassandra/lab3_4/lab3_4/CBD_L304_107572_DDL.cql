CREATE KEYSPACE IF NOT EXISTS cbd_107572_ex4 WITH replication = {'class': 'SimpleStrategy','replication_factor': 1};
USE cbd_107572_ex4;


CREATE TABLE IF NOT EXISTS users (
    user_id int PRIMARY KEY,
    username text,
    email text,
    interests set<text>
);

CREATE TABLE IF NOT EXISTS products (
    product_id int,
    name text,
    category text,
    tags set<text>,
    attributes map<text, text>,
    PRIMARY KEY ((category), product_id)
);


CREATE TABLE IF NOT EXISTS orders (
    order_id int PRIMARY KEY,
    user_id int,
    products list<int>,
    order_date timestamp
);

CREATE TABLE IF NOT EXISTS feedbacks (
    feedback_id int PRIMARY KEY,
    product_id int,
    user_id int,
    rating int,
    comment text,
    timestamp timestamp
);