
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
    /**
     * @param args the command line arguments
     */
   
   

    public static void main(String[] args) {

        try {
            // Start with a DefaultConfiguration, which comes setup with the
            // most common settings.
            // -------------------------------------------------------------

            //Configuramos JGAP
            Configuration configuracion = new DefaultConfiguration();

            FitnessFunction myFunc = new RestriccionesDominio();
            configuracion.setFitnessFunction(myFunc); //Le indicamos a JGAP cual sera nuestra funcion de aptitud
           /*
             * Se crea el cromosoma 
             */

            Gene[] genoma = auxAG.crearCromosoma(configuracion);

            if (genoma == null) {
                System.out.println("errrororororor");
            } else {
                /*
                 Se establece el gen según cada profesor[codProfesor]
                 genEjemplo[0] = new IntegerGene
                 */
                //Recordemos que los cromosomas son el correspondiente a los individuos
                Chromosome cromosomaCuadradoMagico = new Chromosome(configuracion, genoma); //Creamos un individuo a partir de la configuracion de los genes anterior
                configuracion.setSampleChromosome(cromosomaCuadradoMagico); //Le indicamos a JGAP un ejemplo de como seran los individuos, a partir del individuo de ejemplo que creamos
                
                configuracion.setPopulationSize(10); //Creamos nuestra poblacion inicial

            //Creamos el genotipo de la poblacion
                //Recordemos que el genotipo se determina del fenotipo = la configuracion de los genes para un cromosoma particular
                Genotype population = Genotype.randomInitialGenotype(configuracion);

            //Comienza a iterar el algoritmo
            /*
                 número de eras o generaciones
                 */
                for (int m = 0; m < 50; m++) //50 iteraciones, cada iteracion sera una generacion
                {
                    population.evolve();
                    System.out.println("Iteracion #" + m);
                    IChromosome mejor_individuo = population.getFittestChromosome(); //Obtenemos el mejor individuo para esta generacion
                    System.out.println("Mejor Individuo de la generacion " + m + " :");
                    auxAG.mostrarCromosoma(mejor_individuo);
                    System.out.println("Valor de aptitud obtenido:" + mejor_individuo.getFitnessValue());
                }

                /*Al final de las iteraciones, obtenemos el mejor individuo,
                 * para nuestro ejemplo, es el cuadrado que no repite valores
                 * en sus casillas, y cuya suma de lineas verticales, horizontales y
                 * diagonales es 15
                 */
                IChromosome bestSolutionSoFar = population.getFittestChromosome(); //mejor individuo obtenido

                System.out.println("Este es el mejor individuo encontrado para el cuadrado magico de 3x3 despues de 50 generaciones:");
                auxAG.mostrarCromosoma(bestSolutionSoFar);//Mostramos al individuo
                System.out.println("Valor de aptitud obtenido:" + bestSolutionSoFar.getFitnessValue()); //Mostramos el valor obtenido en la función de aptitud para el mejor individuo
            }
        } catch (InvalidConfigurationException ex) {
            System.out.println("No se pudo ejecutar el AG");

        }

    }
}
