import java.awt.Graphics;

public class ObjectCompositionLine extends MainLine {

	public ObjectCompositionLine(MainObject start_obj, MainObject.connection_port start_port) {
		super(start_obj, start_port);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
		g.drawLine(super.start_obj.getLocation().x+super.start_port.x, super.start_obj.getLocation().y+super.start_port.y, super.end_obj.getLocation().x+super.end_port.x, super.end_obj.getLocation().y+super.end_port.y);
		
		int[] pgx = {
				super.end_obj.getLocation().x+super.end_port.x,
				super.end_obj.getLocation().x+super.end_port.x+5,
				super.end_obj.getLocation().x+super.end_port.x,
				super.end_obj.getLocation().x+super.end_port.x-5
				
		};
		
		int[] pgy = {
				super.end_obj.getLocation().y+super.end_port.y,
				super.end_obj.getLocation().y+super.end_port.y+5,
				super.end_obj.getLocation().y+super.end_port.y+10,
				super.end_obj.getLocation().y+super.end_port.y+5
				
		};
		g.fillPolygon(pgx, pgy, 4);
	}

}
