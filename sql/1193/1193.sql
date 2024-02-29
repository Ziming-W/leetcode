select CONCAT(YEAR(trans_date), '-', LPAD(MONTH(trans_date), 2, '0')) as month, country, count(*) as trans_count, SUM(CASE WHEN state = 'approved' then 1 else 0 END) as approved_count,
sum(amount) as trans_total_amount, sum(CASE WHEN state="approved" THEN amount ELSE 0 END) as approved_total_amount
from Transactions
group by country, extract(month from trans_date)