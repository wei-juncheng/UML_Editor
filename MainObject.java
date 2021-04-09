import javax.swing.Action;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.event.MouseInputListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.lang.Math;


public abstract class MainObject extends JButton{
	private static final long serialVersionUID = 1L;
	
	public abstract void draw(Graphics g);
	public boolean selected = false;
	int connection_port_width = 5;
	GUI main_GUI;
	int press_start_position_x, press_start_position_y;
	public ArrayList<connection_port> ports;
	connection_port north_port, east_port, south_port, west_port;

	public MainObject(String btn_name, GUI m, int x, int y, int width, int heigh) {
		super(btn_name);
		setContentAreaFilled(false);
		setOpaque(false);
        setBorderPainted(false);
		setBounds(x , y ,width,heigh);
		setForeground(Color.BLACK);
		setBackground(Color.WHITE);
//		.set
		setVerticalAlignment(SwingConstants.TOP);
		this.main_GUI = m;
		this.addMouseListener(new CanvasMouseEvent(this));
		this.addMouseMotionListener(new CanvasMouseEvent(this));
		
		this.north_port = new connection_port(width/2, 0);
		this.east_port = new connection_port(width, heigh/2);
		this.south_port = new connection_port(width/2, heigh);
		this.west_port = new connection_port(0, heigh/2);
		ports = new ArrayList<connection_port>(Arrays.asList(north_port, east_port, south_port, west_port));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
        draw(g);
        
        for(MainObject obj: main_GUI.selected_object) {
        	obj.selected = true;
        }
        
	}
	
	public class connection_port{
		int x;
		int y;
		public connection_port(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public connection_port get_nearest_port(int x, int y) {
		double distance = 99999;
		connection_port nearest_port = ports.get(1);
		
		for(connection_port p: ports) {
			double d = Math.hypot((p.x - x), (p.y - y));
			if(d<distance){
				distance = d;
				nearest_port = p;
			}
		}
		
		return nearest_port;
		
	}
	
	public class CanvasMouseEvent extends MouseAdapter implements MouseInputListener{
		
		MainObject current_obj;
		
		
		public CanvasMouseEvent(MainObject obj) {
			this.current_obj = obj;
		}
		
		public void mouseClicked(MouseEvent event) {
			main_GUI.clear_selected_list();
			main_GUI.selected_object.add(current_obj);
			System.out.println("mouseClicked selected_object.size():"+main_GUI.selected_object.size());
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
			
			
			if(main_GUI.current_clicked_button.getClass().getName()=="Select") {
				if(main_GUI.selected_object.get(0) != current_obj) {
					main_GUI.clear_selected_list();
					//紀錄點擊物件的起始相對位置
					current_obj.press_start_position_x = e.getX();
					current_obj.press_start_position_y = e.getY();
					main_GUI.selected_object.add(current_obj);
				}
				
				for(MainObject obj: main_GUI.selected_object) {
					obj.setLocation(obj.getLocation().x + e.getX()-current_obj.press_start_position_x, obj.getLocation().y +e.getY()-current_obj.press_start_position_y);
				}
			}
			
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
//			System.out.println("mouseMoved X:"+e.getX()+" Y:"+e.getY());
			
			//滑鼠按住移動到其他物件上
//			if(current_obj != main_GUI.canvas_area.pressed_obj) {
//				main_GUI.canvas_area.entered_obj = current_obj;
//				main_GUI.current_clicked_button.CanvasEnterEvent(e.getX(), e.getY(), current_obj);
//			}
			
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			System.out.println("mousePressed X:"+e.getX()+" Y:"+e.getY());
			
			
			
			//紀錄點擊物件的起始相對位置
			current_obj.press_start_position_x = e.getX();
			current_obj.press_start_position_y = e.getY();
			
//			if(main_GUI.current_clicked_button.getClass().getName()=="AssociationLine") {
//				System.out.println("Pressed with AssociationLine");
//			}
			main_GUI.canvas_area.pressed_obj = current_obj;
			main_GUI.current_clicked_button.CanvasPressEvent(e.getX(), e.getY(), current_obj);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
//			main_GUI.current_clicked_button.CanvasReleaseEvent(e.getX(), e.getY(), current_obj);
			System.out.println("mouseReleased X:"+e.getX()+" Y:"+e.getY());
			main_GUI.current_clicked_button.CanvasReleaseEvent(e.getX(), e.getY(), current_obj);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			main_GUI.current_clicked_button.CanvasEnterEvent(e.getX(), e.getY(), current_obj);
//			
			//滑鼠按住移動到其他物件上 - for association line
//			if(main_GUI.canvas_area.pressed_obj != null && current_obj != main_GUI.canvas_area.pressed_obj) {
//				System.out.println("Enter another object");
//				main_GUI.canvas_area.entered_obj = current_obj;
//				main_GUI.current_clicked_button.CanvasEnterEvent(e.getX(), e.getY(), current_obj);
//			}
			System.out.println("mouseEnter X:"+e.getX()+" Y:"+e.getY());
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
//			main_GUI.canvas_area.entered_obj = null;
			main_GUI.current_clicked_button.CanvasExitEvent(e.getX(), e.getY(), current_obj);
//			System.out.println("mouseExited X:"+e.getX()+" Y:"+e.getY());
			
		}
		
	}


}
