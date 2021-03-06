package io.github.brunoonofre64.vendas.domain.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "clientes")
public class Cliente {

	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "id")
	    private Integer id;

	    @Column(name = "nome", length = 100)
	    private String nome;
	    
	    @Column(name = "cpf", length = 11)
	    private String cpf;

	    @OneToMany( mappedBy = "cliente" , fetch = FetchType.LAZY )
	    private Set<Pedido> pedidos;

	    public Cliente() {
	    }

	    @JsonIgnore
	    public Set<Pedido> getPedidos() {
	        return pedidos;
	    }

	    public void setPedidos(Set<Pedido> pedidos) {
	        this.pedidos = pedidos;
	    }

	    public Cliente(Integer id, String nome) {
	        this.id = id;
	        this.nome = nome;
	    }

	    public Cliente(String nome) {
	        this.nome = nome;
	    }

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    @Override
	    public String toString() {
	        return "Cliente{" +
	                "id=" + id +
	                ", nome='" + nome + '\'' +
	                '}';
	    }

}
