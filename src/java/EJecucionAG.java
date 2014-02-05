/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import entidad.Curso;
import entidad.Materia;
import entidad.Profesor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Vector;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import session.CursoFacade;
import session.MateriaFacade;
import session.ProfesorCursoFacade;
import session.ProfesorFacade;

/**
 *
 * @author milton.fernandez
 */
public class EJecucionAG extends HttpServlet {

    @EJB
    private MateriaFacade materiaFacade;
    @EJB
    private ProfesorFacade profesorFacade;
    @EJB
    private ProfesorCursoFacade profesorCursoFacade;
    @EJB
    private CursoFacade cursoFacade;
    Vector cursosGenerados = new Vector();
    Vector horasCurso = new Vector();
    public int cantidadEras = 100;
    public double mejorFC = 0;
    public int especiePorEra = 500;
    public int sizeCromosoma = 88;
//    private void generarCursos()
//    {
//        int cantidadMaterias = this.materiaFacade.count();
//        List<Materia> listaMaterias = this.materiaFacade.findAll();
//        int aux = 1;
//        for(int i=1; i < 6; i++)
//        {
//            
//            for(int j = 0; j < cantidadMaterias ; j++)
//            {
//                Curso c = new Curso();
//                Materia m = listaMaterias.get(j);
//                c.setIdGrado(i);
//                c.setIdMateria(m.getIdMateria());
//                c.setId(aux);
//                this.cursoFacade.create(c);
//                aux++;
//            }
//            
//        }
//    }
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

    private String publicarResultados() {
        int cantidadHoras = 0;
        String texto = ""
                + "<div class=datagrid>"
                + "<table>"
                + "<thead>"
                + "<tr>"
                + "<th>Curso</th>"
                + "<th>Intensidad Semanal</th>"
                + "</tr></thead>"
                + "<tbody>";
        for (int i = 0; i < cursosGenerados.size(); i++) {
            if (i % 2 == 0) {
                texto += "<tr class=alt>";
            } else {
                texto += "<tr>";
            }
            texto += "<td>" + this.imprimirNombresCurso((Integer) cursosGenerados.get(i)) + "</td><td>" + this.horasCurso.get(i) + "</td></tr>";
            cantidadHoras += (Integer) this.horasCurso.get(i);
        }
        texto += "<tr class=alt><td>Total Horas</td><td>" + cantidadHoras + "</td></tr>";
        texto += "</tbody></table></div>";
        return texto;
    }

    private String imprimirNombresProfesor(int c) {
        String texto = "";
        int cantidadProfesores = this.profesorFacade.count();
        List<Profesor> listaProfesor = this.profesorFacade.findAll();
        for (int i = 0; i < cantidadProfesores; i++) {
            Profesor p = listaProfesor.get(i);
            if (p.getIdProfesor() == c) {
                return p.getNombres();
            }
        }
        return "NINGUNO";
    }

    private String hallarNombreMateria(int idMateria) {
        int cantidadMateria = this.materiaFacade.count();
        List<Materia> listaMaterias = this.materiaFacade.findAll();
        for (int i = 0; i < cantidadMateria; i++) {
            Materia m = listaMaterias.get(i);
            if (m.getIdMateria() == idMateria) {
                return m.getNombreMateria();
            }
        }
        return "Non";
    }

    private String imprimirNombresCurso(int idCurso) {
        String texto = "";
        int cantidadCursos = this.cursoFacade.count();
        List<Curso> listaCursos = this.cursoFacade.findAll();
        for (int i = 0; i < cantidadCursos; i++) {
            Curso c = listaCursos.get(i);
            if (c.getId() == idCurso) {
                int grado = c.getIdGrado();
                return this.hallarNombreMateria(c.getIdMateria()) + "" + grado;
            }
        }
        return "NC";
    }

    public Vector listaCursos() {
        Vector v = new Vector();
        int cantidadCursos = this.cursoFacade.count();
        List<Curso> listaCursos = this.cursoFacade.findAll();
        for (int i = 0; i < cantidadCursos; i++) {
            Curso c = listaCursos.get(i);
            v.add(c);
        }
        return v;
    }

