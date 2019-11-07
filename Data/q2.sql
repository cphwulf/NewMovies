use shop;
select p.price, o.quantity from order_details o, products p
where o.ProductID = p.ProductID;
