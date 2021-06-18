import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.BorderLayout;

import java.util.ArrayList;

public class GUI {
	
	public JFrame f;
	MainButton current_clicked_button;
	CanvasArea canvas_area;
	public ArrayList<MainObject> selected_object;
	int group_id_count = 0;
	
	public MainButton button_list[] = {
			new Select("select", this),
			new AssociationLine("association line", this),
			new GeneralizationLine("generalization line", this),
			new CompositionLine("composition line", this),
			new Class("class",this),
			new UseCase("use case", this)
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
		draw_menu();
		
	}
	
	private void draw_menu() {
		JMenuBar menu_bar = new JMenuBar();
		JMenu menu = new JMenu("Edit");
		JMenuItem item1 = new JMenuItem("Change Name");
		item1.addActionListener(new change_name_handler());
		JMenuItem item2 = new JMenuItem("Group");
		item2.addActionListener(new group_handler());
		JMenuItem item3 = new JMenuItem("UnGroup");
		item3.addActionListener(new ungroup_handler());
		
		menu.add(item1);
		menu.add(item2);
		menu.add(item3);
		
		menu_bar.add(menu);
		f.add(menu_bar, BorderLayout.NORTH);
		
	}
	
	class change_name_handler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(selected_object.size()<1)
				return;
			String new_name = JOptionPane.showInputDialog(f, "Change name", "Change Object Name");
//			System.out.println(new_name);
			if(new_name!=null)
				selected_object.get(0).setText(new_name);
			
		}
		
	}

	class group_handler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {

			if(selected_object.size()<=1)
				return;
				
			init_group();
			
		}
	}

	class ungroup_handler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {

			if(selected_object.size()<1)
				return;
				
			CompositeGroup root = CompositeGroup.get_root_group(selected_object.get(0).group_belong);
			if(root==null){
				return;
			}

			for (MainObject obj : selected_object) {
				// 物件的group_belong有東西
				if (obj.group_belong!=null) {
					//取得這個物件的root group
					CompositeGroup obj_root = CompositeGroup.get_root_group(obj.group_belong);
					if(obj_root!=root){
						return;
					}
				}else{
					//如果有物件沒有Group，那就不能按下ungroup按鈕
					return;
				}


			}
			System.out.println("執行ungroup");
			CompositeGroup.decomposite_latest_group(root);
			
		}
	}

	public void init_group(){

		CompositeGroup group = new CompositeGroup(group_id_count++, this);
		for (MainObject obj : selected_object) {
			
			// 這個物件不屬於任何Group
			if (obj.group_belong == null) {
				group.add_plain_obj(obj);
			}
			//這個物件有屬於某個Group，那就要把他祖宗十八代全部加進這個新的Group
			else{
				group.add_sub_group(obj.group_belong);
			}
			
		}
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
