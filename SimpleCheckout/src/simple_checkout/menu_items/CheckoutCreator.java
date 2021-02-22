package simple_checkout.menu_items;

import java.sql.SQLException;


public class CheckoutCreator extends AbstractMenuPoint {

	private static final String LABEL = "új pénztár felvétele";

	private static final String SQL_STATEMENTS = "" + //
			"INSERT INTO `checkout`.`checkouts` (`name`, `limit`) VALUES (?, ?);"; // TODO check sql statements parameter!!!

	public CheckoutCreator() {
		super(LABEL, SQL_STATEMENTS);
	}

	@Override
	public void executeTask() throws SQLException {
		System.out.println("Add meg az új pénztár nevét: ");
		String checkoutName = scanner.nextLine();
		pstmts[0].setString(1, checkoutName);

		System.out.println("Add meg a pénztár limitet: ");
		int checkoutLimit = scanner.nextInt();
		pstmts[0].setInt(2, checkoutLimit);
		scanner.nextLine();
	}

}
