with cte as(
    select ID, SIZE_OF_COLONY,
    percent_rank() over (order by SIZE_OF_COLONY desc) as RANK_PERCENTAGE
    from ECOLI_DATA
)
select
    cte.ID,
        case
            when (RANK_PERCENTAGE <= 0.25) then 'CRITICAL'
            when (RANK_PERCENTAGE <= 0.50) then 'HIGH'
            when (RANK_PERCENTAGE <= 0.75) then 'MEDIUM'
            else 'LOW'
        end as COLONY_NAME
from cte
order by cte.ID;

