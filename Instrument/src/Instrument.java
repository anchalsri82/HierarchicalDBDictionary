
public interface Instrument {
	String Inst_Id="";
	String Inst_Name="";
	enum type {equity, ADR, Future, Spread, bond, put_option, call_optional};
	String Country="";
}


//Task A: Create Threee Interfaces :-
//1) Instrument : it will contain an Object with following fields 
//	Inst Id,
//	name,
//	type  enum - "equity, ADR, Future, Spread, bond, put option, call optional"
//	RIC,
//	country
//	
//2) I_Option which will inherit above interface
//	Fields:- 
//	Strike_Price
//	
//3) I_Order which will inherit above interfaces
//	Fields:-
//		Price
//		price_tartic - enum -"limit, market, mod on open, mod on Close, Limit on open, Limit on Cloase"