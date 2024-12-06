package br.com.ifpe.oxefood.util.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class EntregadorException {

    public static final String MSG_VALOR_MINIMO_FRETE = "Não é permitido frete menores que R$ 5 reais.";

    public EntregadorException(String msg) {

	super(String.format(msg));

    }
}
