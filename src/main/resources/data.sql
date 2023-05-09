    insert into telephone_exchanges(first_two_digits, number)
    values ('12', '1234567');

    insert into telephone_exchanges(first_two_digits, number)
    values ('89', '890765');

    insert into telephone_exchanges(first_two_digits, number)
    values ('23', '2366777');

    insert into telephone_exchanges(first_two_digits, number)
    values ('45', '4532111');

    insert into telephone_exchanges(first_two_digits, number)
    values ('64', '6455555');

    insert into phone_numbers(phone, exchange_id, subscriber_id) values('89012321', 1, 1);
    insert into phone_numbers(phone, exchange_id, subscriber_id) values('8437589345874839',1,  1);
    insert into phone_numbers(phone, exchange_id,  subscriber_id) values('4782940543', 1,  2);
    insert into phone_numbers(phone, exchange_id,  subscriber_id) values('12345678910', 1,  2);
    insert into phone_numbers(phone, exchange_id,  subscriber_id) values('890765234123413', 2,  2);
    insert into phone_numbers(phone, exchange_id,  subscriber_id) values('23667775645645', 3,  2);


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


    insert into subscribers(login, password, roles) values ('qwe', '$2a$10$v34jyZyknnQywXsBlW2ozef5f35759MZTDQb/F8mk0PDiK91IdwCG', ('{0}'));
    insert into subscribers(login, password, roles) values ('QWE', '$2a$10$v34jyZyknnQywXsBlW2ozef5f35759MZTDQb/F8mk0PDiK91IdwCG', ('{0}'));

