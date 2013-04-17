create or replace trigger default_group_and_dir
  after insert on users
  for each row
   declare
    group_id int;
    dir_id int;
  Begin
    Insert into groups_ values (null,:new.user_name);
    Select groups_auto.currval into group_id from dual;
    Insert into user_has_group values(null,:new.user_id_auto,group_id);
    Insert into directories values(null,:new.user_name,0,'N');
    Select directories_auto.currval into dir_id from dual;
    Insert into group_has_dir values(null,group_id,dir_id);
  End;
  /
  

  
  
  
  