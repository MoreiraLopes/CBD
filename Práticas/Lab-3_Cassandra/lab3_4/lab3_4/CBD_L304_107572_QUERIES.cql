use cbd_107572_ex4;


--2 indexes
DROP INDEX IF EXISTS cat;
CREATE INDEX cat ON products(category);

DROP INDEX IF EXISTS user;
CREATE INDEX user ON users(username);


--5 updates
-- Update user interests for user_id 1 by adding 'programming'
UPDATE users SET interests = interests + {'programming'} WHERE user_id = 1;

-- Update the comment for feedback_id 3
UPDATE feedbacks SET comment = 'Loved using it!' WHERE feedback_id = 3;

-- Update the name of the product with product_id 5
UPDATE products SET name = 'Center Table' WHERE product_id = 5;

-- Update the first product in the order for order_id 10
UPDATE orders SET products[0] = 9 WHERE order_id = 10;

-- Update the rating of feedback_id 11
UPDATE feedbacks SET rating = 5 WHERE feedback_id = 11;


--5 deletes

-- Delete the feedback with feedback_id 6
DELETE FROM feedbacks WHERE feedback_id = 6;

-- Remove product with product_id 11
DELETE FROM products WHERE product_id = 11;

-- Remove the user with user_id 2
DELETE FROM users WHERE user_id = 2;

-- Delete the product with product_id 8
DELETE FROM products WHERE product_id = 8;

-- Delete the feedback with feedback_id 5
DELETE FROM feedbacks WHERE feedback_id = 5;



--10 queries

--1. Select all usernames and emails of users:
SELECT username, email FROM users;

--2. Fetch the names and categories of all products:
SELECT name, category FROM products;

--3. Retrieve the order IDs, user IDs, and ordered products for all orders:
SELECT order_id, user_id, products FROM orders;

--4. Get the feedback comments and ratings for all products:
SELECT comment, rating FROM feedbacks;

--5. Retrieve the usernames and their associated interests for all users:
SELECT username, interests FROM users;

--6. Fetch the names, categories, and tags for products where category is 'Electronics':
SELECT name, category, tags FROM products WHERE category = 'Electronics';

--7. Retrieve the order IDs and user IDs for orders where the user ID is greater than 5.
SELECT order_id, user_id FROM orders WHERE user_id > 5 ALLOW FILTERING;

--8. Retrieve Electronics Products Ordered by Product ID Ascending.
SELECT product_id, name, category, attributes FROM products WHERE category = 'Electronics' ORDER BY product_id ASC;

--9. retrieves the product_id, name, category, and attributes of the first 5 records from the products table.
SELECT product_id, name, category, attributes FROM products LIMIT 5;

--10. Get all orders from user_id 7
SELECT order_id, user_id, products, order_date FROM orders WHERE user_id = 7 ALLOW FILTERING ;