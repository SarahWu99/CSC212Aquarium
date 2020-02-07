package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Fish {

	int x;
	int y;
	Color color;
	boolean isLittle;
	boolean facingLeft;
	// every fish has a destination
	int destX;
	int destY;
	Random rand = new Random();

	public Fish(Color color, int x, int y, boolean isLittle, boolean facingLeft) {
		this.color = color;
		this.x = x;
		this.y = y;
		this.isLittle = isLittle;
		this.facingLeft = facingLeft;
		// calling the random destination
		this.destX = rand.nextInt(500 - 0) + 0;
		this.destY = rand.nextInt(500 - 0) + 0;
	}

	public void swim() {
		// fish destination system  
		if (this.x < this.destX) {
			if (facingLeft) {
				this.x -= 1;
			}
			else {
				this.x += 1;
			}
		}
	}

	public void draw(Graphics2D g) {
		this.swim();
		if (isLittle) {
			if (facingLeft) {
				DrawFish.smallFacingLeft(g, this.color, this.x, this.y);
			} else {
				DrawFish.smallFacingRight(g, this.color, this.x, this.y);
			}
		}
		else {
			if (facingLeft) {
				DrawFish.facingLeft(g, this.color, this.x, this.y);
			} else {
				DrawFish.facingRight(g, this.color, this.x, this.y);
			}
		}

	}

}
