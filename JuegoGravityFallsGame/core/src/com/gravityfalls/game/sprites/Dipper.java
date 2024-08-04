package com.gravityfalls.game.sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.gravityfalls.game.GravityFalls;

public class Dipper extends Sprite {
	public World world;
	public Body b2Body;

	public Dipper(World world) {
	    this.world = world;
	    defineDipper();
	}

	public void defineDipper() {
	    BodyDef bDef = new BodyDef();
	    bDef.position.set(32 / GravityFalls.PPM, 32 / GravityFalls.PPM); // Verifica que estas coordenadas están dentro del mapa
	    bDef.type = BodyDef.BodyType.DynamicBody;
	    b2Body = world.createBody(bDef);
	    
	    FixtureDef fDef = new FixtureDef();
	    CircleShape shape = new CircleShape();
	    shape.setRadius(5 / GravityFalls.PPM);
	    
	    fDef.shape = shape;
	    b2Body.createFixture(fDef);
	}

}
