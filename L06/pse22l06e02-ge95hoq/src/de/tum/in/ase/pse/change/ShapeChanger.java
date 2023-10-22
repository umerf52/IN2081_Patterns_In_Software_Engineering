package de.tum.in.ase.pse.change;

import de.tum.in.ase.pse.draw.Oval;
import de.tum.in.ase.pse.draw.Rectangle;

/**
 * Class holds helper method for changing shapes
 */
@Deprecated
public final class ShapeChanger {

	private ShapeChanger() {
	}

	@Deprecated
	public static Oval changeRectangleToOval(Rectangle r) {
		return Oval.changeForm(r);
	}

	@Deprecated
	public static Rectangle changeOvalToRectangle(Oval o) {
		return Rectangle.changeForm(o);
	}
}
