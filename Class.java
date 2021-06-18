
public class Class extends MainButton {

	
	public Class(String button_name, GUI m) {
		super(button_name, m);
	}
	
	
	public void CanvasClickEvent(int x, int y) {
		MainObject obj = new ObjectClass(super.main_GUI, x,y);
		main_GUI.canvas_area.add(obj);
		// System.out.println(main_GUI.canvas_area.getComponents().length);
		
	}

}
