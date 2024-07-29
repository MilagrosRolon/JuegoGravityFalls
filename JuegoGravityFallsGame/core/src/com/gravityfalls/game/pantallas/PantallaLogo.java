package com.gravityfalls.game.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gravityfalls.game.EntradasSalidas.Entradas;
import com.gravityfalls.game.elementos.Imagen;
import com.gravityfalls.game.elementos.Texto;
import com.gravityfalls.game.utiles.Recursos;
import com.gravityfalls.game.utiles.Render;

public class PantallaLogo implements Screen {

    Imagen fondo;
    SpriteBatch b;
    boolean efectoPantalla = false, termina = false;
    float a = 0;
    float efectoEspera = 0, contTiempo = 0;
    float efectoTermina = 1.0f, contTiempoTermina = 0;
    Texto t;
    Entradas entradas;
    @Override
    public void show() {
       
    	 Entradas entradas = new Entradas(this);
         Gdx.input.setInputProcessor(entradas);

        fondo = new Imagen(Recursos.LOGO);
        b = Render.batch;
        fondo.setTransparencia(0);

        t = new Texto(Recursos.FUENTE, 25, Color.WHITE, true);
        t.setTexto("( PRESIONA ENTER PARA SALTAR LA INTRO )");
        t.setPosition(315, 40);

     
    }

    @Override
    public void render(float delta) {
        Render.limpiarPantalla(0, 0, 0);

        b.begin();
        fondo.dibujar();
        t.dibujar();
        b.end();

        procesarEfecto();
    }

    private void procesarEfecto() {
        if (!efectoPantalla) {
            a += 0.01f;
            if (a > 1) {
                a = 1;
                efectoPantalla = true;
            }
        } else {
            contTiempo += 0.05f;
            if (contTiempo > efectoEspera) {
                a -= 0.01f;
                if (a < 0) {
                    a = 0;
                    efectoPantalla = true;
                    termina = true;
                }
            }
        }

        fondo.setTransparencia(a);

        if (termina) {
            contTiempoTermina += 0.1f;
            if (contTiempoTermina > efectoTermina) {
                Render.app.setScreen(new PantallaMenu());
            }
        }
    }

    public void terminarPantalla() {
        a = 0;
        efectoPantalla = true;
        termina = true;
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
