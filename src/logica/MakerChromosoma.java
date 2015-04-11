
package logica;

import lista.Estructuras;
import lista.Nodo_Curso;
import lista.Nodo_profesor;
import org.jgap.Configuration;
import org.jgap.Gene;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.IntegerGene;

/**
 *
 * @author Milton Yesid F G
 */
public class MakerChromosoma {

    /*
     variables del dominio
     */
    private static final int cantidadDias = 5;
    private static final int cantidadHoras = 9;
    private static final int totalHorasSemana = ((cantidadDias * cantidadHoras) - 1)*2;
    private static final int cantidadProfesores = 29;
    private static final int cantidadCursos = 232;

    public static Gene[] crearCromosoma(Configuration configuracion) {
        try {
            Gene[] genoma = new Gene[totalHorasSemana];

            for (int i = 0; i < totalHorasSemana; i++) {
                if (i % 2 == 0) {
                    genoma[i] = new IntegerGene(configuracion, 1, cantidadProfesores);
                } else {
                    genoma[i] = new IntegerGene(configuracion, 1, cantidadCursos);
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
        int c = 0;
        int l = 0;
        boolean bandera = false;
        for (int i = 0; i < totalHorasSemana; i++) {
            c = (Integer) TTPsolucion.getGene(i).getAllele();
            l = i / 2;
            if (bandera == false) {
                System.out.print("H"+(l+1));
                bandera = true;
            }
                if (i % 2 == 0) {
                    imprimirNombresProfesor(c);
                } else {
                    imprimirNombresCurso(c);
                    bandera = false;
                }
        }
    }
    public static  Estructuras estructura = new Estructuras();
    public static void imprimirNombresProfesor(int id)
    {
        Nodo_profesor profesor = estructura.listaProfesores.buscar(id);
        if(profesor == null)
        {
            System.out.print("T"+id);
        }else
        {
            System.out.print(profesor.getNombre());
        }
    }
    public static void imprimirNombresCurso(int id)
    {
        Nodo_Curso curso = estructura.listaCursos.buscar(id);
        if(curso == null)
        {
            System.out.print("C"+id+"|");
        }else
        {
            System.out.print(curso.getNombreCurso()+"|");
        }
    }
    
    
}
