select * from tbl_config;

describe tbl_config;

CREATE OR REPLACE PROCEDURE RTNVALUEFROMTYPEANDKEY 
(
  TYPE_IN IN VARCHAR2 
, KEY_IN IN VARCHAR2 
, VALUE_OUT OUT VARCHAR2 
) AS 
BEGIN
  	select value from TBL_CONFIG where type = TYPE_IN and key =KEY_IN;
END RTNVALUEFROMTYPEANDKEY;



drop procedure ReturnValueFromTypeAndKey;

EXCEPTION
WHEN OTHERS THEN
   raise_application_error(-20001,'An error was encountered - '||SQLCODE||' -ERROR- '||SQLERRM);