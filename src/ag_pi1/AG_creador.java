package ag_pi1;

import static ag_pi1.main.estructura;
import org.jgap.Configuration;
import org.jgap.Gene;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.IntegerGene;

/**
 *
 * @author Milton Yesid F G
 */
public class AG_creador {

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
            int totalGenoma = cantidadProfesores * 96;

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

                genoma[l] = new IntegerGene(configuracion, 1, 32);
                l++;
                for (int j = 1; j < cantidadDias + 1; j++) {
                    /*
                     * cantidad de dias
                     */
                    System.out.println("");
                    System.out.println("DIA:" + j);

                    genoma[l] = new IntegerGene(configuracion, 1, j);
                    l++;
                    for (int k = 1; k < cantidadHoras + 1; k++) {
                        /*
                         * cantidad de horas
                         */
                        genoma[l] = new IntegerGene(configuracion, 1, 9);
                        l++;
                        /*
                         * cursos
                         */
                        genoma[l] = new IntegerGene(configuracion, 1, 9);
                        l++;
                        System.out.print("  " + k + " " + l);
                    }
                }

            }

            return genoma;

        } catch (InvalidConfigurationException ex) {
            System.out.println("No se pudo ejecutar el AG");

        }
        return null;
    }

    /**
     *
     * @param TTPsolucion
     */
    public static void mostrarCromosoma(IChromosome TTPsolucion) {
        Gene[] genoma = TTPsolucion.getGenes();
        int cantidadProfesores = estructura.listaProfesores.cantidadProfesores();
        System.out.println("la cantidad de profesores es:" + cantidadProfesores);

        Integer c = 0;
        int l = 0;
        for (int i = 0; i < cantidadProfesores; i++) {


            c = (Integer) TTPsolucion.getGene(l).getAllele();
            l++;
            System.out.println("codigo profesor:" + c);
            for (int j = 1; j < 6 ; j++) {
                /*
                 * cantidad de dias
                 */
                c = (Integer) TTPsolucion.getGene(l).getAllele();
                l++;
                System.out.println("DIA:" + c);
                System.out.println("");

                for (int k = 1; k < 10 ; k++) {
                    /*
                     * cantidad de horas
                     */
                    c = (Integer) TTPsolucion.getGene(l).getAllele();
                    l++;
                    System.out.print("hora:" + c);
                    /*
                     * cursos
                     */
                    c = (Integer) TTPsolucion.getGene(l).getAllele();
                    l++;
                    System.out.print("curso" + k);
                }
            }

        }

    }
}
