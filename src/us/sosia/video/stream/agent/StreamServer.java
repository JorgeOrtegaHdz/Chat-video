package us.sosia.video.stream.agent;

import java.awt.Dimension;
import java.net.InetSocketAddress;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import static com.sun.javafx.fxml.expression.Expression.add;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class StreamServer {

	/**
	 * @author kerr
	 * @param args
	 */
    /*
	public static void main(String[] args) {
		Webcam.setAutoOpenMode(true);
		Webcam webcam = Webcam.getDefault();
		Dimension dimension = new Dimension(320,240);
		webcam.setViewSize(dimension);

		StreamServerAgent serverAgent = new StreamServerAgent(webcam, dimension);
		serverAgent.start(new InetSocketAddress("127.0.0.2", 5000));
                
                WebcamPanel panel = new WebcamPanel(webcam); 
 		panel.setMirrored(true); 
 
 
 		JFrame window = new JFrame("Cam"); 
 		window.add(panel); 
 		window.setResizable(true); 
 		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
 		window.pack(); 
 		window.setVisible(true); 
	}
    */
    
    //*******************************************************************************
    int pto;
    String nombre;


public StreamServer(int pto,String nombre){
                
    this.pto=pto;
                this.nombre=nombre;
               
                Webcam.setAutoOpenMode(true);
		Webcam webcam = Webcam.getDefault();
                
		Dimension dimension = new Dimension(320,240);
		webcam.setViewSize(dimension);

		StreamServerAgent serverAgent = new StreamServerAgent(webcam, dimension);
		serverAgent.start(new InetSocketAddress("127.0.0.1", pto));
                
                WebcamPanel panel = new WebcamPanel(webcam); 
 		panel.setMirrored(true); 
                
 		JFrame window = new JFrame("Webcam - "+nombre); 
               
                window.add(panel);
        

                window.setResizable(true); 
 		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
 		window.pack(); 
 		window.setVisible(true); 

    }

}
