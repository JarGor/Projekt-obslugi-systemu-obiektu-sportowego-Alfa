DELIMITER $$
CREATE DEFINER=`mdrozdz`@`localhost` PROCEDURE `add_service`(IN id INT(11),
								IN service_name VARCHAR(45),
								IN price INT(11))
DECLARE exit handler for sqlexception
   
	BEGIN

		ROLLBACK;
	END;

	
	START TRANSACTION;

	INSERT INTO `services` (`id`, `name`, `price`)

	VALUES (id, service_name, price);
	COMMIT;
END$$
DELIMITER ;
