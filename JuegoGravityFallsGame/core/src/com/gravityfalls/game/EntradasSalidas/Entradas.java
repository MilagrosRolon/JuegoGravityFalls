package com.gravityfalls.game.EntradasSalidas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.gravityfalls.game.pantallas.PantallaLogo;
import com.gravityfalls.game.pantallas.PantallaMenu;
import com.gravityfalls.game.utiles.Config;

public class Entradas implements InputProcessor {

    private PantallaLogo pantallaLogo;
    private PantallaMenu pantallaMenu;
    private boolean abajo = false, arriba = false, enter =false,click= false;
    private int mouseX = 0, mouseY = 0;

    // Constructor para PantallaMenu
    public Entradas(PantallaMenu pantallaMenu) {
        this.pantallaMenu = pantallaMenu;
    }

    // Constructor para PantallaLogo
    public Entradas(PantallaLogo pantallaLogo) {
        this.pantallaLogo = pantallaLogo;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (pantallaMenu != null) {
            pantallaMenu.tiempo = 0.08f;
        }

        if (keycode == Keys.DOWN) {
            abajo = true;
        } else if (keycode == Keys.UP) {
            arriba = true;
        }
        if (keycode == Keys.ENTER) {
            enter = true;
            if (pantallaLogo != null) {
                pantallaLogo.terminarPantalla();
            }
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
        click= true;
    	return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
       click =false;
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
        // Ajustar la coordenada Y si es necesario
        mouseX = screenX;
        mouseY = Config.ALTO - screenY; // Gdx.graphics.getHeight() en lugar de Config.ALTO
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

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

	public boolean isClick() {
		return click;
	}

}
