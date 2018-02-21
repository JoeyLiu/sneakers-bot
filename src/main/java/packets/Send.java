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
        String cookie = "TRACK_USER_P=65993350118093735090122362; LOCALEID=en%5FUS; _ga=GA1.2.1507321155.1514821057; mbdc=DA15D082.FC90.5CA6.BB5F.84B2025B685B; _mibhv=anon-1514821062311-813427269_2389; mbcc=2D466D71-395F-598F-BB82-D6DBC6AAC266; visits=2; rskxRunCookie=0; rCookie=b649609yefnwmsvy1c2r5s; BVBRANDID=57d660e9-6546-424d-a30b-27c33c1a33e5; HASCOOKIESON=true; rmStore=amid:3071; xyz_cr_100238_et_111==undefined&cr=100238&et=111&ap=null; _gac_UA-50007301-5=1.1519133899.Cj0KCQiA1afSBRD2ARIsAEvBsNm_Br6M5TkZKQ4SjZfUTtRPYcSS-YERu9-TfyIL0S3b33Sg8rsLvP4aAtyJEALw_wcB; SSLC=web122; DOTOMI_SESSION=1; AKA_A2=1; bm_sz=6C0C384CAAFA87E649419E74B8D844FF~QAAQVlcyuME4erNhAQAA5X+ouLPMP35Hc3WTWSKYnyloxJqDbz05Xq6BjjgMwXz3QbdhNKhH1ofTuVr3Vwos48kUh4Hr+obcPWP/OrQFjPbQSOE7VqOhKH2d/7i8JrepfaBFDVxhiSE2aampPCMi29SWA1RtNzgPvcF16XaDMo9b8ptVxP6R++5Boo2AmIg6Y595; SSLB=0; mdr_browser=desktop; cmTPSet=Y; _gid=GA1.2.116857468.1519221507; mbcs=6D182DA4-D07A-5456-92BE-A5A3AFB6E4D2; ak_bmsc=F8D1B78A62DDEB3BC75D53762ACB68CEB8325756A05B0000027B8D5A42AFE728~plzIYKWIK58XFLrDjizK7pKoBYQqEm1YY6KCRzN94hH4pRcFUmBsOQOXlYKIdW/LyYml5r6t2MFTnIfX40N/pOC5xzX2BRbRv657Hnr+sOtGCtvxsPDfZyyVTBIslUPCpBwD+G6ZOW5z25oCMjKzHRYNm2jsHztb7j9CXcRJTtuj///Svs+9kCYGdsWEh9o53ihgcIbNcSp22qPtLyiZaAm9JMjxNx8pb2lL1HYsK+jnWA7XcTGS2N88cHCdPgpgev; BVBRANDSID=d8f5c421-cef0-4035-b51a-054477bbc5d7; IMI_PageVisitCount_www.footlocker.com_product%2Fmodel%3A277097%2Fsku%3A49557006%2Fnike-air-vapormax-flyknit-womens=1; interceptPrompted=false; TID=5555%2D29211808022129080268875%2D0; BAZAARVOICEUSER=C8AB5F4D59B466F8C2FA060348255908646174653D323031382D30322D3231267573657269643D323230303933353826656D61696C616464726573733D6A756E65736C6179657240676D61696C2E636F6D; USER_PROFILE=Cy4RyF0p%2B4Ebc2zhq8QAj4Di09eCrdoejOY%2F47XxqRcoDpAkOYQAwi5i%2BnGOBceygKlPjiiCNSifNxm3UouMctA%2BG59Cr6klSPPvbELjym57%2BwQU1ib0dWDehkrL%2BnmY7MXinsEMxLP16cSJeDZJx%2BL35EzZIcgs2yVa89e9IjT2FXPLuyAsdoFvjkKoOKOkHTxTRsa4MwXukB8QuF8Pr8IUlENWYzyRo2F%2FJuiag1XZPxfmYLo0AeIyqv5eWO2WLuRxl0r5L%2FGzOfrcZseD4vxvyiQbYAtl7A5xmLx7E4E0U7tUBAtSupEHsCBP%2BfL5QmRlQFPq6qc%3D; SECURE_USER_PROFILE=6pnBvCmjt2t9KCOnu7rSYL2%2BxhD57Pep2yESj6OBbaCXU06Aj8aRK%2BHLHlLOwEqquvrz3Kk3Q2r7cFJQqU3lQO3B%2BQCX8Ko6g3CyvGRz0mE%3D; INLINECARTSUMMARY=0%2C0; BROWSER_SESSION=Cy4RyF0p%2B4FceUrVwCvwqFIkk%2F3G1%2F5k5hWa4S68U%2BaBl469TD2g1kKXj4Kkos68hV8KaonKmSeSINrlil3ozJP2s6eb6BS2n6oVRza3EHvSfD5iBi7fTmPPZ%2B%2FF%2B5P45qm0RCzm2Il%2FAjxT9wkcrr%2FuYFbaSN5e%2FnxlXsozO3IG23W4wmN0yW04pFxjF%2FsC%2FnxlXsozO3Lvdye%2B6HEdEf58ZV7KMztyMl%2BbWxw1%2Fqj%2BfGVeyjM7ckodRrzJgJzKZJS1eDlf1Iv0GKx67D%2F6f0%2BXSoVC00y5Z22nbbhmFrNcDDhaYqaJrRXCz08mW7JwNl%2Bhl6n9JXnRGnR96y772ehAasvEauo9JUCeowSaZcJ52tOuqMlU5vJ6Lu35Dsqi8wjUDvcQVPJgziuMjxFwioStpEhi56u78GteoOrr8nJMcO57%2BCf1nJaMgQWlD4sP%2FNJ4m7QIlLsjlZfhfq8tCBBWWG%2FIUS8EUKVbUOTl0%2FXCPEjWXMINKkGFrXVPSMhWyUA95BtOtfdf%2FocrkXyLF7veBg3S1wVlE%2F1UfRea5AkuTreDoL6GfFghGebNZYfYA6XBnv6FXba80j2QliByUw%3D%3D; IMI_PageVisitCount_www.footlocker.com_catalog%2FemptyCart=5; lastVisitURL=https://www.footlocker.com/_-_/N-1z141xe; RECENTSKULIST=54261001%3A76710%3AMain%2C8448001%3A277097%3AMain; CHOSEN_BANNER=1; CHOSEN_BANNER_ID=; mbox=PC#0ce58a632ff94a2ea9cbf57f57aab824.24_15#1520431750|session#8fc69d64cf5a42e98a369e7957faa8e0#1519224010|check#true#1519222210|disable#browser%20timeout#1519223926; bm_sv=DB3F9AC06DB7ACE91EC67A68F8952674~MFU2JXVOpwywx85JfHGP5A/vVzrtEiVekFnG1YvyoyabcO/+3i+H3OFAqYZ7rVIEmlciydnY7M/+/P2JcSBgeKZzgzLZWAhyXLV5ZS4KtrmzsRm1BxdAnbmf7qKDCGsaV/S4crQghhbgJ034Hapb2AOcDagNAzonlbNshrFpW1c=; SESSION=KHdCxd9YPdg90xbyEq2ft66oFBDolHAYBQ0aEGQNImL5LdFt96applfgiKR18R%2BEaRvDfofVL7PnrJSjuN%2Fil8IFAuFqU6nJcrmItk40voM%3D; stc111427=env:1519221688%7C20180324140128%7C20180221143913%7C8%7C1011950:20190221140913|uid:1516280188609.693158595.4212484.111427.82040467.02:20190221140913|srchist:1011942%3A1516632862%3A20180222145422%7C1011950%3A1516634800%3A20180222152640%7C1011942%3A1516887571%3A20180225133931%7C1011950%3A1516982405%3A20180226160005%7C1011942%3A1518251743%3A20180313083543%7C1011950%3A1518279528%3A20180313161848%7C1011942%3A1518787030%3A20180319131710%7C1011950%3A1518798232%3A20180319162352%7C1011942%3A1519133905%3A20180323133825%7C1011950%3A1519221688%3A20180324140128:20190221140913|nsc:2:20190120122343|tsa:1519221688210.523864751.3769789.372145493043915.32:20180221143913; _abck=8DBA54F4EEED305EEEF478325F412F6CB83257763A130000C6546B5A6930272C~0~RpVOI501mL0YvvtUatqLRRkjyZkTE/r7IYjs0mnOdtM=~-1~-1; RT=\"sl=9&ss=1519221507192&tt=193944&obo=1&sh=1519222170844%3D9%3A1%3A193944%2C1519222148149%3D8%3A1%3A171264%2C1519221913189%3D7%3A1%3A142535%2C1519221873128%3D6%3A1%3A119451%2C1519221807189%3D5%3A1%3A95840&dm=footlocker.com&si=tvhfs1jklk9&rl=1&ld=1519222170845\"; lastRskxRun=1519222176804; IMI_DomainVisitCount_www.footlocker.com=7; IMI_PageVisitCount_www.footlocker.com_product%2Fmodel%3A76710%2Fsku%3A54261001%2Fjordan-retro-3-boys-grade-school%2Fblack%2Fgrey%2F=1";
        
        String[] args1 = {"76710","54261001","Jordan+Retro+3+-+Boys'+Grade+School","04.0","140.00"};
        args = args1;
        
        String model = args[0];
        String sku = args[1];
        String prd = args[2];
        String size = args[3];
        String price = args[4];

        StringBuilder sb;
        sb = new StringBuilder();
        
        sb.append("storeCostOfGoods=0.00&model=");
        sb.append(model);
        sb.append("&requestKey=38CF4B296D175Fp0&hasXYPromo=false&sameDayDeliveryConfig=false&sku=");
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
