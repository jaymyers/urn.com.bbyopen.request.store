package com.bbyopen.request.store;

import org.netkernel.layer0.nkf.INKFRequest;
import org.netkernel.layer0.nkf.INKFRequestContext;
import org.netkernel.module.standard.endpoint.StandardAccessorImpl;

public class RequestStore extends StandardAccessorImpl{
	
	@Override
	public void onSource(INKFRequestContext context) throws Exception{
		String data = context.source("arg:data", String.class);

		INKFRequest storeRequest = context.createRequest("active:mongoDB");
		storeRequest.addArgumentByValue("dbserver","localhost:27017");
		storeRequest.addArgumentByValue("dbname", "test");
		storeRequest.addArgumentByValue("collection", "test");
		storeRequest.addArgumentByValue("action", "insert");
		storeRequest.addArgumentByValue("data",data);
		
		context.issueRequest(storeRequest);
		
		// performing sys out, ideally we would store data in a nosql store here
		System.out.println("request = " + data);
//		context.createResponseFrom(data);
	}
}
