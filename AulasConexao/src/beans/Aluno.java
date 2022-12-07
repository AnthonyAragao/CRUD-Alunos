package beans;

public class Aluno {
	//Atributos
	private int id;
	private String nomealuno;
	private Curso cursoid;
	
	
	//Add ao construtor
	public void addConstrutor(String nomealuno, Curso cursoid) {
		this.nomealuno = nomealuno;
		this.cursoid = cursoid;
	}
	
	//Renomear metodo toString
	public String toString() {
		return "\nNome do aluno: " + nomealuno + "\nId do curso: " + cursoid.getId();
	}

	
	
	//Getters e Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomealuno() {
		return nomealuno;
	}
	public void setNomealuno(String nomealuno) {
		this.nomealuno = nomealuno;
	}
	public Curso getCursoid() {
		return cursoid;
	}
	public void setCursoid(Curso cursoid) {
		this.cursoid = cursoid;
	}
}
