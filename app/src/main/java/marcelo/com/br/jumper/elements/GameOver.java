package marcelo.com.br.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import marcelo.com.br.jumper.graphic.Cores;
import marcelo.com.br.jumper.graphic.Tela;

/**
 * Created by Marcelo on 31/12/2017.
 */

public class GameOver {

    private final Tela tela;
    private static final Paint vermelho = Cores.getCorDoGameOver();

    public GameOver(Tela tela) {
        this.tela = tela;
    }

    private int centralizaTexto(String texto) {
        Rect limiteDoTexto = new Rect();
        vermelho.getTextBounds(texto, 0, texto.length(), limiteDoTexto);
        int centroHorizontal = tela.getLargura()/2 - (limiteDoTexto.right - limiteDoTexto.left)/2;
        return centroHorizontal;
    }

    public void desenhaNo(Canvas canvas) {
        String gameOver = "Game Over";
        int centroHorizontal = centralizaTexto(gameOver);

        canvas.drawText(gameOver, centroHorizontal, tela.getAltura()/2, vermelho);
    }
}
