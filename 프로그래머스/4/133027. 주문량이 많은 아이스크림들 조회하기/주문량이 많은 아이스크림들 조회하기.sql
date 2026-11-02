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

WITH CTE AS(
    SELECT *, SUM(TOTAL_ORDER) AS FL_TOTAL_ORDER
    FROM JULY
    GROUP BY FLAVOR
)

SELECT IFNULL(F.FLAVOR, J.FLAVOR) AS FLAVOR
FROM FIRST_HALF AS F
LEFT JOIN CTE AS J ON F.FLAVOR = J.FLAVOR
ORDER BY F.TOTAL_ORDER + J.FL_TOTAL_ORDER DESC LIMIT 3;
