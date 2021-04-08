import java.awt.LayoutManager;
import java.awt.Color;

import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;

public class CanvasArea extends JPanel {

	GUI main_GUI;
	private Timer timer;
	
	public CanvasArea(GUI m) {
		super();
		setBackground(Color.WHITE);
		setLayout(null);
		this.main_GUI = m;
		
		addMouseListener(new CanvasEvent(m));
		
		TimerTask repeatRepaint= new TimerTask(){
	        @Override
	        public void run() {
	            repaint();
	        }   
	    };
	    timer = new Timer();
	    timer.schedule(repeatRepaint,100,500);
	}
	
	

	
	

}
