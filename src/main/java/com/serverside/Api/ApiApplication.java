package com.serverside.Api;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

//
//	@Bean
//	CommandLineRunner commandLineRunner(UserDao user){
//
//		return args  -> {
//			Users_data x=new Users_data(987L,"ha","ech",88.00);
//			Users_data y=new Users_data(6789L,"mmm","ech",9.00);
//			Users_data z=new Users_data(1234L,"ha","ech",88.00);
//			Users_data q=new Users_data(6732L,"mmm","ech",9.00);
//			Users_data w=new Users_data(987654L,"ha","ech",88.00);
//			Users_data e=new Users_data(84732L,"mmm","ech",9.00);
//			Users_data r=new Users_data(6666L,"ha","ech",88.00);
//			Users_data o=new Users_data(111L,"mmm","ech",9.00);
//            user.add(x);
//			user.add(y);
//			user.add(z);
//			user.add(q);
//			user.add(w);
//			user.add(e);
//			user.add(r);
//			user.add(o);
//};
//	}
//
//	@Bean
//	CommandLineRunner commandl(LoginDao l){
//
//		return args  -> {
//
//
//			Login i=new Login(987L,"h@gmail.com","lkhgfd");
//			Login e=new Login(6789L,"a@gmail.com","lkhgfd");
//			Login v=new Login(1234L,"u@gmail.com","lkhgfd");
//			Login c=new Login(6732L,"l@gmail.com","lkhgfd");
//			Login w=new Login(987L,"p@gmail.com","lkhgfd");
//			Login q=new Login(6666L,"/@gmail.com","lkhgfd");
//			l.add(i);
//			l.add(e);
//			l.add(v);
//			l.add(c);
//			l.add(w);
//			l.add(q);
//
//
//		};
//	}
//
//		@Bean
//	CommandLineRunner command(TransactionDao l){
//
//		return args  -> {
//
//
//			Transaction i=new Transaction(987L,6666L,9888.00);
//			Transaction e=new Transaction(6789L,6666L,9888.00);
//			Transaction v=new Transaction(1234L,6666L,9888.00);
//			Transaction c=new Transaction(6732L,987L,9888.00);
//			Transaction w=new Transaction(987L,6732L,9888.00);
//			Transaction q=new Transaction(6666L,6732L,77.00);
//			l.add(i);
//			l.add(e);
//			l.add(v);
//			l.add(c);
//			l.add(w);
//			l.add(q);
//
//
//		};
//	}



}
