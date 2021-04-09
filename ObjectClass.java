import java.awt.Color;
import java.awt.Graphics;

public class ObjectClass extends MainObject {

	public ObjectClass(GUI m, int x, int y) {
		super("class", m, x, y,120,150);
		
	}
	
	@Override
	public void draw(Graphics g) {
//		g.setColor(Color.WHITE);
//    	g.fillRect(0, 0, 120, 150);
		g.setColor(Color.BLACK);
        for(int j = 0 ; j < 3 ; j++) {
        	g.drawRect(0,50*j, 120, 50);
        }
        
        if(super.selected) {
			g.fillRect(super.north_port.x, super.north_port.y, super.connection_port_width ,super.connection_port_width);
	        g.fillRect(super.east_port.x-super.connection_port_width, super.east_port.y, super.connection_port_width,super.connection_port_width);
	        g.fillRect(super.south_port.x, super.south_port.y-super.connection_port_width ,super.connection_port_width,super.connection_port_width);
	        g.fillRect(super.west_port.x, super.west_port.y, super.connection_port_width,super.connection_port_width);
		}
        	
            
    }

}
