package simple_checkout.menu_items;

import java.sql.SQLException;

public class RecordEraser extends AbstractMenuPoint {

	private static final String LABEL = "új bejegyzés hozzáadása";

	private static final String SQL_STATEMENTS = "" + //
			"INSERT INTO `checkout`.`checkouts` (`name`, `limit`) VALUES (?, ?);"; // TODO check sql statements parameter!!!

	public RecordEraser() {
		super(LABEL, SQL_STATEMENTS);
	}

	@Override
	public void executeTask() throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
