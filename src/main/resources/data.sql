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



    insert into subscribers(login, password, roles) values ('QWE', '$2a$10$v34jyZyknnQywXsBlW2ozef5f35759MZTDQb/F8mk0PDiK91IdwCG', ('{0}'))