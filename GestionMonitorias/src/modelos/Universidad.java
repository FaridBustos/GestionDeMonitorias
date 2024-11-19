/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author Casa Verano
 */
public class Universidad implements Serializable {

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

    public Estudiante buscarEstudiante(int codigo) {
        ArrayList<Estudiante> estu = obtenerEstudiantes();
        for (int i = 0; i < estu.size(); i++) {
            if (estu.get(i).getCodigo() == codigo) {
                return estu.get(i);
            }
        }
        return null;
    }

    public ArrayList<Estudiante> obtenerEstudiantes() {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i) instanceof Estudiante) {
                estudiantes.add((Estudiante) usuarios.get(i));
            }
        }
        return estudiantes;
    }

    public boolean eliminarEstudiante(int codigo) {
        ArrayList<Estudiante> est = obtenerEstudiantes();
        for (int i = 0; i < est.size(); i++) {
            if (est.get(i).getCodigo() == codigo) {
                return usuarios.remove(est.get(i));
            }
        }
        return false;
    }

    public boolean eliminarProfesor(int codigo) {
        ArrayList<Profesor> prof = obtenerProfesores();
        for (int i = 0; i < prof.size(); i++) {
            if (prof.get(i).getCodigo() == codigo) {
                return usuarios.remove(prof.get(i));
            }
        }
        return false;
    }

    public Usuario buscarUsuario(String username) {
        for (int i = 0; i < getUsuarios().size(); i++) {
            if (getUsuarios().get(i).getUsername().equalsIgnoreCase(username)) {
                return getUsuarios().get(i);
            }
        }
        return null;
    }

    // historia 2
    public boolean ingresarMateria(Materia x) {
        return getMaterias().add(x);
    }

    // historia 2
    public boolean eliminarMateria(int codigo) {
        Materia x = buscarMateria(codigo);
        if (x != null) {
            return materias.remove(x);
        } else {
            return false;
        }
    }

    // historia 2
    public Materia buscarMateria(int codigo) {
        for (int i = 0; i < getUsuarios().size(); i++) {
            if (materias.get(i).getCodigo() == codigo) {
                return materias.get(i);
            }
        }
        return null;
    }

    public boolean VerificarProfesor() {
        return this.getUsuarioActual().getRole().equals("profesor");
    }

    public boolean VerificarAdmin() {
        return this.getUsuarioActual().getRole().equals("admin");
    }

    public boolean VerificarMonitor() {
        return this.getUsuarioActual().getRole().equals("monitor");
    }

    public boolean VerificarEstudiante() {
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

    public Materia obtenerMateria(int codigo) {
        for (int i = 0; i < materias.size(); i++) {
            if (materias.get(i).getCodigo() == codigo) {
                return materias.get(i);
            }
        }
        return null;
    }

    // Historia 14
    public ArrayList<Profesor> obtenerProfesores() {
        ArrayList<Profesor> profesores = new ArrayList<>();
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i) instanceof Profesor) {
                profesores.add((Profesor) usuarios.get(i));
            }
        }
        return profesores;
    }

    // Historia 5
    public boolean setMonitor(int codigoMateria, Estudiante monitor) {
        for (int i = 0; i < materias.size(); i++) {
            if (materias.get(i).getCodigo() == codigoMateria) {
                materias.get(i).setMonitor(monitor);
                return true;
            }
        }
        return false;
    }

    // historia 9
    public ArrayList<Estudiante_Curso> obtenerTodosLosEstudiantesDeUnaMateria(int codigoMateria) {
        ArrayList<Estudiante_Curso> estudiantesM = new ArrayList<>();

        ArrayList<Curso> AllCursos = new ArrayList<>();

        ArrayList<Profesor> profesores = obtenerProfesores();
        for (int i = 0; i < profesores.size(); i++) {
            AllCursos = profesores.get(i).buscarCursos(codigoMateria);
            for (int j = 0; j < AllCursos.size(); j++) {
                for (int k = 0; k < AllCursos.get(j).getEstudiantes().size(); k++) {
                    estudiantesM.add(AllCursos.get(j).getEstudiantes().get(k));
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

    // porcentaje de estudiantes que han perdido la materia (Historia 6)
    public float tasaDeMortalidad(int codigoMateria) {
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

    //historia 12 y 13
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
        boolean haGanado = false;
        ArrayList<Profesor> allProfesores = obtenerProfesores();
        for (int i = 0; i < allProfesores.size(); i++) {
            if (allProfesores.get(i).buscarEstudianteEnCurso(codigoEstudiante, codigoMateria) != null) {
                haGanado = allProfesores.get(i).buscarEstudianteEnCurso(codigoEstudiante, codigoMateria).ganoMateria();
            }

        }

        // si gano la materia y fue a monitoria, entonces le sirvio la monitoria
        return haGanado && haIdoAMonitoria;

    }

    // historia 7
    public float tasaDeExito(int codigoMateria) {
        float tasa = tasaDeMortalidad(codigoMateria);
        if (tasa != 0) {
            return tasa - 1;
        } else {
            return 0;
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
    public boolean ingresarEstudianteEnMateria(Estudiante_Curso estudiante, int codigoMateria, int codigoProfesor, int grupo) {
        Profesor p = buscarProfesor(codigoProfesor);
        // si el profesor existe
        if (p != null) {
            // Si el estudiante no existe en ningun curso
            Estudiante_Curso es = p.buscarEstudianteEnCurso(estudiante.getEstudiante().getCodigo(), codigoMateria);
            if (es == null) {
                p.añadirEstudianteEnCurso(estudiante, codigoMateria, grupo);
            } else if (es.estudianteRetiro()) {
                es.setEstado("activo");
            }
        }
        return false;
    }

    // Historia 1
    public boolean eliminarEstudianteMateria(int codigoEstudiante, int codigoMateria, int codigoProfesor) {
        if (buscarProfesor(codigoProfesor) != null) {
            ArrayList<Curso> AllCursos = buscarProfesor(codigoProfesor).buscarCursos(codigoMateria);
            for (int i = 0; i < AllCursos.size(); i++) {
                if (AllCursos.get(i).delete(codigoEstudiante)) {
                    return true;
                }
            }

        }
        return false;
    }

    // Historia 1 y historia 16
    public Estudiante_Curso obtenerEstudianteDeMateria(int codigoEstudiante, int codigoMateria, int codigoProfesor) {
        if (buscarProfesor(codigoProfesor) != null) {
            ArrayList<Curso> AllCursos = buscarProfesor(codigoProfesor).buscarCursos(codigoMateria);
            for (int i = 0; i < AllCursos.size(); i++) {
                if (AllCursos.get(i).buscar(codigoEstudiante) != null) {
                    return AllCursos.get(i).buscar(codigoEstudiante);
                }
            }

        }
        return null;
    }


    

    private ArrayList<Integer> obtenerListaDeCodigosUnicos(ArrayList<Estudiante_Curso> allEstudiantes) {
        ArrayList<Integer> CodigosYaRevisados = new ArrayList<>();
        for (int i = 0; i < allEstudiantes.size(); i++) {
            if (!CodigosYaRevisados.contains(allEstudiantes.get(i).getEstudiante().getCodigo())) {
                CodigosYaRevisados.add(allEstudiantes.get(i).getEstudiante().getCodigo());
            }
        }
        return CodigosYaRevisados;
    }

    // Historia 10
    public float tasaDeRepitentes(int codigoMateria) {
        ArrayList<Estudiante_Curso> allEstudiantes = obtenerTodosLosEstudiantesDeUnaMateria(codigoMateria);
        ArrayList<Integer> codigosU = obtenerListaDeCodigosUnicos(allEstudiantes);
        int numOcurrencias = 0;
        int numRepitentes = 0;
        for (int i = 0; i < codigosU.size(); i++) {
            for (int j = 0; j < allEstudiantes.size(); j++) {
                if (codigosU.get(i) == allEstudiantes.get(j).getEstudiante().getCodigo()) {
                    numOcurrencias++;
                    if (numOcurrencias > 1) {
                        numRepitentes++;
                        break;
                    }
                }
            }
            numOcurrencias = 0;

        }
        if (!codigosU.isEmpty()) {
            return numRepitentes / codigosU.size();
        }
        return 0;

    }

    //historia 11
    public float asistenciasUnicasAMonitorias(int codigoMateria) {
        ArrayList<Estudiante> allEstudiantes = obtenerTodosLosEstudiantesDeUnaMonitoria(codigoMateria);
        Set<Estudiante> setUnicos = new LinkedHashSet<>(allEstudiantes);
        return setUnicos.size();

    }

    //historia 17
    public float tasaDePerdidaPorFacultad(int codigoMateria, String facultad) {
        ArrayList<Estudiante_Curso> estudiantes = obtenerTodosLosEstudiantesDeUnaMateria(codigoMateria);
        int perdidos = 0;
        int total = 0;
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getEstudiante().getFacultad().equals(facultad)) {
                total++;
                if (!estudiantes.get(i).ganoMateria()) {
                    perdidos++;
                }
            }
        }
        if (total > 0) {
            return perdidos / total;
        }
        return 0;
    }

}
