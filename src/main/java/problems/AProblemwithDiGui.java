/**
 * 
 */
package problems;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
//import net.sf.json.JSONObject;

import com.alibaba.fastjson.JSONObject;

/**
 * @author xiaoy
 *
 */
public class AProblemwithDiGui {

	
	    static int count=0;
	    public static void main(String[] args) {
	        String param="{\"ext_meta\":{\"id\":4332021940090402,\"uid\":0,\"similarity\":1,\"blockOid\":{\"id\":4332021940090402,\"uid\":0,\"similarity\":\"1239545\",\"blockOid\":null,\"blockTopicMd5\":null},\"blockTopicMd5\":{\"id\":4332021940090402,\"uid\":0,\"similarity\":\"1239545\",\"blockOid\":{\"id\":4332021940090402,\"uid\":0,\"similarity\":\"1239545\",\"blockOid\":null,\"blockTopicMd5\":null},\"blockTopicMd5\":null}}, \"msg\":\"found\",\"ext_meta1\":{\"id\":4332021940090402,\"uid\":0,\"similarity\":\"1239545\",\"blockOid\":null,\"blockTopicMd5\":null}}";
	        System.out.println(getLength(param));
	    }
	    static public int getLength(String temp){
	        Boolean flag=true;
	        JSONObject jsonObject= JSONObject.parseObject(temp);  //JSONObject.fromObject(temp);
	        Iterator iteratorValue=jsonObject.values().iterator();
	        Iterator iteratorKey=jsonObject.keySet().iterator();
	        while (iteratorValue.hasNext()){
	            String value=iteratorValue.next().toString();
	            System.out.println(iteratorKey.next()+":"+value);
	            if (value.startsWith("{")){
	                if (flag) {  //单层只记录一次
	                    count++;
	                    flag=false;
	                }
	                int tmp=getLength(value);
	                if (tmp>count)
	                    count=tmp;
	            }
	        }
	        return count;
	    }
	

}
