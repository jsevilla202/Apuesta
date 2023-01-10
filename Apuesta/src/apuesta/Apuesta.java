package apuesta;
/**
 *  Clase publica de Apuesta
 * @author jsevilla
 *
 */
public class Apuesta {

	/**
	 * El dinero disponible actual
	 */
    private int dinerodisp;
    /**
     * Goles que ha marcado el equipo local
     */
    private int goleslocal;
    /**
     * Goles que ha marcado el equipo visitante
     */
    private int golesvisitante;
    /**
     * Dinero total apostado
     */
    private int apostado;

    /*Contructor por defecto*/
    /**
     * Constructor por defecto
     */
    public Apuesta() {
    	//Constructor por defecto vacio
    }

    /*Contructor con par�metros*/
    /**
     * Recoge los valores de la apuesta realizada
     * @param dinerodisp Dinero Disponible
     * @param goleslocal Goles apostads para el equipo local
     * @param golesvisitante Goles apostads para el equipo visitante
     */
    public Apuesta(int dinerodisp, int goleslocal, int golesvisitante) {
        this.dinerodisp = dinerodisp;
        this.goleslocal = goleslocal;
        this.golesvisitante = golesvisitante;
        this.apostado = 0;
    }
    
    /*M�todo para obtener el valor del atributo dinero_disp*/
    /**
     * Metodo para obtener el valor del atributo dinerodisp
     * @return Devuelve el valor de "dinerodisp"
     */
    public int getDineroDisp() {
        return dinerodisp;
    }
    
    /*M�todo para modificar el valor del atributo dinero_disp*/
    /**
     * Metodo para modificar el valor del atributo dinero_disp
     * @param dinerodisp Dinero disponible para apostar
     */
    public  void setDineroDisp(int dinerodisp) {
        this.dinerodisp = dinerodisp;
    }

    /* M�todo para apostar.
     * Permite elegir la cantidad a apostar
     *, no puede ser inferior a 1 ni superior a dinerodisp
     */
    /**
     * Metodo para apostar
     * @param dinero Dinero que se apuesta
     * @throws Exception Aparecera si se apuesta más dinero del disponible
     */
    public void apostar(int dinero) throws Exception {
        if (dinero <= 0) {
            throw new Exception("No se puede apostar menos de 1�");
        }

        if (dinero > dinerodisp) {
            throw new Exception("No se puede apostar m�s de lo que tienes");
        }
        {
            dinerodisp = dinero - dinerodisp;
            apostado = dinero;
        }
    }
    
    /* M�todo que comprueba si se ha acertado el resultado del partido
     * Si no ha acertado devuelve true. Chequea que no se metan menos de 0 goles
     */
    /**
     * Metodo que comprueba si se ha acertado el resultado del partido
     * @param local Equipo local
     * @param visitante Equipo visitante
     * @return Devuelve si la apuesta ha sido acertada o no
     * @throws Exception Aparecerá cuando se inserte un número negativo en la apuesta
     */
    public boolean comprobarResultado(int local, int visitante) throws Exception {
        boolean acertado = false;
        if (local < 0 ||visitante < 0) {
            throw new Exception("Un equipo no puede meter menos de 0 goles, por malo que sea");
        }

        if (goleslocal == local && golesvisitante == visitante) {
            acertado = true;
        }
        return acertado;
    }
    
    /* M�todo para cobrar la apuesta.
     * Comprueba que se acerto el resultado y añade el valor apostado x10  su saldo
     */
    /**
     * Metodo para cobrar la apuesta
     * @param goleslocales Cantidad de goles marcados por el equipo local
     * @param golesvisitantes Cantidad de goles marcados por el equipo visitante
     * @throws Exception Aparece si se intenta cobrar una apuesta erronea
     */
    void cobrarapuesta(int goleslocales, int golesvisitantes) throws Exception {

        if (!comprobarResultado(goleslocales, golesvisitantes)) {
            throw new Exception("No se puede cobrar una apuesta no acertada");
        }
        dinerodisp = dinerodisp * 10;

    }
}
