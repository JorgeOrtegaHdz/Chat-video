/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servArch;
import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;
        
public class RecibeArch {
/*
    public static void main(String[] args) {
        try{
            //String archivo="archivo.pdf";
            ServerSocket s=new ServerSocket(4000);//mismo puerto en todos
            System.out.println("Esperando cliente...");
            for(;;){
                Socket cl=s.accept();//acepta la conexion
                //System.out.println("Cliente conectado desde:"+cl.getInetAddress().getHostAddress()+":"+cl.getPort());
				
                
                byte[] buf=new byte[1024];
                DataInputStream dis=new DataInputStream(cl.getInputStream());
				
				//Obtener nombre del archivo
                String archivo=dis.readUTF().toString();
                DataOutputStream dos= new DataOutputStream(new FileOutputStream(archivo));
				
				System.out.println("Recibiendo Archivo: "+archivo);
				
                int n=0;
                while((n=dis.read(buf))!=-1){
                    dos.write(buf,0,n);
                }//while
                System.out.println("Archivo Recibido....");
                JOptionPane.showMessageDialog(null,"Archivo Recibido" );
                dis.close();
                dos.close();
                cl.close();
            }//for
           
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }//main
    */
    public RecibeArch(){
    try{
            //String archivo="archivo.pdf";
            ServerSocket s=new ServerSocket(4000);//mismo puerto en todos
            System.out.println("Esperando cliente...");
            for(;;){
                Socket cl=s.accept();//acepta la conexion
                //System.out.println("Cliente conectado desde:"+cl.getInetAddress().getHostAddress()+":"+cl.getPort());
				
                
                byte[] buf=new byte[1024];
                DataInputStream dis=new DataInputStream(cl.getInputStream());
				
				//Obtener nombre del archivo
                String archivo=dis.readUTF().toString();
                DataOutputStream dos= new DataOutputStream(new FileOutputStream(archivo));
				
				System.out.println("Recibiendo Archivo: "+archivo);
				
                int n=0;
                while((n=dis.read(buf))!=-1){
                    dos.write(buf,0,n);
                }//while
                System.out.println("Archivo Recibido....");
                JOptionPane.showMessageDialog(null,"Archivo Recibido" );
                dis.close();
                dos.close();
                cl.close();
            }//for
           
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}//class




