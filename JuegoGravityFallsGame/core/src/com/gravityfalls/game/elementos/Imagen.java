package com.gravityfalls.game.elementos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.gravityfalls.game.utiles.Config;
import com.gravityfalls.game.utiles.Render;

public class Imagen {

    public Texture tex;
    private  Sprite spr;

    public Imagen(String ruta) {
        tex = new Texture(ruta);
        spr = new Sprite(tex);
        spr.setSize(Config.ANCHO,Config.ALTO);
        spr.setPosition(0, 0);
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
    public void setTransparencia(float a) {
    	spr.setAlpha(a);
    }
}
