package it.maricazocco.myexe_jpa;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCliente;
	private String nome;
	private String cognome;
	private String cartaDiCredito;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Ordine> ordini;

	
	public Cliente() {
	}
	
	

	public Cliente(String nome, String cognome, String cartaDiCredito) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.cartaDiCredito = cartaDiCredito;
	}



	public int getIdCliente() {
		return idCliente;
	}



	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCartaDiCredito() {
		return cartaDiCredito;
	}

	public void setCartaDiCredito(String cartaDiCredito) {
		this.cartaDiCredito = cartaDiCredito;
	}

	@Override
	public String toString() {
		return "Cliente " + idCliente + " -> nome: " + nome + ", cognome: " + cognome + ", cartaDiCredito: "
				+ cartaDiCredito;
	}
	
	
}
