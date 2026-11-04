-- 코드를 입력하세요
select user_id, nickname, concat_ws(' ', city, street_address1, street_address2) as '전체주소', concat_ws('-' ,left(tlno, 3), substr(tlno, 4, 4), right(tlno, 4)) as '전화번호'
from used_goods_user
where user_id in (
    select writer_id
    from used_goods_board
    group by writer_id
    having count(board_id) >= 3
)
order by user_id desc;
