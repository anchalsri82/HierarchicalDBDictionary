package Instrument;
public interface I_Order extends Instrument{
	double price = 0.0;
	enum price_tactic_enum {
			limit,
			market,
			made_on_open,
			madee_on_close,
			limit_on_open,
			limit_on_close
	}
	int quantity=0;
	enum side {
		pallav
	}
}
