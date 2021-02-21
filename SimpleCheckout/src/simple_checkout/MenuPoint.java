package simple_checkout;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public interface MenuPoint {

	String getLabel();

	void setScanner(Scanner scanner);

	void activate(Connection connection) throws SQLException;

	void executeTask() throws SQLException;

	boolean isQuit();

	void close() throws SQLException;


}
