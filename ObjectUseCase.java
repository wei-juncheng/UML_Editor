import java.awt.Graphics;

public class ObjectUseCase extends MainObject {

	public ObjectUseCase(GUI m, int x, int y) {
		super(m, x, y, 151,101);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawOval(0, 0, 150, 100);
		
		if(super.selected) {
			g.fillRect(this.getWidth()/2, 0, super.connection_port_width ,super.connection_port_width);//北
	        g.fillRect(this.getWidth()-super.connection_port_width, this.getHeight()/2,super.connection_port_width,super.connection_port_width);//東
	        g.fillRect(this.getWidth()/2-super.connection_port_width, this.getHeight()-super.connection_port_width,super.connection_port_width,super.connection_port_width);//南
	        g.fillRect(0, this.getHeight()/2,super.connection_port_width,super.connection_port_width);//西
		}

	}
	
	

}
