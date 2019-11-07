use shop;
select sum(p.price * o.quantity) from order_details o, products p
where o.ProductID = p.ProductID;
