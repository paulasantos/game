package br.com.ufc.es.game.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	
	private String edicao;
	
	private String ano;
	
	@ManyToMany (fetch = FetchType.LAZY)
	@JoinTable(name="usuario_livro",
	joinColumns = @JoinColumn(name="livro_id"),
	inverseJoinColumns = @ JoinColumn(name="usuario_id")) 
	private List<Usuario> usuarios = new ArrayList<Usuario>(0);

	@OneToMany (mappedBy = "livro")
	private List<Comentario> comentarios;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}	
	
	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	public void adicionarUsuario(Usuario usuario){
		this.usuarios.add(usuario);
	}
}
