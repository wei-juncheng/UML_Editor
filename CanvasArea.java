import java.awt.LayoutManager;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class CanvasArea extends JPanel {

	GUI main_GUI;
	private Timer timer;
	public MainObject pressed_obj=null;
	public MainObject entered_obj=null;
	public ArrayList<MainLine> line;
	public MainLine temp_line=null;
	
	public CanvasArea(GUI m) {
		super();
		setBackground(Color.WHITE);
		setLayout(null);
		this.main_GUI = m;
		
		this.line = new ArrayList<MainLine>();
		
		addMouseListener(new CanvasEvent(m));
		
		TimerTask repeatRepaint= new TimerTask(){
	        @Override
	        public void run() {
	            repaint();
	        }   
	    };
	    timer = new Timer();
	    timer.schedule(repeatRepaint,0,50);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		if(this.temp_line!=null && this.temp_line.end_obj!=null)
			this.temp_line.draw(g);
        
		for(MainLine l: line) {
        	//TODO 如果有temp_line好像就可以拿掉判斷式？
        	if(l.end_obj!=null)
        		l.draw(g);
        }
		
        
	}
	
	

	
	

}
