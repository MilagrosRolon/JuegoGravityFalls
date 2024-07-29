package com.gravityfalls.game.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
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
    String textos[] = {"EMPEZAR BUSQUEDA", "COMO JUGAR", "CERRAR"};

    int opcion = 1;
    public float tiempo = 0;
    ShapeRenderer sr;
    Entradas entradas;

    @Override
    public void show() {
        fondo = new Imagen(Recursos.MENU);
        b = Render.batch;

        entradas = new Entradas(this);
        Gdx.input.setInputProcessor(entradas);

        int avance = 35;

     

        for (int i = 0; i < opciones.length; i++) {
            opciones[i] = new Texto(Recursos.FUENTE, 35, Color.WHITE, true);
            opciones[i].setTexto(textos[i]);
            opciones[i].setPosition(
                (Config.ANCHO / 2) - (opciones[i].getAncho() / 2),
                ((Config.ALTO / 2) + (opciones[0].getAlto() / 2)) - ((opciones[i].getAlto() * i) + (i * avance))
            );
        }
    }

    @Override
    public void render(float delta) {
        tiempo += delta;

        // Actualiza la opción seleccionada en función de la posición del ratón
        for (int i = 0; i < opciones.length; i++) {
            if (entradas.getMouseX() >= opciones[i].getX() &&
                entradas.getMouseX() <= opciones[i].getX() + opciones[i].getAncho() &&
                entradas.getMouseY() >= opciones[i].getY() - opciones[i].getAlto() &&
                entradas.getMouseY() <= opciones[i].getY()) {
                
                opcion = i + 1; // Actualiza la opción seleccionada
            }
        }

        // Actualiza el color de las opciones basado en la opción seleccionada
        for (int i = 0; i < opciones.length; i++) {
            if (i == opcion - 1) {
                opciones[i].setColor(Color.VIOLET);
            } else {
                opciones[i].setColor(Color.WHITE);
            }
        }

        // Dibuja todo
        b.begin();
        fondo.dibujar();
        for (int i = 0; i < opciones.length; i++) {
            opciones[i].dibujar();
        }

        b.end();


        // Manejo de la entrada del teclado
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

        // Manejo del ENTER
        if (entradas.isEnter()||entradas.isClick()) {
            if (opcion == 1) {
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
