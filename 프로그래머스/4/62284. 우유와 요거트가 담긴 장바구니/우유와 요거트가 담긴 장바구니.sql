-- 코드를 입력하세요
with cte as(SELECT *, group_concat(name order by price separator ', ') as c
from cart_products
group by cart_id
having c like('%milk%') and c like('%yogurt%'))

select cart_id
from cte
order by cart_id