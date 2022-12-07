package conexao;
import java.util.List;
import java.util.Scanner;
import beans.Aluno;
import beans.Curso;
import dao.AlunoDAO;
import dao.CursoDAO;

public class ConexaoDAO {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int opc, duracao, id, idcurso;
		String nome, nivel;
        Curso curso;
        Aluno aluno;
        List<Curso> ListaCursos;
        List<Aluno> ListaAlunos;
        CursoDAO cursoDAO = new CursoDAO();
        AlunoDAO alunoDAO = new AlunoDAO();
        
        
        
       do {
    	   System.out.println("\n\n----------------------------");
    	   System.out.println("        MENU DO CURSO");
    	   System.out.println("Escolha uma opcao");
           System.out.println("1 - Inserir Curso");
           System.out.println("2 - Consultar");
           System.out.println("3 - Ataulizar Curso");
           System.out.println("4 - Excluir curso");
           System.out.println("5 - Consulta total");
           System.out.println("6 - Pesquisar curso pelo nome[Filtrando]");
           System.out.println("0 - Sair");
    
    	   opc = teclado.nextInt();
    	   teclado.nextLine();//Limpar o Buffer
    	   
    	   switch(opc) {
	    	   case 0:
	               System.out.println("\nSaindo.....");
	               break;  
	               
	    	   case 1:
	    		   System.out.println("\nNome do curso: ");
	    		   nome = teclado.nextLine();
	    		   System.out.println("\nNivel do curso: ");
	    		   nivel = teclado.nextLine();
	    		   System.out.println("\nDuracao do curso: ");
	    		   duracao = teclado.nextInt();
	    		   
	    		   curso = new Curso();
	    		   curso.addConstrutor(nome, nivel, duracao);
	    		   cursoDAO.inserir(curso); 		   
	    		   break;
	    		   
	    	   case 2:
	    		   teclado.nextLine();
	    		   System.out.println("\nInsira o id que voce deseja buscar: ");
	    		   id = teclado.nextInt();
	    		   System.out.println(cursoDAO.consulta(id));
	    		   break;
	    	   
	    	   case 3:
	    		   System.out.println("\nAtualize nome do curso: ");
	    		   nome = teclado.nextLine();
	    		   
	    		   System.out.println("\nAtualize nivel do curso: ");
	    		   nivel = teclado.nextLine();
	    		   
	    		   System.out.println("\nAtualize duracao do curso: ");
	    		   duracao = teclado.nextInt();
	    		   
	    		   System.out.println("\nInsira o id que voce deseja editar: ");
	    		   id = teclado.nextInt();
	    		   
	    		   curso = new Curso();
	    		   curso.addConstrutor(nome, nivel, duracao);
	    		   curso.setId(id);
	    		   cursoDAO.atualizar(curso);
	    		   System.out.println("\nCurso atualizado com Sucesso!!! ");
	    		   
	    		   break;
	    		   
	    	    case 4:
	    	    	System.out.println("\nSelecione o id do curso que voce quer excluir: ");
	    	    	id = teclado.nextInt();
	    	    	cursoDAO.excluir(id);
	    	    	System.out.println("\nCurso Excluido com sucesso!");
	    	    	break;
	    	    	
	    	    case 5:
	    	    	ListaCursos = cursoDAO.consultaTotal();
	    	    	for(Curso c : ListaCursos) {
	    	    		System.out.println("\n------------------------\n");
	    	    		System.out.println(c);
	    	    	}
	    	    	break;
	   	
	    	    case 6:
	    	    	System.out.println("\nNome do Curso: ");
	    	    	nome = teclado.nextLine();
	    	    	ListaCursos = cursoDAO.consultaNome(nome);
	    	    	for(Curso c : ListaCursos) {
	    	    		System.out.println("\n------------------------\n");
	    	    		System.out.println(c);
	    	    	}
	    	    	break;
	    	    	
	    	    	
	    		default:
	    			System.out.println("\nOpcao Invalida");
	    	}
       }while(opc != 0);  
       
       
       
