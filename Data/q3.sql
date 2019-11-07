use shop;
select FORMAT(sum(p.price * o.quantity),0) as total, CategoryID from order_details o, products p
where o.ProductID = p.ProductID group by CategoryID order by 1 asc;
