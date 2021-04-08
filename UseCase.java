import java.awt.Graphics;

public class UseCase extends MainButton {

	public UseCase(String button_name, GUI m) {
		super(button_name, m);
		// TODO Auto-generated constructor stub
		
		
	}
	
	public void CanvasClickEvent(int x, int y) {
		MainObject obj = new ObjectUseCase(super.main_GUI, x,y);
		main_GUI.canvas_area.add(obj);
//		System.out.println(main_GUI.canvas_area.getComponents().length);
		
	}

}