       do {
    	   System.out.println("\n\n");
    	   System.out.println("        MENU DO ALUNO");
    	   System.out.println("Escolha uma opcao");
           System.out.println("1 - Inserir Aluno");
           System.out.println("2 - Excluir Aluno");
           System.out.println("3 - Ataulizar Aluno");
           System.out.println("4 - Consulta");
           System.out.println("5 - Consulta total");
           System.out.println("0 - Sair");

    	   opc = teclado.nextInt();
           teclado.nextLine();//Limpar o Buffer
           
           
           switch(opc) {
           		case 1:
           			System.out.println("\nNome do aluno");
           			nome = teclado.nextLine();
           			System.out.println("\nSelecione o curso desejado:");
           			ListaCursos = cursoDAO.consultaTotal();
           			for(Curso c : ListaCursos) {
           				System.out.println(c.getId() + " - "+ c.getNomecurso());
           			}
           			id = teclado.nextInt(); //Numero[id] do Aluno
           			
           			aluno = new Aluno();
           			for(Curso c : ListaCursos) {
           				if(c.getId() == id) {
           					aluno.addConstrutor(nome, c);
           					alunoDAO.inserir(aluno);
           					System.out.println("Aluno adicionado ao Banco de Dados com Sucesso!");
           				}
           			}
           			break;
           			
           		case 2:
           			ListaAlunos = alunoDAO.consultaTotal();
           			System.out.println("\nSelecione o id que voce deseja excluir: ");
           			for(Aluno alunoLista : ListaAlunos) {
           				System.out.println(alunoLista.getId() + " - " + alunoLista.getNomealuno());
           			}
           			id = teclado.nextInt();
           			alunoDAO.excluir(id);
           			System.out.println("Aluno excluido com Sucesso!!!");
           			break;
           			
           		
           		case 3:
           			aluno = new Aluno();
           			System.out.println("\nAtualizar nome do aluno: ");
           			nome = teclado.nextLine();
           			System.out.println("\nInsira o id do aluno que voce deseja editar: ");
           			id = teclado.nextInt();
           			
           			System.out.println("Selecione o curso atualizado");
           			ListaCursos = cursoDAO.consultaTotal();
           			for(Curso c : ListaCursos) {
           				System.out.println(c.getId() + " - " + c.getNomecurso());
           			}
           			
           			idcurso = teclado.nextInt();
           			for(Curso c : ListaCursos) {
           				if(idcurso == c.getId()) {
           					aluno.addConstrutor(nome, c);	
           				}
           			}
           			aluno.setId(id);
           			alunoDAO.editar(aluno);
           			System.out.println("Aluno atualizado com sucesso!");
           			break;
           			
           		
           			
           		case 4:
           			System.out.println("\nSelecione o id do aluno que voce deseja buscar: ");
           			ListaAlunos = alunoDAO.consultaTotal();
           			for(Aluno alunoLista : ListaAlunos) {
           				System.out.println(alunoLista.getId() +  " - "+ alunoLista.getNomealuno());
           			}	
           				
           			id = teclado.nextInt();
           			Aluno a = alunoDAO.consulta(id);
           			System.out.println(a);
           			
           			ListaCursos = cursoDAO.consultaTotal();
           			//Para exibir o curso pertecente ao id do aluno
           			for(Curso c : ListaCursos) {
           				if(c.getId() == a.getCursoid().getId()) {
           					System.out.println("Nome do curso: " + c.getNomecurso());
           				}
           			}
           			break;

           		case 5:
           			ListaAlunos = alunoDAO.consultaTotal();
           			for(Aluno alunoLista : ListaAlunos) {
           				System.out.println("\n\n");
           				System.out.println(alunoLista.getId() + " - " + alunoLista.getNomealuno());
           				System.out.println(alunoLista.getCursoid().getNomecurso());
           				System.out.println(alunoLista.getCursoid().getNivel());
           			}
           			break;
           			
           		case 0:
           			System.out.println("Tchau <3");
           			break;
           			
           		default:
           			System.out.println("\nOpcao Invalida");
           			
           }
           
       }while(opc != 0);
  
     
       
       
    }
	
} 
