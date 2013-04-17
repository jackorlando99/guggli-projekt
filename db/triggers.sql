/* triggereket tartalmazo fajl */
/* keszitette: Varjasi Robert */

/* szekvenciak az auto mezokhoz */

create sequence users_auto start with 1 increment by 1 nomaxvalue;
create sequence groups_auto start with 1 increment by 1 nomaxvalue;
create sequence user_has_group_auto start with 1 increment by 1 nomaxvalue;
create sequence docs_auto start with 1 increment by 1 nomaxvalue;
create sequence directories_auto start with 1 increment by 1 nomaxvalue;
create sequence doc_has_dir_auto start with 1 increment by 1 nomaxvalue;
create sequence events_auto start with 1 increment by 1 nomaxvalue;
create sequence group_has_dir_auto start with 1 increment by 1 nomaxvalue;
create sequence group_has_event_auto start with 1 increment by 1 nomaxvalue;
create sequence names_auto start with 1 increment by 1 nomaxvalue;
create sequence namedays_auto start with 1 increment by 1 nomaxvalue;
create sequence cells_auto start with 1 increment by 1 nomaxvalue;
create sequence maps_auto start with 1 increment by 1 nomaxvalue;
create sequence map_has_cells_auto start with 1 increment by 1 nomaxvalue;
create sequence places_auto start with 1 increment by 1 nomaxvalue;
create sequence event_has_place_auto start with 1 increment by 1 nomaxvalue;
create sequence photos_auto start with 1 increment by 1 nomaxvalue;
create sequence notes_auto start with 1 increment by 1 nomaxvalue;
create sequence group_has_note_auto start with 1 increment by 1 nomaxvalue;

create or replace trigger users_auto_increment
  before insert on users
  for each row
  Begin
    select users_auto.nextval into :new.user_id_auto from dual;  
  End;
  /
  
create or replace trigger groups_auto_increment
  before insert on groups_
  for each row
  Begin
    select groups_auto.nextval into :new.group_id_auto from dual;  
  End;
  /
  
create or replace trigger user_has_group_auto_increment
  before insert on user_has_group
  for each row
  Begin
    select user_has_group_auto.nextval into :new.id_auto from dual;  
  End;  
  /
  
create or replace trigger group_has_dir_auto_increment
  before insert on group_has_dir
  for each row
  Begin
    select group_has_dir_auto.nextval into :new.id_auto from dual;  
  End;  
  /
  
create or replace trigger group_has_event_auto_increment
  before insert on group_has_event
  for each row
  Begin
    select group_has_event_auto.nextval into :new.id_auto from dual;  
  End;  
  /
  
create or replace trigger group_has_note_auto_increment
  before insert on group_has_note
  for each row
  Begin
    select group_has_note_auto.nextval into :new.id_auto from dual;  
  End;  
  /
  
create or replace trigger places_auto_increment
  before insert on places
  for each row
  Begin
    select places_auto.nextval into :new.place_id_auto from dual;  
  End;  
  /
  
create or replace trigger photos_auto_increment
  before insert on photos
  for each row
  Begin
    select photos_auto.nextval into :new.id_auto from dual;  
  End;  
  /
  
create or replace trigger notes_auto_increment
  before insert on notes
  for each row
  Begin
    select notes_auto.nextval into :new.note_id_auto from dual;  
  End;  
  /
  
  create or replace trigger names_auto_increment
  before insert on names
  for each row
  Begin
    select names_auto.nextval into :new.name_id_auto from dual;  
  End;  
  /
  
create or replace trigger namedays_auto_increment
  before insert on namedays
  for each row
  Begin
    select namedays_auto.nextval into :new.id_auto from dual;  
  End;  
  /
  
create or replace trigger maps_auto_increment
  before insert on maps
  for each row
  Begin
    select maps_auto.nextval into :new.map_id_auto from dual;  
  End;  
  /
  
create or replace trigger map_has_cells_auto_increment
  before insert on map_has_cells
  for each row
  Begin
    select map_has_cells_auto.nextval into :new.map_cell_id_auto from dual;  
  End;  
  /

create or replace trigger events_auto_increment
  before insert on events_
  for each row
  Begin
    select events_auto.nextval into :new.event_id_auto from dual;  
  End;  
  /
  
create or replace trigger event_has_place_auto_increment
  before insert on event_has_place
  for each row
  Begin
    select event_has_place_auto.nextval into :new.id_auto from dual;  
  End;  
  /
  
create or replace trigger docs_auto_increment
  before insert on docs
  for each row
  Begin
    select docs_auto.nextval into :new.doc_id_auto from dual;  
  End;  
  /
  
create or replace trigger doc_has_dir_auto_increment
  before insert on doc_has_dir
  for each row
  Begin
    select doc_has_dir_auto.nextval into :new.has_dir_id_auto from dual;  
  End;  
  /
  
create or replace trigger directories_auto_increment
  before insert on directories
  for each row
  Begin
    select directories_auto.nextval into :new.dir_id_auto from dual;  
  End;  
  /
  
create or replace trigger cells_auto_increment
  before insert on cells
  for each row
  Begin
    select cells_auto.nextval into :new.cell_id_auto from dual;  
  End;  
  /