-- level:3
-- concat()
SELECT
    CONCAT("/home/grep/src/",board.BOARD_ID,"/",FILE_ID,FILE_NAME,FILE_EXT) AS FILE_PATH
FROM USED_GOODS_BOARD board
LEFT JOIN USED_GOODS_FILE file ON board.BOARD_ID = file.BOARD_ID
WHERE VIEWS = (SELECT MAX(VIEWS) FROM USED_GOODS_BOARD)
ORDER BY file.FILE_ID DESC