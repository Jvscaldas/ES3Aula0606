package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Aluno")
@NamedNativeQuery(
		name = "disciplina.selectAll",
		query = "SELECT ra, nome, email, posicaoVestibular"
				+ " FROM aluno",
		resultClass = Aluno.class
)
public class Aluno {

	@Id
	@Column(length = 13)
	@NotNull
	private String ra;

	@Column(length = 60)
	private String nome;

	@Column(length = 40)
	private String email;

	@Column
	private int posicaoVestibular;

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPosicaoVestibular() {
		return posicaoVestibular;
	}

	public void setPosicaoVestibular(int posicaoVestibular) {
		this.posicaoVestibular = posicaoVestibular;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Aluno [ra=" + ra + ", nome=" + nome + ", email=" + email + ", posicaoVestibular=" + posicaoVestibular
				+ "]";
	}

}
