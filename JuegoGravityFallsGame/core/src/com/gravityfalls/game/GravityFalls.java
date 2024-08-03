package com.gravityfalls.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gravityfalls.game.pantallas.PantallaLogo;
import com.gravityfalls.game.utiles.Render;

public class GravityFalls extends Game {
    public SpriteBatch batch;
    public static final int  V_WIDTH = 600;
    public static final int  V_HEIGHT = 280;
    		
    		
    		;
    
    @Override
    public void create() {
        batch = new SpriteBatch();
        Render.batch = batch; 
        Render.app = this;
        this.setScreen(new PantallaLogo(this));
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
