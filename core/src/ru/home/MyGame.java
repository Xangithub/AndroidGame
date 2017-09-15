package ru.home;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGame extends ApplicationAdapter {
	SpriteBatch batch;
	Sprite asteroid;
	Sprite bullet;
	Sprite ship;
	int x=10;
	int y=0;

	@Override
	public void create () {
		batch = new SpriteBatch();
		asteroid = new Sprite("asteroid.png");
		bullet = new Sprite("bullet.png");
		ship = new Sprite("rocket.png", 20,0,1f,5f);
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

		ship.draw(batch);

		batch.end();

	}

	public void update(float deltaTime) {
			ship.update(deltaTime);
			bullet.update(deltaTime);
			asteroid.update(deltaTime);
	}

	@Override
	public void dispose () {
        asteroid.dispose();
        bullet.dispose();
        ship.dispose();
        batch.dispose();
	}
}
