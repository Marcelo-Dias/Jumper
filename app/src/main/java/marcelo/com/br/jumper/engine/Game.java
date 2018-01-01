package marcelo.com.br.jumper.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import marcelo.com.br.jumper.R;
import marcelo.com.br.jumper.elements.Cano;
import marcelo.com.br.jumper.elements.Canos;
import marcelo.com.br.jumper.elements.GameOver;
import marcelo.com.br.jumper.elements.Passaro;
import marcelo.com.br.jumper.elements.Pontuacao;
import marcelo.com.br.jumper.graphic.Tela;

/**
 * Created by Marcelo on 30/12/2017.
 */

public class Game extends SurfaceView implements Runnable, View.OnTouchListener {

    private Context context;
    private boolean isRunning = true;
    private final SurfaceHolder holder = getHolder();
    private Canvas canvas;
    private Passaro passaro;
    private Canos canos;
    private Bitmap background;
    private Tela tela;
    private Pontuacao pontuacao;
    private Som som;

    public Game(Context context) {
        super(context);
        this.context = context;

        tela = new Tela(context);
        this.som = new Som(context);

        inicializaElementos();
        setOnTouchListener(this);
    }

    private void inicializaElementos() {
        this.pontuacao = new Pontuacao(som);
        this.passaro = new Passaro(tela, context, som);
        this.canos = new Canos(tela, pontuacao, context);
        Bitmap back = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        this.background = Bitmap.createScaledBitmap(back, back.getWidth(), tela.getAltura(), false);
    }

    @Override
    public void run() {
        while(isRunning) {
            if(!holder.getSurface().isValid()) continue;

            canvas = holder.lockCanvas();

            canvas.drawBitmap(background, 0, 0, null);
            passaro.desenhaNo(canvas);
            passaro.cai();

            canos.desenhaNo(canvas);
            canos.move();

            pontuacao.desenhaNo(canvas);

            if(new VerificadorDeColisao(passaro, canos).temColisao()) {
                som.play(Som.COLISAO);
                new GameOver(tela).desenhaNo(canvas);
                isRunning = false;
            }

            holder.unlockCanvasAndPost(canvas);
        }
    }

    public void pause(){
        this.isRunning = false;
    }

    public void inicia(){
        this.isRunning = true;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        passaro.pula();
        return false;
    }
}
