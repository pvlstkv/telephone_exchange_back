insert into cities(name)
values ('Ульяновск');
insert into cities(name)
values ('Самара');
insert into cities(name)
values ('Казань');
insert into cities(name)
values ('Саранск');
insert into cities(name)
values ('Пенза');



insert into districts(name, city_id)
values ('Засвияжский', (select id from cities where name = 'Ульяновск'));
insert into districts(name, city_id)
values ('Ленинский', (select id from cities where name = 'Ульяновск'));
insert into districts(name, city_id)
values ('Железнодорожный', (select id from cities where name = 'Ульяновск'));
insert into districts(name, city_id)
values ('Засволжский', (select id from cities where name = 'Ульяновск'));
insert into districts(name, city_id)
values ('Центральный', (select id from cities where name = 'Самара'));
insert into districts(name, city_id)
values ('Куйбышевский', (select id from cities where name = 'Самара'));
insert into districts(name, city_id)
values ('Центральный', (select id from cities where name = 'Казань'));



    insert into telephone_exchanges(first_two_digits, number, district_id)
    values ('12', '1234567', 1);
    insert into telephone_exchanges(first_two_digits, number, district_id)
    values ('89', '890765', 2);
    insert into telephone_exchanges(first_two_digits, number, district_id)
    values ('23', '2366777', 2);
    insert into telephone_exchanges(first_two_digits, number, district_id)
    values ('45', '4532111', 3);
    insert into telephone_exchanges(first_two_digits, number, district_id)
    values ('64', '6455555', 4);


    insert into subscribers(type, installation_date, login, name, password, roles, exchange_id)
    values (0, now()::date, 'qwe', 'qwerty', '$2a$10$v34jyZyknnQywXsBlW2ozef5f35759MZTDQb/F8mk0PDiK91IdwCG', ('{0}'), 1);

insert into subscribers(type, installation_date, login, name, password, roles, exchange_id)
values (0, now()::date - 2, 'AstukovPN', 'astukov', '$2a$10$v34jyZyknnQywXsBlW2ozef5f35759MZTDQb/F8mk0PDiK91IdwCG', ('{0}'), 1);

insert into subscribers(type, installation_date, login, name, password, roles, exchange_id)
values (1, now()::date - 5, 'ivanov&co', 'ООО Ivanov&Co', '$2a$10$v34jyZyknnQywXsBlW2ozef5f35759MZTDQb/F8mk0PDiK91IdwCG', ('{0}'), 1);

insert into subscribers(type, installation_date, login, name, password, roles)
values (1, now()::date - 15, 'petrov&co', 'ООО Petrov&Co', '$2a$10$v34jyZyknnQywXsBlW2ozef5f35759MZTDQb/F8mk0PDiK91IdwCG', ('{0}'));

insert into subscribers(type, installation_date, login, name, password, roles)
values (1,now()::date - 25,'astukov&co', 'ООО Astukov&Co', '$2a$10$v34jyZyknnQywXsBlW2ozef5f35759MZTDQb/F8mk0PDiK91IdwCG', ('{0}'));

insert into phone_numbers(phone, exchange_id, subscriber_id) values('89012321', 1, 1);
insert into phone_numbers(phone, exchange_id, subscriber_id) values('8437589345874839',1,  1);
insert into phone_numbers(phone, exchange_id,  subscriber_id) values('4782940543', 1,  2);
insert into phone_numbers(phone, exchange_id,  subscriber_id) values('12345678910', 1,  2);
insert into phone_numbers(phone, exchange_id,  subscriber_id) values('890765234123413', 2,  2);
insert into phone_numbers(phone, exchange_id,  subscriber_id) values('23667775645645', 3,  2);


insert into phone_numbers(phone, exchange_id) values('23232323232323', 3);
insert into phone_numbers(phone, exchange_id) values('23333333333333', 3);
insert into phone_numbers(phone, exchange_id) values('23000000000000', 3);


