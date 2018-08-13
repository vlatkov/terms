
ALTER TABLE city
  ADD CONSTRAINT FK_CountryCity FOREIGN KEY (country_id) REFERENCES country(id) on delete cascade;

ALTER TABLE region
  ADD CONSTRAINT FK_CityRegion FOREIGN KEY (city_id) REFERENCES city(id) on delete cascade;


ALTER TABLE place
  ADD CONSTRAINT FK_PlaceInfosPlace FOREIGN KEY (place_info_id) REFERENCES place_info(id) on delete cascade;


ALTER TABLE component
  ADD CONSTRAINT FK_roleComponents FOREIGN KEY (role_id) REFERENCES role(id);



ALTER TABLE sub_category
  ADD CONSTRAINT FK_SubCategoryCategory FOREIGN KEY (category_id) REFERENCES category(id);


ALTER TABLE registration_place
  ADD CONSTRAINT FK_RegistrationsUser FOREIGN KEY (user_id) REFERENCES user(id);

ALTER TABLE registration_place
  ADD CONSTRAINT FK_RegistrationsPlace FOREIGN KEY (place_id) REFERENCES place(id);


ALTER TABLE place
  ADD CONSTRAINT FK_PlaceRegion FOREIGN KEY (region_id) REFERENCES region(id) on delete cascade;

ALTER TABLE place
  ADD CONSTRAINT FK_PlaceSubcategory FOREIGN KEY (sub_category_id) REFERENCES sub_category(id) on delete cascade;




ALTER TABLE reservation
  ADD CONSTRAINT FK_ReservationsUser FOREIGN KEY (user_id) REFERENCES user(id);

ALTER TABLE reservation
  ADD CONSTRAINT FK_ReservationsPlaceRegistrations FOREIGN KEY (place_reservation_id) REFERENCES registration_place(id);

ALTER TABLE reservation
  ADD CONSTRAINT FK_ReservationsReservationsState FOREIGN KEY (reservation_state_id) REFERENCES reservation_state(id);



ALTER TABLE notification
  ADD CONSTRAINT FK_NotificationUser FOREIGN KEY (user_id) REFERENCES user(id);

ALTER TABLE notification
  ADD CONSTRAINT FK_NotificationState FOREIGN KEY (notification_state_id) REFERENCES notification_state(id);

ALTER TABLE notification
  ADD CONSTRAINT FK_NotificationReservation FOREIGN KEY (reservation_id) REFERENCES reservation(id);

ALTER TABLE notification
  ADD CONSTRAINT FK_NotificationType FOREIGN KEY (notification_type_id) REFERENCES notification_type(id);

ALTER TABLE notification
  ADD CONSTRAINT FK_NotificationContent FOREIGN KEY (notification_content_id) REFERENCES notification_content(id);

ALTER TABLE role_user
  ADD CONSTRAINT FK_UserManyToMany FOREIGN KEY (user_id) REFERENCES user(id);

ALTER TABLE role_user
  ADD CONSTRAINT FK_RoleManyToMany FOREIGN KEY (role_id) REFERENCES role(id);


ALTER TABLE region_user
  ADD CONSTRAINT FK_UserRegionManyToMany FOREIGN KEY (user_id) REFERENCES user(id);

ALTER TABLE region_user
  ADD CONSTRAINT FK_RegionUserManyToMany FOREIGN KEY (region_id) REFERENCES region(id);


ALTER TABLE place_comment
  ADD CONSTRAINT FK_PlaceCommentManyToMany FOREIGN KEY (place_id) REFERENCES place(id);

ALTER TABLE place_comment
  ADD CONSTRAINT FK_CommentPlaceManyToMany FOREIGN KEY (comment_id) REFERENCES comment(id);