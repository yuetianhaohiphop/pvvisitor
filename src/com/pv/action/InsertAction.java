package com.pv.action;

import java.io.IOException;
import java.sql.SQLException;

import util.Json;

import com.opensymphony.xwork2.ModelDriven;
import com.pv.model.BlogMsg;
import com.pv.service.InsertService;

public class InsertAction extends BaseJson implements ModelDriven<BlogMsg> {

	
	private BlogMsg blogMsg =  new BlogMsg();

	InsertService is =  new InsertService();
	
public String execute() throws  IOException{
		Json j = new Json();
		try {
			is.save(blogMsg);
			j.setSuccess(true);
			j.setMessage("保存成功");
		} catch (SQLException e) {
		
			j.setMessage("保存失败");
		}
		writeJson(j);
		return "success";
	}



@Override
public BlogMsg getModel() {
	
	return blogMsg;
}
	
}
