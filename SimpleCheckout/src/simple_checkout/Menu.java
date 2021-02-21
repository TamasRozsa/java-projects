package simple_checkout;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

class Menu implements AutoCloseable {

	private Scanner scanner;
	private MenuPoint[] menuPoint;

	public Menu(Connection connection, String prompt, MenuPoint[] menuPoint) throws SQLException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
		for (var menuAction : menuPoint) {
			menuAction.setScanner(scanner);
		}
		
	}

	public MenuPoint choose() {
		// TODO Auto-generated method stub
		return null;
	}

}
