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


/**
 * @author anyhome
 *
 */
public class CacheManager {
	private BaseCache  myCache;
	private static CacheManager instance;
	private static Object lock = new Object();
	private CacheManager() {
	       // 这个根据配置文件来，初始BaseCache而已;
		myCache = new BaseCache("hrms", 300);
	}
	public static CacheManager getInstance() {
	       if (instance == null) {
	           synchronized (lock) {
	              if (instance == null) {
	                  instance = new CacheManager();
	              }
	           }
	       }
	       return instance;
	    }
	public void put(Object news,String key,String[] groups) {
		myCache.put(key, news,groups);
    }
    public void remove(String key) {
    	myCache.remove(key);
    }
    public Object get(String key) {
       try {
           return myCache.get(key);
       } catch (Exception e) {
           return null;
       }
    }
    public void removeAll() {
    	myCache.removeAll();
    }  
    public void removeObjectByGroup(String group){
    	myCache.removeObjectByGroup(group);
    }	
}
