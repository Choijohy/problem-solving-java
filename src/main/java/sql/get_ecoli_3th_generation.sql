with recursive cte as(
    select
        id,
        0 as generation,
        id as root
    from ECOLI_DATA
    where PARENT_ID is NULL

    union all

    select
        a.id,
        b.generation +1 as generation,
        b.root as root

    from ECOLI_DATA a
    join cte b on b.id = a.PARENT_ID
)
select cte.ID from cte where generation = 2 order by id;


# select * from ECOLI_DATA;