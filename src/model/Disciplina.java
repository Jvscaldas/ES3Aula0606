package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Disciplina")
@NamedNativeQuery(
		name = "disciplina.selectAll",
		query = "SELECT codigo_disc, nome_disc, carga_horaria"
				+ " FROM disciplina",
		resultClass = Disciplina.class
)
public class Disciplina {

	@Id
	@Column
	@NotNull
	private int codigo_disc;
	
	@Column(length = 50)
	private String nome_disc;
	
	@Column
	private int carga_horaria;

	public int getCodigo_disc() {
		return codigo_disc;
	}

	public void setCodigo_disc(int codigo_disc) {
		this.codigo_disc = codigo_disc;
	}

	public String getNome_disc() {
		return nome_disc;
	}

	public void setNome_disc(String nome_disc) {
		this.nome_disc = nome_disc;
	}

	public int getCarga_horaria() {
		return carga_horaria;
	}

	public void setCarga_horaria(int carga_horaria) {
		this.carga_horaria = carga_horaria;
	}

	@Override
	public String toString() {
		return "Disciplina [codigo_disc=" + codigo_disc + ", nome_disc=" + nome_disc + ", carga_horaria="
				+ carga_horaria + "]";
	}

}
