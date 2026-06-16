package it.maricazocco.myexe_jpa;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

@Entity
@NamedQuery(name="ProdottiByPrezzo", query="SELECT p FROM Prodotto p WHERE p.prezzo BETWEEN :myMin AND :myMax")
public class Prodotto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProdotto;
	private String nome;
	private String marca;
	private double prezzo;
	
	@OneToMany(mappedBy = "prodotto", cascade = CascadeType.ALL)
	private List<Ordine> ordini;
	
	public Prodotto() {
	}
	

	public Prodotto(String nome, String marca, double prezzo) {
		super();
		this.nome = nome;
		this.marca = marca;
		this.prezzo = prezzo;
	}


	public int getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}


	@Override
	public String toString() {
		return "Prodotto " + idProdotto + " -> nome: " + nome + ", marca: " + marca + ", prezzo: " + prezzo;
	}
	
		

}
