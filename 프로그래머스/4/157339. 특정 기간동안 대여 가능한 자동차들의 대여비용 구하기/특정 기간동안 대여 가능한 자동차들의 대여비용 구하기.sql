with car as (select car_id, car_type, daily_fee * 30 / 10000 as daily_fee
from car_rental_company_car
where car_id not in (
    select car_id
    from car_rental_company_rental_history
    where timestampdiff(day, start_date, '2022-11-30') >= 1
        and timestampdiff(day, '2022-11-01', end_date) >= 1
)
and car_type in ('세단', 'SUV'))

select c.car_id, c.car_type, c.daily_fee * (1 - d.discount_rate/100) * 10000 as fee
from car as c
join (
    select car_type, discount_rate
    from car_rental_company_discount_plan
    where duration_type like ('30일 이상')
) as d
on c.car_type = d.car_type
where c.daily_fee * (1 - d.discount_rate/100) >= 50
    and c.daily_fee * (1 - d.discount_rate/100) < 200
    


