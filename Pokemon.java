public class Pokemon {
    private String nombre;
    private TipoPokemon tipo;
    private int ataque;
    private int defensa;
    private HabilidadEspecial habilidad;
    private int bonusAtaque;
    private int bonusDefensa;
    private int rondasConBonusAtaque;
    private int rondasConBonusDefensa;
    
    public Pokemon(String nombre, TipoPokemon tipo, int ataque, int defensa, HabilidadEspecial habilidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.habilidad = habilidad;
        this.bonusAtaque = 0;
        this.bonusDefensa = 0;
        this.rondasConBonusAtaque = 0;
        this.rondasConBonusDefensa = 0;
    }

    public int getAtaqueTotal() {
        return ataque + bonusAtaque;
    }
    
    public int getDefensaTotal() {
        return defensa + bonusDefensa;
    }
    
    public boolean usarHabilidad() {
        if (habilidad.seActiva()) {
            if (habilidad.getEfecto() == TipoEfecto.AUMENTAR_ATAQUE) {
                bonusAtaque = bonusAtaque + habilidad.getValor();
                rondasConBonusAtaque = 2;
            } else if (habilidad.getEfecto() == TipoEfecto.AUMENTAR_DEFENSA) {
                bonusDefensa = bonusDefensa + habilidad.getValor();
                rondasConBonusDefensa = 2;
            }
            return true; 
        }
        return false; 
    }

    public void actualizarBonusRonda() {
        if (rondasConBonusAtaque > 0) {
            rondasConBonusAtaque = rondasConBonusAtaque - 1;
            if (rondasConBonusAtaque == 0) {
                bonusAtaque = 0;
            }
        }
        
        if (rondasConBonusDefensa > 0) {
            rondasConBonusDefensa = rondasConBonusDefensa - 1;
            if (rondasConBonusDefensa == 0) {
                bonusDefensa = 0;
            }
        }
    }
    
    
    public String getNombre() { 
        return nombre; 
    }
    
    public TipoPokemon getTipo() { 
        return tipo; 
    }
    
    public int getAtaque() { 
        return ataque; 
    }
    
    public int getDefensa() { 
        return defensa; 
    }
    
    public HabilidadEspecial getHabilidad() { 
        return habilidad; 
    }
}