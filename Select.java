import java.awt.Component;

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
		
		if(this.x1> this.x2) {
			int temp = this.x1;
			this.x1 =this.x2;
			this.x2 = temp;
		}
		
		if(this.y1> this.y2) {
			int temp = this.y1;
			this.y1 =this.y2;
			this.y2 = temp;
		}
		
		
		main_GUI.clear_selected_list();
		
		for(Component obj: main_GUI.canvas_area.getComponents()) {
			if(obj.getLocation().x > this.x1 && obj.getLocation().y>this.y1 && obj.getLocation().x<this.x2 && obj.getLocation().y<this.y2) {
				main_GUI.selected_object.add((MainObject) obj);
			}
		}
	}

}
