package com.et.mvc.binding.binders;

import com.et.mvc.binding.BindingContext;
import com.et.mvc.binding.DataBinder;
import com.et.mvc.binding.DataBinders;

public class SqlDateBinder implements DataBinder{
    public Object bind(BindingContext ctx) throws Exception{
        String parameterName = ctx.getParameterName();
        if (!ctx.getPrefix().equals("")){
            parameterName = ctx.getPrefix() + "." + parameterName;
        }
        
        String value = ctx.getRequest().getParameter(parameterName);
        if (value == null){
        	return null;
        } else {
        	if (DataBinders.isAllowEmpty() && value.equals("")) {
        		return null;
        	}
        	return java.sql.Date.valueOf(value.substring(0, 10));
        }
    }

}
