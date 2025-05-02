with quarter_type as(
    select '1Q' as QUARTER
    union all select '2Q'
    union all select '3Q'
    union all select '4Q'
),
ecoli as(
    select
        id,
        case
            when month(differentiation_date) >= 10 then '4Q'
            when month(differentiation_date) >= 7 then '3Q'
            when month(differentiation_date) >= 4 then '2Q'
            else '1Q'
        end as quarter
    #concat(QUARTER(DIFFERENTIATION_DATE),'Q') as quarter
    from ecoli_data
)
select
    q.QUARTER as QUARTER,
    count(e.id) as ECOLI_COUNT
from quarter_type q
left join ecoli e on q.quarter = e.quarter
group by q.quarter
order by q.quarter