import javax.swing.ImageIcon;


public class Select extends MainButton{
	
	int x1, x2, y1, y2;

	public Select(String button_name, GUI m) {
		super(button_name, m);
	}
	
	public void CanvasClickEvent(int x, int y) {
		super.main_GUI.clear_selected_list();
		System.out.println("Clicked!");
		
	}
	
	public void CanvasPressEvent(int x, int y) {
		super.main_GUI.clear_selected_list();
		System.out.println("Press!");
		this.x1 = x;
		this.y1 = y;
	}
	
	public void CanvasReleaseEvent(int x, int y) {
		super.main_GUI.clear_selected_list();
		System.out.println("Release!");
		
		this.x2 = x;
		this.y2 = y;
	}

}
