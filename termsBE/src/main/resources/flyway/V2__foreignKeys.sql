
ALTER TABLE city
  ADD CONSTRAINT FK_CountryCity FOREIGN KEY (country_id) REFERENCES country(id) on delete cascade;

ALTER TABLE region
  ADD CONSTRAINT FK_CityRegion FOREIGN KEY (city_id) REFERENCES city(id) on delete cascade;

ALTER TABLE playground
  ADD CONSTRAINT FK_PlaygroundsCity FOREIGN KEY (region_id) REFERENCES region(id) on delete cascade;

ALTER TABLE playground_info
  ADD CONSTRAINT FK_PlaygrdInfosPlaygrd FOREIGN KEY (playground_id) REFERENCES playground(id) on delete cascade;

ALTER TABLE user
  ADD CONSTRAINT FK_regionUser FOREIGN KEY (region_id) REFERENCES region(id);

ALTER TABLE component
  ADD CONSTRAINT FK_roleComponents FOREIGN KEY (role_id) REFERENCES role(id);

ALTER TABLE registration_playground
  ADD CONSTRAINT FK_RegistrationsPlaygrounds FOREIGN KEY (user_id) REFERENCES user(id);

ALTER TABLE reservation
  ADD CONSTRAINT FK_ReservationsUser FOREIGN KEY (user_id) REFERENCES user(id);

ALTER TABLE reservation
  ADD CONSTRAINT FK_ReservationsPlaygroundsRegistrations FOREIGN KEY (playground_reservation_id) REFERENCES registration_playground(id);

ALTER TABLE role_user
  ADD CONSTRAINT FK_UserManyToMany FOREIGN KEY (user_id) REFERENCES user(id);
ALTER TABLE role_user
  ADD CONSTRAINT FK_RoleManyToMany FOREIGN KEY (role_id) REFERENCES role(id);

