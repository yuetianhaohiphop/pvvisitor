package com.pv.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pv.dao.ReadDao;
import com.pv.model.BlogMsg;

public class ReadList  {

	ReadDao rd = new ReadDao();

	public List read() throws SQLException {

		List<BlogMsg> resultList = rd.select();

		return resultList;

	}

}
