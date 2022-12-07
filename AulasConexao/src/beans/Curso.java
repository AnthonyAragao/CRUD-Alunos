package beans;

public class Curso {
	//Atributos
	private int id;
	private String nomecurso;
	private String nivel;
	private int duracao;
	
	//Metodos
	public void addConstrutor(String nomecurso, String nivel, int duracao) {
		this.nomecurso = nomecurso;
		this.nivel = nivel;
		this.duracao = duracao;
	}
	
	
	@Override
	public String toString() {
		return "\nNome do Curso: " + nomecurso+ "\nNivel do curso: " + nivel + "\nDuracao do Curso: " + duracao;
	}

	
	//Getters e Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomecurso() {
		return nomecurso;
	}
	public void setNomecurso(String nomecurso) {
		this.nomecurso = nomecurso;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
}
