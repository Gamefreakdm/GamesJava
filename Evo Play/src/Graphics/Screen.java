package Graphics;

import GuiObject.Button;
import GuiObject.InventoryObject.Items.InventoryItem;
import Level.Tile.Tile;

public class Screen {
	private int[] Pixels;
	private int Width, Height;
	private static float xOffset;
	private static float yOffset;

	public Screen(int w, int h, int[] p) {
		Width = w;
		Height = h;
		Pixels = p;
	}

	public void RenderBack() {
		for (int y = 0; y < Height; y++)
			for (int x = 0; x < Width; x++)
				Pixels[x + y * Width] = 0x0;
	}

	public void RenderCC() {
		this.RenderEntity(40 + (160 * 0), 0, Sprite.Human_F);
	}

	public void RBC(float xp, float yp, int width, int height, Button b) {
		for (int y = 0; y < height; y++) {
			int ya = (int) (y + yp);
			for (int x = 0; x < width; x++) {
				int xa = (int) (x + xp);
				if (b.Hovered())
					Pixels[xa + ya * Width] = 0x00D300;
				else
					Pixels[xa + ya * Width] = 0x007100;
			}
		}
	}

	public void RenderInventorym(InventoryItem[] il, int xp, int yp) {
		int screenoffy = 64 * yp;
		int screenoffx = 64 * xp;
		for (int y = 0; y < 64; y++)
			for (int x = 0; x < 64; x++) {
				int col = Sprite.InventorySlot.Pixels[x + y * 64];
				if (col != 0XFFFF00FF)
					Pixels[(x + screenoffx) + (y + screenoffy) * Width] = Sprite.InventorySlot.Pixels[x + y * 64];
			}
	}

	public void RenderInventory1(InventoryItem[] il, int invennum) {
		int screenoffy = Height - 100;
		int screenoffx = 80;
		if (invennum != 0)
			screenoffx *= invennum;
		for (int y = 0; y < 64; y++)
			for (int x = 0; x < 64; x++) {
				int Col2 = Sprite.EmptySlot.Pixels[x + y * 64];
				if (Col2 != 0XFFFF00FF)
					Pixels[(x + screenoffx) + (y + screenoffy) * Width] = Sprite.EmptySlot.Pixels[x + y * 64];
				if (il[invennum].isIsSelected() == true) {
					int col1 = Sprite.InHand.Pixels[x + y * 64];
					if (col1 != 0XFFFF00FF)
						Pixels[(x + screenoffx) + (y + screenoffy) * Width] = Sprite.InHand.Pixels[x + y * 64];
				}
			}
	}

	public void RenderUpgrade() {
		int xsof = Width - 300;
		for (int y = 0; y < 400; y++)
			for (int x = xsof; x < Width; x++) {
				Pixels[x + y * Width] = 0x282828;
			}
	}

	public void RenderSelect(float xp, float yp, int width, int height, Button b) {
		for (int y = 0; y < height; y++) {
			int ya = (int) (y + yp);
			if (ya < 0)
				ya = 0;
			for (int x = 0; x < width; x++) {
				int xa = (int) (x + xp);
				if (xa < -width || xa >= Width || ya < -height || ya >= Height)
					break;
				if (xa < 0)
					xa = 0;
				int col = Sprite.Select.Pixels[x + y * width];
				if (col != 0XFFFF00FF)
					Pixels[xa + ya * Width] = Sprite.Select.Pixels[x + y * width];
			}
		}
	}

	public void RenderTile(int xp, int yp, Tile tile) {
		xp -= getxOffset();
		yp -= getyOffset();
		for (int y = 0; y < tile.getSprite().SIZE; y++) {
			int ya = y + yp;
			if (ya < 0)
				ya = 0;
			for (int x = 0; x < tile.getSprite().SIZE; x++) {
				int xa = x + xp;
				if (xa < -tile.getSprite().SIZE || xa >= Width || ya < -tile.getSprite().SIZE || ya >= Height)
					break;
				if (xa < 0)
					xa = 0;
				Pixels[xa + ya * Width] = tile.getSprite().Pixels[x + y * tile.getSprite().SIZE];
			}
		}
	}

	public void Update(float xf, float yf) {
		this.setOffset(xf, yf);
	}

	public void RenderEntity(float xp, float yp, Sprite sprite) {
		xp -= getxOffset();
		yp -= getyOffset();
		for (int y = 0; y < sprite.SIZE; y++) {
			int ya = (int) (y + yp);
			if (ya < 0)
				ya = 0;
			for (int x = 0; x < sprite.SIZE; x++) {
				int xa = (int) (x + xp);
				if (xa < -sprite.SIZE || xa >= Width || ya < -sprite.SIZE || ya >= Height)
					break;
				if (xa < 0)
					xa = 0;
				int col = sprite.Pixels[x + y * sprite.SIZE];
				if (col != 0XFFFF00FF)
					Pixels[xa + ya * Width] = col;
			}
		}
	}

	public void RenderImage(float xp, float yp, int w, int h, Sprite sprite) {
		for (int y = 0; y < h; y++) {
			int ya = (int) (y + yp);
			for (int x = 0; x < w; x++) {
				int xa = (int) (x + xp);
				int Col = sprite.Pixels[x + y * sprite.SIZE];
				if (Col != 0XFFFF00FF)
					Pixels[xa + ya * Width] = sprite.Pixels[x + y * sprite.SIZE];
			}
		}
	}

	public void RenderPlayer(float xp, float yp, Sprite sprite) {
		for (int y = 0; y < 64; y++) {
			int ya = (int) (y + yp);
			if (ya < 0)
				ya = 0;
			for (int x = 0; x < 64; x++) {
				int xa = (int) (x + xp);
				if (xa < -64 || xa >= Width || ya < 0 || ya >= Height)
					break;
				if (xa < 0)
					xa = 0;
				int col = sprite.Pixels[x + y * 64];
				if (col != 0XFFFF00FF)
					Pixels[xa + ya * Width] = col;
			}
		}
	}

	public void setOffset(float xOf, float yOf) {
		xOffset = (int) xOf;
		yOffset = (int) yOf;
	}

	public void Clear() {
		for (int i = 0; i < Pixels.length; i++)
			Pixels[i] = 0;
	}

	public void setWHP(int w, int h, int[] p) {
		Width = w;
		Height = h;
		Pixels = p;
	}

	public int[] getPixels() {
		return Pixels;
	}

	public float getxOffset() {
		return xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}
}