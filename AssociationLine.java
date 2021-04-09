
public class AssociationLine extends MainButton {

	public AssociationLine(String button_name, GUI m) {
		super(button_name, m);
		// TODO Auto-generated constructor stub
	}
	
	public void CanvasPressEvent(int x, int y, MainObject obj) {
		System.out.println("Press!");
		MainObject.connection_port  nearest_port = obj.get_nearest_port(x, y);
		ObjectAssociationLine ass_line = new ObjectAssociationLine(obj, nearest_port);
		//滑鼠還在拖曳時，先加進temp_line，等release時再加進ass_line
		
//		main_GUI.canvas_area.line.add(ass_line);
		main_GUI.canvas_area.temp_line = ass_line;
		
	}
	
	public void CanvasEnterEvent(int x, int y, MainObject obj) {
		System.out.println("Enter!");
		System.out.println("CanvasMoveEvent X:"+x+" Y:"+y);
		
		//當滑鼠按住拖曳時，進入其他物件
		if(main_GUI.canvas_area.pressed_obj!=null && main_GUI.canvas_area.pressed_obj != obj) {
			System.out.println("滑鼠按住拖曳時，進入其他物件");
			main_GUI.canvas_area.entered_obj = obj;
			System.out.println("Enter another oject and create line");
			//給他終點就可以產生線段了
			main_GUI.canvas_area.temp_line.end_obj = obj;
			main_GUI.canvas_area.temp_line.end_port = obj.get_nearest_port(x, y);
		}else if(main_GUI.canvas_area.pressed_obj!=null && main_GUI.canvas_area.pressed_obj == obj && main_GUI.canvas_area.temp_line != null && main_GUI.canvas_area.temp_line.end_obj != null){
			// 進入原本的物件，association線段將不會建立
			//把終點拿掉，他就不會畫線段了
			main_GUI.canvas_area.temp_line.end_obj = null;
			main_GUI.canvas_area.temp_line.end_port = null;
		}
		
	}
	
	public void CanvasReleaseEvent(int x, int y , MainObject obj) {
		
		//當按住滑鼠拖曳，且mouse release的時候進入其他物件，則畫線
		if(main_GUI.canvas_area.pressed_obj!=null && main_GUI.canvas_area.entered_obj!=null) {
			main_GUI.canvas_area.line.add(main_GUI.canvas_area.temp_line);
		}
		main_GUI.canvas_area.temp_line = null;
		main_GUI.canvas_area.entered_obj = null;
		main_GUI.canvas_area.pressed_obj = null;
	}
	
	public void CanvasExitEvent(int x, int y , MainObject obj) {
		
		//當按住滑鼠拖曳 離開某物件，且這個物件不是當初press的那一個
		if(main_GUI.canvas_area.pressed_obj!=null &&  obj != main_GUI.canvas_area.pressed_obj) {
			//歸零
			main_GUI.canvas_area.entered_obj = null;
			
			//把終點拿掉，他就不會畫線段了
			main_GUI.canvas_area.temp_line.end_obj = null;
			main_GUI.canvas_area.temp_line.end_port = null;
		}
		
	}
	
	

}
