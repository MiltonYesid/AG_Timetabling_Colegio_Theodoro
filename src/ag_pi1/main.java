/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

    /**
     * @param args the command line arguments
     */
    public static void mostrarCromosoma(IChromosome TTPsolucion) {
        Gene[] genoma = TTPsolucion.getGenes();
        int cantidadProfesores = estructura.listaProfesores.cantidadProfesores();
        System.out.println("la cantidad de profesores es:" + cantidadProfesores);
        for (int i = 0; i < cantidadProfesores; i++) {
            for (int j = 1; j < 5; j++) {
                Integer c = (Integer) TTPsolucion.getGene(j).getAllele();
//                switch (j) {
//                    case 1:
//                        System.out.print("codigo:" + c);
//                        break;
//                    case 2:
//                        System.out.print("  día: " + c);
//                        break;
//                    case 3:
//                        System.out.print("  hora: " + c);
//                        break;
//                    case 4:
//                        System.out.print("  curso: " + c);
//                        break;
//                }

            }
            System.out.println("");
        }
    }

    public static Gene[] crearCromosoma(Configuration configuracion) {
        try {
            /*
             * obtiene el # de profesores 
             */
            int cantidadProfesores = estructura.listaProfesores.cantidadProfesores();
            System.out.println("la cantidad de profesores es:" + cantidadProfesores);
            /*
             * horas semanales
             */
            int cantidadDias = 5;
            int cantidadHoras = 9;
            int totalHorasSemana = (cantidadDias * cantidadHoras);
            System.out.println(totalHorasSemana);
            /*
             * cantidad total de profesores
             */
            int cantidadTotalProfesores = 27;
            /*
             * cantidad total de cursos en el colegio
             */
            int cantidadTotalCursos = 225;
            /*
             * el tamaño del fenoma esta dado por
             */
            int totalGenoma = cantidadProfesores * (totalHorasSemana * 2)+50;

            System.out.println("total cromosoma" + totalGenoma);
            /*
             * se genera el genoma del cromosoma
             */
            Gene[] genoma = new Gene[totalGenoma];
            /*
             * se valida que exista la lista con datos
             */
            
            boolean bandera = true;
            int l = 0;
            for (int i = 0; i < cantidadProfesores; i++) {
                /*
                 * codigos de profesor
                 */
                System.out.println("-------------------");
                System.out.println("HORA|L");
                System.out.println("codigo profesor:" + i);
                System.out.println("--------------------");
                
                genoma[l] = new IntegerGene(configuracion, 1, i);
                l++;
                for (int j = 1; j < cantidadDias + 1; j++) {
                    /*
                     * cantidad de dias
                     */
                    System.out.println("");
                    System.out.println("DIA:"+j);
                    
                    genoma[l] = new IntegerGene(configuracion, 1, j);
                    l++;
                    for (int k = 1; k < cantidadHoras + 1; k++) {
                        /*
                         * cantidad de horas
                         */
                        
                        
                        genoma[l] = new IntegerGene(configuracion, 1, k);
                        l++;
                        /*
                         * cursos
                         */
                  
                        genoma[l] = new IntegerGene(configuracion, 1, cantidadTotalCursos);
                        l++;

                        System.out.print("  " + k + " " + l);
                        if (l == totalGenoma) {
                            bandera = false;
                            System.out.println("problema");
                            break;
                        }

                    }
                }

            }


//            for (int i = 0; i < cantidadProfesores; i++) {
//                /*
//                 * codigos de profesor
//                 */
//                genoma[l] = new IntegerGene(configuracion, 1, cantidadTotalProfesores);
//                l++;
//                for (int j = 0; j < totalHorasSemana; j++) {
//                    genoma[l] = new IntegerGene(configuracion, 11, totalHorasSemana);
//                    l++;
//                    genoma[l] = new IntegerGene(configuracion, 1, cantidadTotalCursos);
//                    l++;
//                }
//            }
            if(bandera)
            {
            return genoma;
            }else
            {
                return null;
            }
        } catch (InvalidConfigurationException ex) {
            System.out.println("No se pudo ejecutar el AG");

        }
        return null;
    }

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
            Gene[] genoma = crearCromosoma(configuracion);
            if(genoma == null)
            {
                System.out.println("problema");
            }
                 
            /*
             Se establece el gen según cada profesor[codProfesor]
             genEjemplo[0] = new IntegerGene
             */

            //Recordemos que los cromosomas son el correspondiente a los individuos
            Chromosome cromosomaCuadradoMagico = new Chromosome(configuracion, genoma); //Creamos un individuo a partir de la configuracion de los genes anterior
            configuracion.setSampleChromosome(cromosomaCuadradoMagico); //Le indicamos a JGAP un ejemplo de como seran los individuos, a partir del individuo de ejemplo que creamos

            configuracion.setPopulationSize(5000); //Creamos nuestra poblacion inicial

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
                mostrarCromosoma(mejor_individuo);
                System.out.println("Valor de aptitud obtenido:" + mejor_individuo.getFitnessValue());
            }

            /*Al final de las iteraciones, obtenemos el mejor individuo,
             * para nuestro ejemplo, es el cuadrado que no repite valores
             * en sus casillas, y cuya suma de lineas verticales, horizontales y
             * diagonales es 15
             */
            IChromosome bestSolutionSoFar = population.getFittestChromosome(); //mejor individuo obtenido

            System.out.println("Este es el mejor individuo encontrado para el cuadrado magico de 3x3 despues de 50 generaciones:");
            mostrarCromosoma(bestSolutionSoFar);//Mostramos al individuo
            System.out.println("Valor de aptitud obtenido:" + bestSolutionSoFar.getFitnessValue()); //Mostramos el valor obtenido en la función de aptitud para el mejor individuo

        } catch (InvalidConfigurationException ex) {
            System.out.println("No se pudo ejecutar el AG");

        }

    }
}
