package com.gravityfalls.game.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.gravityfalls.game.GravityFalls;
import com.gravityfalls.game.Escenas.Hud;
import com.gravityfalls.game.utiles.Recursos;
import com.gravityfalls.game.utiles.Render;

public class PantallaEmpezarBusqueda implements Screen {

	private GravityFalls game;

	private OrthographicCamera gameCam;
	private Viewport gamePort;
	private Hud hud;

	private World world;
	private Box2DDebugRenderer b2Render;

	private TmxMapLoader maploader;
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;

	public PantallaEmpezarBusqueda(GravityFalls game) {
		this.game = game;
		// crea la camara para seguir a Mabel/Dipper
		gameCam = new OrthographicCamera();
		// Ajustar el zoom de la cámara
		gameCam.zoom = 1.0f;
		// crea una ventana de ajuste sin distorcionar el mapa
		gamePort = new FitViewport(GravityFalls.V_WIDTH, GravityFalls.V_HEIGHT, gameCam);
		// crea los hubs para las vidas/tiempo/nivel y mas
		hud = new Hud(game.batch);

		maploader = new TmxMapLoader();
		map = maploader.load(Recursos.MAPA);
		renderer = new OrthogonalTiledMapRenderer(map);

		gameCam.position.set(gamePort.getScreenWidth() / 2, gamePort.getScreenHeight() / 2, 0);

		world = new World(new Vector2(0, 0), true);
		b2Render = new Box2DDebugRenderer();

		BodyDef bDef = new BodyDef();
		PolygonShape shape = new PolygonShape();
		FixtureDef fDef = new FixtureDef();
		Body body;

		//suelo
		for (MapObject object : map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)) {
			Rectangle rect = ((RectangleMapObject) object).getRectangle();
			bDef.type = BodyDef.BodyType.StaticBody;
			bDef.position.set(rect.getX() + rect.getWidth() / 2, rect.getY() + rect.getHeight() / 2);

			body = world.createBody(bDef);

			shape.setAsBox(rect.getWidth() / 2, rect.getHeight() / 2);
			fDef.shape = shape;
			body.createFixture(fDef);
		}
		//roca
		for (MapObject object : map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)) {
			Rectangle rect = ((RectangleMapObject) object).getRectangle();
			bDef.type = BodyDef.BodyType.StaticBody;
			bDef.position.set(rect.getX() + rect.getWidth() / 2, rect.getY() + rect.getHeight() / 2);

			body = world.createBody(bDef);

			shape.setAsBox(rect.getWidth() / 2, rect.getHeight() / 2);
			fDef.shape = shape;
			body.createFixture(fDef);
		}

	}

	public void handleInput(float dt) {
		if (Gdx.input.isTouched())
			gameCam.position.x += 100 * dt;
	}

	public void update(float delta) {
		handleInput(delta);

		gameCam.update();
		renderer.setView(gameCam);

	}

	@Override
	public void show() {

		// Centrar la cámara en el mapa
		gameCam.position.set(map.getProperties().get("width", Integer.class) / 2 * 16,
				map.getProperties().get("height", Integer.class) / 2 * 16, 0);

	}

	@Override
	public void render(float delta) {
		update(delta);

		Render.limpiarPantalla(0, 0, 0);

		renderer.setView(gameCam);
		renderer.render();
		
		b2Render.render(world, gameCam.combined);

		game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
		hud.stage.draw();

	}

	@Override
	public void resize(int width, int height) {
		gamePort.update(width, height);

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
