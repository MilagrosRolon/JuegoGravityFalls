package com.gravityfalls.game.elementos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.gravityfalls.game.utiles.Render;

public class Mabel {

	 public Texture tex;
	 public Sprite spr;
	 public float alto, ancho;
	 public float x,y;
	 
	 public Mabel(float x, float y, float ancho, float alto) {
		 tex = new Texture("Mabel.png");
		 spr = new Sprite(tex);
		 spr.setPosition(x, y);
		 spr.setSize(ancho, alto);
		 
	 }

	public void dibujar() {
	   spr.draw(Render.batch);
	}
	
	public void setX(float x) {
		spr.setX(x);
	}
	public void setY(float y) {
		spr.setY(y);
	}
}
