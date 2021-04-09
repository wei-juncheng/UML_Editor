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
			g.fillRect(super.north_port.x, super.north_port.y, super.connection_port_width ,super.connection_port_width);
	        g.fillRect(super.east_port.x-super.connection_port_width, super.east_port.y, super.connection_port_width,super.connection_port_width);
	        g.fillRect(super.south_port.x, super.south_port.y-super.connection_port_width ,super.connection_port_width,super.connection_port_width);
	        g.fillRect(super.west_port.x, super.west_port.y, super.connection_port_width,super.connection_port_width);
		}

	}
	
	

}
