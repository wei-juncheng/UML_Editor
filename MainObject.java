import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.event.MouseInputListener;

import java.util.Timer;
import java.util.TimerTask;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public abstract class MainObject extends JButton{
	private static final long serialVersionUID = 1L;
	
	public abstract void draw(Graphics g);
	public boolean selected = false;
	int connection_port_width = 5;
	GUI main_GUI;

	public MainObject(GUI m, int x, int y, int width, int heigh) {
		super();
		setOpaque(false);
        setBorderPainted(false);
		setBounds(x , y ,width,heigh);
		setForeground(Color.BLACK);
//		setVerticalAlignment(SwingConstants.TOP);
		this.main_GUI = m;
		this.addMouseListener(new CanvasMouseEvent(this));
		this.addMouseMotionListener(new CanvasMouseEvent(this));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
        draw(g);
        
        for(MainObject obj: main_GUI.selected_object) {
        	obj.selected = true;
        }
        
	}
	
	class CanvasMouseEvent extends MouseAdapter implements MouseInputListener{
		
		MainObject current_obj;
		int start_position_x, start_position_y, end_position_x, end_position_y;
		
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
//			System.out.println("mouseDragged X:"+e.getX()+" Y:"+e.getY());
//			repaint();
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			System.out.println("mouseMoved X:"+e.getX()+" Y:"+e.getY());
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			System.out.println("mousePressed X:"+e.getX()+" Y:"+e.getY());
			this.start_position_x = e.getX();
			this.start_position_y = e.getY();
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			System.out.println("mouseReleased X:"+e.getX()+" Y:"+e.getY());
			this.end_position_x = e.getX();
			this.end_position_y = e.getY();
			for(MainObject obj: main_GUI.selected_object) {
				obj.setLocation(obj.getLocation().x + this.end_position_x-this.start_position_x, obj.getLocation().y +this.end_position_y-this.start_position_y);
			}
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			System.out.println("mouseEnter X:"+e.getX()+" Y:"+e.getY());
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			System.out.println("mouseExited X:"+e.getX()+" Y:"+e.getY());
			
		}
		
	}


}
