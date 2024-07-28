package com.gravityfalls.game.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gravityfalls.game.EntradasSalidas.Entradas;
import com.gravityfalls.game.elementos.Imagen;
import com.gravityfalls.game.elementos.Texto;
import com.gravityfalls.game.utiles.Config;
import com.gravityfalls.game.utiles.Recursos;
import com.gravityfalls.game.utiles.Render;

public class PantallaMenu implements Screen {

	Imagen fondo;
	SpriteBatch b;
	
	Texto opciones[] = new Texto[3];
	String  textos[] = {"EMPEZAR BUSQUEDA","COMO JUGAR","CERRAR"};
	
	Entradas entradas = new Entradas(this);
	
	int opcion = 1;
	public float tiempo = 0;

	@Override
	public void show() {
	    fondo = new Imagen(Recursos.MENU);
	    b = Render.batch;
	    
	    Gdx.input.setInputProcessor(entradas);
	    
	    int avance = 45;
	    
	    for (int i = 0; i < opciones.length; i++) {
	        opciones[i] = new Texto(Recursos.FUENTE, 35, Color.WHITE, true);
	        opciones[i].setTexto(textos[i]);
	        opciones[i].setPosition(
	            (Config.ANCHO / 2) - (opciones[i].getAncho() / 2),
	            ((Config.ALTO / 2) + (opciones[0].getAlto()/2))-((opciones[i].getAlto()*i)+(i * avance))
	        );
	    }
	}

	@Override
	public void render(float delta) {
	    b.begin();
	    fondo.dibujar();
	    for (int i = 0; i < opciones.length; i++) {
	        opciones[i].dibujar();
	    }
	    b.end();
	    
	    tiempo += delta;

	    if (entradas.isAbajo() && tiempo > 0.09f) {
	        opcion++;
	        if (opcion > 3) {
	            opcion = 1;
	        }
	        tiempo = 0;
	    } else if (entradas.isArriba() && tiempo > 0.09f) {
	        opcion--;
	        if (opcion < 1) {
	            opcion = 3;
	        }
	        tiempo = 0;
	    }
	
	 for (int i = 0; i < opciones.length; i++) {
	       if(i == opcion-1) {
	    	   opciones[i].setColor(Color.VIOLET);
	       } else {
	    	   opciones[i].setColor(Color.WHITE);
	       }
	    }
	 
		if(entradas.isEnter()) {
			if(opcion == 1) {
				Render.app.setScreen(new PantallaEmpezarJuego());
			}
		}

			
	}
	
	
	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void dispose() {
	}

}
