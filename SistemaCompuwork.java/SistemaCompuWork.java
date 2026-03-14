import java.util.ArrayList;
import java.util.Scanner;

public class SistemaCompuWork {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Empleado> empleados = new ArrayList<>();
    static ArrayList<Departamento> departamentos = new ArrayList<>();

    static ReporteDesempeño reporte = new ReporteDesempeño();

    public static void main(String[] args) {

        // LOGIN BASICO
        System.out.println("=== LOGIN ===");

        System.out.print("Usuario: ");
        String user = sc.nextLine();

        System.out.print("Clave: ");
        String pass = sc.nextLine();

        if (!user.equals("admin") || !pass.equals("1234")) {
            System.out.println("Acceso incorrecto");
            return;
        }

        int opcion = 0;

        while (opcion != 10) {

            System.out.println("\n==== MENU ====");
            System.out.println("1 Crear empleado");
            System.out.println("2 Crear departamento");
            System.out.println("3 Asignar empleado a departamento");
            System.out.println("4 Actualizar rendimiento");
            System.out.println("5 Reporte individual");
            System.out.println("6 Reporte por departamento");
            System.out.println("7 Eliminar empleado");
            System.out.println("8 Modificar departamento");
            System.out.println("9 Eliminar departamento");
            System.out.println("10 Salir");

            try {

                System.out.print("Opcion: ");
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {

                    case 1:
                        crearEmpleado();
                        break;

                    case 2:
                        crearDepartamento();
                        break;

                    case 3:
                        asignarEmpleado();
                        break;

                    case 4:
                        actualizarRendimiento();
                        break;

                    case 5:
                        reporteIndividual();
                        break;

                    case 6:
                        reporteDepartamento();
                        break;

                    case 7:
                        eliminarEmpleado();
                        break;

                    case 8:
                        modificarDepartamento();
                        break;

                    case 9:
                        eliminarDepartamento();
                        break;

                    case 10:
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opcion invalida");

                }

            } catch (Exception e) {

                System.out.println("Error en la entrada de datos");
                sc.nextLine();

            }

        }

    }

    static void crearEmpleado() {

        try {

            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Cargo: ");
            String cargo = sc.nextLine();

            System.out.print("Tipo (1 Permanente / 2 Temporal): ");
            int tipo = sc.nextInt();
            sc.nextLine();

            Empleado e;

            if (tipo == 1) {
                e = new EmpleadoPermanente(id, nombre, cargo);
            } else {
                e = new EmpleadoTemporal(id, nombre, cargo);
            }

            empleados.add(e);

            System.out.println("Empleado creado");

        } catch (Exception e) {

            System.out.println("Error al crear empleado");
            sc.nextLine();

        }

    }

    static void crearDepartamento() {

        System.out.print("Nombre del departamento: ");
        String nombre = sc.nextLine();

        departamentos.add(new Departamento(nombre));

        System.out.println("Departamento creado");

    }

    static void asignarEmpleado() {

        try {

            System.out.print("ID del empleado: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Nombre del departamento: ");
            String nombre = sc.nextLine();

            Empleado emp = null;
            Departamento dep = null;

            for (Empleado e : empleados) {

                if (e.getId() == id) {
                    emp = e;
                }

            }

            for (Departamento d : departamentos) {

                if (d.getNombre().equalsIgnoreCase(nombre)) {
                    dep = d;
                }

            }

            if (emp == null || dep == null) {
                throw new Exception();
            }

            emp.setDepartamento(dep);
            dep.agregarEmpleado(emp);

            System.out.println("Empleado asignado al departamento");

        } catch (Exception e) {

            System.out.println("No se pudo asignar el empleado");

        }

    }

    static void actualizarRendimiento() {

        try {

            System.out.print("ID del empleado: ");
            int id = sc.nextInt();

            for (Empleado e : empleados) {

                if (e.getId() == id) {

                    System.out.print("Nuevo rendimiento: ");
                    double r = sc.nextDouble();

                    e.setRendimiento(r);

                    System.out.println("Rendimiento actualizado");
                    return;

                }

            }

            System.out.println("Empleado no encontrado");

        } catch (Exception e) {

            System.out.println("Error al actualizar rendimiento");
            sc.nextLine();

        }

    }

    static void reporteIndividual() {

        try {

            System.out.print("ID del empleado: ");
            int id = sc.nextInt();

            for (Empleado e : empleados) {

                if (e.getId() == id) {

                    reporte.reporteIndividual(e);
                    return;

                }

            }

            System.out.println("Empleado no encontrado");

        } catch (Exception e) {

            System.out.println("Error al generar reporte");

        }

    }

    static void reporteDepartamento() {

        sc.nextLine();

        System.out.print("Nombre del departamento: ");
        String nombre = sc.nextLine();

        for (Departamento d : departamentos) {

            if (d.getNombre().equalsIgnoreCase(nombre)) {

                reporte.reporteDepartamento(d);
                return;

            }

        }

        System.out.println("Departamento no encontrado");

    }

    static void eliminarEmpleado() {

        try {

            System.out.print("ID del empleado a eliminar: ");
            int id = sc.nextInt();

            for (int i = 0; i < empleados.size(); i++) {

                if (empleados.get(i).getId() == id) {

                    empleados.remove(i);

                    System.out.println("Empleado eliminado");
                    return;

                }

            }

            System.out.println("Empleado no encontrado");

        } catch (Exception e) {

            System.out.println("Error al eliminar empleado");
            sc.nextLine();

        }

    }

    static void modificarDepartamento() {

        sc.nextLine();

        System.out.print("Nombre del departamento a modificar: ");
        String nombre = sc.nextLine();

        for (Departamento d : departamentos) {

            if (d.getNombre().equalsIgnoreCase(nombre)) {

                System.out.print("Nuevo nombre del departamento: ");
                String nuevo = sc.nextLine();

                try {

                    java.lang.reflect.Field field = d.getClass().getDeclaredField("nombre");
                    field.setAccessible(true);
                    field.set(d, nuevo);

                    System.out.println("Departamento modificado");

                } catch (Exception e) {

                    System.out.println("No se pudo modificar el departamento");

                }

                return;

            }

        }

        System.out.println("Departamento no encontrado");

    }

    static void eliminarDepartamento() {

        sc.nextLine();

        System.out.print("Nombre del departamento a eliminar: ");
        String nombre = sc.nextLine();

        for (int i = 0; i < departamentos.size(); i++) {

            if (departamentos.get(i).getNombre().equalsIgnoreCase(nombre)) {

                departamentos.remove(i);

                System.out.println("Departamento eliminado");
                return;

            }

        }

        System.out.println("Departamento no encontrado");

    }

}