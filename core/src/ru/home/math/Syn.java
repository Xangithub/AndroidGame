package ru.home.math;

import com.badlogic.gdx.math.Vector2;

public class Syn {
        private float time;
        private static final float AMPLITUDE = 255f / 2f;
        private Vector2 speed;

        public void update(float deltaTime) {
            time += deltaTime;
            int x = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time * 2f));
            int y = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time * 3f));
            int z = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time));
            speed = new Vector2(x, y);
        }

}
