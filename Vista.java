public class Vista {
    
    public String mostrarMenu() {
        return "\n=== BATALLA POKEMON ===\n" +
               "1. Jugar\n" +
               "2. Salir\n" +
               "Elige una opcion: ";
    }

    public String mostrarEquipo(Entrenador entrenador) {
        String mensaje = "\n=== Equipo de " + entrenador.getNombre() + " ===\n";
        
        for (int i = 0; i < 4; i++) {
            Pokemon p = entrenador.getPokemon(i);
            if (entrenador.pokemonDisponible(i)) {
                mensaje = mensaje + (i + 1) + ". " + p.getNombre() + 
                         " (" + p.getTipo() + ") - ATK:" + p.getAtaque() + 
                         " DEF:" + p.getDefensa() + " Habilidad:" + 
                         p.getHabilidad().getNombre() + "\n";
            } else {
                mensaje = mensaje + (i + 1) + ". [YA USADO]\n";
            }
        }
        return mensaje;
    }

    public String preguntarAccion() {
        return "\nQue quieres hacer?\n" +
               "1. Atacar normal\n" +
               "2. Usar habilidad especial\n" +
               "Elige: ";
    }

    public String mostrarResultadoRonda(int ganador, String nombre1, String nombre2, int numRonda) {
        String mensaje = "\n--- RESULTADO RONDA " + numRonda + " ---\n";
        
        if (ganador == 1) {
            mensaje = mensaje + "¡Gana " + nombre1 + "!\n";
        } else if (ganador == 2) {
            mensaje = mensaje + "¡Gana " + nombre2 + "!\n";
        } else {
            mensaje = mensaje + "¡EMPATE!\n";
        }
        
        return mensaje;
    }

     public String mostrarResultadoFinal(Batalla batalla) {
        String mensaje = "\n=== RESULTADO FINAL ===\n";
        mensaje = mensaje + batalla.getEntrenador1().getNombre() + ": " + 
                 batalla.getRondasGanadas1() + " rondas\n";
        mensaje = mensaje + batalla.getEntrenador2().getNombre() + ": " + 
                 batalla.getRondasGanadas2() + " rondas\n";
        
        int ganador = batalla.determinarGanadorFinal();
        if (ganador == 1) {
            mensaje = mensaje + "\n GANADOR: " + batalla.getEntrenador1().getNombre() + " !!!\n";
        } else if (ganador == 2) {
            mensaje = mensaje + "\n GANADOR: " + batalla.getEntrenador2().getNombre() + " !!!\n";
        } else {
            mensaje = mensaje + "\n EMPATE!!!\n";
        }
        
        return mensaje;
    }
    
    public String mostrarError(String error) {
        return "\nERROR: " + error + "\n";
    }
}