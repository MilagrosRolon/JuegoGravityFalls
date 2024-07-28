package com.gravityfalls.game.elementos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.gravityfalls.game.utiles.Render;

public class Texto {

	BitmapFont fuente;
	private float x = 0, y = 0;
	private String texto = "";
	GlyphLayout layout;

	public Texto(String rutaFuente, int dimension, Color color, boolean sombra) {

		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(rutaFuente));
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

		parameter.size = dimension;
		parameter.color = color;

		if (sombra) {

			parameter.shadowColor = Color.BLACK;
			parameter.shadowOffsetX = 1;
			parameter.shadowOffsetY = 1;

		}
		fuente = generator.generateFont(parameter);
		layout = new GlyphLayout();
	}

	public void dibujar() {
		fuente.draw(Render.batch, texto, x, y);
	}
	

	public void setPosition(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public BitmapFont getFuente() {
		return fuente;
	}

	public void setFuente(BitmapFont fuente) {
		this.fuente = fuente;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
		layout.setText(fuente, texto);
	}

	public float getAncho() {
		return layout.width;

	}

	public float getAlto() {
		return layout.height;
	}

	public void setColor(Color color) {
		fuente.setColor(color);
	}

	
}
