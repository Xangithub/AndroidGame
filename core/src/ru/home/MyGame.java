package ru.home;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import ru.home.math.Rnd;

public class MyGame extends ApplicationAdapter {
	SpriteBatch batch;
	Sprite asteroid;
	Sprite bullet;
	Sprite ship;
	int x=10;
	int y=0;
	Rectangle screen;

	@Override
	public void create () {
		batch = new SpriteBatch();
		screen = new Rectangle();
		asteroid = new Sprite("asteroid.png", Rnd.nextFloat(10,90),Rnd.nextFloat(10,60),Rnd.nextFloat(300,300),Rnd.nextFloat(30,300));
		bullet = new Sprite("bullet.png", Rnd.nextFloat(10,20),Rnd.nextFloat(10,20),Rnd.nextFloat(100,300),Rnd.nextFloat(30,200));
		ship = new Sprite("rocket.png", Rnd.nextFloat(80,30),Rnd.nextFloat(50,100),Rnd.nextFloat(400,600),Rnd.nextFloat(800,900));
//		ship = new Sprite("rocket.png", 750,400,00f,200f);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		float deltaTime= Gdx.graphics.getDeltaTime();
		update(deltaTime);
		show();
	}

	private void show() {
		batch.begin();
		asteroid.draw(batch);
		ship.draw(batch);

		batch.end();

	}

	public void update(float deltaTime) {
			ship.update(deltaTime, screen);
			bullet.update(deltaTime, screen);
			asteroid.update(deltaTime, screen);
	}

	@Override
	public void resize(int width, int height) {
		System.out.println("resize: width = " + width + " height = " + height);
		screen.set(0f, 0f, width, height);

	}

	public Rectangle getScreen() {
		return screen;
	}

	@Override
	public void dispose () {
        asteroid.dispose();
        bullet.dispose();
        ship.dispose();
        batch.dispose();
	}
}
