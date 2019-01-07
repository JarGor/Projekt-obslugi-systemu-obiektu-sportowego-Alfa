create temporary table `sports_facility`.`top3_services`
select `sports_facility`.`services`.`id`,
`sports_facility`.`services`.`name`,
`sports_facility`.`services`.`price`,
count(*) as `count`
from `sports_facility`.`services` join `sports_facility`.`purchases_services`
on `sports_facility`.`services`.`id` = `sports_facility`.`purchases_services`.`service_id`
group by `sports_facility`.`purchases_services`.`service_id`
order by `count` desc limit 3;

select * from `sports_facility`.`top3_services`;

drop temporary table `sports_facility`.`top3_services`;