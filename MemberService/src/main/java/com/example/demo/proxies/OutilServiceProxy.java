package com.example.demo.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.beans.OutilBean;

@FeignClient(name="OUTIL-SERVICE")
public interface OutilServiceProxy {
	@GetMapping("/outils/{id}")
	public OutilBean findCustomerById(@PathVariable(name = "id") Long
			id);
}
