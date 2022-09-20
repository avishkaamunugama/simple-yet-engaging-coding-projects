insert into motor_bike  values ('BBO6892',true,'125','50km/l','Yamaha','Z300','manual',1000,'Normal');
insert into motor_bike  values ('BBQ1234',true,'1200','10km/l','Honda','CBR','manual',1000,'Racing');
insert into motor_bike  values ('WW5674',true,'180','30km/l','Bajaj','Pulsar','manual',1000,'Normal');
insert into motor_bike  values ('BCA9435',true,'200','60km/l','Honda','Monet','manual',1000,'Trailer');
insert into motor_bike  values ('BBO6662',true,'125','50km/l','Honda','Jade','manual',1000,'Normal');


insert into car values ('KY6892',true,'1500','20km/l','Toyota','Aqua','auto',7,20.5,450,5,5);
insert into car values ('KY6076',true,'1500','25km/l','Toyota','Axio','auto',7,20.5,450,5,5);
insert into car values ('AB8974',true,'1300','12km/l','Toyota','Corolla','manual',7,20.5,450,5,5);
insert into car values ('CAQ4463',true,'1300','20km/l','Honda','Fit','auto',7,20.5,450,5,5);
insert into car values ('KA6176',true,'1500','25km/l','BMW','i8','auto',7,20.5,450,5,5);
insert into car values ('AW8274',true,'1300','12km/l','BMW','i3','manual',7,20.5,450,5,5);
insert into car values ('C2Q3463',true,'1300','20km/l','Benz','Compressor','auto',7,20.5,450,5,5);
insert into car values ('KY6592',true,'1500','20km/l','Toyota','Landcruiser','auto',7,20.5,450,5,5);
insert into car values ('KA4176',true,'1500','25km/l','Toyota','FJ-cruiser','auto',7,20.5,450,5,5);
insert into car values ('AW8074',true,'1300','12km/l','Mazda','Axela','manual',7,20.5,450,5,5);
insert into car values ('CAW3663',true,'1300','20km/l','Honda','Civic','auto',7,20.5,450,5,5);
insert into car values ('KY6992',true,'1500','20km/l','Nissan','N16','auto',7,20.5,450,5,5);


insert into customer ( address , email , name , phone ) values ('New York','adam@admail.com','Adam',06773353536);
insert into customer ( address , email , name , phone ) values ('LA','adam@admail.com','Adam Ling',06773354536);
insert into customer ( address , email , name , phone ) values ('Kandy','adam@admail.com','Adam Bing',06772353536);
insert into customer ( address , email , name , phone ) values ('Colombo','adam@admail.com','Adam Sing',06783353536);


insert into schedule ( pick_up_date , drop_off_date ,vehicle_plate_no , customer_id ) values ('2019-10-10T17:00:00.000Z','2019-10-10T17:00:00.000Z','KY6076',1);
insert into schedule ( pick_up_date , drop_off_date ,vehicle_plate_no , customer_id ) values ('2019-12-10T17:00:00.000Z','2019-12-20T17:00:00.000Z','KY6076',2);
insert into schedule ( pick_up_date , drop_off_date ,vehicle_plate_no , customer_id  ) values ('2019-12-11T17:00:00.000Z','2019-12-19T17:00:00.000Z','BBO6892',3);
insert into schedule ( pick_up_date , drop_off_date ,vehicle_plate_no , customer_id  ) values ('2019-12-15T17:00:00.000Z','2019-12-30T17:00:00.000Z','CAQ4463',4);

