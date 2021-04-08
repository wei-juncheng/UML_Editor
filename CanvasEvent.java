import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CanvasEvent extends MouseAdapter {

	
	GUI main_GUI;
	public CanvasEvent(GUI m) {
		this.main_GUI = m;
		// TODO Auto-generated constructor stub
	}
	
	public void mouseClicked(MouseEvent e) {
		System.out.println("CavasEvent Clicke X:"+e.getX()+" Y:"+e.getY());
		main_GUI.current_clicked_button.CanvasClickEvent(e.getX(), e.getY());
	}
	
	public void mouseDragged(MouseEvent e) {
//		main_GUI.current_clicked_button.CanvasDragEvent(e.)
		System.out.println("Dragged");
	}
	
	public void mousePressed(MouseEvent e) {
		main_GUI.current_clicked_button.CanvasPressEvent(e.getX(), e.getY());
		System.out.println("CavasEvent Presse X:"+e.getX()+" Y:"+e.getY());
	}
	
	public void mouseReleased(MouseEvent e) {
		main_GUI.current_clicked_button.CanvasReleaseEvent(e.getX(), e.getY());
		System.out.println("CavasEvent Released X:"+e.getX()+" Y:"+e.getY());
	}

}
