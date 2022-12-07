package dao;
import conexao.Conexao;
import beans.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class CursoDAO {
	private Conexao conexao;
	private Connection conn;
	
	//Construtor
	public CursoDAO() {
		this.conexao = new Conexao();
		this.conn = this.conexao.getConexao();		
	}
	 
	
	//Inserir Curso
	public void inserir(Curso curso) {
		String sql = "INSERT INTO cursos(nomecurso, nivel, duracao) VALUES (?,?,?)";
		try {
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			stmt.setString(1, curso.getNomecurso());     
			stmt.setString(2, curso.getNivel());
			stmt.setInt(3, curso.getDuracao());
			stmt.execute();
			System.out.println("Curso Inserido com Sucesso!");
		}catch(Exception e) {
			System.out.println("Erro ao inserir curso; " + e.getMessage());	
		}
	}
	
	
	//Consultar curso
	public Curso consulta(int id) {
		String sql = "SELECT * FROM cursos WHERE id = ?";
		
		try {
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs =  stmt.executeQuery();
			Curso curso = new Curso();
			//Primeiramente, posiciona o ResultSet na primeira posicao
			rs.first();
			curso.setId(id);
			curso.setNomecurso(rs.getString("nomecurso"));		
			curso.setNivel(rs.getString("nivel"));
			curso.setDuracao(rs.getInt("duracao"));
			return curso;
			
		}catch(Exception e) {
			System.out.println("Curso nao encontrado! Verifique se o id foi digitado corretamente.");
			return null;
			
		}
	}
	
	
	//Atualizar curso
	public void atualizar(Curso curso) {
		String sql = "UPDATE cursos SET nomecurso=?, nivel=?, duracao=? WHERE id=?";
		
		try {
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			stmt.setString(1, curso.getNomecurso());
			stmt.setString(2, curso.getNivel());
			stmt.setInt(3, curso.getDuracao());
			stmt.setInt(4, curso.getId());
			stmt.execute();
		}catch(Exception e) {
			System.out.println("Erro ao editar curso: " + e.getMessage());
			}
	}
	
	
	//Excluir curso
	public void excluir(int id) {
		String sql = "DELETE FROM cursos WHERE ID = ?";
		
		try {
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
		}catch(Exception e) {
			System.out.println("Erro ao excluir: " + e.getMessage());
		}
	}
	
	
	//Consulta total
	public List<Curso> consultaTotal(){
		String sql = "SELECT * FROM cursos";
		
		try {
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			List<Curso> listaCursos = new ArrayList<>();
			
			while(rs.next()) {
				Curso curso = new Curso();
				curso.setId(rs.getInt("id"));
				curso.setNomecurso(rs.getString("nomecurso"));
				curso.setNivel(rs.getString("nivel"));
				curso.setDuracao(rs.getInt("duracao"));
				listaCursos.add(curso);	
			}
			return listaCursos;
			
			
		} catch (Exception e) {
			System.out.println("Erro.... " + e.getMessage());
			return null;
		}	
	}
	
	public List<Curso> consultaNome(String nomecurso){
		String sql = "SELECT * FROM cursos WHERE nomecurso LIKE ?";
		try {
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			stmt.setString(1, "%" + nomecurso + "%");
			ResultSet rs = stmt.executeQuery();
			List<Curso> listaCursos = new ArrayList<>();
			
			while(rs.next()) {
				Curso curso = new Curso();
				curso.setId(rs.getInt("id"));
				curso.setNomecurso(rs.getString("nomecurso"));
				curso.setNivel(rs.getString("nivel"));
				curso.setDuracao(rs.getInt("duracao"));
				listaCursos.add(curso);	
			}
			return  listaCursos;
			
		} catch (Exception e) {
			return  null;
		}	
	}
	
		
	}
	
	
