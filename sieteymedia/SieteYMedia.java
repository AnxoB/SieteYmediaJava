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
        Carta c = baraja.darCartas(1)[0];
        insertarCartaEnArray(cartasJugador, c);
    }

    public boolean jugadorSePaso() {
        return valorCartas(cartasJugador) > 7.5;
    }

    void turnoBanca() {
        double valorCartasJugador = valorCartas(cartasJugador);
        if (valorCartasJugador > 7.5) {
            return;
        }

        while (valorCartas(cartasBanca) < valorCartasJugador) {
            Carta c = baraja.darCartas(1)[0];
            insertarCartaEnArray(cartasBanca, c);
        }
    }


    public boolean bancaSePaso() {
        return valorCartas(cartasBanca) > 7.5;
    }



    double valorCartas(ArrayList<Carta> cartas) {
        double total = 0.0;
        for (Carta carta : cartas) {
            int val = carta.getNumero();
            total += (val > 7) ? 0.5 : val;
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
