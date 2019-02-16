package Instrument;
public interface I_Option extends Instrument{
	double strike_price=0.0;
};



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
//		
//Task B: Create an APT named I-Compliance_checker with below methods
//method 1: CheckOnSend(I_Order, I_Price)
//				where I-Price ="best Bid, best bid Close, Best Ask, Best Ask Online, Last,
//				Last ask, Array of Best, Array of Quantity, Last Before Close, Last After Close"
//method 2: CheckOnVerify
//		Price LImit While Buy ->Aggressive   when > x%
//								->Passive 		when <y%
//		Price LImit While Sell->Aggressive   when < x%
//								->Passive 		when >y%
//								