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
import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.IChromosome;

public class RestriccionesDominio extends FitnessFunction {
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
    private int sizeProfesores = 0;
    /*
     Estructuras;
     EJB de Profesores[intesidadHorariaProfesor(min,max)]
     EJB de Cursos
     */

    RestriccionesDominio(int id) {
        this.idProfesor = id;
    }

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
        for (int i = 0; i < this.sizeProfesores; i++) {
            this.evaluarDisponibilidadHorariaProfesor(ic);
            this.evaluarProfesoresDictaCurso(ic);
            this.evaluarIntensidadHorariaProfesor(ic);
            this.evaluarUnCursoNoTengaMasProfesores(ic);
            this.evaluarIntensidadHorariaCurso(ic);
        }

        return fitness;
    }

    /*
     evaluarDisponibilidadHorariaProfesor: Satisface que un profesor dicte clases en el horario en el cual presenta disponibilidad.
     */
    public void evaluarDisponibilidadHorariaProfesor(IChromosome cromosoma) {

    }
    /*
     evaluarProfesoresDictaCurso:satisface que un profesor sea asignado a un curso que pueda dictar.
     */
    public void evaluarProfesoresDictaCurso(IChromosome cromosoma) {

    }
    /*
    satisface que un profesor no dicte mas o menos horas de las reglamentadas en su contrato
    */
    public void evaluarIntensidadHorariaProfesor(IChromosome cromosoma)
    {
        
    }
    /*
    satisface que un curso y/o Profesor tenga el mismo curso asignado
    */
    public void evaluarUnCursoNoTengaMasProfesores(IChromosome cromosoma)
    {
        
    }
    /*
    Satisface que un curso tenga las horas estipuladas dadas
    */
    public void evaluarIntensidadHorariaCurso(IChromosome cromosoma)
    {
        
    }
    /*
    Se obvian las restricciones de hora y espacio para cada profesor
    */

}
