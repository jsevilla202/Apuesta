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
     * Contructor por defecto
     */
    public Apuesta() {
    }

    /*Contructor con par�metros*/
    /**
     * Recoge los valores de la apuesta realizada
     * @param dinerodisp
     * @param goleslocal
     * @param golesvisitante
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
    public int getDinero_disp() {
        return dinerodisp;
    }
    
    /*M�todo para modificar el valor del atributo dinero_disp*/
    /**
     * Metodo para modificar el valor del atributo dinero_disp
     * @param dinerodisp Dinero disponible para apostar
     */
    public void setDinero_disp(int dinerodisp) {
        this.dinerodisp = dinerodisp;
    }

    /* M�todo para apostar.
     * Permite elegir la cantidad a apostar, no puede ser inferior a 1 ni superior a tu saldo disponible
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
     * En caso de que lo haya acertado devuelve true. Chequea que no se metan menos de 0 goles
     */
    /**
     * Metodo que comprueba si se ha acertado el resultado del partido
     * @param local Equipo local
     * @param visitante Equipo visitante
     * @return Devuelve si la apuesta ha sido acertada o no
     * @throws Exception Aparecerá cuando se inserte un número negativo en la apuesta de los goles
     */
    public boolean comprobar_resultado(int local, int visitante) throws Exception {
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
     * Comprueba que se acert� el resultado y, en ese caso, a�ade el valor apostado multiplicado por 10
     * al saldo disponible
     */
    /**
     * Metodo para cobrar la apuesta
     * @param cantidadgoleslocal Cantidad de goles marcados por el equipo local
     * @param cantidadgolesvisit Cantidad de goles marcados por el equipo visitante
     * @throws Exception Aparecera si se intenta cobrar una apuesta que no ha sido acertada
     */
    void cobrarapuesta(int cantidadgoleslocal, int cantidadgolesvisit) throws Exception {

        if (!comprobar_resultado(cantidadgoleslocal, cantidadgolesvisit)) {
            throw new Exception("No se puede cobrar una apuesta no acertada");
        }
        dinerodisp = dinerodisp * 10;

    }
}
