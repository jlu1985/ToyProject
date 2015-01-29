package jl.playground.spring.di;

import java.util.Map;

public class ColorLibrary {
	private Map<String,Color> colors;
	
	public Map<String, Color> getColors() {
		return colors;
	}

	public void setColors(Map<String, Color> colors) {
		this.colors = colors;
	}

	public Color getColor(String name) {
		return colors.get(name);
	}

	public void setColor(String name, Color color) {
		colors.put(name, color);
	}
}
