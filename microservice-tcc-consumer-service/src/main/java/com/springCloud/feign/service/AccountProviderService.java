package com.springCloud.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "microservice-tcc-provider-service",fallback = AccountProviderServiceFallback.class)
public interface AccountProviderService {

	@RequestMapping(method = RequestMethod.POST, value = "/accountOne/increase")
	public int increaseAmount(@RequestParam("acctId") String acctId, @RequestParam("amount") double amount);


}
