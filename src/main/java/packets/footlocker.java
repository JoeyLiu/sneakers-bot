/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;


/**
 *
 * @author damaomao
 */
public class footlocker {

    void cop(String[] args){

        String model = args[0];
        String sku = args[1];
        String prd = "ANY";
        String size = args[2];
        String price = "1";
        String key = args[3];
        String cookie = args[4];

        StringBuilder sb;
        sb = new StringBuilder();
        
        sb.append("storeCostOfGoods=0.00&model=");
        sb.append(model);
        sb.append("&requestKey=");
        sb.append(key);
        sb.append("&hasXYPromo=false&sameDayDeliveryConfig=false&sku=");
        sb.append(sku);
        sb.append("&the_model_nbr=");
        sb.append(model);
        sb.append("&model_name=");
        sb.append(prd);
        sb.append("&skipISA=no&selectedPrice=%24");
        sb.append(price);
        sb.append("&qty=1&size=");
        sb.append(size);
        sb.append("&fulfillmentType=SHIP_TO_HOME&storeNumber=00000&coreMetricsDo=true&coreMetricsCategory=Add+to+Wish+List+-+PDP&quantity=1&inlineAddToCart=1");
        
        
        String result = sendPostToFootLocker(sb.toString(), cookie);
        System.out.println(result);
    }
    /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    String sendPostToFootLocker(String param, String cookie) {
        long begin = System.currentTimeMillis();
        PrintWriter out = null;
        BufferedReader in = null;
        final String FL = "https://www.footlocker.com/catalog/miniAddToCart.cfm?secure=1&";
        String result = "";
        try {
            HttpsURLConnection conn = util.getHttpsConn(FL);
            
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36");
            conn.setRequestProperty("Host", "www.footlocker.com");
            conn.setRequestProperty("Content-Length", "375");
            conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            conn.setRequestProperty("Referer", "https://www.footlocker.com/product/model:76710/sku:54261001/jordan-retro-3-boys-grade-school/black/grey/");
            conn.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
            conn.setRequestProperty("Accept-Language", "en,zh-CN;q=0.9,zh;q=0.8");
            conn.setRequestProperty("Cookie", cookie);
            
            
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            long end = System.currentTimeMillis();
            //System.out.println(end-begin);
            // 一旦发送成功，用以下方法就可以得到服务器的回应：
              String sCurrentLine;
              String sTotalString;
              sCurrentLine = "";
              sTotalString = "";
              InputStream l_urlStream;
              l_urlStream = conn.getInputStream();
              
              
              GZIPInputStream gzin = new GZIPInputStream(l_urlStream);
              // 三层包装
              BufferedReader l_reader = new BufferedReader(new InputStreamReader(
                gzin,"utf-8"));
              while ((sCurrentLine = l_reader.readLine()) != null) {
               sTotalString += sCurrentLine + "\r\n";
              }
              System.out.println(sTotalString);
            
            util.getResponseHeader(conn);

        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
}
