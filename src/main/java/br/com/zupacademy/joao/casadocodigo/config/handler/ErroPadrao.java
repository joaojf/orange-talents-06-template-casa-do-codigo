package br.com.zupacademy.joao.casadocodigo.config.handler;

public class ErroPadrao {

	private String campo;
	private String descricao;

	public ErroPadrao(String campo, String descricao) {
		this.campo = campo;
		this.descricao = descricao;
	}

	public String getCampo() {
		return campo;
	}

	public String getDescricao() {
		return descricao;
	}

}
