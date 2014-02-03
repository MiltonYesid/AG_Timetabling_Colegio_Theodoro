/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

import java.util.Vector;

/**
 *
 * @author milton.fernandez
 */
public class Estructuras {

    public ListaProfesores listaProfesores;
    public ListaCursos listaCursos;
    public int idCurso = 1;
    public int idProfesor = 1;
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

        /*
         * Instanciación de varios profesores
         */
        profesor = new Nodo_profesor();
        profesor.setId_profesor(5);
        profesor.setNombre("Leidy Velez");
        /*
         * Disponibilidad Horaria Profesor
         */
        disponibilidad = new disponibilidadHoraria();
        dispo = new Nodo_disponibilidad();
        dispo.setDiaHora(40);
        dispo.setTarea("CLASE");
        dispo.setDiaHora(48);
        dispo.setTarea("CLASE");
        dispo.setDiaHora(25);
        dispo.setTarea("CLASE");
        dispo.setDiaHora(22);
        dispo.setTarea("CLASE");
        dispo.setDiaHora(44);
        dispo.setTarea("CLASE");
        dispo.setDiaHora(41);
        dispo.setTarea("CLASE");
        dispo.setDiaHora(53);
        dispo.setTarea("CLASE");
        disponibilidad.insertar(dispo);
        profesor.setDisponibilidad(disponibilidad);
        /*
         * Lista de Cursos que puede dictar
         */
        listaCurso = new cursosAsignadosProfesor();
        curso = new Nodo_Curso();
        curso.setIdCurso(7);
        curso.setNombreCurso("cultura");
        curso.setCantidadHoraria(4);
        listaCurso.insertarCurso(curso);
        this.listaCursos.insertarCurso(curso);
        profesor.setListaCursos(listaCurso);
        this.listaProfesores.insertarProfesor(profesor);

        /*
         * Instanciación de varios profesores
         */
        profesor = new Nodo_profesor();
        profesor.setId_profesor(10);
        profesor.setNombre("hernando silva");
        /*
         * Disponibilidad Horaria Profesor
         */
        disponibilidad = new disponibilidadHoraria();
        dispo = new Nodo_disponibilidad();
        dispo.setDiaHora(40);
        dispo.setTarea("CLASE");
        dispo.setDiaHora(48);
        dispo.setTarea("CLASE");
        dispo.setDiaHora(25);
        dispo.setTarea("CLASE");
        dispo.setDiaHora(22);
        dispo.setTarea("CLASE");
        dispo.setDiaHora(44);
        dispo.setTarea("CLASE");
        dispo.setDiaHora(41);
        dispo.setTarea("CLASE");
        dispo.setDiaHora(53);
        dispo.setTarea("CLASE");
        disponibilidad.insertar(dispo);
        profesor.setDisponibilidad(disponibilidad);
        /*
         * Lista de Cursos que puede dictar
         */
        listaCurso = new cursosAsignadosProfesor();
        curso = new Nodo_Curso();
        curso.setIdCurso(15);
        curso.setNombreCurso("fudnamentos");
        curso.setCantidadHoraria(4);
        listaCurso.insertarCurso(curso);
        this.listaCursos.insertarCurso(curso);
        profesor.setListaCursos(listaCurso);
        this.listaProfesores.insertarProfesor(profesor);

    }

    private void inicializarListas() {
        this.listaCursos = new ListaCursos();
        this.listaProfesores = new ListaProfesores();
        construirCursos5();
        construirCursos11();
        construirProfesores();
    }

    private void construirCursos5() {
        String v[] = {"Música",
            "Ed. Física",
            "Español",
            "Grammar",
            "Sociales",
            "Matemáticas",
            "Literature",
            "Hebreo ",
            "Informática",
            "Science ",
            "PAI",
            "Biblioteca",
            "Etica",
            "Phonetics",
            "Cultura",
            "Ed. Artística",
            "Religión ",
            "Geometría"};
        Nodo_Curso x;
        for (int i = 1; i < 6; i++) {
            x = new Nodo_Curso();
            for (int j = 0; j < v.length; j++) {
                x.setNombreCurso(v[j].toString() + i);
                x.setIdCurso(idCurso);
                this.idCurso++;
            }
        }
    }

    private void construirCursos11() {
        String v[] = {
            "Science",
            "Música",
            "Hebreo",
            "Sociales",
            "Filosofía",
            "Físico Química",
            "Química",
            "Biología",
            "Estadística",
            "Conversación ",
            "Economía",
            "Física",
            "Phonetics",
            "Grammar",
            "Español",
            "Literature",
            "Ed. Física",
            "Ed. Artística",
            "Matemáticas",
            "Geometría",
            "Religión ",
            "Ética"
        };
        Nodo_Curso x;
        for (int i = 6; i < 12; i++) {
            x = new Nodo_Curso();
            for (int j = 0; j < v.length; j++) {
                x.setNombreCurso(v[j].toString() + i);
                x.setIdCurso(idCurso);
                this.idCurso++;
            }
        }
    }
    
    private void construirProfesores() {
        String v[] = {
            "BECKY COHEN",
            "DARA HINCAPIÉ",
            "PILAR MARTÍNEZ",
            "ALEXANDER ZULUAGA",
            "NOVER RUIZ",
            "EDWIN ALEJANDRO CARTAGENA",
            "JOSÉ FERNANDO JIMÉNEZ",
            "ÓSCAR GÓMEZ",
            "SERGIO SANDOVAL",
            "LILIANA OCHOA",
            "ALEJANDRO MONTES",
            "CARLOS ANDRÉS MORA",
            "ÁNGELA ECHEVERRI",
            "MAURICIO GIL",
            "DIANA ÁLVAREZ",
            "LUZ ELENA MORENO",
            "LEAH FELDMAN",
            "ABRAHAM M",
            "GIOVANNY TORRES",
            "JAVIER RIVERA",
            "FELIPE GONZÁLEZ ",
            "JHON ARBOLEDA",
            "ÓSCAR CASTAÑEDA",
            "ADIS JANETH OSORIO",
            "TALLULAH FLORES",
            "WILVER MESA",
            "JUAN LEÓN GONZÁLEZ",
            "LILIANA CASTRILLÓN",
            "DORA JARAMILLO",
            "RICARDO OSORIO"
        };

        Nodo_profesor x;
        for (int i = 1; i < v.length   ; i++) {
            x = new Nodo_profesor();
            x.setId_profesor(idProfesor);
            this.idProfesor++;
            x.setNombre(v[i]);
            this.listaProfesores.insertarProfesor(x);
        }
    }
    public void asignarDisponibilidad()
    {
        
    }
}
