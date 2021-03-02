package simple_checkout;

import simple_checkout.menu_items.CheckoutCreator;
import simple_checkout.menu_items.CheckoutEraser;
import simple_checkout.menu_items.CheckoutLoader;
import simple_checkout.menu_items.RecordHandler;

public class MenuPointServiceImp implements MenuPointService {

	private static final MenuPoint[] availableMenuPoint = new MenuPoint[] { //
			new CheckoutCreator(), //
			new CheckoutLoader(), //
			new CheckoutEraser(), //
			new RecordHandler() //
	};

	@Override
	public MenuPoint[] getAvailableMenuPoint() {
		return availableMenuPoint;
	}

	@Override
	public MenuPoint[] getMenuActions(String... labels) {
		MenuPoint[] actions = new MenuPoint[labels.length];
		int i = 0;
		for (String label : labels) {
			actions[i++] = getAction(label);
		}
		return actions;
	}

	private MenuPoint getAction(String label) {
		for (MenuPoint action : availableMenuPoint) {
			if (action.getLabel().equals(label)) {
				return action;
			}
		}
		throw new IllegalArgumentException(label + ": nincs ilyen menü funkció");
	}

}
