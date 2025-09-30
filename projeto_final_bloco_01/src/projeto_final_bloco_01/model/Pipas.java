package projeto_final_bloco_01.model;

public class Pipas extends Produto {

	private String modelo;
	
	public Pipas(int id, String nome, int categoria, float preco, String modelo) {
		super(id, nome, categoria, preco);
		this.modelo = modelo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void visualizar() {
		super.visualizar();
		System.out.printf("Nome do modelo: %s\n", this.modelo);
	}
	
	
}

