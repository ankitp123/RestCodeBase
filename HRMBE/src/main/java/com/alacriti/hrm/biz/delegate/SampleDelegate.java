package com.alacriti.hrm.biz.delegate;

import java.sql.Connection;

import com.alacriti.hrm.bo.ISampleBO;
import com.alacriti.hrm.bo.impl.SampleBO;
import com.alacriti.hrm.log.impl.AppLogger;
import com.alacriti.hrm.util.LogUtil;

public class SampleDelegate extends BaseDelegate {
	private static final AppLogger log = LogUtil.getLogger(SampleDelegate.class);


	public String getMessage() {
		log.debugPrintCurrentMethodName();
		log.logInfo("In delegate");
		boolean rollBack = false;
		Connection connection = null;
		String msg = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			ISampleBO sampleBO = new SampleBO();
			msg = sampleBO.retrieveMessage();
		} catch (Exception e) {
			log.logError("Exception in getMessage " + e.getMessage(), e);
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}

		return msg;
	}

}
