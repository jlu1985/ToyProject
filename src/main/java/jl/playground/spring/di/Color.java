package jl.playground.spring.di;

public class Color {
	private String id;
	private String RGB;
	private String HCL;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRGB() {
		return RGB;
	}
	public void setRGB(String rGB) {
		RGB = rGB;
	}
	public String getHCL() {
		return HCL;
	}
	public void setHCL(String hCL) {
		HCL = hCL;
	}
	
	@Override
	public String toString() {
		return "Color [id=" + id + ", RGB=" + RGB + ", HCL=" + HCL + "]";
	}
	

}
