public class HabilidadEspecial {
    private String nombre;
    private TipoEfecto efecto;
    private int valor;
    private int probabilidad;
    
    public HabilidadEspecial(String nombre, TipoEfecto efecto, int valor, int probabilidad) {
        this.nombre = nombre;
        this.efecto = efecto;
        this.valor = valor;
        this.probabilidad = probabilidad;
    }
    
    
    public boolean seActiva() {
        int numeroRandom = (int)(Math.random() * 100);
        return numeroRandom < probabilidad;
    }

    public String getNombre() { 
        return nombre; 
    }
    
    public TipoEfecto getEfecto() { 
        return efecto; 
    }
    
    public int getValor() { 
        return valor; 
    }
    
    public int getProbabilidad() { 
        return probabilidad; 
    }
}
