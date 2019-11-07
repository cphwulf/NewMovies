use shop;
select count(*) as total, s.ShipperID from shippers as s, orders as o
where s.ShipperID = o.ShipperID group by s.ShipperID;
