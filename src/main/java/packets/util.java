/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packets;

import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author damaomao
 */
public class util {
    static void getResponseHeader(HttpsURLConnection conn){
                    Map<String, List<String>> map = conn.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                if(null != entry.getKey()){
                                        System.out.println(entry.getKey() +
                             ": " + entry.getValue());
                }
                else{
                    System.out.println(entry.getValue());
                }

            }
    }
}
