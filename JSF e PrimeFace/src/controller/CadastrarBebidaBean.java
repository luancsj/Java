package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Bebida;

@ManagedBean(name = "cadastrarBebida")
@SessionScoped
public class CadastrarBebidaBean {
	
	private Bebida bebida;
	private FacesMessage mensagem = null;
	private FacesContext context = null;
	
	public void prepararCadastro() {
			this.bebida = new Bebida();
			if (mensagem != null) {
				context = FacesContext.getCurrentInstance();
				context.addMessage("messages", mensagem);
			}
	}

	public void salvar() {
		
		
	}

	public Bebida getBebida() {
		return null;
	}

	public void setBebida(Bebida bebida) {
		
	}
}
