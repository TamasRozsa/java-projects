package simple_checkout;

public interface MenuPointService {

	MenuPoint[] getAvailableMenuPoint();

	MenuPoint[] getMenuActions(String... strings);

}
