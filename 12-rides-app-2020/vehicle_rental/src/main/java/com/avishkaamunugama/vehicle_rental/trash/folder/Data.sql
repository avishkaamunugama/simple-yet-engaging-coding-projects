insert into  vehicle ( dtype , plate_no ,availability, engine_capacity , fuel_consumption, make , model, transmission , mileage_on_full_tank , type_of_bike    )  values ('Bike','BBO6892',true,'125','50km/l','Bajaj','Disovery','manual',1000,'Normal');
insert into  vehicle ( dtype , plate_no ,availability, engine_capacity , fuel_consumption, make , model, transmission , mileage_on_full_tank , type_of_bike    )  values ('Bike','BBQ1234',true,'1200','10km/l','Honda','CBR','manual',1000,'Racing');
insert into  vehicle ( dtype , plate_no ,availability, engine_capacity , fuel_consumption, make , model, transmission , mileage_on_full_tank , type_of_bike    )  values ('Bike','WW5674',true,'180','30km/l','Bajaj','Pulsar','manual',1000,'Normal');
insert into  vehicle ( dtype , plate_no ,availability, engine_capacity , fuel_consumption, make , model, transmission , mileage_on_full_tank , type_of_bike    )  values ('Bike','BCA9435',true,'200','60km/l','Honda','JB200','manual',1000,'Trailer');

insert into vehicle (dtype , plate_no , availability , engine_capacity , fuel_consumption , make , model , transmission , seating_capacity , leg_space , max_load , ground_clearance , number_of_doors  ) values ('Car','KY6892',true,'1500','20km/l','Toyota','Aqua','auto',7,20.5,450,5,5);
insert into vehicle (dtype , plate_no , availability , engine_capacity , fuel_consumption , make , model , transmission , seating_capacity , leg_space , max_load , ground_clearance , number_of_doors  ) values ('Car','KY6076',true,'1500','25km/l','Toyota','Axio','auto',7,20.5,450,5,5);
insert into vehicle (dtype , plate_no , availability , engine_capacity , fuel_consumption , make , model , transmission , seating_capacity , leg_space , max_load , ground_clearance , number_of_doors  ) values ('Car','AB8974',true,'1300','12km/l','Toyota','Corolla','manual',7,20.5,450,5,5);
insert into vehicle (dtype , plate_no , availability , engine_capacity , fuel_consumption , make , model , transmission , seating_capacity , leg_space , max_load , ground_clearance , number_of_doors  ) values ('Car','CAQ4463',true,'1300','20km/l','Honda','Fit','auto',7,20.5,450,5,5);

insert into customer ( address , email , name , phone ) values ('New York','adam@admail.com','Adam',06773353536);
insert into customer ( address , email , name , phone ) values ('LA','adam@admail.com','Adam Ling',06773354536);
insert into customer ( address , email , name , phone ) values ('Kandy','adam@admail.com','Adam Bing',06772353536);
insert into customer ( address , email , name , phone ) values ('Colombo','adam@admail.com','Adam Sing',06783353536);


insert into schedule ( pick_up_date , drop_off_date ,vehicle_plate_no , customer_id ) values ('2019-06-16T17:00:00.000Z','2019-06-18T17:00:00.000Z','KY6076',1);
insert into schedule ( pick_up_date , drop_off_date ,vehicle_plate_no , customer_id ) values ('2019-03-10T17:00:00.000Z','2019-03-30T17:00:00.000Z','KY6076',2);
insert into schedule ( pick_up_date , drop_off_date ,vehicle_plate_no , customer_id  ) values ('2019-06-11T17:00:00.000Z','2019-06-12T17:00:00.000Z','BBO6892',3);
insert into schedule ( pick_up_date , drop_off_date ,vehicle_plate_no , customer_id  ) values ('2019-06-15T17:00:00.000Z','2019-06-17T17:00:00.000Z','CAQ4463',4);