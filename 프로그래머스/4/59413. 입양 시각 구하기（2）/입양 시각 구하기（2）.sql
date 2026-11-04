with recursive hours as(
    select 0 as hour
    union all
    select hour + 1
    from hours
    where hour < 23
)

select h.hour, count(animal_id) as count
from animal_outs as o
right join hours as h
on h.hour = hour(o.datetime)
group by h.hour
order by h.hour;

