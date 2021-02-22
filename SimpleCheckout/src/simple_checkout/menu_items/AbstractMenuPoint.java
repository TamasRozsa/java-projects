package simple_checkout.menu_items;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import simple_checkout.MenuPoint;

public abstract class AbstractMenuPoint implements MenuPoint {

//	private static final String UTF_8 = null;
	private final String label;
	private final String[] sqlStatements;
	final PreparedStatement[] pstmts;
	Scanner scanner;

	public AbstractMenuPoint(String label, String... sqlStatements) {
		this.label = label;
		this.sqlStatements = sqlStatements;
		this.pstmts = new PreparedStatement[sqlStatements.length];
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	@Override
	public void activate(Connection connection) throws SQLException {
		int i = 0;
		for (String sqlStatement : sqlStatements) {
			pstmts[i++] = connection.prepareStatement(sqlStatement);
		}
	}

	@Override
	public boolean isQuit() {
		return false;
	}

	@Override
	public void close() throws SQLException {
		for (PreparedStatement pstmt : pstmts) {
			pstmt.close();
		}
	}
	// -----------------------------------------------------------	

		String inputText(String prompt) {
			System.out.print(prompt + ": ");
			return scanner.nextLine();
		}

		int inputInt(String prompt) {
			for (;;) {
				try {
					System.out.print(prompt + ": ");
					return Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException e) {
				}
			}
		}

}
