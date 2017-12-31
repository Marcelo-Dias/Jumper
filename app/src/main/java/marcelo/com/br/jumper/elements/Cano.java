package marcelo.com.br.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import marcelo.com.br.jumper.graphic.Cores;
import marcelo.com.br.jumper.graphic.Tela;

/**
 * Created by Marcelo on 31/12/2017.
 */

public class Cano {

    private Tela tela;
    private static final int TAMANHO_DO_CANO = 250 / 2;
    private static final int LARGURA_DO_CANO = 100 / 2;
    private int alturaDoCanoInferior;
    private int alturaDoCanoSuperior;
    private int posicao;
    private final Paint verde = Cores.getCorDoCano();

    public Cano(Tela tela, int posicao){
        this.tela = tela;
        this.posicao = posicao;
        this.alturaDoCanoInferior = tela.getAltura() - TAMANHO_DO_CANO - valorAleatorio();
        this.alturaDoCanoSuperior = 0 + TAMANHO_DO_CANO + valorAleatorio();
    }

    public void desenhaNo(Canvas canvas){
        desenhaCanoSuperiorNo(canvas);
        desenhaCanoInferiorNo(canvas);
    }

    public void desenhaCanoSuperiorNo(Canvas canvas) {
        canvas.drawRect(posicao, 0, posicao + LARGURA_DO_CANO, alturaDoCanoSuperior, verde);
    }

    public void desenhaCanoInferiorNo(Canvas canvas) {
        canvas.drawRect(posicao, alturaDoCanoInferior, posicao + LARGURA_DO_CANO, tela.getAltura(), verde);
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
}
