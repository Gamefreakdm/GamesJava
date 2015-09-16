package Objects;

import java.awt.Graphics;
import java.util.LinkedList;
import Objects.Object;

public class ObjectsHandler {
	LinkedList<Object> object = new LinkedList<Object>();

	public void Update() {
		for (short u = 0; u < object.size(); u++) {
			Object tempObject = object.get(u);
			tempObject.Update();
		}
	}

	public void Render(Graphics g) {
		for (short r = 0; r < object.size(); r++) {
			Object tempObject = object.get(r);
			tempObject.Render(g);
		}
	}

	public void addObject(Object object) {
		this.object.add(object);
	}

	public void removeObject(Object object) {
		this.object.remove(object);
	}
}