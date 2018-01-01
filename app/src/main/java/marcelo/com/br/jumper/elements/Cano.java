package marcelo.com.br.jumper.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import marcelo.com.br.jumper.R;
import marcelo.com.br.jumper.graphic.Cores;
import marcelo.com.br.jumper.graphic.Tela;

/**
 * Created by Marcelo on 31/12/2017.
 */

public class Cano {

    private Bitmap canoSuperior;
    private Bitmap canoInferior;
    private Tela tela;
    private static final int TAMANHO_DO_CANO = 250 / 2;
    private static final int LARGURA_DO_CANO = 100 / 2;
    private int alturaDoCanoInferior;
    private int alturaDoCanoSuperior;
    private int posicao;
    private final Paint verde = Cores.getCorDoCano();

    public Cano(Tela tela, int posicao, Context context){
        this.tela = tela;
        this.posicao = posicao;
        this.alturaDoCanoInferior = tela.getAltura() - TAMANHO_DO_CANO - valorAleatorio();
        this.alturaDoCanoSuperior = 0 + TAMANHO_DO_CANO + valorAleatorio();
        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.cano);
        this.canoInferior = Bitmap.createScaledBitmap(bp, LARGURA_DO_CANO, this.alturaDoCanoInferior, false);
        this.canoSuperior = Bitmap.createScaledBitmap(bp, LARGURA_DO_CANO, this.alturaDoCanoSuperior, false);
    }

    public void desenhaNo(Canvas canvas){
        desenhaCanoSuperiorNo(canvas);
        desenhaCanoInferiorNo(canvas);
    }

    public void desenhaCanoSuperiorNo(Canvas canvas) {
        //canvas.drawRect(posicao, 0, posicao + LARGURA_DO_CANO, alturaDoCanoSuperior, verde);
        canvas.drawBitmap(canoSuperior, posicao, 0, null);
    }

    public void desenhaCanoInferiorNo(Canvas canvas) {
        //canvas.drawRect(posicao, alturaDoCanoInferior, posicao + LARGURA_DO_CANO, tela.getAltura(), verde);
        canvas.drawBitmap(canoInferior, posicao, alturaDoCanoInferior, null);
    }

    public void move() {
        this.posicao -= 2;
    }

    private int valorAleatorio() {
        return (int) (Math.random() * 150);
    }

    public boolean saiuDaTela() {
        return posicao + LARGURA_DO_CANO < 0;
    }

    public int getPosicao() {
        return posicao;
    }

    public boolean temColisaoHorizontalCom(Passaro passaro) {
        return this.posicao - passaro.X < passaro.RAIO;
    }

    public boolean temColisaoVerticalCom(Passaro passaro) {
        return passaro.getAltura() - passaro.RAIO < this.alturaDoCanoSuperior || passaro.getAltura() + passaro.RAIO > this.alturaDoCanoInferior;
    }
}
