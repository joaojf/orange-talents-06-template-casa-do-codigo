package br.com.zupacademy.joao.casadocodigo.config.handler;

public class ErroIdNaoEncontrado {

	private Integer status;
    private String mensagem;

    public ErroIdNaoEncontrado(Integer status, String mensagem) {
        this.status = status;
        this.mensagem = mensagem;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMensagem() {
        return mensagem;
    }

}
