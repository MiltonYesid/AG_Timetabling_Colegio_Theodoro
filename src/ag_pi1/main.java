package ag_pi1;

//Libreria JGAP
import lista.Estructuras;
import lista.Nodo_profesor;
import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;
import org.jgap.impl.StringGene;

public class main {

    /*
     * se obtiene las estructuras a trabajar
     */
    public static Estructuras estructura = new Estructuras();
    public static AG_creador auxAG = new AG_creador();
    /*
     variables del dominio
     */
    private static int cantidadDias = 5;
    private static int cantidadHoras = 9;
    private static final int totalHorasSemana = ((cantidadDias * cantidadHoras) - 1)*2;
    private static int nroEras = 50;

    public static void main(String[] args) {

        try {
            //Configuramos JGAP
            Configuration configuracion = new DefaultConfiguration();
            /*
             Se llama a la metafuncion de restricciones de dominio
             */
            FitnessFunction myFunc = new RestriccionesDominio();
            /*
             Le indicamos a JGAP cual sera nuestra funcion de aptitud
             */
            configuracion.setFitnessFunction(myFunc);
            /*
             crear el cromosoma
             */
            Gene[] genoma = auxAG.crearCromosoma(configuracion);
            /*
             Creamos un individuo a partir de la configuracion de los genes anterior
             */
            Chromosome posibleHorarioGrupo = new Chromosome(configuracion, genoma);
            configuracion.setSampleChromosome(posibleHorarioGrupo);
            configuracion.setPopulationSize(totalHorasSemana * 10); //Creamos nuestra poblacion inicial
            //Creamos el genotipo de la poblacion
            //Recordemos que el genotipo se determina del fenotipo = la configuracion de los genes para un cromosoma particular
            Genotype population = Genotype.randomInitialGenotype(configuracion);
            for (int m = 0; m < nroEras ; m++) //50 iteraciones, cada iteracion sera una generacion
            {
                population.evolve();
                System.out.println("Iteracion #" + m);
                IChromosome mejor_individuo = population.getFittestChromosome(); //Obtenemos el mejor individuo para esta generacion
                System.out.println("Mejor Individuo de la generacion " + m + " :");
                auxAG.mostrarCromosoma(mejor_individuo);
                System.out.println("Valor de aptitud obtenido:" + mejor_individuo.getFitnessValue());
            }
            IChromosome bestSolutionSoFar = population.getFittestChromosome(); //mejor individuo obtenido

            System.out.println("Este es el mejor individuo encontrado para el cuadrado magico de 3x3 despues de 50 generaciones:");
            auxAG.mostrarCromosoma(bestSolutionSoFar);//Mostramos al individuo
            System.out.println("Valor de aptitud obtenido:" + bestSolutionSoFar.getFitnessValue()); //Mostramos el valor obtenido en la función de aptitud para el mejor individuo

        } catch (InvalidConfigurationException ex) {
            System.out.println("No se pudo ejecutar el AG");

        }

    }
}
