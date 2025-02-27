with cte as(
    select
        food_type,
        max(coalesce(favorites,0)) as max_favorites
    from rest_info
    group by food_type
)
select
    info.FOOD_TYPE,
    info.REST_ID,
    info.REST_NAME,
    info.FAVORITES
from rest_info info
join cte on info.food_type = cte.food_type and info.favorites = cte.max_favorites
order by info.food_type desc


