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
public class Profesor extends Usuario {

    private int codigo;
    private ArrayList<Curso> cursos;
    private ArrayList<Resena> resenas;

    public Profesor(int codigo, String username, String password, String role, String fullName) {
        super(username, password, role, fullName);
        this.codigo = codigo;
        this.cursos = new ArrayList<>();
        this.resenas = new ArrayList<>();
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the cursos
     */
    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    /**
     * @return the resemas
     */
    //Historia 18
    public ArrayList<Resena> getResenas() {
        return resenas;
    }

    public ArrayList<Curso> buscarCursos(int codigoMateria) {
        ArrayList<Curso> CursosDeMateria = new ArrayList<>();
        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i).getMateria().getCodigo() == codigoMateria) {
                CursosDeMateria.add(cursos.get(i));
            }
        }
        return CursosDeMateria;
    }

    public Estudiante_Curso buscarEstudianteEnCurso(int codigoEstudiante, int codigoMateria) {
        ArrayList<Curso> AllCursos = buscarCursos(codigoMateria);
        for (int i = 0; i < AllCursos.size(); i++) {
            Estudiante_Curso es = AllCursos.get(i).buscar(codigoEstudiante);
            if (es != null) {
                return es;
            }
        }
        return null;
    }

    public ArrayList<Estudiante_Curso> obtenerEstudiantesMateria(int codigoMateria) {

        ArrayList<Estudiante_Curso> allStudents = new ArrayList<>();
        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i).getMateria().getCodigo() == codigoMateria) {
                ArrayList<Estudiante_Curso> estud = cursos.get(i).getEstudiantes();
                for (int j = 0; j < estud.size(); j++) {
                    allStudents.add(estud.get(j));
                }
            }
        }
        return allStudents;
    }

    public boolean añadirEstudianteEnCurso(Estudiante_Curso estudiante, int codigoMateria, int grupo) {
        ArrayList<Curso> AllCursos = buscarCursos(codigoMateria);
        for (int i = 0; i < AllCursos.size(); i++) {
            if (AllCursos.get(i).getGrupo() == grupo) {
                AllCursos.get(i).add(estudiante);
                return true;
            }
        }
        return false;
    }

    // Historia 3
    public boolean agregarCurso(Curso x) {
        return cursos.add(x);
    }

    // Historia 3
    public boolean eliminarCurso(int codigoMateria, int grupo) {
        Curso c = buscarCurso(codigoMateria, grupo);
        if (c != null) {
            return cursos.remove(c);
        }
        return false;
    }

    public Curso buscarCurso(int codigoMateria, int grupo) {
        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i).getMateria().getCodigo() == codigoMateria && cursos.get(i).getGrupo() == grupo) {
                return cursos.get(i);
            }
        }
        return null;
    }

    //historia 4
    public boolean agregarResena(Resena x) {
        return resenas.add(x);
    }

    //historia 4
    public boolean eliminarResena(int codigoResena) {
        Resena resena = buscarResena(codigoResena);
        if (resena != null) {
            resenas.remove(resena);
        }
        return false;
    }

    public Resena buscarResena(int codigoResena) {
        for (int i = 0; i < resenas.size(); i++) {
            if (resenas.get(i).getCodigo() == codigoResena) {
                return resenas.get(i);
            }
        }
        return null;
    }

    // Buscar todos los estudiantes de una materia de un profesor
    public ArrayList<Estudiante_Curso> estudiantesDeMateria(int codigoMateria) {
        ArrayList<Curso> AllCursos = buscarCursos(codigoMateria);
        ArrayList<Estudiante_Curso> allEstudiantes = new ArrayList<>();
        for (int i = 0; i < AllCursos.size(); i++) {
            for (int j = 0; j < AllCursos.get(i).getEstudiantes().size(); j++) {
                allEstudiantes.add(AllCursos.get(i).getEstudiantes().get(j));
            }

        }
        return allEstudiantes;
    }

    //Historia 8
    public float tasaDeRetiroDeProfesor(int codigoMateria) {
        int alumnosRetirados = 0;
        int totalAlumnos = 0;

        ArrayList<Estudiante_Curso> estudiantes = estudiantesDeMateria(codigoMateria);
        totalAlumnos = estudiantes.size();
        for (int i = 0; i < totalAlumnos; i++) {
            if (estudiantes.get(i).estudianteRetiro()) {
                alumnosRetirados++;
            }
        }

        if (totalAlumnos <= 0) {
            return 0;
        }
        return alumnosRetirados / totalAlumnos;
    }

    // historia 15
    public ArrayList<Estudiante_Curso> estudiantesConBajoRendimiento(int codigoMateria) {
        ArrayList<Estudiante_Curso> estu = obtenerEstudiantesMateria(codigoMateria);
        ArrayList<Estudiante_Curso> caidos = new ArrayList<>();
        for (int i = 0; i < estu.size(); i++) {
            if (!estu.get(i).ganoMateria()) {
                caidos.add(estu.get(i));
            }
        }
        return caidos;

    }

}
