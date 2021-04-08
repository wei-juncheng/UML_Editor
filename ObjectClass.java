import java.awt.Color;
import java.awt.Graphics;

public class ObjectClass extends MainObject {

	public ObjectClass(GUI m, int x, int y) {
		super(m, x, y,101,151);
		
	}
	
	@Override
	public void draw(Graphics g) {
        for(int j = 0 ; j < 3 ; j++) {
        	g.drawRect(0,50*j, 100, 50);
        }
        
        if(super.selected) {
			g.fillRect(this.getWidth()/2, 0, super.connection_port_width ,super.connection_port_width);//北
	        g.fillRect(this.getWidth()-super.connection_port_width, this.getHeight()/2,super.connection_port_width,super.connection_port_width);//東
	        g.fillRect(this.getWidth()/2-super.connection_port_width, this.getHeight()-super.connection_port_width,super.connection_port_width,super.connection_port_width);//南
	        g.fillRect(0, this.getHeight()/2,super.connection_port_width,super.connection_port_width);//西
		}
        	
            
    }

}
