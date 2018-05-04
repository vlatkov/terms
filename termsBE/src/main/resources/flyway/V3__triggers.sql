
DELIMITER $$
DROP TRIGGER IF EXISTS `reservation_after_insert` $$
CREATE TRIGGER `reservation_after_insert`
AFTER INSERT ON `reservation`
FOR EACH ROW
  BEGIN

    SET @price = (select number_players from playground_info pi
      join registration_playground rp on pi.playground_id = rp.playground_id
      join playground p on p.id = pi.playground_id
    where pr.id = new.id);

    SET @nums = (select number_players from playground_info pi
      join registration_playground rp on pi.playground_id = rp.playground_id
      join playground p on p.id = pi.playground_id
    where pr.id = new.id);

    INSERT INTO resertavion_audit (id, user_id, playground_reservation_id, start_time, end_time, price, number_player)
    VALUES (NEW.id, NEW.user_id, NEW.playground_reservation_id, NEW.start_time, NEW.end_time, @price, @nums);
  END $$
DELIMITER ;