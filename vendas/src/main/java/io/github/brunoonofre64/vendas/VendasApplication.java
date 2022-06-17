package io.github.brunoonofre64.vendas;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import io.github.brunoonofre64.vendas.domain.entity.Cliente;
import io.github.brunoonofre64.vendas.domain.entity.Pedido;
import io.github.brunoonofre64.vendas.domain.repository.Clientes;
import io.github.brunoonofre64.vendas.domain.repository.Pedidos;

@SpringBootApplication
@RestController
public class VendasApplication {

	  @Bean
	    public CommandLineRunner init(
	            @Autowired Clientes clientes,
	            @Autowired Pedidos pedidos
	    ) {
	        return args -> {
	            System.out.println("Salvando clientes");
	            Cliente fulano = new Cliente("Fulano");
	            clientes.save(fulano);

	            Pedido p = new Pedido();
	            p.setCliente(fulano);
	            p.setDataPedido(LocalDate.now());
	            p.setTotal(BigDecimal.valueOf(100));

	            pedidos.save(p);

//	            Cliente cliente = clientes.findClienteFetchPedidos(fulano.getId());
//	            System.out.println(cliente);
//	            System.out.println(cliente.getPedidos());

//	            pedidos.findByCliente(fulano).forEach(System.out::println);



	        };
	    }

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);

	}

}
