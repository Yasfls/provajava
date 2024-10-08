import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        //variável utilizado na seleção switch
        int opt = 0;
        Scanner scanner = new Scanner(System.in);
        //listas utilizadas para armazenamento de dados
        ArrayList<Professor> professores = new ArrayList<Professor>();
        ArrayList<Curso> cursos = new ArrayList<Curso>();
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();

        //utilizado o do while no switch do menu para que até que o menu continue rodando até qe o usuário selcine 7
        do {
            System.out.println("Opções: ");
            System.out.println("1 - Cadastrar Professor");
            System.out.println("2 - Cadastrar Curso");
            System.out.println("3 - Cadastrar Aluno");
            System.out.println("4 - Listar Professores");
            System.out.println("5 - Listar Cursos");
            System.out.println("6 - Listar Alunos");
            System.out.println("7 - Sair");
            try {
                opt = scanner.nextInt();
            
            //opção 1 - inserindo os dados no objeto Pofessor
            switch (opt) {
                case 1: {
                    
                    System.out.println("Digite o id: ");
                    int idProfessor = scanner.nextInt();
                    System.out.println("Digite o nome: ");
                    String nomeProfessor = scanner.next();
                    System.out.println("Digite o departamento: ");
                    String departamentoProf = scanner.next();

                    Professor professor = new Professor(idProfessor, nomeProfessor, departamentoProf);
                    professores.add(professor);
                    
                }
                break;
            //opção 2 - inserindo os dados no objeto curso
                case 2: {
                    System.out.println("Digite o id: ");
                    int idCurso = scanner.nextInt();
                    System.out.println("Digite o nome: ");
                    String nomeCurso = scanner.next();
                    System.out.println("Digite a carga horária: ");
                    int cargaHoras = scanner.nextInt();
                    System.out.println("Digite o id do Professor responsável pelo curso: ");
                    int professorCurso = scanner.nextInt();
                    Professor prof = null;
                    for (Professor professor : professores){
                        if(professor.idProfessor == professorCurso){
                            prof = professor;
                        }
                    }
                    //utilizado if para não deixar inserções com o id inexistente ocorrer (ao inserir o id do professor)
                    if(prof != null ){
                        Curso curso = new Curso(idCurso, nomeCurso, cargaHoras, prof);
                        cursos.add(curso);
                    }else{
                        System.out.println("ID não identificado, favor tentar novamente");
                    }
                    
                }
                break;
            //opção 3 - inserindo os dados no objeto aluno
                case 3: {
                    System.out.println("Digite o id: ");
                    int idAluno = scanner.nextInt();
                    System.out.println("Digite o nome: ");
                    String nomeAluno = scanner.next();
                    System.out.println("Digite a data de nascimento: ");
                    String dataNasc = scanner.next();
                    System.out.println("Digite o cpf: ");
                    String cpf = scanner.next();
                    System.out.println("Digite o id do Curso que o aluno participa: ");
                    int cursoAluno = scanner.nextInt();
                    Curso cursinho = null;
                    for(Curso curso : cursos){
                        if(curso.idCurso == cursoAluno){
                            cursinho = curso;
                        }
                    //utilizado if para não deixar inserções com o id inexistente ocorrer (ao inserir o id do curso)
                    }
                    if(cursinho != null){
                    Aluno aluno = new Aluno(idAluno, nomeAluno, dataNasc, cpf, cursinho);
                    alunos.add(aluno);
                    }else{
                        System.out.println("ID não identificado, favor tentar novamente");
                    }
                }
                break;
            //opção 4 - imprimindo a lista de professores
                case 4:
                //primeiro for imprime os dados normais do objeto professor
                    for (Professor professorPrint : professores) {
                        System.out.println("Nome: " + professorPrint.nomeProfessor);
                        System.out.println("Departamento: " + professorPrint.departamentoProf);
                        System.out.println("Cursos lecionados:");
                    //segundo for para validar se o id do professor está presente na inserção do curso, se sim, ele será impresso junto ao professor
                        for(Curso curso : cursos){
                            if(curso.professorCurso.idProfessor == professorPrint.idProfessor){
                                System.out.println("Curso: " + curso.nomeCurso);
                                int contador = 0;
                            //terceiro for para validar a quantidade de alunos em ada curso em que o professor leciona, utilizando um contador junto ao for
                            //validamos se o id do curso (já validado anteriormente) é o mesmo inserido no auno, se sim, ele conta mais 1 no contador de alunos
                                for(Aluno aluno: alunos){
                                    if(aluno.cursoAluno.idCurso == curso.idCurso){
                                        contador++;
                                    }
                                }
                                //imprimindo a quantidade de alunos
                                System.out.println("Total de alunos no curso: " + contador);
                            }
                        }
                        System.out.println("----------------------");

                    }
                    break;
                //opção 5 imprimindo as inserções do objeto curso com o nome do professor que o leciona, sendo puxado pelo id inserido no objeto
                case 5:
                    for (Curso cursoPrint : cursos) {
                        System.out.println("Nome: " + cursoPrint.nomeCurso);
                        System.out.println("Carga Horária: " + cursoPrint.cargaHoras);
                        System.out.println("Nome Professor: " + cursoPrint.professorCurso.nomeProfessor);
                        System.out.println("----------------------");

                    }
                    break;
                //opção 6 imprimindo as inerções do objeto aluno com o nome do curso em que ele está matriculado, o nome é puxado pelo id inserido no objeto
                case 6:
                    for (Aluno alunoPrint : alunos) {
                        int contador = 0;
                        System.out.println("Nome: " + alunoPrint.nomeAluno);
                        System.out.println("Data de Nascimento: " + alunoPrint.dataNasc);
                        System.out.println("CPF: " + alunoPrint.cpf);
                        System.out.println("Curso: " + alunoPrint.cursoAluno.nomeCurso);
                        System.out.println("----------------------");
                        
                    }
                    break;
                //opção 7 fecha o programa e saí do loop do while
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    break;
            }
        //mensagem de erro do try catch
        } catch (Exception e) {
            System.out.println("Opção inválida");
            scanner.nextLine();
            continue;
        }
        } while (opt != 7);
    
    

        scanner.close();
        }
    
}