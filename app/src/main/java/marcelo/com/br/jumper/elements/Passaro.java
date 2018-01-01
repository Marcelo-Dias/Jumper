package marcelo.com.br.jumper.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import marcelo.com.br.jumper.R;
import marcelo.com.br.jumper.engine.Som;
import marcelo.com.br.jumper.graphic.Cores;
import marcelo.com.br.jumper.graphic.Tela;

/**
 * Created by Marcelo on 30/12/2017.
 */

public class Passaro {

    private static final Paint vermelho = Cores.getCorDoPassaro();
    public static final int X = 100 / 2;
    public static final int RAIO = 50 / 2;
    private final Bitmap passaro;
    private int altura;
    private Tela tela;
    private Som som;

    public Passaro(Tela tela, Context context, Som som) {
        this.tela = tela;
        this.altura = 100;
        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.passaro);
        this.passaro = Bitmap.createScaledBitmap(bp, RAIO*2, RAIO*2 , false);
        this.som = som;
    }

    public void desenhaNo(Canvas canvas){
        //canvas.drawCircle(X, altura, RAIO, vermelho);
        canvas.drawBitmap(passaro, X-RAIO, altura-RAIO, null);
    }

    public void cai() {
        boolean chegouNoChao = altura + RAIO > tela.getAltura();

        if(!chegouNoChao) {
            altura += 2;
        }
    }

    public void pula() {
        if(altura > RAIO) {
            som.play(Som.PULO);
            altura -= 75;
        }
    }

    public int getAltura() {
        return this.altura;
    }
}