    public Vector listaProfesores() {
        Vector v = new Vector();
        int cantidadProfesores = this.profesorFacade.count();
        List<Profesor> listaProfesor = this.profesorFacade.findAll();
        for (int i = 0; i < cantidadProfesores; i++) {
            Profesor p = listaProfesor.get(i);
            v.add(p);
        }
        return v;
    }
    
    
    public Vector listaMaterias()
    {
        Vector v = new Vector();
        int cantidadMaterias = this.materiaFacade.count();
        List<Materia> listaMaterias = this.materiaFacade.findAll();
        for(int i = 0; i < cantidadMaterias; i++)
        {
            Materia m = listaMaterias.get(i);
            v.add(m);
        }
        return v;
    }
    private static int cantidadProfesores = 25;
    private static int cantidadCursos = 100;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Aplicacion de AG|Colegio THeodoro Hertlz</title>");
            out.println("<link rel='stylesheet' type='text/css' href='css/hojaEstilo.css' />");
            out.println("</head>");
            out.println("<body>");
            out.println(imprimirEncabezado());
            String horario = this.mostrarCromosoma(this.crearCromosoma());
            String cursosXhora = this.publicarResultados();
            String texto = "<table><tr><td>" + horario + "</td><td></td><td>" + cursosXhora + "</td></tr></table>";
            out.println(texto);
            out.println("<br><hr>"+imprimirDatos()+"<br>");
            out.println(imprimirPiePagina());
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    private String imprimirEncabezado()
    {
        String text = "<div class=datagrid><h1>Colegio THeodoro Hertlz</h1></div>";
        return text;
    }
    private String imprimirPiePagina()
    {
        String text = "<div class=datagrid>Colegio THeodoro Hetlz|Universidad de Antioquia|Fac.de Ingeniería|Departamento de Sistemas</div>";
        return text;
    }
    private String imprimirDatos()
    {
         String text = "<div class=datagrid>"
                + "<table>"
                + "<thead>"
                + "<tr>"
                + "<th>Número de Eras</th>"
                + "<th>Especies por Era</th>"
                + "<th>tamaño del genoma</th>"
                + "<th>Valor de mejor Puntuación(Función de calidad)</th>"
                + "</tr></thead>"
                + "<tbody>";
                 
                 text += "<tr class=alt>"
                         + "<td>"+this.cantidadEras+"</td>"
                         + "<td>"+this.especiePorEra+"</td>"
                        + "<td>"+this.sizeCromosoma+"</td>"
                         + "<td>"+this.mejorFC+"</td>"
                         + "</tr></table></div>";
        return text;
    }
    public IChromosome crearCromosoma() {
        try {

            //Configuramos JGAP
            Configuration configuracion = new DefaultConfiguration();
            /*
             Se llama a la metafuncion de restricciones de dominio
             */
            FitnessFunction myFunc = new FuncionesEvaluacion(listaCursos(), listaProfesores(),listaMaterias());
            /*
             Le indicamos a JGAP cual sera nuestra funcion de aptitud
             */
            configuracion.setFitnessFunction(myFunc);
            /*
             crear el cromosoma
             */
            Gene[] genoma = crearGenoma(configuracion);
            /*
             Creamos un individuo a partir de la configuracion de los genes anterior
             */
            Chromosome posibleHorarioGrupo = new Chromosome(configuracion, genoma);
            configuracion.setSampleChromosome(posibleHorarioGrupo);
            configuracion.setPopulationSize( especiePorEra); //Creamos nuestra poblacion inicial
            //Creamos el genotipo de la poblacion
            //Recordemos que el genotipo se determina del fenotipo = la configuracion de los genes para un cromosoma particular
            Genotype population = Genotype.randomInitialGenotype(configuracion);
            for (int m = 0; m < cantidadEras; m++) //50 iteraciones, cada iteracion sera una generacion
            {
                population.evolve();
                System.out.println("Iteracion #" + m);
                IChromosome mejor_individuo = population.getFittestChromosome(); //Obtenemos el mejor individuo para esta generacion
                System.out.println("Mejor Individuo de la generacion " + m + " :");
                System.out.println(mejor_individuo);
                System.out.println("Valor de aptitud obtenido:" + mejor_individuo.getFitnessValue());
            }
            IChromosome bestSolutionSoFar = population.getFittestChromosome(); //mejor individuo obtenido

            System.out.println("Este es el mejor individuo encontrado para el cuadrado magico de 3x3 despues de 50 generaciones:");

            mejorFC = bestSolutionSoFar.getFitnessValue();
            return bestSolutionSoFar;
        } catch (InvalidConfigurationException ex) {
            System.out.println("No se pudo ejecutar el AG");

        }
        return null;
    }

    public static Gene[] crearGenoma(Configuration configuracion) {
        try {

            Gene[] genoma = new Gene[88];

            for (int i = 0; i < 88; i++) {
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

    public String mostrarCromosoma(IChromosome TTPsolucion) {
        String texto = ""
                + "<div class=datagrid>"
                + "<table>"
                + "<thead>"
                + "<tr>"
                + "<th>Lunes</th>"
                + "<th>Martes</th>"
                + "<th>Miercoles</th>"
                + "<th>Jueves</th>"
                + "<th>Viernes</th>"
                + "</tr></thead>"
                + "<tbody>";

        Gene[] genoma = TTPsolucion.getGenes();
        int c = 0;
        int l = 0;
        int aux = 0;

        String textoaux = "";

        textoaux += "<tr class=alt>";
        int aux2 = 1;
        int c1 = 0;
        boolean b = false;
        for (int i = 1; i < 89; i = i + 2) {
            if (aux2 < 5) {
                c = (Integer) TTPsolucion.getGene(i).getAllele();
                aux2++;
            } else {
                aux2 = 1;
                if (b) {
                    textoaux += "</tr><tr class=alt>";
                    b = false;
                } else {
                    b = true;
                    textoaux += "</tr><tr>";
                }
            }
            c = (Integer) TTPsolucion.getGene(i).getAllele();
            c1 = (Integer) TTPsolucion.getGene(i - 1).getAllele();
            this.guardarCurso(c);
            textoaux += "<td>" + this.imprimirNombresCurso(c) + "<br>" + this.imprimirNombresProfesor(c1) + "</td>";
        }
        texto += textoaux;


        texto += "</tbody></table></div>";

        return texto;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
