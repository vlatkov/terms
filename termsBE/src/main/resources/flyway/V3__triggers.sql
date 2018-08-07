
DELIMITER $$
DROP TRIGGER IF EXISTS `reservation_after_insert` $$
CREATE TRIGGER `reservation_after_insert`
AFTER INSERT ON `reservation`
FOR EACH ROW
  BEGIN

    SET @price = (select price from place_info pi
      join registration_place rp on pi.place_id = rp.place_id
      join place p on p.id = pi.place_id
    where pr.id = new.id);

    SET @nums = (select number_players from place_info pi
      join registration_place rp on pi.place_id = rp.place_id
      join place p on p.id = pi.place_id
    where pr.id = new.id);

    INSERT INTO resertavion_audit (id, user_id, place_reservation_id, start_time, end_time, price, number_participant)
    VALUES (NEW.id, NEW.user_id, NEW.place_reservation_id, NEW.start_time, NEW.end_time, @price, @nums);
  END $$
DELIMITER ;