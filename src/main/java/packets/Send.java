/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packets;

import bots.Common;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.GZIPInputStream;


import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 *
 * @author damaomao
 */
public class Send {

    public static void main(String[] args){
       
        //String[] args1 = {"289972","AH2219","08.5",requestKey, cookie};
        
        //String[] args2 = {"76710","54261001","04.5",requestKey, cookie};
        int count = 200;
        
        //util.setClock(23, 00);
        //util.redayToStart();
        
        //new util.cops();
        
        util ut = new util();
        ut.cops();
            
//        for(int i=0;i<count;i++){
//            cop(args2);
//            //bots.Common.waitforms(300);           
//        }
    }

        

    
   
    
    


}
