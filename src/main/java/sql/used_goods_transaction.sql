SELECT
    user.USER_ID,
    user.NICKNAME,
    sum(board.price) as TOTAL_SALES
FROM used_goods_user user
JOIN used_goods_board board on user.user_id = board.writer_id
WHERE board.status = "DONE"
group by user.user_id
having TOTAL_SALES >= 700000
order by TOTAL_SALES