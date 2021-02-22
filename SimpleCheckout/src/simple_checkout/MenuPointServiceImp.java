package simple_checkout;

import simple_checkout.menu_items.CheckoutCreator;
import simple_checkout.menu_items.CheckoutLoader;

public class MenuPointServiceImp implements MenuPointService {

	private static final MenuPoint[] availableMenuPoint = new MenuPoint[] { new CheckoutCreator(), new CheckoutLoader(), };

	@Override
	public MenuPoint[] getAvailableMenuPoint() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MenuPoint[] getMenuActions(String[] strings) {
		// TODO Auto-generated method stub
		return null;
	}

}
