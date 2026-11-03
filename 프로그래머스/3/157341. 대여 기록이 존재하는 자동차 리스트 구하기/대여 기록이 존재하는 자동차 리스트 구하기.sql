with history as (
    select car_id
    from car_rental_company_rental_history
    where month(start_date) = 10
    group by car_id
)

select car_id
from car_rental_company_car
where car_id in (
    select car_id
    from car_rental_company_rental_history
    where month(start_date) = 10
    group by car_id
)
    and car_type like ('세단')
order by car_id desc