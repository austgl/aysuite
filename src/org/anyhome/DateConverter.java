/* ***********************************************
 * author :  Anyhome
 * email  :  ayhome@gmail.com 
 * function: 
 * @date 2009-12-28
 * history:  created by Anyhome
 * ***********************************************/
 
/**
 * 
 */
package org.anyhome;

import com.et.ar.Converter;

/**
 * @author anyhome
 *
 */
public class DateConverter implements Converter {

	/* (non-Javadoc)
	 * @see com.et.ar.Converter#convert(java.lang.Object)
	 */
	@Override
	public Object convert(Object value) {
		if (value==null){
			return null;
		}
		String s = value.toString().substring(0, 10);
		return java.sql.Date.valueOf(s);
	}

}
