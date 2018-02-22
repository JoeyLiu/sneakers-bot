/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;

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
        String cookie = "AKA_A2=1; TRACK_USER_P=65993350118093735090122362; LOCALEID=en%5FUS; _ga=GA1.2.1507321155.1514821057; mbdc=DA15D082.FC90.5CA6.BB5F.84B2025B685B; _mibhv=anon-1514821062311-813427269_2389; mbcc=2D466D71-395F-598F-BB82-D6DBC6AAC266; visits=2; rskxRunCookie=0; rCookie=b649609yefnwmsvy1c2r5s; BVBRANDID=57d660e9-6546-424d-a30b-27c33c1a33e5; HASCOOKIESON=true; rmStore=amid:3071; xyz_cr_100238_et_111==undefined&cr=100238&et=111&ap=null; _gid=GA1.2.116857468.1519221507; SSLC=web214; TID=8793%2D29211808022129080268875%2D0; DOTOMI_SESSION=1; bm_sz=8E14E122B86EE0DA55B04853F763CC4D~QAAQrFcyuFgWu7VhAQAA7UGKvTZ4fEmdStPpcBxeAnvD4i9RwkyG62pCx2i6x4esXT8NxgY1dbt5pyPE0M9kTgQ2CT3CiUB9BM7aD7P+pZhCOS74WoZg+vjG2/ld7eHaUA57qZ0moDXQd3204T9Tpcpt/82DyVvbAbSWkvXVatSR1qKQdM1tMREmfhyRKtPmCDTa; SSLB=0; mdr_browser=desktop; ak_bmsc=650826C13E77871E3E6BD93FE214B033B83257AC4A690000F2BA8E5A62050C5B~plqvU5Cb7eOjdE2vAVe+KbRLMq+buv2mOYyZsdFFgBOKLI09eTORMAB/SBwlXer4Y7xSx7erz1I7/6C7RPyE+5WUdAC0ujEKd3Shd+kHTnE9Fv2d1UyTrN0Wc4SkIpzVWZO0TK+S93JqpXdjHh+7wrstbLMuFA9aCzGDqGbI3lenxLbqzq90Ag3jkf222k73P88e4+8edvpKoYakMt/89+ehZBeipZ9YqRpi6kcnkzY5DUB2oWtSL43Sx01DtiG6jmpmtQ1F1dQFtPdkJIv1EtUQq+mMC3RLbX8JJIVI4VURYFQnjmTaCoOjG1bNkBDUSZDivYclkpKvPT52O6YG0ucQ==; cmTPSet=Y; mbcs=0A1C45F3-AC23-58ED-BCC7-DBA69FC4B2DC; IMI_PageVisitCount_www.footlocker.com_release-dates%2F=1; interceptPrompted=false; IMI_PageVisitCount_www.footlocker.com_catalog%2FemptyCart=4; CM_EVENT=%5B%5D; IMI_PageVisitCount_www.footlocker.com_product%2Fmodel%3A76710%2Fsku%3A54261001%2Fjordan-retro-3-boys-grade-school%2Fblack%2Fgrey%2F=1; _gac_UA-50007301-5=1.1519306000.Cj0KCQiA1afSBRD2ARIsAEvBsNm_Br6M5TkZKQ4SjZfUTtRPYcSS-YERu9-TfyIL0S3b33Sg8rsLvP4aAtyJEALw_wcB; BAZAARVOICEUSER=877C39DFC4FFCB92DEA90E8498667119646174653D323031382D30322D3232267573657269643D323230303933353826656D61696C616464726573733D6A756E65736C6179657240676D61696C2E636F6D; SECURE_USER_PROFILE=9cjZfu14NvWv82U7jA63eKjPxrWXePzwu8O1h%2BUwLXNYT3lB50PZcuHLHlLOwEqquvrz3Kk3Q2r7cFJQqU3lQO3B%2BQCX8Ko6g3CyvGRz0mE%3D; USER_PROFILE=Cy4RyF0p%2B4EfM1DWsfsmPjv4lloRySHpQempe1yQDzmetrOfmnunGKTiK9GMOzaSgKlPjiiCNSifNxm3UouMctA%2BG59Cr6klSPPvbELjym57%2BwQU1ib0dWDehkrL%2BnmY7MXinsEMxLP16cSJeDZJx%2BL35EzZIcgs2yVa89e9IjT2FXPLuyAsdoFvjkKoOKOkHTxTRsa4MwXukB8QuF8Pr8IUlENWYzyRo2F%2FJuiag1XZPxfmYLo0AV65KSwx%2FbcPj8XAYX7GL42xeEk9HGUrzm7IDtw5b8KlLCdQv7rjLwMrSQEEBv4OlicTelQOX2g5vNI9kJYgclM%3D; IMI_PageVisitCount_www.footlocker.com_shoppingcart%2F=1; BROWSER_SESSION=Cy4RyF0p%2B4FceUrVwCvwqFIkk%2F3G1%2F5k5hWa4S68U%2Bb6V7qNN40Nj6v1QktvKHoBlvtRp8lXdbUdkt8SA4JumTW773Wyb7rb%2FMjQISyfrkFSUjcbxhCW7cYb4IayY5nMoSjYV7440G87sxs0sk56CMl%2FRvIcbpfxKLTy33WE3epnQ2D4b0T5WhR0XPoeSpC2HEk%2BsQONMAyzphcLBdxTR9feVINE0th5ltvvBB7Ot2XOIUlG5scTWFe5%2B%2FEPHfetv1xxxWx2Bz3SnoZUB9PZQ3TIuYk9dTXew2SKnl451pMNB1d377p5TvPWY7yRz7n9xSPwv9z4JZ5tLGh8z0Qlmmw7Q8r62rRJGwM0RMJjcrZsO0PK%2Btq0SQqjvh60fBF5vSFo349zAZcAQ4AfGczKRyjt5NSdn6nhcOV6s20cxqso7eTUnZ%2Bp4TxXnyaT2zkynIlWASjAPBN8sg1vOyblYAkTlSpDG7aivB%2FkaK%2FGMQWi0HIr5BMqt2zRZkOlRU5W7MXinsEMxLPGjpmUwgcP7r6anNTJ9IVsaLNkAXpLlyYHdBzbU55woMNMdGDWtaV4aCZftGtVVZMr4EakWPp2US6Sdt%2BTidICbZ%2FdOEtc4y5hJP00ooFc%2F3QnG52O%2FHO0Bbqi0Rubso1gpYfDGascwy2yjJLhfSZ1yGuxSkPQ4Y5uvslEJnXLb%2FatcYKuCniSK7iiFUvmR9dC5njSWDFQJk23oo6TDZozVT%2F%2FpbKtg4uj93YuFodyVymUyZ1ZF61rk10g9svMSpqIz7kh1k2HZvivspQcyxPehxV9I88b7aX%2B6jK8W7jx0g%3D%3D; IMI_PageVisitCount_www.footlocker.com__-_%2FN-1z141xe=2; IMI_PageVisitCount_www.footlocker.com_shoppingcart%2Fdefault=8; IMI_PageVisitCount_www.footlocker.com_product%2Fmodel%3A293752%2Fsku%3AQ0067101%2Fnike-epic-react-flyknit-mens=4; AKA_A2=1; IMI_DomainVisitCount_www.footlocker.com=22; IMI_PageVisitCount_www.footlocker.com_product%2Fmodel%3A266161%2Fsku%3ADA9163%2Fadidas-ultra-boost-uncaged-mens%2Fgrey%2Fblack%2F=1; lastRskxRun=1519307157723; _gat=1; lastVisitURL=https://www.footlocker.com/_-_/N-1z141xe; _abck=8DBA54F4EEED305EEEF478325F412F6CB83257763A130000C6546B5A6930272C~0~RpVOI501mL0YvvtUatqLRRkjyZkTE/r7IYjs0mnOdtM=~-1~-1; RECENTSKULIST=54261001%3A76710%3AMain%2CDA9163%3A266161%3AMain%2CH6772004%3A287646%3AMain%2C29487021%3A76713%3AMain; CHOSEN_BANNER=1; CHOSEN_BANNER_ID=; mbox=PC#0ce58a632ff94a2ea9cbf57f57aab824.24_15#1520516963|session#bbc27e1cce5545a287bb8cb9d9d0bb26#1519309223|disable#browser%20timeout#1519308359|check#true#1519307423; bm_sv=DB12848BFA191987DBA998CC5F3EC2E4~7E4NZfuakg6YwO/NgFQpkTIzlrK23QB57dXVLXTumaenClNvZd3W3tkMnpOysBhuojebxtmlJxoqVri86DzBya/XCV0BTMOZ6sXc/f8fcNTFwbek4VHut9kvdkyAcOscHJ0vmI819DOVrnnT+p06rORdqtp4sbV8QEpvHRnz6ao=; SESSION=KHdCxd9YPdi8H%2BRor8YxBY4MZGJtd%2BAWfCWUN7dcnmtzIm%2F9V6PqxtUm7TS6Y37HR6QOrOr%2BN%2BtkT1Z%2F2W6nDwWugUT21PjUcrmItk40voM%3D; stc111427=env:1519306003%7C20180325132643%7C20180222141925%7C32%7C1011942:20190222134925|uid:1516280188609.693158595.4212484.111427.82040467.02:20190222134925|srchist:1011950%3A1516634800%3A20180222152640%7C1011942%3A1516887571%3A20180225133931%7C1011950%3A1516982405%3A20180226160005%7C1011942%3A1518251743%3A20180313083543%7C1011950%3A1518279528%3A20180313161848%7C1011942%3A1518787030%3A20180319131710%7C1011950%3A1518798232%3A20180319162352%7C1011942%3A1519133905%3A20180323133825%7C1011950%3A1519303413%3A20180325124333%7C1011942%3A1519306003%3A20180325132643:20190222134925|nsc:2:20190120122343|tsa:612625655:20180222141925; BVBRANDSID=2d60a2e3-67ba-4a8e-965d-1e86f399b85f; RT=\"sl=60&ss=1519303409865&tt=1097695&obo=15&sh=1519307361424%3D60%3A15%3A1097695%2C1519307336788%3D59%3A15%3A1073059%2C1519307330970%3D58%3A14%3A1073059%2C1519307249920%3D57%3A14%3A992013%2C1519307152277%3D56%3A13%3A992013&dm=footlocker.com&si=4dadf3ab-5c1c-4211-97ef-875ef9c3b06e&bcn=%2F%2F36fb6d09.akstat.io%2F&rl=1&nu=&cl=1519307368711\"";
        String[] args1 = {"293752","Q0067101","ANY","08.5","1"};
        String[] args2 = {"76710","54261001","ANY","04.5","1"};
        int count = 3;
        long begin = System.currentTimeMillis();
        for(int i=0;i<count;i++){
            cop(args1);
            bots.Common.waitforms(1000);
            long end = System.currentTimeMillis();
            System.out.println(end-begin);
        }
        
        
        
    }
    static void cop(String[] args){

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
    static String sendPostToFootLocker(String param, String cookie) {
        
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
            // 定义BufferedReader输入流来读取URL的响应
//            in = new BufferedReader(
//                    new InputStreamReader(conn.getInputStream()));
//            String line;
//            while ((line = in.readLine()) != null) {
//                result += line;
//            }
            
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
