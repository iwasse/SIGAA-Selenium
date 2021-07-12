package Utility;

public class Login {
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	private String usuario;

	private String senha;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return usuario + " " + senha;
	}

}
