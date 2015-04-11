package logica;

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



    public static void main(String[] args) {
        EjecucionAG ejecucionAG = new EjecucionAG();
        ejecucionAG.crearHorario();

    }
}
