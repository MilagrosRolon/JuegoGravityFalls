package com.gravityfalls.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gravityfalls.game.elementos.Mabel;
import com.gravityfalls.game.pantallas.PantallaLogo;
import com.gravityfalls.game.pantallas.PantallaMenu;
import com.gravityfalls.game.utiles.Render;

public class GravityFalls extends Game {
    SpriteBatch batch;

    @Override
    public void create () {
        Render.batch = new SpriteBatch();
        Render.app = this;
        this.setScreen(new PantallaLogo());
    }

    @Override
    public void render () {
        super.render();
    }

    @Override
    public void dispose () {
        Render.batch.dispose();
    }
}