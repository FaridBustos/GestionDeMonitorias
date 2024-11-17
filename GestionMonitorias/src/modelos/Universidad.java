/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.ArrayList;

/**
 *
 * @author Casa Verano
 */
public class Universidad {

    private ArrayList<Usuario> usuarios;
    private ArrayList<Materia> materias;
    private Usuario usuarioActual;

    public Universidad() {
        this.materias = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public boolean ingresarUsuario(Usuario x) {
        return getUsuarios().add(x);
    }

    public boolean eliminarUsuario(String username) {

        Usuario x = buscarUsuario(username);
        if (x != null) {
            return getUsuarios().remove(x);
        } else {
            return false;
        }
    }

    public Usuario buscarUsuario(String username) {
        for (int i = 0; i < getUsuarios().size(); i++) {
            if (getUsuarios().get(i).getUsername().equalsIgnoreCase(username)) {
                return getUsuarios().get(i);
            }
        }
        return null;
    }

    // Hisotira 2
    public boolean ingresarMateria(Materia x) {
        return getMaterias().add(x);
    }

    // Hisotira 2
    public boolean eliminarMateria(int codigo) {
        Materia x = buscarMateria(codigo);
        if (x != null) {
            return materias.remove(x);
        } else {
            return false;
        }
    }

    // Hisotira 2
    public Materia buscarMateria(int codigo) {
        for (int i = 0; i < getUsuarios().size(); i++) {
            if (materias.get(i).getCodigo() == codigo) {
                return materias.get(i);
            }
        }
        return null;
    }

    private boolean VerificarProfesor() {
        return this.getUsuarioActual().getRole().equals("profesor");
    }

    private boolean VerificarAdmin() {
        return this.getUsuarioActual().getRole().equals("admin");
    }

    private boolean VerificarMonitor() {
        return this.getUsuarioActual().getRole().equals("monitor");
    }

    private boolean VerificarEstudiante() {
        return this.getUsuarioActual().getRole().equals("estudiante");
    }

    /**
     * @return the usuarios
     */
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * @return the materias
     */
    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    /**
     * @return the usuarioActual
     */
    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    /**
     * @param usuarioActual the usuarioActual to set
     */
    public void setUsuarioActual(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    public boolean haGanadoLaMateria(int codigoEstudiante, int codigoMateria) { // funcion que verifica si un estudiante ha ganado ya la materia
        ArrayList<Estudiante_Curso> estudiantesM = obtenerTodosLosEstudiantesDeUnaMateria(codigoMateria);
        boolean haGanado = false;
        for (int i = 0; i < estudiantesM.size(); i++) {
            if (estudiantesM.get(i).getEstudiante().getCodigo() == codigoEstudiante) {
                if (estudiantesM.get(i).calcularNotaFinal() >= 300) {
                    haGanado = true;
                    break;
                }

            }
        }
        return haGanado;
    }

    public ArrayList<Estudiante_Curso> obtenerTodosLosEstudiantesDeUnaMateria(int codigoMateria) {
        ArrayList<Estudiante_Curso> estudiantesM = new ArrayList<>();

        for (int i = 0; i < usuarios.size(); i++) { // recorremos la lista de usuarios
            if (usuarios.get(i) instanceof Profesor) { // obtenemos a solo los profesores de la lista de usuarios completa
                Profesor pro = (Profesor) usuarios.get(i); // inicializamos en una sola variable al profesor
                ArrayList<Curso> Cprofesor = pro.getCursos(); // obtenemos los cursos del profesor
                for (int j = 0; j < Cprofesor.size(); j++) { // recorremos los cursos del profesor
                    if (Cprofesor.get(j).getMateria().getCodigo() == codigoMateria) { // si el curso actual es igual al codigo de la materia que buscamos
                        ArrayList<Estudiante_Curso> listaEstudiantes = Cprofesor.get(j).getEstudiantes(); // dame a todos los estudiantes de dicho curso
                        for (int k = 0; k < listaEstudiantes.size(); k++) { // recorre a los estudiantes del curso
                            estudiantesM.add(listaEstudiantes.get(k));
                        }
                    }
                }
            }
        }

        return estudiantesM;
    }

    public ArrayList<Estudiante> obtenerTodosLosEstudiantesDeUnaMonitoria(int codigoMateria) { // Esta funcion obtiene todos los estudiantes que han asistido a alguna montoria de una materia
        ArrayList<Estudiante> estud = new ArrayList<>(); // incializamos un array vacio

        ArrayList<Monitoria> moni = buscarMateria(codigoMateria).getMonitorias(); // buscamos la materia y obtenemos todas las monitorias de dicha materia

        for (int i = 0; i < moni.size(); i++) { // recorremos cada monitoria hecha
            ArrayList<Estudiante> asis = moni.get(i).getAsistencias(); // obtenemos y guardamos en una variable las asistencias de cada monitoria
            for (int j = 0; j < asis.size(); j++) {// recorremos las asistencias
                estud.add(asis.get(j)); // a cada estudiante de dicha asistencia lo metemos en la lsita total de asistencias a monitoria
            }
        }
        return estud; // retornamos la lista total de todas las asistencias de las monitorias de una materia
    }

    public float obtenerTasaRepitentes(int codigoMateria) { // porcentaje de estudiantes que han perdido la materia (Historia 6)
        ArrayList<Estudiante_Curso> EenM = obtenerTodosLosEstudiantesDeUnaMateria(codigoMateria);
        int totalEstudiantes = EenM.size();
        int estudiantesPerdidos = 0;

        for (int i = 0; i < totalEstudiantes; i++) {
            if (EenM.get(i).calcularNotaFinal() < 300) {
                estudiantesPerdidos++;
            }
        }

        if (totalEstudiantes > 0) { // si el total de estudiantes es mayor a 0
            return estudiantesPerdidos / totalEstudiantes; // devuelveme el porcentaje de estudiantes que perdieron
        } else {
            return 0; // si es menor a 0, retorna 0
        }

    }

    //Historia
    public boolean sirvioMonitoria(int codigoEstudiante, int codigoMateria) {

        //verificar si el estudiante fue a monitorias de dicha materia
        boolean haIdoAMonitoria = false;
        ArrayList<Estudiante> asistenciasAMon = obtenerTodosLosEstudiantesDeUnaMonitoria(codigoMateria);
        for (int i = 0; i < asistenciasAMon.size(); i++) {
            if (asistenciasAMon.get(i).getCodigo() == codigoEstudiante) {
                haIdoAMonitoria = true;
                break;
            }
        }

        // verificar si el estudiante gano la materia
        boolean haGanado = haGanadoLaMateria(codigoEstudiante, codigoMateria);

        // si gano la materia y fue a monitoria, entonces le sirvio la monitoria
        return haGanado && haIdoAMonitoria;

    }

    // historia de usuario 7
    public float tasaDeExito(int codigoMateria) {
        float tasa = obtenerTasaRepitentes(codigoMateria);
        if (tasa != 0) {
            return tasa - 1;
        } else {
            return 0;
        }

    }

    public float tasaDesercionProfesor(int codigoProfesor, int codigoMateria) { // historia 8
        Profesor p = buscarProfesor(codigoProfesor); // Buscamos al profesor

        ArrayList<Estudiante_Curso> todosEstu = new ArrayList<>(); // inicializamos un array vacio

        if (p != null) { // Si el profesor existe
            ArrayList<Curso> cursos = p.getCursos(); // obtenemos los cursos del profesor
            for (int i = 0; i < cursos.size(); i++) { // recorremos el array de cursos del profesor
                if (cursos.get(i).getMateria().getCodigo() == codigoMateria) { // si el curso actual es de la materia que estamos buscando
                    ArrayList<Estudiante_Curso> estud = cursos.get(i).getEstudiantes(); // obten todos los estudiantes de dicho curso
                    for (int j = 0; j < estud.size(); j++) { // recorre todos los estudiantes del curso
                        todosEstu.add(estud.get(j)); // Ingresa a los estudiantes al array de todos los estudiantes
                    }
                }
            }
        }
        int totalEstudiantes = todosEstu.size(); // obtenemos el total de estudiantes
        int estudiantesPerdidos = 0; // inicializamos la cantidad de estudiantes que han perdido la materia a 0
        for (int i = 0; i < todosEstu.size(); i++) { // recorremos el array de todos los estudiantes de una materia
            if (todosEstu.get(i).calcularNotaFinal() < 300) { // si la nota final del estudiante es menor a 300
                estudiantesPerdidos++; // aumentamos en 1 la poblacion de estudiantes perdidos
            }
        }

        if (totalEstudiantes != 0) {// si el total de estudiantes no es 0
            return estudiantesPerdidos / totalEstudiantes; // retornamos el porcentaje de estudiantes perdidos
        } else {
            return 0; // de otro modo retorna 0
        }

    }

    public Profesor buscarProfesor(int codigoProfesor) {
        Profesor p = null;
        Profesor x = null;
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i) instanceof Profesor) {
                p = (Profesor) usuarios.get(i);
                if (p.getCodigo() == codigoProfesor) {
                    x = p;
                }
            }
        }
        return x;
    }

    // Historia 1
    public boolean ingresarEstudianteEnMateria(Estudiante estudiante, int codigoMateria, int codigoProfesor) {
        if (buscarProfesor(codigoProfesor) != null) {
            if (buscarProfesor(codigoProfesor).buscarCurso(codigoMateria) != null) {
                buscarProfesor(codigoProfesor).buscarCurso(codigoMateria).add(new Estudiante_Curso(estudiante, 0, 0, 0, "activo"));
            }
        }
        return false;
    }

    // Historia 1
    public boolean eliminarEstudianteMateria(int codigoEstudiante, int codigoMateria, int codigoProfesor) {
        if (buscarProfesor(codigoProfesor) != null) {
            if (buscarProfesor(codigoProfesor).buscarCurso(codigoMateria) != null) {
                return buscarProfesor(codigoProfesor).buscarCurso(codigoMateria).delete(codigoEstudiante);
            }
        }
        return false;
    }

    // Historia 1
    public Estudiante_Curso obtenerEstudianteDeMateria(int codigoEstudiante, int codigoMateria, int codigoProfesor) {
        if (buscarProfesor(codigoProfesor) != null) {
            if (buscarProfesor(codigoProfesor).buscarCurso(codigoMateria) != null) {
                return buscarProfesor(codigoProfesor).buscarCurso(codigoMateria).buscar(codigoEstudiante);
            }
        }
        return null;
    }

}
