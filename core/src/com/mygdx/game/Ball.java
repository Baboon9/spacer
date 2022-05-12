package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
	public float circleX = 200;
	public float circleY = 100;
	
	public int size = 1;
	public float size_in_level = (float) (Math.pow(size, 2)*100);

	public float xSpeed = 0;
	public float ySpeed = 0;
	
	Ball(int x, int y) {
		circleX = x;
		circleY = y;
	}
	
	void update() {
		circleX += xSpeed * Gdx.graphics.getDeltaTime();;
		circleY += ySpeed * Gdx.graphics.getDeltaTime();;

		if(circleX < 0 || circleX > Gdx.graphics.getWidth()){
			xSpeed *= -1;
		}

		if(circleY < 0 || circleY > Gdx.graphics.getHeight()){
			ySpeed *= -1;
		}	
	}
	
	void render(ShapeRenderer renderer) {
		renderer.begin(ShapeRenderer.ShapeType.Filled);
		renderer.setColor(0, 1, 0, 1);
		renderer.circle(circleX, circleY, size_in_level);
		renderer.end();
		
	}
}
