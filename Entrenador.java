public class Entrenador {
    private String nombre;
    private Pokemon[] equipo;
    private boolean[] yaUsado;


    public Entrenador(String nombre) {
        this.nombre = nombre; 
        this.equipo = new Pokemon[4];
        this.yaUsado = new boolean[4];
    }

    public void agregarPokemon(Pokemon pokemon, int posicion) {
        if (posicion >= 0 && posicion < 4) {
            equipo[posicion] = pokemon;
        }
    }
    
    public Pokemon seleccionarPokemon(int posicion) {
        if (posicion >= 0 && posicion < 4 && !yaUsado[posicion]) {
            yaUsado[posicion] = true;
            return equipo[posicion];
        }
        return null; 
    }

    public boolean pokemonDisponible(int posicion) {
        if (posicion >= 0 && posicion < 4) {
            return !yaUsado[posicion];
        }
        return false;
    }

    public void reiniciarSelecciones() {
        for (int i = 0; i < 4; i++) {
            yaUsado[i] = false;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public Pokemon getPokemon(int posicion) {
        if (posicion >= 0 && posicion < 4) {
            return equipo[posicion];
        }
        return null;
    }
}
