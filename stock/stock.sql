select * from finnhub_stocks order by id;
select * from finnhub_stock_prices;
select * from finnhub_stock_symbols;

drop table finnhub_stocks;
create table finnhub_stocks (
	id BIGSERIAL PRIMARY KEY,
	country varchar(2) ,
	company_name varchar(100) ,
	ipo_date date ,
	logo varchar(200),
    market_cap numeric(15, 2) ,
	currency varchar(3)
)

drop table finnhub_stock_prices;
create table finnhub_stocks_prices (
	id BIGSERIAL PRIMARY KEY,
	stock_id integer REFERENCES finnhub_stocks(id),
	datetime TIMESTAMP ,
	current_price numeric(15,2) ,
	day_high numeric(15,2) ,
	day_low numeric(15,2) ,
	day_open numeric(15,2) ,
	prev_day_close numeric(15,2) 
)



alter table finnhub_stocks_prices alter column stock_id TYPE BIGINT;

ALTER TABLE finnhub_stocks_prices
ALTER COLUMN stock_id
SET DATA TYPE BIGINT;
	
select s.id, s.country, s.company_name, s.ipo_date, s.logo, s.market_cap, s.currency 
from finnhub_stocks s 
where s.id = 4;










