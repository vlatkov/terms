INSERT INTO role(name, description) VALUE ('ROLE_ADMIN', 'Rola administratora profila');
INSERT INTO role(name, description) VALUE ('ROLE_USER', 'Rola korisničkog profila');
INSERT INTO role(name, description) VALUE ('ROLE_SUPERUSER', 'Rola superuser profila');

INSERT into country(name, code, flag_url) VALUES("Crna Gora", "382", null);
INSERT into country(name, code, flag_url) VALUES("Srbija", "381", null);
INSERT into country(name, code, flag_url) VALUES("Republika Srpska", "387", null) ;
INSERT into country(name, code, flag_url) VALUES("Hrvatska", "385", null);

INSERT INTO city(country_id, name, code, flag_url) VALUES (1,"Podgorica",81000,null);
INSERT INTO city(country_id, name, code, flag_url) VALUES (2,"Beograg",11000,null);
INSERT INTO city(country_id, name, code, flag_url) VALUES (2,"Novi Sad",21000,null);
INSERT INTO city(country_id, name, code, flag_url) VALUES (3,"Banjaluka",84000,null);
INSERT INTO city(country_id, name, code, flag_url) VALUES (1,"Žabljak",52000,null);
INSERT INTO city(country_id, name, code, flag_url) VALUES (1,"Nikšić",82000,null);
INSERT INTO city(country_id, name, code, flag_url) VALUES (1,"Budva",89000,null);
INSERT INTO city(country_id, name, code, flag_url) VALUES (1,"Kotor",25000,null);

INSERT INTO region(city_id, name, code, flag_url) VALUES (1,"Zagorič",81120, null);
INSERT INTO region(city_id, name, code, flag_url) VALUES (1,"Tološi",81130, null);
INSERT INTO region(city_id, name, code, flag_url) VALUES (1,"Stari Aerodrom",81150, null);
INSERT INTO region(city_id, name, code, flag_url) VALUES (1,"Masline",81420, null);
INSERT INTO region(city_id, name, code, flag_url) VALUES (1,"Zelenika",81620, null);
INSERT INTO region(city_id, name, code, flag_url) VALUES (1,"Drač",81162, null);
INSERT INTO region(city_id, name, code, flag_url) VALUES (1,"Centar",81100, null);
INSERT INTO region(city_id, name, code, flag_url) VALUES (5,"Ravni Žabljak",52100, null);
INSERT INTO region(city_id, name, code, flag_url) VALUES (2,"Blok 1",11100, null);
INSERT INTO region(city_id, name, code, flag_url) VALUES (2,"Banovo Brdo",11103, null);
INSERT INTO region(city_id, name, code, flag_url) VALUES (2,"Žarkovo",11120, null);
INSERT INTO region(city_id, name, code, flag_url) VALUES (2,"Blok 45",11150, null);
INSERT INTO region(city_id, name, code, flag_url) VALUES (3,"Liman",21150, null);

insert into category(name, description) VALUES ('Sport', 'Sportske aktivnosti');
insert into category(name, description) VALUES ('Zdravstvo', 'Zdravstvene ustanove');

insert into sub_category(category_id, name, description) VALUES (1,'Mali fudbal', 'Tereni za mali fudbal');
insert into sub_category(category_id, name, description) VALUES (2,'Laboratorija', 'Zdravstvena ustanova');

insert into place_info(price, number_participants, place_type) VALUES (20,12,'Otvoreni teren');
insert into place_info(price, number_participants, place_type) VALUES (25,12,'Otvoreni teren');

INSERT INTO place(region_id, sub_category_id, name, description, location_lat, location_lng, active, place_info_id) VALUES (1,1,"Teren1","Opis 1", 11.1111,12.1111, 1, 2);
INSERT INTO place(region_id, sub_category_id, name, description, location_lat, location_lng, active, place_info_id) VALUES (1,1,"Teren2","Opis 2", 11.2221,14.1221, 1, 2);
INSERT INTO place(region_id, sub_category_id, name, description, location_lat, location_lng, active, place_info_id) VALUES (1,2,"Lab1","Opis 3", 11.2221,14.1221, 1, 1);
INSERT INTO place(region_id, sub_category_id, name, description, location_lat, location_lng, active, place_info_id) VALUES (1,2,"Lab2","Opis 4", 13.2221,10.1221, 1, 1);

