package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Bebida;
import service.BebidaService;

@ManagedBean
public class CadastrarBebidaBean {

	private Bebida bebida = new Bebida();
	private FacesMessage mensagem = null;
	private FacesContext context = null;

	// public void prepararCadastro() {
	// this.bebida = new Bebida();
	// if (mensagem != null) {
	// context = FacesContext.getCurrentInstance();
	// context.addMessage("messages", mensagem);
	// }
	// }
	@SuppressWarnings("static-access")
	public void salvar() {
		BebidaService.salvarBebida(this.bebida);
	}

	public Bebida getBebida() {
		return bebida;
	}
}
