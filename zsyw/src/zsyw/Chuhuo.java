/**
 * 
 */
package zsyw;

/**
 * @author Administrator
 *
 */
public class Chuhuo {
	private String costem;
	private String type;
	private int count;
	
	Chuhuo(String costem, String type, int count){
		this.costem = costem;
		this.type =type;
		this.count =count;
	}
	
	public String getCostem() {
		return costem;
	}
	public void setCostem(String costem) {
		this.costem = costem;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	
}
