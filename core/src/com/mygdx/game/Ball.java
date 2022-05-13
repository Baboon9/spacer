package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
	
	Model model;
	ModelInstance instance;

	
	public float circleX = 0;
	public float circleY = 0;
	
	public int size = 1;
	public float size_in_level = (float) (Math.pow(size, 2)*100);

	public float xSpeed = 0;
	public float ySpeed = 0;
	
	Ball(float x, float y) {
		circleX = x;
		circleY = y;
		
		ModelBuilder mb = new ModelBuilder();
		mb.begin();
		mb.node().id = "ball";
		mb.part("sphere", GL20.GL_TRIANGLES, Usage.Position | Usage.Normal, new Material(ColorAttribute.createDiffuse(Color.WHITE)))
			.sphere(100f, 100f, 100f, 30, 30);
		model = mb.end();
		
		instance = new ModelInstance(model, "ball");
		instance.transform.setToTranslation(circleX, circleY, 0);
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
