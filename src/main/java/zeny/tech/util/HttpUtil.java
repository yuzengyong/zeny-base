package zeny.tech.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpUtil {
	public static String getSessionKey(String code) throws ClientProtocolException, IOException{
		String body = "";
		 //创建httpclient对象  
        CloseableHttpClient client = HttpClients.createDefault();  
        //创建get方式请求对象  
        HttpGet httpGet = new HttpGet("https://api.weixin.qq.com/sns/jscode2session?appid=wx195d072301cded72&secret=47ea0011d77b5ec721de56a4b26e6976&js_code="+code+"&grant_type=authorization_code");
        //执行请求操作，并拿到结果（同步阻塞）  
        CloseableHttpResponse response = client.execute(httpGet);  
      //获取结果实体  
        HttpEntity entity = response.getEntity();  
        if (entity != null) {  
            //按指定编码转换结果实体为String类型  
            body = EntityUtils.toString(entity, "UTF-8");  
        }  
        EntityUtils.consume(entity);  
        //释放链接  
        response.close();
        return body;
	}
}
