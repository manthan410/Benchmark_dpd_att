
public class Porsche911 extends CarroPrototipo{
	public Porsche911(Porsche911 objPorsche911) {
		setValorCompra(objPorsche911.getValorCompra());
	}
	public Porsche911() {
}
	public String exibirInfo() {
		return "Fabricante: Porsche\n" +
			   "Modelo: 911" +
			   "Valor: R$ " + getValorCompra() + "\n";
	}
	public CarroPrototipo clonar() {
		return new Porsche911(this);
	}
}
