/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servArch;

import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;


public class EnviaArch {
    /*
    public static void main(String[] args) {
		int n=0;
		while(n!=1){
		
			try{
            
			JFileChooser fc= new JFileChooser();
            fc.setMultiSelectionEnabled(true);
            int r=fc.showOpenDialog(null);
            if(r==JFileChooser.APPROVE_OPTION){
                
                File [] f= fc.getSelectedFiles();
				for(int i=0;i<f.length;i++){//FOR repite hasta que se envian todos los archivos
                                        String path=f[i].getAbsolutePath();
                                        long tam=f[i].length();
                                        String nombre=f[i].getName();

                                        Socket cl=new Socket("localhost",4000);
                                        DataOutputStream dos=new DataOutputStream(cl.getOutputStream());
                                        DataInputStream dis=new DataInputStream(new FileInputStream(path));
                                        dos.writeUTF(nombre);

                                        byte[] buf=new byte[1024];
                                        dos.flush();

                                        int m=0;
                                        long enviados=0;
                                        while(enviados<tam){
                                                m=dis.read(buf);
                                                dos.write(buf,0,m);
                                                enviados=enviados+m;
                                                int porcentaje=(int)((enviados*100)/tam);
                                                System.out.println("Se ha enviado el "+porcentaje+"%"+" del archivo: "+nombre);

                                                }//while
                                                //JOptionPane.showMessageDialog(null,"Archivo Enviado "); 
                                                dis.close();
                                                dos.close();
                                                cl.close();
                }//for

						
            }//if
                System.out.println("Hecho");
				
			
        }catch(IOException e){
            e.printStackTrace();
        
    }//while
		
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(null,"Quieres agregar mas archivos","Duda Existencial",dialogButton);
		if(dialogResult == JOptionPane.NO_OPTION){
		n=1;	
			
		}
		
		System.out.println("Quieres agregar mas archivos Si[0] No[1]");
		Scanner sc=new Scanner(System.in);
		n = sc.nextInt();
		}*/
    
public EnviaArch(){
    
    int n=0;
		while(n!=1){
		
			try{
            
			JFileChooser fc= new JFileChooser();
            fc.setMultiSelectionEnabled(true);
            int r=fc.showOpenDialog(null);
            if(r==JFileChooser.APPROVE_OPTION){
                
                File [] f= fc.getSelectedFiles();
				for(int i=0;i<f.length;i++){//FOR repite hasta que se envian todos los archivos
                                        String path=f[i].getAbsolutePath();
                                        long tam=f[i].length();
                                        String nombre=f[i].getName();

                                        Socket cl=new Socket("127.0.0.5",4000);
                                        DataOutputStream dos=new DataOutputStream(cl.getOutputStream());
                                        DataInputStream dis=new DataInputStream(new FileInputStream(path));
                                        dos.writeUTF(nombre);

                                        byte[] buf=new byte[1024];
                                        dos.flush();

                                        int m=0;
                                        long enviados=0;
                                        while(enviados<tam){
                                                m=dis.read(buf);
                                                dos.write(buf,0,m);
                                                enviados=enviados+m;
                                                int porcentaje=(int)((enviados*100)/tam);
                                                System.out.println("Se ha enviado el "+porcentaje+"%"+" del archivo: "+nombre);

                                                }//while
                                                //JOptionPane.showMessageDialog(null,"Archivo Enviado "); 
                                                dis.close();
                                                dos.close();
                                                cl.close();
                }//for

						
            }//if
                System.out.println("Hecho");
				
			
        }catch(IOException e){
            e.printStackTrace();
            
        
    }//while
		
	int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(null,"Quieres agregar mas archivos","Duda Existencial",dialogButton);
		if(dialogResult == JOptionPane.NO_OPTION){
		n=1;	
			
		}	
		
    
    

}
    
}
}
