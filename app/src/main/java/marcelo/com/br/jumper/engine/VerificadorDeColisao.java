package marcelo.com.br.jumper.engine;

import marcelo.com.br.jumper.elements.Canos;
import marcelo.com.br.jumper.elements.Passaro;

/**
 * Created by Marcelo on 31/12/2017.
 */

class VerificadorDeColisao {

    private final Passaro passaro;
    private final Canos canos;

    public VerificadorDeColisao(Passaro passaro, Canos canos) {
        this.passaro = passaro;
        this.canos = canos;
    }

    public boolean temColisao() {
        return canos.temColisaoCom(passaro);
    }
}
