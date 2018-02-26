package Check;

public enum Color{
	WHITE("2"), BLACK("1"), NONE(" "), INVALID("-1");
	String num = null;
	private Color(String num) {
		this.num = num;
	}
	public String getPlayerNum() {
		return num;
	}
}
