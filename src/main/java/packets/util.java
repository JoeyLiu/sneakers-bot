/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packets;

import bots.Common;
import static bots.Common.waitforms;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
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
public class util {
         String cookie = "TRACK_USER_P=65993350118093735090122362; LOCALEID=en%5FUS; _ga=GA1.2.1507321155.1514821057; mbdc=DA15D082.FC90.5CA6.BB5F.84B2025B685B; _mibhv=anon-1514821062311-813427269_2389; mbcc=2D466D71-395F-598F-BB82-D6DBC6AAC266; visits=2; rskxRunCookie=0; rCookie=b649609yefnwmsvy1c2r5s; BVBRANDID=57d660e9-6546-424d-a30b-27c33c1a33e5; HASCOOKIESON=true; rmStore=amid:3071; _gid=GA1.2.116857468.1519221507; TID=8793%2D29211808022129080268875%2D0; _gac_UA-50007301-5=1.1519306000.Cj0KCQiA1afSBRD2ARIsAEvBsNm_Br6M5TkZKQ4SjZfUTtRPYcSS-YERu9-TfyIL0S3b33Sg8rsLvP4aAtyJEALw_wcB; xyz_cr_100238_et_111==undefined&cr=100238&et=111&ap=null; SECURE_USER_PROFILE=Sj%2FfewFZmo1dEEO%2BZJvu3ncVsbAA9Q8ifnh9D4vgaNX%2BtoLkI0GtaOHLHlLOwEqquvrz3Kk3Q2r7cFJQqU3lQO3B%2BQCX8Ko6g3CyvGRz0mE%3D; SSLC=web146; DOTOMI_SESSION=1; AKA_A2=1; SSLB=0; bm_sz=E81142EADB0CB30C7DEFF4019AE01472~QAAQrFcyuBDTyMJhAQAAMH/5xx8vXlzqt2GDZytllgo+PJgsG3vzl36su/ii0S4mIhwvxgYcqLjs8PwYqBlqlvUZ39SbgOcZ7dwF8z9WECtxAcYE7e0B13XK3docinuO3RiLx1r1EKXjuHIc0bBY7J7KNQn0i1laseeP3pdpKCfibZxAqIzk7Sm3z4FcrczUPqMm; mdr_browser=desktop; cmTPSet=Y; mbcs=8EF44941-D4E8-56EE-B602-55689002E606; ak_bmsc=4122BC501FB1C2429C2E469BF4B1BAF1B83257ACAD4C0000C866915A764BDB24~plpRAOnDLVDEvRY2EN5KBBRusOjjUKfL6lQwn6PrvfxfM90oZlScbjmuG1Tc3RBkZE2Kk3O+wjLX7cber2GmivMcptFyTr7P1phYc0cUkF5TA+/QUfiuZFrK271g+FpWOgEW8PEx9xQKnwhvuOeSCJFWQvbnsPBnpOGJKYyvZDBIm1CTmY8Ixg5aYzQiiLLIDz+BKkHooby359n2GYVc8yjWJF7/BJeC/2nVcgXb8lLSag+UksDReLHRr+EXWAq+9l; IMI_PageVisitCount_www.footlocker.com_=1; interceptPrompted=false; BAZAARVOICEUSER=F34CB6987581AE1207CA05063610C077646174653D323031382D30322D3234267573657269643D323230303933353826656D61696C616464726573733D6A756E65736C6179657240676D61696C2E636F6D; IMI_PageVisitCount_www.footlocker.com_account%2Fdefault=1; IMI_PageVisitCount_www.footlocker.com_catalog%2FemptyCart=4; RECENTSKULIST=AH2219%3A289972%3AMain; BVBRANDSID=e9b1fff5-9794-43d8-9b49-12e0e898ea17; CARTSKUS=AH2219; IMI_PageVisitCount_www.footlocker.com_product%2Fmodel%3A289972%2Fsku%3AAH2219%2Fadidas-harden-vol=1; USER_PROFILE=Cy4RyF0p%2B4GP48Syi5rg3WOcE0t5hTmSEAPQGkk%2Fj0C8MDvnV39y1lr5jM2mQxXBgKlPjiiCNSifNxm3UouMctA%2BG59Cr6klSPPvbELjym57%2BwQU1ib0dWDehkrL%2BnmY7MXinsEMxLP16cSJeDZJx%2BL35EzZIcgs2yVa89e9IjT2FXPLuyAsdoFvjkKoOKOkHTxTRsa4MwXukB8QuF8Pr8IUlENWYzyRo2F%2FJuiag1XZPxfmYLo0AV65KSwx%2FbcPj8XAYX7GL42xeEk9HGUrzm7IDtw5b8KlLCdQv7rjLwMrSQEEBv4OlicTelQOX2g5vNI9kJYgclM%3D; lastVisitURL=https://www.footlocker.com/shoppingcart/default.cfm?sku=; INLINECARTSUMMARY=1%2C140; stc111427=env:1519478481%7C20180327132121%7C20180224141526%7C16%7C1011950:20190224134526|uid:1516280188609.693158595.4212484.111427.82040467.02:20190224134526|srchist:1011942%3A1518251743%3A20180313083543%7C1011950%3A1518279528%3A20180313161848%7C1011942%3A1518787030%3A20180319131710%7C1011950%3A1518798232%3A20180319162352%7C1011942%3A1519133905%3A20180323133825%7C1011950%3A1519303413%3A20180325124333%7C1011942%3A1519306003%3A20180325132643%7C1011950%3A1519310979%3A20180325144939%7C1011949%3A1519313519%3A20180325153159%7C1011950%3A1519478481%3A20180327132121:20190224134526|nsc:2:20190120122343|tsa:1519478481290.1615722686.5730052.9531110975752268.:20180224141526; lastRskxRun=1519479962128; IMI_DomainVisitCount_www.footlocker.com=9; IMI_PageVisitCount_www.footlocker.com_shoppingcart%2Fdefault=2; CM_EVENT=%5B%22Shopping%20Cart~Checkout%22%5D; BROWSER_SESSION=Cy4RyF0p%2B4FceUrVwCvwqFIkk%2F3G1%2F5k5hWa4S68U%2BZcHM0p%2FTHIh2xldGQ7ju7t5AIUIvdB%2BBBRYhTGtihYQ943aDd%2Bqc%2FgRYqF%2BVrRUn8Q8haC6KezE43QRfrRMs0oX%2FAidPm6sjix3j3ZNbOcziMC1SboA2oKUWfq5HcYzCmNYmo75CvTEImUYBfHEkNMLtlRy2zl4FVyJYAwuWU4FIo0SMvoGcuzLtlRy2zl4FWnYwPSV95XcZRURDg6IXYOmpOOqaaA4n1plOoqT7IDfOwG72rb5A8KaZTqKk%2ByA3xzwKIrnPdpUMAuUqYPokHB%2FR%2BvjE1GU45cdMf3%2FNW8NJUJ6whPLGujQae4Kcndbd%2FgcoZyMaGbDIs0nbrbb2%2Ft6EBqy8Rq6j2JVRdp%2FjHBPyVsjSPA7htvHlO8M9nANk4CBnDpgjoTDIimz8mcIRCuB0fjYOKYeso4RKS00kz4VcqfaIKN2prdLqqGUQUOeZUJE5UqQxu2ooCjM77%2BRD8ajgxkYm134BZFndIqI0QWjOmwoPBLCBASGvEMqP%2BhHsbge2e58goR7riwxmEyJPgkMJh7z796f2L4B4TD15MEFrb%2FB%2FWQ4v2giCYo9LrgLBHKDOsfFeY5VQIGcOmCOhMM7La0I0b%2FCu2WXU3p6Se4lqmWPrdT5lhhcHY77JpJ%2BC3Te0eMkOXTBQ%3D%3D; CHOSEN_BANNER=1; CHOSEN_BANNER_ID=; ORDERAUTH=29211808022129080268875; SESSION=KHdCxd9YPdiAozO%2B%2FkQ%2FGo4MZGJtd%2BAWIJ9VXy9Iw%2FnU%2FL5xwrLgIcjra8RI%2B%2BW2089Xr9QqkGJolrYbWms90b%2Fcu4z3QRcCcrmItk40voM%3D; CHECKOUT_SESSION=KHdCxd9YPdiAozO%2B%2FkQ%2FGo4MZGJtd%2BAWWQhR604N%2BcY67DhqXbpwQg%3D%3D; _abck=8DBA54F4EEED305EEEF478325F412F6CB83257763A130000C6546B5A6930272C~-1~m4y/soCHg2S7YDtMtb+b0dS53gefooZ8qmvlbl2nU5c=~0~-1; mbox=PC#0ce58a632ff94a2ea9cbf57f57aab824.24_15#1520689712|session#7ef902a977c14cf58b0710d18ff3d367#1519481972|check#true#1519480172; _gat=1; RT=\"sl=16&ss=1519478471936&tt=454252&obo=0&sh=1519479959779%3D16%3A0%3A454252%2C1519479919797%3D15%3A0%3A414283%2C1519479647977%3D14%3A0%3A367358%2C1519479588841%3D13%3A0%3A343435%2C1519479544981%3D12%3A0%3A299591&dm=footlocker.com&si=4dadf3ab-5c1c-4211-97ef-875ef9c3b06e&bcn=%2F%2F36fb607e.akstat.io%2F&rl=1\"; bm_sv=25128E5DB981CB84C34F0A908396BEB2~qgVB4svW2An7ZdV++PgCMvpc6xypxULA54S5U+TKzE9RCG/f96mQAyr0Plo2plfd9RNo4KmiqWpvpiOzAEISfCmJ8GCgd8Sys9x57LlXHRQEb4CcQMXwe2HpmOaKcEmz6emOKrRcyp3HaOkoxUEPdgj+puDhv+OSBKfr9sSPGFw=";
        String requestKey = "D6BA5Ca5B51C411D";
    String[] args2 = {"190074","55088610","08.5",requestKey, cookie};
    static Date target = new Date();
    static Date current;
    static void getResponseHeader(HttpsURLConnection conn){
                    Map<String, List<String>> map = conn.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                if(null != entry.getKey()){
                    
//                                        System.out.println(entry.getKey() +
//                             ": " + entry.getValue());
                }
                else{                                       
                    System.out.println(entry.getValue());
                    System.out.println("Content-Encoding: " + conn.getHeaderField("Content-Encoding"));
                }

            }
    }
        private static class DefaultTrustManager implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
        
        
    }
        static HttpsURLConnection getHttpsConn(String url) throws Exception {
            SSLContext ctx = null;
        try {
            ctx = SSLContext.getInstance("TLS");
            ctx.init(new KeyManager[0], new TrustManager[] { new DefaultTrustManager() }, new SecureRandom());
        } catch (KeyManagementException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SSLSocketFactory ssf = ctx.getSocketFactory();
        URL httpsurl = new URL(url);
            // 打开和URL之间的连接
            HttpsURLConnection conn = (HttpsURLConnection) httpsurl.openConnection();
            conn.setSSLSocketFactory(ssf);
            conn.setHostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String arg0, SSLSession arg1) {
                return true;
            }
        });
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            return conn;
        }
    public static void setClock(int hour, int minute){
       
        target.setHours(hour);
        target.setMinutes(minute);
        target.setSeconds(0);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(target);
        calendar.set(Calendar.MILLISECOND, 0);
        target = calendar.getTime();
        //System.out.println(df.format(target));
        
    }
    public  static void redayToStart(){
        //LOGGER.log(Level.SEVERE,"Cop set to " + df.format(target) + " Waiting......");
        current = new Date();       
        while(target.compareTo(current) > 0){
            waitforms(100);
            current = new Date();
            //LOGGER.log(Level.FINER,"Target: " + df.format(target) + " Current: " + df.format(current));
        }
        //LOGGER.log(Level.SEVERE,"Cop starts at " + df.format(current));
    }
    
    class copones implements Runnable{
        
       
        public void run(){
               footlocker fl = new footlocker();
               fl.cop(args2);
        }
//        void setUserID(String user){
//            this.userID = user;
//        }
    }
        void cops(){
        int threads = 3;
        
        ExecutorService executor = Executors.newFixedThreadPool(threads);
//        Runnable copone = () -> {
//            cop("test");
//        };
        for(int i=0;i<threads;i++){
            copones copone = new copones();
//            copone.setUserID(i);
            bots.Common.waitforms(100);
            executor.execute(copone);           
        }
        
        //executor.execute(copone);
        //executor.execute(copone);
        
        executor.shutdown();
    }
}
