package com.pvlstkv.telephone_exchange;

import com.pvlstkv.telephone_exchange.model.Subscriber;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TelephoneExchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelephoneExchangeApplication.class, args);
		var s = new Subscriber();
		s.setAddress("city");
		System.out.println(s.getAddress());


	}

}
