package projeto_final_bloco_01.model;

public class Linhas extends Produto{

	private String jardas;

	public Linhas(int id, String nome, int categoria, float preco, String jardas) {
		super(id, nome, categoria, preco);
		this.jardas = jardas;
	}

	public String getFragrancia() {
		return jardas;
	}

	public void setFragrancia(String jardas) {
		this.jardas = jardas;
	}
	
	public void visualizar() {
		super.visualizar();
		System.out.printf("Jardas: %s\n", this.jardas);
}
}


