package com.wongweiye;

		import com.wongweiye.serviceImpl.BankAccountServiceImpl;
		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

public class SpringRestApplication {

	@Autowired
	static BankAccountServiceImpl bankAccountServiceImpl;

	public static void main(String[] args) {

		SpringApplication.run(SpringRestApplication.class, args);

		System.out.println(bankAccountServiceImpl.getAccountAmount(10));


	}

}
