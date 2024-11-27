package com.bryan.desafioDevSuperior;

import com.bryan.desafioDevSuperior.entities.Order;
import com.bryan.desafioDevSuperior.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class DesafioDevSuperiorApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(DesafioDevSuperiorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Código produto: ");
		int code = sc.nextInt();
		System.out.print("Valor: ");
		double value = sc.nextDouble();
		System.out.print("Desconto: ");
		double discount = sc.nextDouble();

		Order order = new Order(code, value, discount);

		System.out.println("Pedido código " + order.getCode());
		System.out.printf("Valor total: R$ %.2f \n", orderService.total(order));
	}
}
