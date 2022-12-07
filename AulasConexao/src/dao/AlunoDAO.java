package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Aluno;
import beans.Curso;
import conexao.Conexao;

public class AlunoDAO {
	//Atributos
	private Conexao conexao;
	private Connection conn;
	
	//Construtor
	public AlunoDAO() {
		this.conexao = new Conexao();
		this.conn = this.conexao.getConexao();	
	}
	
	//Inserir Aluno
	public void inserir(Aluno aluno) {
		String sql = "INSERT INTO alunos(nomealuno, cursoid) VALUES(?,?)";
		
		try {
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			stmt.setString(1, aluno.getNomealuno());
			stmt.setInt(2, aluno.getCursoid().getId());
			stmt.execute();
			
		} catch (Exception e) {
			System.out.println("Erro ao inserir curso; " + e.getMessage());
		}
	}
	
	
	//Atualizar aluno
	public void editar(Aluno aluno) {
		String sql = "UPDATE alunos SET nomealuno=?, cursoid=? WHERE id =?";
		
		try {
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			stmt.setString(1, aluno.getNomealuno());
			stmt.setInt(2, aluno.getCursoid().getId());
			stmt.setInt(3, aluno.getId());
			stmt.execute();
			
		} catch (Exception e) {
			System.out.println("Erro ao atualizar..." + e.getMessage());	
		}	
	}
	
	
	//Excluir Aluno
	public void excluir(int id){
		String sql = "DELETE FROM alunos WHERE ID = ?";
		
		try {
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			
		} catch (Exception e) {
			System.out.println("Erro ao excluir aluno..." + e.getMessage());
		}
	}
	

	//Buscar aluno
	public Aluno consulta(int id) {
		String sql = "SELECT * FROM alunos WHERE ID =?";
		try {
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			//Posicionar o ResultSet na primeira posicao
			rs.first();
			Aluno aluno = new Aluno();
			aluno.setId(id);
			aluno.setNomealuno(rs.getString("nomealuno"));
			Curso cursoid = new Curso();
			cursoid.setId(rs.getInt("cursoid"));
			aluno.setCursoid(cursoid);
			return aluno;
			
		} catch (Exception e) {
			return null;
		}
	}
	
	//Lista de alunos
	public List<Aluno>consultaTotal(){
		String sql = "SELECT alunos.id as id, nomealuno, cursoid, nomecurso, nivel ,duracao FROM alunos JOIN cursos ON alunos.cursoid = cursos.id";
		try {
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			List<Aluno> lista = new ArrayList<>();
			while(rs.next()) {
				Aluno aluno = new Aluno();
				Curso curso = new Curso();
				
				aluno.setNomealuno(rs.getString("nomealuno"));
				aluno.setId(rs.getInt("id"));
				curso.setNomecurso(rs.getString("nomecurso"));
				curso.setId(rs.getInt("cursoid"));
				curso.setDuracao(rs.getInt("duracao"));
				curso.setNivel(rs.getString("nivel"));

				aluno.setCursoid(curso);
				lista.add(aluno);	
			}
			return lista;

		} catch (Exception e) {
			return null;
		}	
	}
	
	
	
	
	
}
