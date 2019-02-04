##Hierarichal DB Dictionary

# Hierarichal DB of dictionary in DB

# Oracle DB
Create table tbl_config
(
   type varchar2 (20),
    key varchar2(100),
    value varchar2(2000),
    Constraint tbl_config_uk unique (type, key)
);

e.g. data 

//Pallav Correcting SQL queries with right syntax on 02/02.
Insert into tbl_config(type, key, value) Values ('TraderBookMapping', 'anchal', 'book1');
Insert into tbl_config(type, key, value) Values ('TraderBookMapping', 'bapi', 'book2');
Insert into tbl_config(type, key, value) Values ('TraderBookMapping', 'pallav', 'book3');
Insert into tbl_config(type, key, value) Values ('TraderBookMapping', 'sunil', 'book4');
Insert into tbl_config(type, key, value) Values ('BookMarketMapping', 'book1', 'nse');
Insert into tbl_config(type, key, value) Values ('BookMarketMapping', 'book2', 'bse');
Insert into tbl_config(type, key, value) Values ('BookMarketMapping', 'book2', 'nse');
Insert into tbl_config(type, key, value) Values ('BookMarketMapping', 'book3', 'sgx');
Insert into tbl_config(type, key, value) Values ('BookMarketMapping', 'book4', 'hkse');

Create
DB Agnostic API to store multiple dictionaries in DB.

a method string GetValue(string type, string key) which will return value when dictionary Type and Key are passed to the method.

a method Dictionary<string,string> GetDictionary(string type) which will return complete dictionary (all key, value pairs) if passed a dictionary type.

a method Dictionary<string,Dictionary<string,string>> GetAllDictionaries(string type) which will return all dictionaries.


Oracle DB definition:
Create table tbl_config
(
type varchar2 (20),
key varchar2(100),
value varchar2(8000)
);

Alter table tbl_config Add Constraint tbl_config_uk unique (type, key)
