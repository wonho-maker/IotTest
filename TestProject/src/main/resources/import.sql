insert into Booking(booking_name) values('Kris');
insert into Booking(booking_name) values('Martin');
insert into Booking(booking_name) values('Andy');
insert into Booking(booking_name) values('Josh');
insert into Booking(booking_name) values('jhu');
insert into Booking(booking_name) values('dummy');

insert into users(username, PASSWORD, STUDENT_NUMBER, NAME, role) values('test2','test2', '20072535','tester1', 'ROLE_USER');
insert into users(username, PASSWORD, STUDENT_NUMBER, NAME, role) values('admin','admin', '20072532','admin', 'ROLE_ADMIN');

insert into devices(device_name, description, tags, location, data_name1, data_name2, is_public, ownner_id) values('test device', 'test description', 'temp', '507',  'v1', 'v2', true, 1);
insert into devices(device_name, description, tags, location, data_name1, data_name2, is_public, ownner_id) values('device2', 'description2', 'diameter', '507',  'v1', 'v2', FALSE, 1);

insert into sensor_data_field(data_value1, data_value2, update_time, mapped_device_id) values(10, 20, '2015-03-10 11:55:30', 1);
insert into sensor_data_field(data_value1, data_value2, update_time, mapped_device_id) values(30, 10, '2015-03-10 12:55:30', 1);
insert into sensor_data_field(data_value1, data_value2, update_time, mapped_device_id) values(20, 30, '2015-03-10 13:15:30', 1);

insert into sensor_data_field(data_value1, data_value2, update_time, mapped_device_id) values(20, 25, '2015-03-10 14:55:30', 2);
insert into sensor_data_field(data_value1, data_value2, update_time, mapped_device_id) values(30, 15, '2015-03-10 15:55:30', 2);
insert into sensor_data_field(data_value1, data_value2, update_time, mapped_device_id) values(10, 35, '2015-03-10 16:15:30', 2);

insert into api_keys(api_key, created_time, write_able, api_ownner_id) values('ABCDEFGHIJKLMNO1', '2015-03-04', false, 1);
insert into api_keys(api_key, created_time, write_able, api_ownner_id) values('ABCDEFGHIJKLMNO2', '2015-03-04', false, 2);