package com.mygdx.game;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

public class Lake {
	Point position = new Point();
	int size;
	List<Point> formation = new LinkedList<Point>();
	
	public Lake() {
		position.x = (int) (Math.random() * (double) Level.SIZE); 
		position.y = (int) (Math.random() * (double) Level.SIZE);
		
		size = (int) (5 * Math.random()) + 1; 

		Point initialPoint = new Point(position);
		formation.add(initialPoint);
		for (int i = 0; i < size; i++) {
			
			
		}
	}
	
	
}
