/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ag_pi1;

/**
 *
 * @author Milton Yesid F G
 */
import lista.Estructuras;
import lista.Nodo_Curso;
import lista.Nodo_profesor;
import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.IChromosome;

public class RestriccionesDominio extends FitnessFunction {

    public RestriccionesDominio() {
    }
    /*
     Valor total a retornar evaluado para cada cromosoma
     */
    private double fitness;
    /*
     Se establece que el idProfesor es una varible que se establece del for 
     propio, con lo cual vamos estableciendo la evaluación de cada horario del 
     profesor
     */
    private int idProfesor;
    /*
     tamaño total de profesores
     */
    private int sizeProfesores;
    /*
     Estructuras;
     EJB de Profesores[intesidadHorariaProfesor(min,max)]
     EJB de Cursos
     se obtiene las estructuras a trabajar
     */
    public static Estructuras estructura = new Estructuras();
    /*
     * posicion
     */
    int k = 0;

    @Override
    protected double evaluate(IChromosome ic) {

        /*
         se establece para cada cromosoma
         el valor de fitness comienza desde 0
         */
        fitness = 0;
        /*
         evaluar por cada profesor del sistema
         */
        this.sizeProfesores = this.estructura.listaProfesores.cantidadProfesores();
//        for (int i = 0; i < this.sizeProfesores; i++) {
//            this.idProfesor = i + 1;
////            if (this.verificarProfesor(ic)) {
//                this.evaluarDisponibilidadHorariaProfesor(ic);
//                this.evaluarProfesoresDictaCurso(ic);
//                this.evaluarIntensidadHorariaProfesor(ic);
//                this.evaluarUnCursoNoTengaMasProfesores(ic);
//                this.evaluarIntensidadHorariaCurso(ic);
////            }
//        }
        for (int i = 0; i < this.sizeProfesores; i++) {
            this.evaluarProfesoresDictaCurso(ic);
        }

        return fitness;
    }

    /*
     evaluarDisponibilidadHorariaProfesor: Satisface que un profesor dicte clases en el horario en el cual presenta disponibilidad.
     */
    public void evaluarDisponibilidadHorariaProfesor(IChromosome cromosoma) {
//        int valor = this.idProfesor * 4;
//        Integer codigoProfesor = (Integer) cromosoma.getGene(valor - 4).getAllele();
//        Integer dia = (Integer) cromosoma.getGene(valor - 3).getAllele();
//        Integer hora = (Integer) cromosoma.getGene(valor - 2).getAllele();
//        Integer curso = (Integer) cromosoma.getGene(valor - 1).getAllele();
//
//        Nodo_profesor profesor = this.estructura.listaProfesores.buscar(codigoProfesor);
////        System.out.println("profesor encontrado"+profesor.getNombre());
//        this.fitness= this.fitness+10;
    }
    /*
     evaluarProfesoresDictaCurso:satisface que un profesor sea asignado a un curso que pueda dictar.
     */

    public void evaluarProfesoresDictaCurso(IChromosome cromosoma) {
        int cantidadTotalHoras = 44;
        int c = 0;
        int aux = 0;
        int idCurso = 0;
        for (int i = 0; i < cantidadTotalHoras; i = i + 2) {
            c = (Integer) cromosoma.getGene(i).getAllele();
            Nodo_profesor profesor = this.estructura.listaProfesores.buscar(c);
            if (profesor != null) {
                aux = i + 1;
                idCurso = (Integer) cromosoma.getGene(aux).getAllele();
                    this.profesorDictaCurso(idCurso, profesor);
            }
        }
        this.estructura.listaProfesores.buscar(0);
    }

    public void profesorDictaCurso(int codigoCurso, Nodo_profesor profesor) {
        Nodo_Curso x = profesor.getListaCursos().getPrimero();
        while (x != null) {
            if (x.getIdCurso() == codigoCurso) {
                this.fitness = this.fitness + 10;
                return;
            }
            x = x.getSig();
        }

    }
    /*
     satisface que un profesor no dicte mas o menos horas de las reglamentadas en su contrato
     */

    public void evaluarIntensidadHorariaProfesor(IChromosome cromosoma) {
    }
    /*
     satisface que un curso y/o Profesor tenga el mismo curso asignado
     */

    public void evaluarUnCursoNoTengaMasProfesores(IChromosome cromosoma) {
    }
    /*
     Satisface que un curso tenga las horas estipuladas dadas
     */

    public void evaluarIntensidadHorariaCurso(IChromosome cromosoma) {
    }
    /*
     Se obvian las restricciones de hora y espacio para cada profesor
     */

    /*
     * verificar que un profesor si exista
     */
    private boolean verificarProfesor(IChromosome cromosoma) {
        int valor = this.idProfesor * 4;
        Integer codigoProfesor = (Integer) cromosoma.getGene(valor - 4).getAllele();
        Nodo_profesor profesor = this.estructura.listaProfesores.buscar(codigoProfesor);
        if (profesor != null) {
            return true;
        }
        return false;
    }
}
