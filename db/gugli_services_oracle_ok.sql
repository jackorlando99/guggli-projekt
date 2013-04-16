/* keszitette: Varjasi Robert */

ALTER SESSION SET NLS_DATE_LANGUAGE = HUNGARIAN;
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MON-DD';


Create table users(
user_id_auto int,
user_name varchar2(15) not null,
first_name varchar2(50) not null,
last_name varchar2(30) not null,
email varchar2(255) not null,
pwhash varchar2(256) not null,
active char(1) check (active in ( 'Y', 'N' )),
activation_code varchar2(255) not null,
constraint users_prikey primary  key (user_id_auto)
);


create table groups_(
group_id_auto int,
group_name varchar2(255) not null,
constraint groups_prikey primary key (group_id_auto)
);


create table user_has_group(
id_auto int not null,
user_id int not null,
group_id int not null,
constraint gid_foreign foreign key (group_id) references groups_ (group_id_auto),
constraint userid_foreign foreign key (user_id) references users (user_id_auto),
constraint id_prikey primary key(id_auto)
);


create table docs(
doc_id_auto int,
created_at date not null,
updated_at date not null,
doc_name varchar2(255) not null,
content_path varchar2(255) not null,
user_id int not null,
display_in_calendar char(1) check (display_in_calendar in ( 'Y', 'N' )),
constraint doc_id_auto_prikey primary key(doc_id_auto),
constraint user_id_foreign foreign key(user_id) references users(user_id_auto)
);

create table directories(
dir_id_auto int not null,
dir_name varchar2(255) not null,
parent_dir int not null,
constraint dir_id_auto_prikey primary key(dir_id_auto)
);

create table doc_has_dir(
has_dir_id_auto int not null,
dir_id int not null,
doc_id int not null,
constraint has_dir_id_auto_prikey primary key(has_dir_id_auto),
constraint has_dir_id_foreign foreign key(dir_id) references directories(dir_id_auto),
constraint has_doc_id_foreign foreign key(doc_id) references docs(doc_id_auto)
);

create table events_(
event_id_auto int,
event_name varchar2(100),
user_id int,
starts_at date not null,
ends_at date not null,
description varchar2(255),
public_ char(1) check (public_ in ( 'Y', 'N' )),
constraint  events_user_id_foreign foreign key(user_id) references users(user_id_auto),
constraint event_id_prikey primary key(event_id_auto)
);

create table group_has_dir(
id_auto int not null,
group_id int not null,
dir_id not null,
constraint group_has_dir_prikey primary key(id_auto),
constraint group_has_dir_foreign foreign key(group_id) references groups_(group_id_auto),
constraint dir_id_foreign foreign key(dir_id) references directories(dir_id_auto)
);

create table group_has_event(
id_auto int not null,
group_id int not null,
event_id not null,
constraint group_has_event primary key(id_auto),
constraint gid_foreign2 foreign key(group_id) references groups_(group_id_auto),
constraint event_id_foreign foreign key(event_id) references events_(event_id_auto)
);


create table names(
name_id_auto int not null, 
name_ varchar2(100) not null,
constraint name_id_auto_prikey primary key(name_id_auto)
);

create table namedays(
id_auto int not null,
name_id int not null,
month_ int not null,
day_ int not null,
main_day char(1) check (main_day in ( 'Y', 'N' )),
constraint id_auto_prikey primary key(id_auto),
constraint namedays_foreign foreign key(name_id) references names(name_id_auto)
);


create table cells(
cell_id_auto int,
code varchar2 (2),
constraint cell_id_auto_prikey primary key(cell_id_auto)
);

create table maps(
map_id_auto int,
map_name varchar2(100),
constraint map_id_auto_prikey primary key (map_id_auto)
);

create table map_has_cells(
map_cell_id_auto int,
map_id int,
cell_id int,
cell_img_path varchar2(255),
constraint map_cell_id_auto_prikey primary key(map_cell_id_auto),
constraint cell_id_foreign foreign key(cell_id) references cells(cell_id_auto),
constraint map_id_foreign foreign key(map_id) references maps(map_id_auto)
);


create table places(
place_id_auto int not null,
name_ varchar2(100) not null,
address varchar2(150) not null,
phone varchar2(100),
place_type varchar2(100) not null,
comment_ varchar2(255),
coord_x int not null,
coord_y int not null,
map_cell_id int not null,
constraint places_id_auto_prikey primary key(place_id_auto),
constraint map_cell_id_foreign foreign key(map_cell_id) references map_has_cells(map_cell_id_auto)
);

create table event_has_place(
id_auto int not null,
event_id int not null,
place_id int not null,
constraint ehp_event_id_foreign foreign key(id_auto) references events_(event_id_auto),
constraint ehp_place_id_foreign foreign key(place_id) references places(place_id_auto),
constraint ehp__id_auto_prikey primary key(id_auto)
);

create table photos(
id_auto int not null,
place_id int not null,
user_id int not null,
created_at date not null,
owner varchar2(100),
photo_path varchar2(255),
constraint photos_userid_foreign foreign key(user_id) references users(user_id_auto),
constraint photos_place_id_foreign foreign key(place_id) references places(place_id_auto),
constraint photos_id_prikey primary key(id_auto)
);


create table notes(
note_id_auto int not null,
note varchar2(255) not null,
user_id int not null,
created_at date not null,
constraint note_prikey primary key(note_id_auto),
constraint note_user_id_foreign foreign key(user_id) references users(user_id_auto)
);

create table group_has_note(
id_auto int not null,
note_id int not null,
group_id int not null,
constraint group_has_note_prikey primary key(id_auto),
constraint note_foreign foreign key(note_id) references notes(note_id_auto),
constraint group_has_note_foreign foreign key(group_id) references groups_(group_id_auto)
);