select distinct l.cart_id
from cart_products as l
join cart_products as r
on l.cart_id = r.cart_id
    and l.name like 'yogurt'
    and r.name like 'milk'
order by l.cart_id