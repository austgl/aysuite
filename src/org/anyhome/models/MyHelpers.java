/* ***********************************************
 * author :  Anyhome
 * email  :  ayhome@gmail.com 
 * function: 
 * @date 2009-12-14
 * history:  created by Anyhome
 * ***********************************************/
 
/**
 * 
 */
package org.anyhome.models;

import java.util.List;

/**
 * @author Ayhome
 *
 */
public class MyHelpers {
	private String Url;
	private String HostName;
	private String Controller;
	private String Action;
	private String Method;
	private String ContextPath;
	private String Uri;
	private List<String> Permission;
	public void setUrl(String url) {
		Url = url;
	}
	public String getUrl() {
		return Url;
	}
	public void setHostName(String hostName) {
		HostName = hostName;
	}
	public String getHostName() {
		return HostName;
	}
	public void setController(String controller) {
		Controller = controller;
	}
	public String getController() {
		return Controller;
	}
	public void setAction(String action) {
		Action = action;
	}
	public String getAction() {
		return Action;
	}
	public void setMethod(String method) {
		Method = method;
	}
	public String getMethod() {
		return Method;
	}
	public void setContextPath(String contextPath) {
		ContextPath = contextPath;
	}
	public String getContextPath() {
		return ContextPath;
	}
	public void setUri(String uri) {
		Uri = uri;
	}
	public String getUri() {
		return Uri;
	}
	public void setPermission(List<String> permission) {
		Permission = permission;
	}
	public List<String> getPermission() {
		return Permission;
	}
}
