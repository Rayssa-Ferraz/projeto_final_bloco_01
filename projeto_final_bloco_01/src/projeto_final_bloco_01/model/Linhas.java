package projeto_final_bloco_01.model;

public class Linhas extends Produto{

	private int jardas;

	public Linhas(int id, String nome, int categoria, float preco, int jardas) {
		super(id, nome, categoria, preco);
		this.jardas = jardas;
	}

	public int getJardas() {
		return jardas;
	}

	public void setJardas(int jardas) {
		this.jardas = jardas;
	}
	
	public void visualizar() {
		super.visualizar();
		System.out.printf("Jardas: %s\n", this.jardas);
}
}


