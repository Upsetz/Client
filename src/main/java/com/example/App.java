package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Il client è partito!" );
        try {
        
            Socket s = new Socket("localhost", 3000);
            
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            
            out.writeBytes("ciao a tutti" + '\n');

            String stringaRicevuta = in.readLine();
            System.out.println("stringa ricevuta: " + stringaRicevuta );

            s.close();
       
        } catch (UnknownHostException e) {
            
            e.printStackTrace();
        
        } catch (IOException e) {
            
            e.printStackTrace();
        
        }
    }
}
