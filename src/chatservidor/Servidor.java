package chatservidor;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Servidor {
    //Inicializamos el puerto y el numero maximo de conexciones que acepta el servidor
    //private int puertoU = 9000;
    private int noConexiones = 20, idpriv;
    private int puertoM = 4000;
    private String dir = "230.1.1.1";
    private InetAddress grupo = null;
    private String msj = "";
    private int[][] matriz = new int[20][2];//tabla de jugadores
    private String[] nombres = new String[20];
    private int w = 0;
    private String nombre;
    private MulticastSocket sM;
    DatagramPacket out;
    //Creamos una lista de sockets, donde guardaremos los sockets que se vayan conectando
    //private LinkedList<Socket> usuarios = new LinkedList<Socket>();
       
   //Funcion para que el servidor empieze a recibir conexiones de clientes
    public void escuchar(){
        try {
            //crea el grupo para socket multicast
            try{
                    grupo = InetAddress.getByName(dir);
                    System.out.println(grupo);
            }catch(UnknownHostException uhe){
                    System.out.println("Direccion no valida");
                    System.exit(0);
            }
            //Creamos los sockets del servidor
            //ServerSocket sU = new ServerSocket(puertoU,noConexiones);//(9000,20)
           
            sM = new MulticastSocket(puertoM);//(4000)
            sM.setTimeToLive(200);
            sM.joinGroup(grupo);
            String tipo = "";
            byte[] b = msj.getBytes();
            w=0;
            //Ciclo infinito para estar escuchando por nuevos clientes
            while(true){
                System.out.println("Escuchando");
                DatagramPacket in=new DatagramPacket(new byte[1024],1024);
                sM.receive(in);
                String d = new String(in.getData(), 0, in.getLength());
                d=new String(in.getData(), 0, in.getLength());
                System.out.println(""+d+" "+in.getPort());
                    tipo=d;
                    if(tipo.equals("publico")){//si el mensaje es publico llegara "publico"
                        sM.receive(in); 
                        nombre=new String(in.getData(), 0, in.getLength());
                        
                        //----------------------------------------------------------------------extra  publico-camara-puerto
                        //se verifica que no sea una invitacion a videochat
                                if(nombre.equals("camara")){
                                    sM.receive(in); //recibe puerto
                                    d = new String(in.getData(), 0, in.getLength());//puerto
                                    for (int i = 0; i < w; i++) {
                                        if(matriz[i][1]==in.getPort()){
                                            
                                        }else{
                                            //aviso de camara
                                            b = "camara".getBytes();
                                            out = new DatagramPacket(b,b.length,grupo,matriz[i][1]);
                                            sM.send(out);
                                            //envia puerto
                                            b = d.getBytes();
                                            out = new DatagramPacket(b,b.length,grupo,matriz[i][1]);
                                            sM.send(out);//envio el mensaje 
                                        }
                                    }
                                    continue;
                                }
                                //--------------------------------------------------------------extra
                                
                                
                        //extra archivos-----------------
                            if(nombre.equals("archivos")){
                                    
                                    for (int i = 0; i < w; i++) {
                                        if(matriz[i][1]==in.getPort()){
                                            
                                        }else{
                                            //aviso de camara
                                            b="archivos".getBytes();
                                            out= new DatagramPacket(b,b.length,grupo,matriz[i][1]);
                                            sM.send(out);
                                            
                                        }
                                    }
                                    continue;
                                }     
                                
                        //-------------------------------
                        
                        
                        sM.receive(in); 
                        d="<strong>"+nombre+":</strong> "+new String(in.getData(), 0, in.getLength());
                       //Cuando se recibe un mensaje se envia a todos los usuarios conectados 
                        for (int i = 0; i < w; i++) {
                            
                            //aviso de mensaje
                            b="msj".getBytes();
                            out= new DatagramPacket(b,b.length,grupo,matriz[i][1]);
                            sM.send(out);

                            //mensaje
                            b=d.getBytes();
                            out= new DatagramPacket(b,b.length,grupo,matriz[i][1]);
                            sM.send(out);//envio el mensaje 
                        }
                    }else if(tipo.equals("privado")){//si el mensaje es privado llegara "privado" y se enviara solo al puerto del id que reciba
                        
                        //llegara el puerto a envir
                        sM.receive(in); 
                        idpriv=Integer.parseInt(new String(in.getData(), 0, in.getLength()));
                        //llegara el nombre
                        sM.receive(in); 
                        
                            //----------------------------------------------------------------------extra  privado-idpriv-camara-puerto
                        //se verifica que no sea una invitacion a videochat
                                if(new String(in.getData(), 0, in.getLength()).equals("camara")){
                                    sM.receive(in); //recibe puerto
                                    d=new String(in.getData(), 0, in.getLength());//puerto
                                    b="camara".getBytes();
                                    out= new DatagramPacket(b,b.length,grupo,idpriv);
                                    sM.send(out);
                                  
                                    
                                    //puerto
                                    b=d.getBytes();
                                    out= new DatagramPacket(b,b.length,grupo,idpriv);
                                    sM.send(out); 
                                    
                                 
                                      continue;
                                }
                                //--------------------------------------------------------------extra
                                
                                
                                //extra archivos
                                if(new String(in.getData(), 0, in.getLength()).equals("archivos")){
                                    
                                    b="archivos".getBytes();
                                    out= new DatagramPacket(b,b.length,grupo,idpriv);
                                    sM.send(out);
                                  
                                      continue;
                                }
                                //------------------------
              
                        nombre=new String(in.getData(), 0, in.getLength());
                        //despues llega el mensaje
                        sM.receive(in); 
                        d="<strong>"+nombre+":</strong> "+"<strong>"+"Privado"+"</strong> "+new String(in.getData(), 0, in.getLength());
                        
                        
                        //se prepara para enviar El mensaje
                       
                        //aviso de mensaje
                        //-AL IDPRIVADO RECIBIDO
                        b="msj".getBytes();
                        out= new DatagramPacket(b,b.length,grupo,idpriv);
                        sM.send(out);
                        //-al id que envio el mensaje privado
                        b="msj".getBytes();
                        out= new DatagramPacket(b,b.length,grupo,in.getPort());
                        sM.send(out);
                        //mensaje
                        b=d.getBytes();
                        out= new DatagramPacket(b,b.length,grupo,idpriv);
                        sM.send(out); 
                        out= new DatagramPacket(b,b.length,grupo,in.getPort());
                        sM.send(out);

                    }
                
                String msj="Listo";
                //agrego nuevo cliente
                
                if(d.equals(msj)){
                    sM.receive(in);
                    d=new String(in.getData(), 0, in.getLength());
                    System.out.println(""+d+" "+in.getPort());
                    matriz[w][0]=w;
                    matriz[w][1]=in.getPort();
                    nombres[w]=d;//guarda el nombre
                    for (int i = 0; i < w; i++) {//aviso a los antes registrados que se ha agregado un nuevo usuario
                            
                            //aviso de mensaje
                            b="msj".getBytes();
                            out= new DatagramPacket(b,b.length,grupo,matriz[i][1]);
                            sM.send(out);

                            //mensaje
                            String aux="Nuevo cliente agregado "+"<strong>"+d+"</strong> ";
                            b=aux.getBytes();
                            out= new DatagramPacket(b,b.length,grupo,matriz[i][1]);
                            sM.send(out);//envio el mensaje 
                        }
                    w=w+1;
                    System.out.println(""+matriz[w-1][0]+" "+matriz[w-1][1]+" "+nombres[w-1]);
                    //Inicializamos los canales de comunicacion y mandamos un mensaje de bienvenida
                    b="msj".getBytes();
                    DatagramPacket m= new DatagramPacket(b,b.length,grupo,matriz[w-1][1]);
                    sM.send(m);
                    msj="Bienvenido....";
                    b=msj.getBytes();
                    
                    d="";
                    tipo="";
                    m= new DatagramPacket(b,b.length,grupo,matriz[w-1][1]);
                    sM.send(m);
                    System.out.println("Mensaje de bienvenida enviado al puerto "+matriz[w-1][1]);    
                    //Instanciamos un hilo que estara atendiendo al cliente y lo ponemos a escuchar
                    /*Runnable  run = new HiloServidor(in.getPort(),sM,matriz,w-1,grupo,nombres);//puerto para escuchar,multicast servidor,matrkiz de clientes , no de clientes, y eñ grupo multicast
                    Thread hilo = new Thread(run);
                    hilo.start();*/
                    //se envia a todos el listado de clientes registrados y sus puertos
                    for (int i=0;i<w;i++){
                        if(i==0){//se les envia mensaje para que sepan que van a recibir la tabla, y el numero de columnas para las tablas                        
                            for(int h=0;h<w;h++){
                                msj="Lista";  
                                b=msj.getBytes();
                                m= new DatagramPacket(b,b.length,grupo,matriz[h][1]);
                                sM.send(m);
                                
                                msj=Integer.toString(w);
                                b=msj.getBytes();
                                m= new DatagramPacket(b,b.length,grupo,matriz[h][1]);
                                sM.send(m);
                            }
                        }
                        for(int j=0;j<2;j++){//se envia uno a uno los datos de la matriz
                          for(int h=0;h<w;h++){
                                msj=Integer.toString(matriz[i][j]);
                                b=msj.getBytes();
                                m= new DatagramPacket(b,b.length,grupo,matriz[h][1]);
                                sM.send(m);

                            }    
                        }
                            
                    }//for
                    for(int h=0;h<w;h++){
                        for (int i=0;i<w;i++){
                            
                            msj=nombres[h];
                            b=msj.getBytes();
                            m= new DatagramPacket(b,b.length,grupo,matriz[i][1]);
                            sM.send(m);
                        }
                                    
                    }//for
                
                }//if(recibe mensaje "listo")
                
                
            }//while(true)
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
 
    //Funcion main para correr el servidor
    public static void main(String[] args) {
        Servidor servidor= new Servidor();
        servidor.escuchar();
    }
}
