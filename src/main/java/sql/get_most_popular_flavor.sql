select f.flavor
from first_half f
left join
(select flavor, sum(total_order) as total
from july
group by flavor) as j on f.flavor = j.flavor
group by f.flavor
order by sum(coalesce(f.total_order,0)+coalesce(j.total,0)) desc
limit 3;