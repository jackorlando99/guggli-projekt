/* keszitette: Varjasi Robert */

ALTER SESSION SET NLS_DATE_LANGUAGE = HUNGARIAN;
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MON-DD';


Create table userek(
userid_auto int,
uname varchar2(15) not null,
email varchar2(255) not null,
pwhash varchar2(256) not null,
constraint userek_prikey primary  key (userid_auto)
);


create table csoportok(
gid_auto int,
gname varchar2(255) not null,
constraint csop_prikey primary key (gid_auto)
);


create table csoportjai(
gid_auto int,
userid_auto int,
constraint gid_foreign foreign key (gid_auto) references csoportok (gid_auto),
constraint userid_auto_foreign foreign key (userid_auto) references userek (userid_auto)
);


create table dokumentumok(
doc_id_auto int,
created_at date not null,
updated_at date not null,
doc_name varchar2(255) not null,
content nclob not null,
userid int,
constraint doc_id_auto_prikey primary key(doc_id_auto),
constraint doc_foreign foreign key(userid) references userek(userid_auto)
);

create table konyvtar(
dir_id_auto int not null,
dir_name varchar2(255) not null,
parent_dir int not null,
constraint dir_id_auto_prikey primary key(dir_id_auto)
);

create table konyvtarja(
has_dir_id_auto int not null,
dir_id int not null,
doc_id int not null,
constraint has_dir_id_auto_prikey primary key(has_dir_id_auto),
constraint has_dir_id_foreign foreign key(dir_id) references konyvtar(dir_id_auto),
constraint has_doc_id_foreign foreign key(doc_id) references dokumentumok(doc_id_auto)
);

create table kapcs_konyvt_esem_csop(
kapcs_id_auto int not null,
tipus varchar2(50) not null,
tipus_id int not null,
gid int not null,
constraint kapcs_id_auto_prikey primary key(kapcs_id_auto)
);


create table nevek(
nev_id_auto int not null, 
nev varchar2(100) not null,
constraint nev_id_auto_prikey primary key(nev_id_auto)
);

create table nevnapok(
nevn_id_auto int not null,
nev_id int not null,
honap int not null,
nap int not null,
fo_nap char(1) check (fo_nap in ( 'Y', 'N' )),
constraint nevn_id_auto_prikey primary key(nevn_id_auto),
constraint nev_id_foreign foreign key(nev_id) references nevek(nev_id_auto)
);


create table esemenyek(
event_id_auto int,
event_name varchar2(100),
userid int,
idopont date not null,
description varchar(255),
nyilvanos char(1) check (fo_nap in ( 'Y', 'N' )),
constraint  userid_foreign foreign key(userid) references userek(userid_auto),
constraint event_id_prikey primary key(event_id_auto)
);

create table cellak(
cella_id_auto int,
betukod varchar2 (2),
constraint cella_id_auto_prikey primary key(cella_id_auto)
);

create table terkepek(
map_id_auto int,
map_name varchar2(100),

constraint map_id_auto_prikey primary key (map_id_auto)
);

create table cellaja(
map_cell_id_auto int,
map_id int,
cella_id int,
cella_img varchar(255),
constraint map_cell_id_auto_prikey primary key(map_cell_id_auto),
constraint cella_id_foreign foreign key(cella_id) references cellak(cella_id_auto),
constraint map_id_foreign foreign key(map_id) references terkepek(map_id_auto)
);

create table helyek(
hely_id_auto int not null,
hely_neve varchar2(100) not null,
hely_cime varchar2(150) not null,
hely_tel varchar2(100),
hely_foto_id int,
hely_tipusa varchar2(100) not null,
komment varchar2(255),
hely_x int not null,
hely_y int not null,
map_cell_id int not null,
constraint hely_id_auto_prikey primary key(hely_id_auto),
constraint map_cell_id_foreign foreign key(map_cell_id) references cellaja(map_cell_id_auto)
);

create table esem_helyszin(
esem_helysz_id_auto int not null,
esem_id int not null,
hely_id int not null,
constraint esem_id_foreign foreign key(esem_id) references esemenyek(event_id_auto),
constraint hely_id_foreign foreign key(hely_id) references helyek(hely_id_auto),
constraint esem_helysz_id_auto_prikey primary key(esem_helysz_id_auto)
);


create table fotok(
foto_id_auto int not null,
hely_id int not null,
userid int not null,
idopont date not null,
keszito varchar2(100),
constraint fuserid_foreign foreign key(userid) references userek(userid_auto),
constraint fhely_id_foreign foreign key(hely_id) references helyek(hely_id_auto),
constraint foto_id_prikey primary key(foto_id_auto)
);

create table naptar_bejegyz(
note_id_auto int not null,
note varchar(255) not null,
userid int not null,
created_at date not null,
constraint naptar_bejegyz_prikey primary key(note_id_auto),
constraint naptar_bejegyz_foreign foreign key(userid) references userek(userid_auto)
);