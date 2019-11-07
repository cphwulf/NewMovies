use shop;
select count(o.ShipperID) as total, o.ShipperID from orders as o
right join shippers s on s.ShipperID = o.ShipperID group by o.ShipperID;
