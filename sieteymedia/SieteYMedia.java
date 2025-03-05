package sieteymedia;

import recursos.Baraja;
import recursos.Carta;

import java.util.ArrayList;
import java.util.Scanner;

public class SieteYMedia {

    Baraja baraja;
    ArrayList<Carta> cartasJugador;
    ArrayList<Carta> cartasBanca;
    Scanner sc = new Scanner(System.in);

    SieteYMedia(){
        baraja=new Baraja();
        baraja.barajar();
        cartasJugador = new ArrayList<>();
        cartasBanca = new ArrayList<>();
    }


    void turnoJugador() {
        // obligamos a que como mínimo se tenga 1 carta
        //System.out.println("Como mínimo recibes una carta, luego puedes decidir si seguir o plantarte");
        Carta c = baraja.darCartas(1)[0];
            // insertamos c en las cartas del jugador
        insertarCartaEnArray(cartasJugador, c);
        double valor = valorCartas(cartasJugador);
            // mostramos cartas y su valor, si se pasa se sale del bucle
            //System.out.println("Éstas son tus cartas jugador:");
            //mostrarCartas(cartasJugador);
            //System.out.println("\n\tValor de cartas: " + valor);

    }

    public boolean jugadorSePaso() {
        return valorCartas(cartasJugador) > 7.5;
    }

    void turnoBanca() {
        // lo primero es consultar el valor que alcanzó el jugador en su turno
        double valorCartasJugador = valorCartas(cartasJugador);
        if (valorCartasJugador > 7.5) {
            //System.out.println("Jugador, te has pasado en tu jugada anterior, gana la banca");
            return;
        }
        //System.out.println("\n\nTurno de banca ...");

        // juega hasta empatar o superar
        while (valorCartas(cartasBanca) < valorCartasJugador) {
            Carta c = baraja.darCartas(1)[0];
            insertarCartaEnArray(cartasBanca, c);
        }
        /*System.out.println("Éstas son mis cartas:");
        mostrarCartas(cartasBanca);
        //System.out.println("\nValor de  mis cartas(banca): " + valorCartas(cartasBanca));
        if (valorCartas(cartasBanca) > 7.5) {
            //System.out.println("me pasé, ganas tú,jugador");
        } else {
            //System.out.println("Gana la banca");
        }*/
    }


    public boolean bancaSePaso() {
        return valorCartas(cartasBanca) > 7.5;
    }



    double valorCartas(ArrayList<Carta> cartas) {
        double total = 0.0;
        for (Carta carta : cartas) {  // Usamos un bucle for-each para iterar sobre el ArrayList
            int val = carta.getNumero();
            total += (val > 7) ? 0.5 : val;  // Se suma 0.5 si el número es mayor que 7
        }
        return total;
    }

    void insertarCartaEnArray(ArrayList<Carta> cartas, Carta c) {
        cartas.add(c);
    }

    ArrayList<Carta> mostrarCartas(ArrayList<Carta> cartas) {
        return cartas;
    }

    public ArrayList<Carta> getCartasJugador() {
        return cartasJugador;
    }

    public ArrayList<Carta> getCartasBanca() {
        return cartasBanca;
    }
}
