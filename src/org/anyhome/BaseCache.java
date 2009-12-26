/* ***********************************************
 * author :  Anyhome
 * email  :  ayhome@gmail.com 
 * function: 
 * @date 2009-12-25
 * history:  created by Anyhome
 * ***********************************************/
 
/**
 * 
 */
package org.anyhome;

import java.util.Date;
import com.opensymphony.oscache.base.NeedsRefreshException;
import com.opensymphony.oscache.general.GeneralCacheAdministrator;

/**
 * @author anyhome
 *
 */
public class BaseCache extends GeneralCacheAdministrator  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4463101440033158563L;
	private int refreshPeriod; //过期时间(单位为秒);        
	private String keyPrefix; //关键字前缀字符;       
	public BaseCache(String keyPrefix,int refreshPeriod){   
	    super();   
	    this.keyPrefix = keyPrefix;   
	    this.refreshPeriod = refreshPeriod;   
	} 	
	
	//添加被缓存的对象;   
    public void put(String key,Object value){   
        this.putInCache(this.keyPrefix+"_"+key,value);   
    }   
    //删除被缓存的对象;   
    public void remove(String key){   
        this.flushEntry(this.keyPrefix+"_"+key);   
    }   
    //删除所有被缓存的对象;   
    public void removeAll(Date date){   
        this.flushAll(date);   
    }          
    public void removeAll(){   
        this.flushAll();   
    }   
    // 添加被缓存的对象;
    public void put(String key, Object value,String[] groups) {
       this.putInCache(this.keyPrefix + "_" + key, value,groups);
    }
    //删除该组的缓存对象
    public void removeObjectByGroup(String group){
       this.flushGroup(group);
    }    
    //获取被缓存的对象;   
    public Object get(String key) throws Exception{   
        try{   
            return this.getFromCache(this.keyPrefix+"_"+key,this.refreshPeriod);   
        } catch (NeedsRefreshException e) {   
            this.cancelUpdate(this.keyPrefix+"_"+key);   
            throw e;   
        }     
    }         	
	
}
