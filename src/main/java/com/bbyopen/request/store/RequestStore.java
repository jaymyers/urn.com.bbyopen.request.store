package com.bbyopen.request.store;

import org.netkernel.layer0.nkf.INKFRequestContext;
import org.netkernel.module.standard.endpoint.StandardAccessorImpl;

public class RequestStore extends StandardAccessorImpl{
	
	@Override
	public void onSource(INKFRequestContext context) throws Exception{
		String url = context.getThisRequest().getArgumentValue("url");
		// performing sys out, ideally we would store data in a nosql store here
		System.out.println("Captured url = " + url);
		context.createResponseFrom(url);
	}
}