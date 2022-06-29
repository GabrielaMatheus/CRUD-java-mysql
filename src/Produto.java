
public class Produto {
	
	private int id;
	private String desc;
	private double valor;
	private int qtd;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Produto("
				+ " id: "+ getId()
				+ " Descrição: "+getDesc()
				+ " Valor: "+getValor()
				+ " Qtd: "+getQtd()
				+ ")";
	}
	
	

}
