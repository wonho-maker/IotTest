 
insert into users(username, PASSWORD, STUDENT_NUMBER, NAME, role) values('test2','test2', '20072535','tester1', 'ROLE_USER');
insert into users(username, PASSWORD, STUDENT_NUMBER, NAME, role) values('admin','admin', '20072532','admin', 'ROLE_ADMIN');

insert into devices(device_name, description, tags, location, data_name1, data_name2, is_public, ownner_id) values('test device', 'test description', 'temp', '507',  'v1', 'v2', true, 1);
insert into devices(device_name, description, tags, location, data_name1, data_name2, is_public, ownner_id) values('device2', 'description2', 'diameter', '507',  'v1', 'v2', FALSE, 1);

insert into sensor_data_field(data_value, update_time, field_number, mapped_field_id) values(10, '2015-03-12 10:15:30', 1, 1);
insert into sensor_data_field(data_value, update_time, field_number, mapped_field_id) values(30, '2015-03-12 10:20:30', 1, 1);
insert into sensor_data_field(data_value, update_time, field_number, mapped_field_id) values(20, '2015-03-12 10:25:30', 1, 1);

insert into sensor_data_field(data_value, update_time, field_number, mapped_field_id) values(20, '2015-03-12 10:15:30', 2, 1);
insert into sensor_data_field(data_value, update_time, field_number, mapped_field_id) values(10, '2015-03-12 10:20:30', 2, 1);
insert into sensor_data_field(data_value, update_time, field_number, mapped_field_id) values(30, '2015-03-12 10:25:30', 2, 1);

insert into sensor_data_field(data_value, update_time, field_number, mapped_field_id) values(10, '2015-03-12 10:15:30', 1, 2);
insert into sensor_data_field(data_value, update_time, field_number, mapped_field_id) values(30, '2015-03-12 10:20:30', 1, 2);
insert into sensor_data_field(data_value, update_time, field_number, mapped_field_id) values(20, '2015-03-12 10:25:30', 1, 2);

insert into sensor_data_field(data_value, update_time, field_number, mapped_field_id) values(20, '2015-03-12 10:15:30', 2, 2);
insert into sensor_data_field(data_value, update_time, field_number, mapped_field_id) values(10, '2015-03-12 10:20:30', 2, 2);
insert into sensor_data_field(data_value, update_time, field_number, mapped_field_id) values(30, '2015-03-12 10:25:30', 2, 2);

insert into api_keys(api_key, created_time, write_able, api_ownner_id) values('ABCDEFGHIJKLMNO1', '2015-03-04', false, 1);
insert into api_keys(api_key, created_time, write_able, api_ownner_id) values('ABCDEFGHIJKLMNO2', '2015-03-04', false, 2);