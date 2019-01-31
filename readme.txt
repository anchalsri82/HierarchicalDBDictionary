##Hierarichal DB Dictionary

# Hierarichal DB of dictionary in DB

# Oracle DB
Create table tbl_config
(
   type varchar2 (20),
    key varchar2(100),
    value varchar2(8000)
);

Alter table tbl_config Add Constraint tbl_config_uk unique (type, key)
