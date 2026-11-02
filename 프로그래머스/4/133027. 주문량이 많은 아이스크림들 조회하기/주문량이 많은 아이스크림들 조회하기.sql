select flavor
from (
    select shipment_id, flavor, total_order
    from first_half as f
    
    union all
    
    select max(shipment_id), flavor, sum(total_order)
    from july
    group by flavor
) as total
group by flavor
order by sum(total_order) desc
limit 3;
