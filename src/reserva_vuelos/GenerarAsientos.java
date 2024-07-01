package reserva_vuelos;

import java.util.List;

public class GenerarAsientos {
    // Método para generar la lista de asientos de un objeto Avion
    protected static List<Asiento> generarAsientos(List<Asiento> listaAsientos, double precio_base_asientos, int num_asientos_grandes, 
                                                    int num_asientos_normales, int num_asientos_pequenos) throws IllegalArgumentException {
        int num_asientos_totales = num_asientos_grandes + num_asientos_normales + num_asientos_pequenos;
        if (num_asientos_totales % 6 != 0) {
            throw new IllegalArgumentException("El número total de asientos del Avion debe ser un múltiplo de 6");
        }

        int numFilas = num_asientos_totales / 6; // Cada fila tiene 6 asientos

        // Contadores para llevar el control de la cantidad de asientos grandes y pequeños
        int contadorAsientosGrandes = 0;
        int contadorAsientosPequenos = 0;

        // NO existen asientos primera fila (A,B,C)

        // Grandes en primera fila (D,E,F)
        generarAsientosGrandes(1, 1, 'D', 'F', precio_base_asientos, listaAsientos, contadorAsientosGrandes, num_asientos_grandes);

        // Delanteros en la fila 2 (A,B,C)
        generarAsientosDelanteros(2, 2, 'A', 'C', precio_base_asientos, listaAsientos, contadorAsientosPequenos, num_asientos_pequenos);

        // Grandes en fila 2 (D,E,F)
        generarAsientosGrandes(2, 2, 'D', 'F', precio_base_asientos, listaAsientos, contadorAsientosGrandes, num_asientos_grandes);

        // Asientos Delanteros de la fila 3-5
        generarAsientosDelanteros(3, 5, 'A', 'F', precio_base_asientos, listaAsientos, contadorAsientosPequenos, num_asientos_pequenos);


        generarAsientosNormales(6, 15, 'A', 'F', precio_base_asientos, listaAsientos);

        // Si todavía hay espacio Asientos Grandes en las filas 16 y 17 (todas las letras)
        generarAsientosGrandes(16, numFilas, 'A', 'F', precio_base_asientos, listaAsientos, contadorAsientosGrandes, num_asientos_grandes);


        // Calcular fila fin teniendo en cuenta los que ya hemos llenado:
        int numAsientosOcupados = 3 + 16*6; // 3 de la primera fila, de la 2-17 hay 6
        int filaFinal = 18 + ((numAsientosOcupados - 18 * 6) / 6);
        generarAsientosNormales(18, filaFinal, 'A', 'F', precio_base_asientos, listaAsientos);

        return listaAsientos;
    }

    // Método para generar asientos normales
    private static void generarAsientosNormales(int filaInicio, int filaFin, char columnaInicio, char columnaFin,
                                                double precio_base_asientos, List<Asiento> listaAsientos) {
        for (int fila = filaInicio; fila <= filaFin; fila++) {
            for (char letra = columnaInicio; letra <= columnaFin; letra++) {
                AsientoNormal asiento = new AsientoNormal(fila, letra, precio_base_asientos, false);
                listaAsientos.add(asiento);
            }
        }
    }

    // Método para generar asientos grandes
    private static void generarAsientosGrandes(int filaInicio, int filaFin, char columnaInicio, char columnaFin,
                                               double precio_base_asientos, List<Asiento> listaAsientos, int contador, int limite) {
        for (int fila = filaInicio; fila <= filaFin; fila++) {
            for (char letra = columnaInicio; letra <= columnaFin; letra++) {
                if (contador < limite) {
                    AsientoGrande asiento = new AsientoGrande(fila, letra, precio_base_asientos, 15, false);
                    listaAsientos.add(asiento);
                    contador++;
                } else {
                    break;
                }
            }
        }
    }

    // Método para generar asientos delanteros
    private static void generarAsientosDelanteros(int filaInicio, int filaFin, char columnaInicio, char columnaFin,
                                                  double precio_base_asientos, List<Asiento> listaAsientos, int contador, int limite) {
        for (int fila = filaInicio; fila <= filaFin; fila++) {
            for (char letra = columnaInicio; letra <= columnaFin; letra++) {
                if (contador < limite) {
                    AsientoDelantero asiento = new AsientoDelantero(fila, letra, precio_base_asientos, 5, false);
                    listaAsientos.add(asiento);
                    contador++;
                } else {
                    break;
                }
            }
        }
    }
}