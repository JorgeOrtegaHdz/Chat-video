package chatcliente;

import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import us.sosia.video.stream.agent.*;
import servArch.*;

public class Cliente implements Runnable{
    //Declaramos las variables necesarias para la conexion y comunicacion
    //private Socket cliente;
    //private DataInputStream in;
    //private DataOutputStream out;
    JEditorPane panel;
    JTable Jtable;
    public StreamClient sc;
    public RecibeArch ra;
    
    private int[][] matriz = new int[20][2];//tabla de jugadores
    private String[] nombres = new String[20];
    
    //inicializao variables
    private String dir = "230.1.1.1";
    //private String dir = "10.100.10.244";
    private InetAddress grupo = null;
    private int ptoS = 4000, w = 0;
    private String mensajes = "";
    private MulticastSocket cl;
    
    byte[] b = null;  
    private DatagramPacket in = new DatagramPacket(new byte[1024],1024);
    private DatagramPacket out;
    private String msj = "";
    private DefaultTableModel modelo;
    public String nombre;
    
    
    //Constructor recibe como parametro el panel donde se mostraran los mensajes
    public Cliente(JEditorPane panel,JTable TabNombres,String nombre){
        this.nombre = nombre;        
        this.panel = panel;
        Jtable=TabNombres;
        modelo=(DefaultTableModel) Jtable.getModel();
        try {//creo el socket
            cl = new MulticastSocket();
            try{//cliente y servidor
                    grupo = InetAddress.getByName(dir);
                    System.out.println(dir);
            }catch(UnknownHostException uhe){
                    System.out.println("Direccion no valida");
                    System.exit(0);
            }
            System.out.println("lel");
            cl.joinGroup(grupo);            
            System.out.println("Socket cliente creado y unido a multicast con exito"); 
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
    
    @Override
    public void run() {
        try{
            //Ciclo infinito que escucha por mensajes del servidor y los muestra en el panel
            while(true){
                System.out.println("Esperando mensajes");
                cl.receive(in);
                System.out.println("Mensaje recibido de "+in.getPort());
                if(in.getPort()!=4000){}else{
                String d=new String(in.getData(), 0, in.getLength());
                String l=" ";
                String aux="";
                String aux1="";
                System.out.println(""+d);
                        //recibo lista de usuarios registrados
                        if(d.equals("Lista")){//recibira la lista de id-puerto y la de nombres
                            l=d;
                            d="";
                            cl.receive(in);//recibe el numerod de usuarios registrados
                            l=new String(in.getData(), 0, in.getLength());
                            w=Integer.parseInt(l);  
                            System.out.println(""+Jtable.getRowCount()+" "+w);
                            if(Jtable.getRowCount()!=0){
                                
                                for(int p=Jtable.getRowCount()-1;p>=0;p--){
                                modelo.removeRow(p);
                                }
                            }
                            
                            for (int i=0;i<w;i++){//recibe uno a uno el id y el PORT de cada usuario registrado
                                
                                
                                for(int j=0;j<2;j++){
                                        cl.receive(in);
                                        l=new String(in.getData(), 0, in.getLength());
                                        matriz[i][j]=Integer.parseInt(l);
                                        System.out.print(" "+matriz[i][j]);
                                        
                                    }
                                System.out.println(" ");
                            }//for
                            for(int h=0;h<w;h++){//revibe los nombres de usuarios
                                cl.receive(in);
                                
                                l=new String(in.getData(), 0, in.getLength());
                                nombres[h]=l;    
                                System.out.println(""+nombres[h]);
                                modelo.addRow(new Object[]{nombres[h],matriz[h][1]});
                               
                            }//for
                        }
                        if(d.equals("msj")){
                        cl.receive(in);
                        d=new String(in.getData(), 0, in.getLength());
                        
                        mensajes +="<br> "+d;
                        System.out.println(""+mensajes);
                        panel.setText(mensajes);
                        }
                        //-------------------------------------------------codigo extra camara 
                        if(d.equals("camara")){
                            cl.receive(in);//puerto
                            int ptocamara=Integer.parseInt(new String(in.getData(), 0, in.getLength()));
                            
                            int result = JOptionPane.showConfirmDialog(null,"¿Acepta invitacion a video-Streaming?",null, JOptionPane.YES_NO_OPTION);
                             if(result == JOptionPane.YES_OPTION) {
                                sc= new StreamClient(ptocamara,nombre);
                                /*Thread hilo = new Thread((Runnable) sc);
                                hilo.start();*/
                             } 
                        }
                        //-------------------------------------------------codigo extra camara 
                        
                        //extra archivos
                        if(d.equals("archivos")){
                            
                            int result = JOptionPane.showConfirmDialog(null,"¿Acepta archivo?",null, JOptionPane.YES_NO_OPTION);
                             if(result == JOptionPane.YES_OPTION) {
                                ra= new RecibeArch();
                                /*Thread hilo = new Thread((Runnable) sc);
                                hilo.start();*/
                             } 
                        }
                        //-------------
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
  
    //Funcion sirve para enviar mensajes al servidor
    
    public void enviarMsg(String msg) {
        System.out.println(msg);
        try {
            b = msg.getBytes();
            out = new DatagramPacket(b , b.length, grupo, ptoS);
            cl.send(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    } 
}
