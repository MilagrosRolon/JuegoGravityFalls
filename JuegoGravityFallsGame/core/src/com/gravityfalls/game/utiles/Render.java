package com.gravityfalls.game.utiles;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gravityfalls.game.GravityFalls;

public class Render {

    public static SpriteBatch batch;
    public static Game app;

    public static void initialize() {
        batch = new SpriteBatch();
    }

    public static void dispose() {
        batch.dispose();
    }

    public static void limpiarPantalla(float r, float g, float b ) {
        Gdx.gl.glClearColor(r, g, b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
}
