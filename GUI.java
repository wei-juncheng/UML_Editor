import javax.swing.*;  

import java.awt.GridLayout;
import java.awt.Container;
import java.awt.BorderLayout;

import java.util.ArrayList;

public class GUI {
	
	JFrame f;
	MainButton current_clicked_button;
	CanvasArea canvas_area;
	public ArrayList<MainObject> selected_object;
	
	public MainButton button_list[] = {
			new Select("select", this),
			new AssociationLine("association", this),
			new GeneralizationLine("generalization", this),
			new Class("class",this),
			new UseCase("usecase", this)
	};

	public static void main(String[] args) {
		          
		new GUI();
 
	}
	
	public GUI() {
		f = new JFrame("UML editor");
		f.setSize(800,800);
		f.setVisible(true);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		selected_object = new ArrayList<MainObject>();
		draw_basic_panel();
		
	}
	
	private void draw_basic_panel() {
		Container all_item = f.getContentPane();
		
		JPanel ToolPanel = new JPanel();
		for(MainButton b:button_list) {
			ToolPanel.add(b);
		}
		ToolPanel.setLayout(new GridLayout(6,1,1,20));
		all_item.add(ToolPanel,BorderLayout.WEST); 
		
		canvas_area = new CanvasArea(this);
		all_item.add(canvas_area, BorderLayout.CENTER);
		
		
		
	}
	
	public void clear_selected_list() {
		for(MainObject obj: selected_object) {
			obj.selected = false;
		}
		selected_object.clear();
	}

}
