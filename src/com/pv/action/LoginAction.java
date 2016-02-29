package com.pv.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.pv.model.BlogMsg;
import com.pv.service.ReadList;

public class LoginAction extends BaseJson {

	ReadList rl = new ReadList();
	
	public String execute() throws SQLException, IOException{
		
		
		List<BlogMsg> resultList = rl.read();
	
		writeJson(resultList);
		
		return "success";
	}

}
