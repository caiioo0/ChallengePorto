package dominio.porto;

public class Carga {

	private	double peso;
	private double volume;
	private double dimensao;
	private String tipo;
	private String fragilidade;
	private int quantidadeEixos;
	

	Carga(double peso, double volume, double dimensao, String tipo, String fragilidade, int quantidadeEixos){
		
		this.peso = peso;
		this.volume = volume;
		this.dimensao = dimensao;
		this.tipo = tipo;
		this.fragilidade = fragilidade;
		this.quantidadeEixos = quantidadeEixos;
		
	}
	
	public void exibirCargaDoServico() {
		System.out.println(peso + ", " + volume + ", " + dimensao + " " + tipo  + ", " + fragilidade + ", " + quantidadeEixos);  
	}

}
