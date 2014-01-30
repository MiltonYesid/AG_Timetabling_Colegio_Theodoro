/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

/**
 *
 * @author milton.fernandez
 */
public class Estructuras {

    public ListaProfesores listaProfesores;
    public ListaCursos listaCursos;
    public Estructuras() {
        this.inicializarListas();
        
        /*
         * Instanciación de varios profesores
         */
        Nodo_profesor profesor = new Nodo_profesor();
        profesor.setId_profesor(1);
        profesor.setNombre("David Saldarriaga");
        /*
         * Disponibilidad Horaria Profesor
         */
        disponibilidadHoraria disponibilidad = new disponibilidadHoraria();
        Nodo_disponibilidad dispo = new Nodo_disponibilidad();
        dispo.setDiaHora(11);
        dispo.setTarea("CLASE");
        dispo.setDiaHora(12);
        dispo.setTarea("CLASE");
        dispo.setDiaHora(21);
        dispo.setTarea("CLASE");
        dispo.setDiaHora(22);
        dispo.setTarea("CLASE");
        dispo.setDiaHora(31);
        dispo.setTarea("CLASE");
        dispo.setDiaHora(41);
        dispo.setTarea("CLASE");
        dispo.setDiaHora(51);
        dispo.setTarea("CLASE");
        disponibilidad.insertar(dispo);
        profesor.setDisponibilidad(disponibilidad);
        /*
         * Lista de Cursos que puede dictar
         */
        cursosAsignadosProfesor listaCurso = new cursosAsignadosProfesor();
        Nodo_Curso curso = new Nodo_Curso();
        curso.setIdCurso(1);
        curso.setNombreCurso("Matemáticas - primero");
        curso.setCantidadHoraria(4);
        listaCurso.insertarCurso(curso);
        this.listaCursos.insertarCurso(curso);
        profesor.setListaCursos(listaCurso);
        this.listaProfesores.insertarProfesor(profesor);
        
        
        /*
         * Instanciación de varios profesores
         */
        profesor = new Nodo_profesor();
        profesor.setId_profesor(1);
        profesor.setNombre("Milton Fernández");
        /*
         * Disponibilidad Horaria Profesor
         */
        disponibilidad = new disponibilidadHoraria();
        dispo = new Nodo_disponibilidad();
        dispo.setDiaHora(36);
        dispo.setTarea("CLASE");
        dispo.setDiaHora(48);
        dispo.setTarea("CLASE");
        dispo.setDiaHora(25);
        dispo.setTarea("CLASE");
        dispo.setDiaHora(22);
        dispo.setTarea("CLASE");
        dispo.setDiaHora(77);
        dispo.setTarea("CLASE");
        dispo.setDiaHora(41);
        dispo.setTarea("CLASE");
        dispo.setDiaHora(85);
        dispo.setTarea("CLASE");
        disponibilidad.insertar(dispo);
        profesor.setDisponibilidad(disponibilidad);
        /*
         * Lista de Cursos que puede dictar
         */
        listaCurso = new cursosAsignadosProfesor();
        curso = new Nodo_Curso();
        curso.setIdCurso(2);
        curso.setNombreCurso("ingles - segundo");
        curso.setCantidadHoraria(4);
        listaCurso.insertarCurso(curso);
        this.listaCursos.insertarCurso(curso);
        profesor.setListaCursos(listaCurso);
        this.listaProfesores.insertarProfesor(profesor);
        
        
        
        
        
    }
    private void inicializarListas()
    {
        this.listaCursos = new ListaCursos();
        this.listaProfesores = new ListaProfesores();
    }
}
