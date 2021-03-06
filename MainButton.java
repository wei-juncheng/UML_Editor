import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainButton extends JButton{

	protected GUI main_GUI;
	public MainButton(String button_name, GUI m) {
		super(button_name);
		this.addActionListener(new button_click_handler(this));
		this.main_GUI = m;
//		setBackground(Color.black);
		setContentAreaFilled(false);
		setOpaque(true);

	}
	
	class button_click_handler implements ActionListener{
		MainButton clicked_button;
		public button_click_handler(MainButton clicked_button) {
			this.clicked_button = clicked_button;
		}
		
		public void actionPerformed(ActionEvent e) {
			for(MainButton button: main_GUI.button_list) {
				button.setBackground(Color.WHITE);
//				System.out.println("set white!");
			}
			
			clicked_button.setBackground(Color.GRAY);
			
			main_GUI.clear_selected_list();
			main_GUI.canvas_area.pressed_obj = null;
			main_GUI.canvas_area.temp_line = null;
			main_GUI.canvas_area.entered_obj = null;
			
			main_GUI.current_clicked_button = clicked_button;
			
			System.out.println(main_GUI.current_clicked_button.getClass().getName());
			
			
		}
	}
	
	public void CanvasClickEvent(int x, int y) {}
	
	public void CanvasPressEvent(int x, int y) {}
	public void CanvasPressEvent(int x, int y, MainObject obj) {} //from object event
	
	public void CanvasReleaseEvent(int x, int y) {}
	public void CanvasReleaseEvent(int x, int y , MainObject obj) {}//from object event
	
	public void CanvasEnterEvent(int x, int y , MainObject obj) {}//from object event
	
	public void CanvasExitEvent(int x, int y , MainObject obj) {}//from object event

}
