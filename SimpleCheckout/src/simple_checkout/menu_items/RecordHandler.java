package simple_checkout.menu_items;

import java.sql.SQLException;


public class RecordHandler extends AbstractMenuPoint {
	
	private static final String LABEL = "új bejegyzés hozzáadása";

	private static final String SQL_STATEMENTS = "";

	public RecordHandler(String label, String[] sqlStatements) {
		super(LABEL, SQL_STATEMENTS);
	}

	@Override
	public void executeTask() throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
