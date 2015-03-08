insert into Booking(booking_name) values('Kris');
insert into Booking(booking_name) values('Martin');
insert into Booking(booking_name) values('Andy');
insert into Booking(booking_name) values('Josh');
insert into Booking(booking_name) values('jhu');
insert into Booking(booking_name) values('dummy');

insert into users(username, PASSWORD, STUDENT_NUMBER, NAME, role) values('test2','test2', '20072535','tester1', 'ROLE_USER');
insert into users(username, PASSWORD, STUDENT_NUMBER, NAME, role) values('admin','admin', '20072532','admin', 'ROLE_ADMIN');

insert into devices(device_name, description, tags, location, data_name1, is_public, ownner_id) values('test device', 'test description', 'temp', '507',  'v1', true, 1);
insert into devices(device_name, description, tags, location, data_name1, is_public, ownner_id) values('device2', 'description2', 'diameter', '507',  'v1', FALSE, 1);

insert into api_keys(api_key, created_time, write_able, api_ownner_id) values('ABCDEFGHIJKLMNO1', '2015-03-04', false, 1);
insert into api_keys(api_key, created_time, write_able, api_ownner_id) values('ABCDEFGHIJKLMNO2', '2015-03-04', false, 2);