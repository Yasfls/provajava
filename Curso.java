    public class Curso {
    int idCurso;
    String nomeCurso;
    int cargaHoras;
    Professor professorCurso;

    public Curso(
        int idCurso,
        String nomeCurso,
        int cargaHoras,
        Professor professorCurso
        ){
            this.idCurso = idCurso;
            this.nomeCurso = nomeCurso;
            this.cargaHoras = cargaHoras;
            this.professorCurso = professorCurso;
        }
}

