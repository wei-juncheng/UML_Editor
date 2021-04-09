import java.awt.Graphics;

public abstract class MainLine {
	
	MainObject start_obj, end_obj;
	MainObject.connection_port start_port, end_port;

	public MainLine(MainObject start_obj, MainObject.connection_port start_port) {
		// TODO Auto-generated constructor stub
		this.start_obj = start_obj;
		this.start_port = start_port;
		
//		this.end_obj = end_obj;
//		this.end_port_num = end_port_num;
		
	}
	
	abstract public void draw(Graphics g);

}
