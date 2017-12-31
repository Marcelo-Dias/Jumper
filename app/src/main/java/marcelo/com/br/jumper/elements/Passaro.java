package marcelo.com.br.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import marcelo.com.br.jumper.graphic.Cores;
import marcelo.com.br.jumper.graphic.Tela;

/**
 * Created by Marcelo on 30/12/2017.
 */

public class Passaro {

    private static final Paint vermelho = Cores.getCorDoPassaro();
    public static final int X = 100 / 2;
    public static final int RAIO = 50 / 2;
    private int altura;
    private Tela tela;

    public Passaro(Tela tela) {
        this.tela = tela;
        this.altura = 100;
    }

    public void desenhaNo(Canvas canvas){
        canvas.drawCircle(X, altura, RAIO, vermelho);
    }

    public void cai() {
        boolean chegouNoChao = altura + RAIO > tela.getAltura();

        if(!chegouNoChao) {
            altura += 2;
        }
    }

    public void pula() {
        if(altura > RAIO) {
            altura -= 75;
        }
    }

    public int getAltura() {
        return this.altura;
    }
}
