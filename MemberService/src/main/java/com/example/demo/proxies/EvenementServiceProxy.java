package com.example.demo.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.beans.EvenementBean;

@FeignClient(name="EVENEMENT-SERVICE")
public interface EvenementServiceProxy {
	@GetMapping("/evenements/{id}")
	public EvenementBean findCustomerById(@PathVariable(name = "id") Long
			id);
}
