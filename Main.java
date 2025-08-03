import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vista vista = new Vista();
        boolean continuar = true;
        
        while (continuar) {
            System.out.print(vista.mostrarMenu());
            int opcion = scanner.nextInt();
            
            if (opcion == 1) {
                jugar(scanner, vista);
            } else if (opcion == 2) {
                continuar = false;
                System.out.println("¡Gracias por jugar!");
            } else {
                System.out.println(vista.mostrarError("Opcion no valida"));
            }
        }
        scanner.close();
    }

    public static void jugar(Scanner scanner, Vista vista) {
        Entrenador ash = crearAsh();
        Entrenador gary = crearGary();
        
        
        Batalla batalla = new Batalla(ash, gary);
        
        System.out.println("\n¡Comienza la batalla entre " + ash.getNombre() + " y " + gary.getNombre() + "!");
        
        
        for (int ronda = 1; ronda <= 4; ronda++) {
            System.out.println("\n========= RONDA " + ronda + " =========");
            
            
            System.out.print(vista.mostrarEquipo(ash));
            System.out.print("Ash, elige tu Pokemon (1-4): ");
            int pokemonAsh = scanner.nextInt() - 1;
            
            System.out.print(vista.preguntarAccion());
            int accionAsh = scanner.nextInt();
            boolean ashUsaHabilidad = (accionAsh == 2);
            
            
            System.out.print(vista.mostrarEquipo(gary));
            System.out.print("Gary, elige tu Pokemon (1-4): ");
            int pokemonGary = scanner.nextInt() - 1;
            
            System.out.print(vista.preguntarAccion());
            int accionGary = scanner.nextInt();
            boolean garyUsaHabilidad = (accionGary == 2);
            
            
            int ganador = batalla.ejecutarRonda(pokemonAsh, pokemonGary, ashUsaHabilidad, garyUsaHabilidad);
            
            if (ganador == -1) {
                System.out.println(vista.mostrarError("Pokemon no disponible"));
            } else {
                System.out.println(vista.mostrarResultadoRonda(ganador, ash.getNombre(), gary.getNombre(), ronda));
            }
        }
        
        
        System.out.println(vista.mostrarResultadoFinal(batalla));
    }

        public static Entrenador crearAsh() {
        Entrenador ash = new Entrenador("Ash");
        
        // Crear habilidades
        HabilidadEspecial llamaFinal = new HabilidadEspecial("Llama Final", TipoEfecto.AUMENTAR_ATAQUE, 15, 30);
        HabilidadEspecial torrente = new HabilidadEspecial("Torrente", TipoEfecto.AUMENTAR_ATAQUE, 12, 40);
        HabilidadEspecial escudo = new HabilidadEspecial("Escudo Natural", TipoEfecto.AUMENTAR_DEFENSA, 20, 25);
        HabilidadEspecial rayo = new HabilidadEspecial("Impacto Relampago", TipoEfecto.DAÑAR_ENEMIGO, 10, 35);
        
        // Crear pokemon
        Pokemon charizard = new Pokemon("Charizard", TipoPokemon.FUEGO, 84, 78, llamaFinal);
        Pokemon blastoise = new Pokemon("Blastoise", TipoPokemon.AGUA, 83, 100, torrente);
        Pokemon venusaur = new Pokemon("Venusaur", TipoPokemon.PLANTA, 82, 83, escudo);
        Pokemon pikachu = new Pokemon("Pikachu", TipoPokemon.ELECTRICO, 55, 40, rayo);
        
        // Agregar al equipo
        ash.agregarPokemon(charizard, 0);
        ash.agregarPokemon(blastoise, 1);
        ash.agregarPokemon(venusaur, 2);
        ash.agregarPokemon(pikachu, 3);
        
        return ash;
    }
    
    public static Entrenador crearGary() {
        Entrenador gary = new Entrenador("Gary");
        
        // Crear habilidades
        HabilidadEspecial fuego = new HabilidadEspecial("Llama Final", TipoEfecto.AUMENTAR_ATAQUE, 15, 30);
        HabilidadEspecial agua = new HabilidadEspecial("Torrente", TipoEfecto.AUMENTAR_ATAQUE, 12, 40);
        HabilidadEspecial planta = new HabilidadEspecial("Escudo Natural", TipoEfecto.AUMENTAR_DEFENSA, 20, 25);
        HabilidadEspecial electrico = new HabilidadEspecial("Impacto Relampago", TipoEfecto.DAÑAR_ENEMIGO, 10, 35);
        
        // Crear pokemon
        Pokemon arcanine = new Pokemon("Arcanine", TipoPokemon.FUEGO, 110, 80, fuego);
        Pokemon gyarados = new Pokemon("Gyarados", TipoPokemon.AGUA, 125, 79, agua);
        Pokemon exeggutor = new Pokemon("Exeggutor", TipoPokemon.PLANTA, 95, 85, planta);
        Pokemon jolteon = new Pokemon("Jolteon", TipoPokemon.ELECTRICO, 65, 60, electrico);
        
        // Agregar al equipo
        gary.agregarPokemon(arcanine, 0);
        gary.agregarPokemon(gyarados, 1);
        gary.agregarPokemon(exeggutor, 2);
        gary.agregarPokemon(jolteon, 3);
        
        return gary;
    }
}

