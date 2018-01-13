package us.sosia.video.stream.agent;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.sosia.video.stream.agent.ui.SingleVideoDisplayWindow;
import us.sosia.video.stream.handler.StreamFrameListener;

public class StreamClient {
	/**
	 * @author kerr
	 * */
	private final static Dimension dimension = new Dimension(320,240);
	 private  static SingleVideoDisplayWindow displayWindow = null;
	protected final static Logger logger = LoggerFactory.getLogger(StreamClient.class);
        int pto;
        String nombre;
        /*
	public static void main(String[] args) {
		//setup the videoWindow
		displayWindow.setVisible(true);
		
		//setup the connection
		logger.info("setup dimension :{}",dimension);
		StreamClientAgent clientAgent = new StreamClientAgent(new StreamFrameListenerIMPL(),dimension);
		clientAgent.connect(new InetSocketAddress("127.0.0.2", 5000));
	}*/
        public StreamClient(int pto,String nombre){
            //setup the videoWindow
            this.nombre=nombre;
            this.pto=pto;
                displayWindow = new SingleVideoDisplayWindow("Videoconferencia - "+nombre,dimension);
		displayWindow.setVisible(true);
                
                
		
		//setup the connection
		logger.info("setup dimension :{}",dimension);
		StreamClientAgent clientAgent = new StreamClientAgent(new StreamFrameListenerIMPL(),dimension);
		clientAgent.connect(new InetSocketAddress("127.0.0.2", pto));
        
        
        }
	
	
	protected static class StreamFrameListenerIMPL implements StreamFrameListener{
		private volatile long count = 0;
		@Override
		public void onFrameReceived(BufferedImage image) {
			logger.info("frame received :{}",count++);
			displayWindow.updateImage(image);			
		}
		
	}
	

}
