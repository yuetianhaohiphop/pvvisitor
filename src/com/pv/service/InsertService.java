package com.pv.service;

import java.sql.SQLException;

import com.pv.dao.InsertDao;
import com.pv.model.BlogMsg;

public class InsertService {
	InsertDao insertDao  = new InsertDao();
	public void save(BlogMsg bs) throws SQLException{
		insertDao.save(bs);
	}
}
