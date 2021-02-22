package simple_checkout.menu_items;

import java.sql.SQLException;

public class CheckoutLoader extends AbstractMenuPoint {

	private static final String LABEL = "pénztár betöltése"; // (aktuális: <pénztár neve (pénztár egyedi szám azonosítója)>)

	private static final String SQL_STATEMENTS = "";

	public CheckoutLoader() {
		super(LABEL, SQL_STATEMENTS);
	}

	@Override
	public void executeTask() throws SQLException {
		// TODO Auto-generated method stub
	}

}
