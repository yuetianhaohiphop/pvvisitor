package com.pv.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.pv.model.BlogMsg;

public class BaseJson extends ActionSupport {

	public  void writeJson(Object o) throws IOException{
		String json = JSON.toJSONString(o);
	 
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		System.out.println(json);
		ServletActionContext.getResponse().getWriter().flush();
		ServletActionContext.getResponse().getWriter().close();
	}
	
	
}
