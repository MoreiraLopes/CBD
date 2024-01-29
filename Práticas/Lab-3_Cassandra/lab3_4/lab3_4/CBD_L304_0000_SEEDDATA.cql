USE cbd_107572_ex4;


INSERT INTO users (user_id, username, email, interests) VALUES (1, 'Alex', 'alex@example.com', {'music', 'sports', 'technology'});
INSERT INTO users (user_id, username, email, interests) VALUES (2, 'John', 'john@example.com', {'travel', 'photography'});
INSERT INTO users (user_id, username, email, interests) VALUES (3, 'johnsmith', 'johnsmith@example.com', {'movies', 'music'});
INSERT INTO users (user_id, username, email, interests) VALUES (4, 'maryjones', 'mary@example.com', {'books', 'art'});
INSERT INTO users (user_id, username, email, interests) VALUES (5, 'davidlee', 'david@example.com', {'sports', 'fitness'});
INSERT INTO users (user_id, username, email, interests) VALUES (6, 'sarahbrown', 'sarah@example.com', {'travel', 'cooking'});
INSERT INTO users (user_id, username, email, interests) VALUES (7, 'laurawilliams', 'laura@example.com', {'fashion', 'design'});
INSERT INTO users (user_id, username, email, interests) VALUES (8, 'michaelwilson', 'michael@example.com', {'technology', 'coding'});
INSERT INTO users (user_id, username, email, interests) VALUES (9, 'emilydavis', 'emily@example.com', {'photography', 'nature'});
INSERT INTO users (user_id, username, email, interests) VALUES (10, 'andrewmartinez', 'andrew@example.com', {'science', 'astronomy'});
INSERT INTO users (user_id, username, email, interests) VALUES (11, 'olivialopez', 'olivia@example.com', {'health', 'wellness'});
INSERT INTO users (user_id, username, email, interests) VALUES (12, 'ethanjackson', 'ethan@example.com', {'gaming', 'computers'});


INSERT INTO products (product_id, name, category, tags, attributes) VALUES (1, 'Smartphone', 'Electronics', {'gadget', 'tech'}, {'color': 'black', 'weight': '2kg'});
INSERT INTO products (product_id, name, category, tags, attributes) VALUES (2, 'Denim Jeans', 'Clothing', {'fashion', 'style'}, {'size': 'M', 'color': 'blue'});
INSERT INTO products (product_id, name, category, tags, attributes) VALUES (3, 'Laptop', 'Electronics', {'gadget', 'tech'}, {'color': 'white', 'weight': '1.5kg'});
INSERT INTO products (product_id, name, category, tags, attributes) VALUES (4, 'Dress Shirt', 'Clothing', {'casual', 'style'}, {'size': 'L', 'color': 'red'});
INSERT INTO products (product_id, name, category, tags, attributes) VALUES (5, 'Coffee Table', 'Home', {'decor', 'furniture'}, {'material': 'wood', 'color': 'brown'});
INSERT INTO products (product_id, name, category, tags, attributes) VALUES (6, 'Lip Gloss', 'Beauty', {'makeup', 'skincare'}, {'type': 'lipstick', 'color': 'pink'});
INSERT INTO products (product_id, name, category, tags, attributes) VALUES (7, 'Dumbbell Set', 'Sports', {'outdoors', 'fitness'}, {'equipment': 'dumbbells', 'weight': '5kg'});
INSERT INTO products (product_id, name, category, tags, attributes) VALUES (8, 'Crime Thriller Book', 'Books', {'fiction', 'novel'}, {'author': 'John Doe', 'pages': '300'});
INSERT INTO products (product_id, name, category, tags, attributes) VALUES (9, 'Building Blocks', 'Toys', {'kids', 'play'}, {'age_group': '3-6', 'material': 'plastic'});
INSERT INTO products (product_id, name, category, tags, attributes) VALUES (10, 'Potato Chips', 'Food', {'grocery', 'snacks'}, {'type': 'chips', 'flavor': 'spicy'});
INSERT INTO products (product_id, name, category, tags, attributes) VALUES (11, 'Gold Necklace', 'Jewelry', {'accessories', 'bling'}, {'type': 'necklace', 'material': 'gold'});
INSERT INTO products (product_id, name, category, tags, attributes) VALUES (12, 'Smartwatch', 'Electronics', {'smart', 'devices'}, {'type': 'smartwatch', 'color': 'silver'});


