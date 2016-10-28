package personaje;

import constante.Constantes;
import interfaces.Atacable;
import personaje.Alianza;

public abstract class Personaje implements Atacable {
	protected int experiencia = 0;
	protected int nivel = 1;
	protected int destreza;	///INDICA BENEFICIOS AL PERSONAJE EN LA BATALLA, COMO ESQUIVAR...
	protected int fuerza;
	protected int inteligencia;
	protected int energia = 100;
	protected int salud = 100;
	protected int altura;
	protected String nombre;
	public Casta casta = null;
	protected Alianza alianza = null;
	
	

	public final void atacar(Atacable atacado) {
		if (puedeAtacar()) {
			atacado.serAtacado(calcularPuntosDeAtaque());
			energia -= calcularPuntosDeAtaque();
			despuesDeAtacar();
		}
	}
	
	@Override
	public void serAtacado(int da�o) {
		if( da�o <= this.calcularPuntosDeDefensa())
			da�o = 0;
		else
			da�o -= this.calcularPuntosDeDefensa();
		
		this.salud -= da�o;
		this.despuesDeSerAtacado();
	}
	
	//DEFENSA
	protected abstract int calcularPuntosDeDefensa();
	public int obtenerPuntosDeDefensa() {
		return calcularPuntosDeDefensa();
	}
	
	protected void despuesDeSerAtacado() { }
	
	//ATAQUE
	protected abstract boolean puedeAtacar();
	protected abstract int calcularPuntosDeAtaque();
	
	///LO PUEDE USAR EL ALIEN COMO UN MODO DE REGENERARSE
	///POR EJ, DESPUES DE ATACAR RECUPERA UN PORCENTAJE DE ENERGIA
	///EQUIVALENTE AL DA�O REALIZADO.
	protected void despuesDeAtacar() { }
	public int obtenerPuntosDeAtaque() {
		return calcularPuntosDeAtaque();
	}
	
	/// GETTERS
	public int getDestreza() {
		return destreza;
	}

	public int getFuerza() {
		return fuerza;
	}

	public int getInteligencia() {
		return inteligencia;
	}
	
	public int getAltura() {
		return this.altura;
	}
	
	public int getExperiencia() {
		return this.experiencia;
	}
	
	public int getNivel() {
		return this.nivel;
	}

	public Casta getCasta() {
		return casta;
	}

	public int getSalud() {
		return salud;
	}
	
	public Alianza getAlianza() {
		return alianza;
	}
	
	// BOOLEANS
	public boolean esSaludMaxima() {
		return this.salud==100;
	}
	
	public boolean esEnergiaMaxima() {
		return this.energia==100;
	}
	
	public boolean estaVivo() {
		return this.salud > 0;
	}
	
	/// ALIANZA
	public void crearAlianza(String nombreAlianza) {
		this.alianza = new Alianza(nombreAlianza);
		this.alianza.agregarAliado(this);	//Se agrega en el momento que se crea la alianza entre dos personajes. 
	}
	
	public void aliar(Personaje per){
		this.alianza.aliar(per);
	}
	
	public void desaliar(){
		this.alianza.desaliar(this);
	}
	
	///Aumentar Experiencia
	public void aumentarExperiencia() {
		this.experiencia+= Constantes.EXPERIENCIA_POR_VICTORIA;
		
		if(esTopeDeExperiencia())
			subirDeNivel();
	}
	
	public boolean esTopeDeExperiencia() {
		return this.experiencia >= Constantes.EXPERERIENCIA_TOPE_POR_NIVEL[this.nivel];
	}
	
	public void subirDeNivel() {
		this.nivel+=1;
	}
	
}
