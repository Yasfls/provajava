public class Aluno {
    int idAluno;
    String nomeAluno;
    String dataNasc;
    String cpf;
    Curso cursoAluno;

    public Aluno(
        int idAluno,
        String nomeAluno,
        String dataNasc,
        String cpf,
        Curso cursoAluno
        ){
            this.idAluno = idAluno;
            this.nomeAluno = nomeAluno;
            this.dataNasc = dataNasc;
            this.cpf = cpf;
            this.cursoAluno = cursoAluno;
        }
}