INSERT INTO orders (order_id, user_id, products, order_date) VALUES (1, 1, [1, 2], toTimestamp(now()));
INSERT INTO orders (order_id, user_id, products, order_date) VALUES (2, 2, [2, 1], toTimestamp(now()));
INSERT INTO orders (order_id, user_id, products, order_date) VALUES (3, 3, [3, 2], toTimestamp(now()));
INSERT INTO orders (order_id, user_id, products, order_date) VALUES (4, 4, [4, 1], toTimestamp(now()));
INSERT INTO orders (order_id, user_id, products, order_date) VALUES (5, 5, [5, 1, 6, 2], toTimestamp(now()));
INSERT INTO orders (order_id, user_id, products, order_date) VALUES (6, 6, [7, 2], toTimestamp(now()));
INSERT INTO orders (order_id, user_id, products, order_date) VALUES (7, 7, [8, 1, 9, 1], toTimestamp(now()));
INSERT INTO orders (order_id, user_id, products, order_date) VALUES (8, 8, [10, 1], toTimestamp(now()));
INSERT INTO orders (order_id, user_id, products, order_date) VALUES (9, 9, [11, 1, 12, 2], toTimestamp(now()));
INSERT INTO orders (order_id, user_id, products, order_date) VALUES (10, 10, [3, 1], toTimestamp(now()));
INSERT INTO orders (order_id, user_id, products, order_date) VALUES (11, 11, [4, 1, 5, 1], toTimestamp(now()));
INSERT INTO orders (order_id, user_id, products, order_date) VALUES (12, 12, [6, 2], toTimestamp(now()));

INSERT INTO feedbacks (feedback_id, product_id, user_id, rating, comment, timestamp) VALUES (1, 1, 1, 5, 'Great product!', toTimestamp(now()));
INSERT INTO feedbacks (feedback_id, product_id, user_id, rating, comment, timestamp) VALUES (2, 2, 2, 4, 'Good quality.', toTimestamp(now()));
INSERT INTO feedbacks (feedback_id, product_id, user_id, rating, comment, timestamp) VALUES (3, 3, 3, 4, 'Enjoyed using it.', toTimestamp(now()));
INSERT INTO feedbacks (feedback_id, product_id, user_id, rating, comment, timestamp) VALUES (4, 4, 4, 5, 'Great quality product!', toTimestamp(now()));
INSERT INTO feedbacks (feedback_id, product_id, user_id, rating, comment, timestamp) VALUES (5, 5, 5, 4, 'Satisfied with the purchase.', toTimestamp(now()));
INSERT INTO feedbacks (feedback_id, product_id, user_id, rating, comment, timestamp) VALUES (6, 6, 6, 3, 'Could be better.', toTimestamp(now()));
INSERT INTO feedbacks (feedback_id, product_id, user_id, rating, comment, timestamp) VALUES (7, 7, 7, 5, 'Excellent equipment!', toTimestamp(now()));
INSERT INTO feedbacks (feedback_id, product_id, user_id, rating, comment, timestamp) VALUES (8, 8, 8, 4, 'Good book.', toTimestamp(now()));
INSERT INTO feedbacks (feedback_id, product_id, user_id, rating, comment, timestamp) VALUES (9, 9, 9, 3, 'Not bad.', toTimestamp(now()));
INSERT INTO feedbacks (feedback_id, product_id, user_id, rating, comment, timestamp) VALUES (10, 10, 10, 5, 'Highly recommended!', toTimestamp(now()));
INSERT INTO feedbacks (feedback_id, product_id, user_id, rating, comment, timestamp) VALUES (11, 11, 11, 4, 'Interesting story.', toTimestamp(now()));
INSERT INTO feedbacks (feedback_id, product_id, user_id, rating, comment, timestamp) VALUES (12, 12, 12, 3, 'Good functionality.', toTimestamp(now()));