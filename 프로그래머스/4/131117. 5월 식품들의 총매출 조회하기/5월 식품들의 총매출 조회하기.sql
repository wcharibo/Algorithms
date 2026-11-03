with cte as(
select product_id, sum(amount) as amount
from food_order
where year(produce_date) = 2022
    and month(produce_date) = 5
group by product_id
)

select p.product_id, p.product_name, (o.amount * p.price) as total_sales
from cte o
join food_product p
    on o.product_id = p.product_id
order by o.amount * p.price desc, p.product_id;