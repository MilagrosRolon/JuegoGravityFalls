package com.gravityfalls.game.EntradasSalidas;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.gravityfalls.game.pantallas.PantallaLogo;
import com.gravityfalls.game.pantallas.PantallaMenu;

public class Entradas implements InputProcessor {

    private PantallaLogo pantallaLogo;
    private PantallaMenu app;
    private boolean abajo = false, arriba = false;
    private boolean enter = false;
    // Constructor para PantallaMenu
    public Entradas(PantallaMenu app) {
        this.app = app;
    }

    // Constructor para PantallaLogo
    public Entradas(PantallaLogo pantallaLogo) {
        this.pantallaLogo = pantallaLogo;
    }

    @Override
    public boolean keyDown(int keycode) {
        app.tiempo = 0.08f;
       
        if (keycode == Keys.DOWN) {
            abajo = true;
        } else if (keycode == Keys.UP) {
            arriba = true;
        }
        if (keycode == Keys.ENTER) {
           enter = true;
        }
        
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
    	

        if (keycode == Keys.DOWN) {
            abajo = false;
        } else if (keycode == Keys.UP) {
            arriba = false;
        }
        if (keycode == Keys.ENTER) {
           enter = false;
        }
     
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
    
    public boolean isAbajo() {
        return abajo;
    }

    public boolean isArriba() {
        return arriba;
    }

	public boolean isEnter() {
		
		return enter;
	}
}
