CREATE ALGORITHM=UNDEFINED DEFINER=`mdrozdz`@`localhost` SQL SECURITY DEFINER VIEW `sports_facility`.`invoice_data` AS
select `sports_facility`.`customers`.`first_name` AS `C First Name`,`sports_facility`.`customers`.`last_name` AS `C Last Name`,
`sports_facility`.`customers`.`address` AS `C Address`,`sports_facility`.`employees`.`first_name` AS `first_name`,
`sports_facility`.`employees`.`last_name` AS `last_name`,`sports_facility`.`employees`.`address` AS `address`,
`sports_facility`.`services`.`name` AS `name`,`sports_facility`.`services`.`price` AS `price`,
`sports_facility`.`purchases`.`purchase_date` AS `purchase_date`
from ((((`sports_facility`.`purchases` join `sports_facility`.`employees`
on((`sports_facility`.`employees`.`id` = `sports_facility`.`purchases`.`employee_id`)))
join `sports_facility`.`customers` on((`sports_facility`.`customers`.`id` = `sports_facility`.`purchases`.`customer_id`)))
left join `sports_facility`.`purchases_services` on((`sports_facility`.`purchases`.`id` = `sports_facility`.`purchases_services`.`purchase_id`)))
left join `sports_facility`.`services` on((`sports_facility`.`purchases_services`.`service_id` = `sports_facility`.`services`.`id`)));
