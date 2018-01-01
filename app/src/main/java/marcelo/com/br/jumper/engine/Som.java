package marcelo.com.br.jumper.engine;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import marcelo.com.br.jumper.R;

/**
 * Created by Marcelo on 01/01/2018.
 */

public class Som {

    public static int COLISAO;
    public static int PONTUACAO;
    public static int PULO;
    private SoundPool soundPool;

    public Som(Context context){
        soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        PULO = soundPool.load(context, R.raw.pulo, 1);
        PONTUACAO = soundPool.load(context, R.raw.pontos, 0);
        COLISAO = soundPool.load(context, R.raw.colisao, 0);
    }

    public void play(int som) {
        soundPool.play(som, 1, 1, 1, 0, 1);
    }
}
