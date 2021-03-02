package simple_checkout;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			new Main().run();
		} catch (SQLException e) {
			System.err.println("Hiba történt adatbázis-eléréskor: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Egyéb (nem adatbázis) hiba történt: " + e);
		}
	}

	private final String urlPrefix = "jdbc:mysql://localhost:3306/";
	private final String user = "root";
	private final String password = "root";
	private final String schema = "checkout";
	private final String switches = "?serverTimezone=UTC";

	private final MenuPointService menuPointService = new MenuPointServiceImp();

	// labels of actions to include in the menu: choose items from the labels of the specific MenuAction classes
	private final MenuPoint[] menuActions = menuPointService.getMenuActions(new String[] { //
			"új pénztár felvétele", //
			"pénztár betöltése", // (aktuális: <pénztár neve (pénztár egyedi szám azonosítója)>)", //
			"pénztár törlése", //
			"bejegyzések kezelése" //

	});

	private void run() throws Exception {
		System.out.println("hellooo");
		System.out.println("Üdvözöllek a pénztár programban.");
		Scanner scanner = new Scanner(System.in);
		try (Connection connection = DriverManager.getConnection(urlPrefix + schema + switches, user, password);
				Menu menu = new Menu(connection, "=====> ", menuActions)) {
			menu.setScanner(scanner);
			MenuPoint menuPoint;
			do {
				menuPoint = menu.choose();
				menuPoint.executeTask();
			} while (!menuPoint.isQuit());
		}
		scanner.close();
		System.out.printf("%nViszlát!%n");
	}

}
