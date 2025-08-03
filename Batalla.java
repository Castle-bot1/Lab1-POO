public class Batalla {
    private Entrenador entrenador1;
    private Entrenador entrenador2;
    private int rondasGanadas1;
    private int rondasGanadas2;
    private int rondaActual;

    public Batalla(Entrenador entrenador1, Entrenador entrenador2) {
        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;
        this.rondasGanadas1 = 0;
        this.rondasGanadas2 = 0;
        this.rondaActual = 0;
    }

    public int ejecutarRonda(int pokemon1, int pokemon2, boolean usa1Habilidad, boolean usa2Habilidad) {
        if (rondaActual >= 4) {
            return -1; 
        }
        
        Pokemon p1 = entrenador1.seleccionarPokemon(pokemon1);
        Pokemon p2 = entrenador2.seleccionarPokemon(pokemon2);
        
        if (p1 == null || p2 == null) {
            return -1; 
        }
        
        int ataqueTotal1 = calcularAtaque(p1, p2, usa1Habilidad);
        int ataqueTotal2 = calcularAtaque(p2, p1, usa2Habilidad);
        
        int ganador = 0; 
        
        if (ataqueTotal1 > ataqueTotal2) {
            ganador = 1;
            rondasGanadas1++;
        } else if (ataqueTotal2 > ataqueTotal1) {
            ganador = 2;
            rondasGanadas2++;
        }
        
        p1.actualizarBonusRonda();
        p2.actualizarBonusRonda();
        
        rondaActual++;
        return ganador;
    }

    private int calcularAtaque(Pokemon atacante, Pokemon defensor, boolean usaHabilidad) {
        int ataqueBase = atacante.getAtaqueTotal();
        int efectoTipo = calcularEfectoTipo(atacante.getTipo(), defensor.getTipo());
        int dañoExtra = 0;
        
        if (usaHabilidad) {
            boolean seActivo = atacante.usarHabilidad();

            if (seActivo && atacante.getHabilidad().getEfecto() == TipoEfecto.DAÑAR_ENEMIGO) {
                dañoExtra = Math.abs(atacante.getHabilidad().getValor());
            }
        }
        
        return ataqueBase + efectoTipo + dañoExtra;
    }

    private int calcularEfectoTipo(TipoPokemon atacante, TipoPokemon defensor) {
        
        if (atacante == TipoPokemon.FUEGO && defensor == TipoPokemon.PLANTA) return 20;
        if (atacante == TipoPokemon.PLANTA && defensor == TipoPokemon.AGUA) return 20;
        if (atacante == TipoPokemon.AGUA && defensor == TipoPokemon.FUEGO) return 20;
        if (atacante == TipoPokemon.ELECTRICO && defensor == TipoPokemon.AGUA) return 20;
        
        if (atacante == TipoPokemon.FUEGO && defensor == TipoPokemon.AGUA) return -10;
        if (atacante == TipoPokemon.AGUA && defensor == TipoPokemon.PLANTA) return -10;
        if (atacante == TipoPokemon.PLANTA && defensor == TipoPokemon.FUEGO) return -10;
        
        return 0;
    }

    public int determinarGanadorFinal() {
        if (rondasGanadas1 > rondasGanadas2) {
            return 1;
        } else if (rondasGanadas2 > rondasGanadas1) {
            return 2;
        } else {
            return 0; // Empate
        }
    }
    
    // Getters simples
    public Entrenador getEntrenador1() { 
        return entrenador1; 
    }
    
    public Entrenador getEntrenador2() { 
        return entrenador2; 
    }
    
    public int getRondasGanadas1() { 
        return rondasGanadas1; 
    }
    
    public int getRondasGanadas2() { 
        return rondasGanadas2; 
    }
    
    public int getRondaActual() { 
        return rondaActual; 
    }
}
