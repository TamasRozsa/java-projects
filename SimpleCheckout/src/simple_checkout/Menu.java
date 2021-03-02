package simple_checkout;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

class Menu implements AutoCloseable {

	private Scanner scanner;
	private final String prompt;
	private final String text;
	private MenuPoint[] menuPoint;

	public Menu(Connection connection, String prompt, MenuPoint[] menuPoint) throws SQLException {
		this.menuPoint = Arrays.copyOf(menuPoint, menuPoint.length + 1);
		this.menuPoint[this.menuPoint.length - 1] = getQuitMenuAction();
		StringBuilder textBuilder = new StringBuilder(String.format("%nMENÜ%n----%n"));
		int n = 1;
		for (var menuAction : this.menuPoint) {
			textBuilder.append(String.format("%2d. %s%n", n++, menuAction.getLabel()));
			menuAction.activate(connection);
		}
		this.prompt = prompt;
		text = textBuilder.toString();
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
		for (var menuAction : menuPoint) {
			menuAction.setScanner(scanner);
		}
	}

	MenuPoint choose() throws SQLException {
		System.out.print(text);
		for (;;) {
			System.out.print(prompt);
			try {
				return menuPoint[Integer.parseInt(scanner.nextLine()) - 1];
			} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
			}
		}
	}

	@Override
	public void close() throws Exception {
		for (var menuAction : menuPoint) {
			menuAction.close();
		}
	}

	private MenuPoint getQuitMenuAction() {
		return new MenuPoint() {

			@Override
			public String getLabel() {
				return "kilépés";
			}

			@Override
			public boolean isQuit() {
				return true;
			}

			@Override
			public void activate(Connection connection) throws SQLException {
			}

			@Override
			public void setScanner(Scanner scanner) {
			}

			@Override
			public void executeTask() throws SQLException {
			}

			@Override
			public void close() throws SQLException {
			}

		};
	}

}
