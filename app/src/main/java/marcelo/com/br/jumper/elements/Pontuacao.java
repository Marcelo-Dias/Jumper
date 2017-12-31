package marcelo.com.br.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import marcelo.com.br.jumper.graphic.Cores;

/**
 * Created by Marcelo on 31/12/2017.
 */

public class Pontuacao {

    private static final Paint BRANCO = Cores.getCorDaPontuacao();
    private int pontos = 0;

    public void aumenta() {
        pontos++;
    }
    public void desenhaNo(Canvas canvas) {
        canvas.drawText(String.valueOf(pontos), 100 / 2, 100 / 2, BRANCO);
    }
}
