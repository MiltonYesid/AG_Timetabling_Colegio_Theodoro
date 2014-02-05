
import entidad.Curso;
import entidad.Materia;
import entidad.Profesor;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.jgap.FitnessFunction;
import org.jgap.IChromosome;
import org.jgap.impl.IntegerGene;
import session.CursoFacade;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author milton.fernandez
 */
public class FuncionesEvaluacion extends FitnessFunction {

    Vector listaCursos;
    Vector listaProfesor;
    Vector cursosGenerados;
    Vector horasCurso;
    Vector listamaterias;
    private double fitness = 0;

    public FuncionesEvaluacion(Vector cursos, Vector profesor, Vector materias) {
        this.listaCursos = cursos;
        this.listaProfesor = profesor;
        this.listamaterias = materias;
    }

    @Override
    protected double evaluate(IChromosome ic) {
        fitness = 0;
        cursosGenerados = new Vector();
        horasCurso = new Vector();
        for (int i = 0; i < 88; i++) {

            if (i % 2 == 0) {
                Integer codProfesor = (Integer) ic.getGene(i).getAllele();
                evaluarProfesorExista(codProfesor);
            } else {
                Integer codCurso = (Integer) ic.getGene(i).getAllele();
                evaluarCursosGrado(3, codCurso);
                this.guardarCurso(codCurso);
            }
        }
        evaluarLaExistenciaDeTodosLosCursos();
        evaluarIntensidadHorariaDeCadaCurso();
        return fitness;
    }

    private void guardarCurso(int codCurso) {
        boolean bandera = false;
        /*
         * verifica que el curso no se encuentre dentro del vector cursos generados
         */
        for (int i = 0; i < cursosGenerados.size(); i++) {
            if ((Integer) cursosGenerados.get(i) == codCurso) {
                int horasCurso = (Integer) this.horasCurso.get(i);
                /*
                 * incrementamos cantidad de horas del curso
                 */

                this.horasCurso.set(i, horasCurso + 1);
                bandera = true;
                break;
            }
        }
        if (bandera == false) {
            this.cursosGenerados.add(codCurso);
            this.horasCurso.add(1);
        }
    }

    private void evaluarCursosGrado(int grado, int codCurso) {
        int cantidadCursos = this.listaCursos.size();
        for (int i = 0; i < cantidadCursos; i++) {
            Curso c = (Curso) this.listaCursos.get(i);
            if (c.getIdGrado() == grado) {
                if (c.getId() == codCurso) {
                    this.fitness += 10;
                    break;
                }
            }
        }
    }

    private void evaluarProfesorExista(int codProfesor) {
        int cantidadProfesores = this.listaProfesor.size();

        for (int i = 0; i < cantidadProfesores; i++) {
            Profesor p = (Profesor) this.listaProfesor.get(i);
            if (p.getIdProfesor() == codProfesor) {
                this.fitness += 2;
                break;
            }

        }
    }

    private void evaluarLaExistenciaDeTodosLosCursos() {
        if (this.cursosGenerados.size() == 20) {
            this.fitness += 12;
        }
    }

    private void evaluarIntensidadHorariaDeCadaCurso() {
        for (int i = 0; i < cursosGenerados.size(); i++) {
            int codCurso = (Integer)this.cursosGenerados.get(i);
            for(int j = 0; j < this.listaCursos.size();j++)
            {
                Curso c = (Curso)this.listaCursos.get(j);
                if(c.getId()==codCurso)
                {
                    int codMateria = c.getIdMateria();
                    for(int k = 0; k < this.listamaterias.size();k++)
                    {
                        Materia m = (Materia)this.listamaterias.get(k);
                        if(m.getIdMateria()==codMateria)
                        {
                            int intesidadHoraria = m.getIntensidadHoraria();
                            if((Integer)this.horasCurso.get(i)==intesidadHoraria)
                            {
                                this.fitness += 6;
                            }
                        }
                    }
                }
            }
        }
    }

    
}
