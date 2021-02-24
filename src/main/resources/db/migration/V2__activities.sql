create table track_points(
	id bigint AUTO_INCREMENT,
	activity_id bigint,
	track_time timestamp,
	latitude FLOAT,
	longitude FLOAT,
	primary key(id),
	foreign key(activity_id) references activities(id));
