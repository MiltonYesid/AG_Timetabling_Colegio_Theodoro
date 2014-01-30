/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ejemplo;

//Libreria JGAP
import ag_pi1.funcionAptitud;
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



public class cuadradoMagico {

    /**
     * @param args the command line arguments
     */

   public static void mostrarCuadrado(IChromosome cuadradoSolucion)
   {
        Integer c1 = (Integer) cuadradoSolucion.getGene(0).getAllele();
        Integer c2 = (Integer) cuadradoSolucion.getGene(1).getAllele();
        Integer c3 = (Integer) cuadradoSolucion.getGene(2).getAllele();

        Integer c4 = (Integer) cuadradoSolucion.getGene(3).getAllele();
        Integer c5 = (Integer) cuadradoSolucion.getGene(4).getAllele();
        Integer c6 = (Integer) cuadradoSolucion.getGene(5).getAllele();

        Integer c7 = (Integer) cuadradoSolucion.getGene(6).getAllele();
        Integer c8 = (Integer) cuadradoSolucion.getGene(7).getAllele();
        Integer c9 = (Integer) cuadradoSolucion.getGene(8).getAllele();

        System.out.println(c7+"   "+c8+"   "+c9);
        System.out.println(c4+"   "+c5+"   "+c6);
        System.out.println(c1+"   "+c2+"   "+c3);

   }


    public static void main(String[] args) {
        // TODO code application logic here

        //Algoritmo genético
         try{
            // Start with a DefaultConfiguration, which comes setup with the
            // most common settings.
            // -------------------------------------------------------------

            //Configuramos JGAP
            Configuration configuracion = new DefaultConfiguration();
            
            FitnessFunction myFunc = new funcionAptitud();
            configuracion.setFitnessFunction(myFunc); //Le indicamos a JGAP cual sera nuestra funcion de aptitud
            /*
            Se establece el numero de profesores en esta variable
            */
            Gene[] genEjemplo = new Gene[9];
            //Creamos una codificacion de 9 genes que nos servira para nuestros individuos (fenotipo)
            //Los genes seran valores entre 1 y 9 (por el cuadrado magico de 3x3)
            genEjemplo[0] = new IntegerGene(configuracion, 1, 9);
            genEjemplo[1] = new IntegerGene(configuracion, 1, 9);
            genEjemplo[2] = new IntegerGene(configuracion, 1, 9);
            genEjemplo[3] = new IntegerGene(configuracion, 1, 9);
            genEjemplo[4] = new IntegerGene(configuracion, 1, 9);
            genEjemplo[5] = new IntegerGene(configuracion, 1, 9);
            genEjemplo[6] = new IntegerGene(configuracion, 1, 9);
            genEjemplo[7] = new IntegerGene(configuracion, 1, 9);
            genEjemplo[8] = new IntegerGene(configuracion, 1, 9);
           
            /*
            Se establece el gen según cada profesor[codProfesor]
            genEjemplo[0] = new IntegerGene
            */

            //Recordemos que los cromosomas son el correspondiente a los individuos
            Chromosome cromosomaCuadradoMagico = new Chromosome(configuracion, genEjemplo); //Creamos un individuo a partir de la configuracion de los genes anterior
            configuracion.setSampleChromosome(cromosomaCuadradoMagico); //Le indicamos a JGAP un ejemplo de como seran los individuos, a partir del individuo de ejemplo que creamos

            configuracion.setPopulationSize(5000); //Creamos nuestra poblacion inicial

            //Creamos el genotipo de la poblacion
            //Recordemos que el genotipo se determina del fenotipo = la configuracion de los genes para un cromosoma particular
            Genotype population = Genotype.randomInitialGenotype(configuracion);


            //Comienza a iterar el algoritmo
            /*
            número de eras o generaciones
            */
            for (int m = 0 ; m < 50 ; m++) //50 iteraciones, cada iteracion sera una generacion
            {
                population.evolve();

                System.out.println("Iteracion #"+m);
                IChromosome mejor_individuo = population.getFittestChromosome(); //Obtenemos el mejor individuo para esta generacion
                System.out.println("Mejor Individuo de la generacion "+m+" :");
                mostrarCuadrado(mejor_individuo);
                System.out.println("Valor de aptitud obtenido:"+mejor_individuo.getFitnessValue());
            }

            /*Al final de las iteraciones, obtenemos el mejor individuo,
             * para nuestro ejemplo, es el cuadrado que no repite valores
             * en sus casillas, y cuya suma de lineas verticales, horizontales y
             * diagonales es 15
             */
            IChromosome bestSolutionSoFar = population.getFittestChromosome(); //mejor individuo obtenido

            System.out.println("Este es el mejor individuo encontrado para el cuadrado magico de 3x3 despues de 50 generaciones:");
            mostrarCuadrado(bestSolutionSoFar);//Mostramos al individuo
            System.out.println("Valor de aptitud obtenido:"+bestSolutionSoFar.getFitnessValue()); //Mostramos el valor obtenido en la función de aptitud para el mejor individuo

        }
        catch (InvalidConfigurationException ex) {
            System.out.println("No se pudo ejecutar el AG");

        }

    }

}