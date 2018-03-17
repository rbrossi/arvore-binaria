package arvorebinaria;

public abstract class ArvoreBinariaAbstract<T> {
	
private NoArvoreBinaria<T> raiz;
	
	public ArvoreBinariaAbstract(){
	}

	public NoArvoreBinaria<T> getRaiz() {
		return raiz;
	}

	protected void setRaiz(NoArvoreBinaria<T> raiz) {
		this.raiz = raiz;
	}
	
	public boolean estaVazia(){
		if (raiz == null)
			return true;
		return false;
	}
	
	public boolean pertence(T info){
		return pertence(raiz, info);
	}
	
	private boolean pertence(NoArvoreBinaria<T> no, T info){
		if (no == null)
			return false;
		else return (no.getInfo() == info) ||
				pertence(no.getEsquerda(), info) ||
				pertence(no.getDireita(), info);
	}
	
	private String arvorePre(NoArvoreBinaria<T> no){
		
		String saida = "<";
		if (no != null){
			saida += no.getInfo();
			saida += arvorePre(no.getEsquerda());
			saida += arvorePre(no.getDireita());
		}
		saida += ">";
		return saida;
	}
	
	public String toString(){
		return arvorePre(this.raiz);
	}
	
	public int contarFolhas(){
		return contarFolhas(raiz);
	}
	
	private int contarFolhas(NoArvoreBinaria<T> no){
		if (no==null)
			return 0;
		if (no.getEsquerda()==null && no.getDireita()==null)
			return 1;
		else {
			return contarFolhas(no.getEsquerda()) +
				   contarFolhas(no.getDireita());
		}
	}
	
	public int calcularNosInternos() {
		return calcularNosInternos(raiz);
	}
	
	private int calcularNosInternos(NoArvoreBinaria<T> no){
		if (no==null)
			return 0;
		if (no.getEsquerda()!=null || no.getDireita()!=null){
			return 1+calcularNosInternos(no.getEsquerda()) +
				   calcularNosInternos(no.getDireita());
		} else {
			return 0;
		}
	}
	
	public String arvorePos(){
		return arvorePos(raiz);
	}
	
	private String arvorePos(NoArvoreBinaria<T> no){
		if	(no == null){
			return "";
		}else{
			return arvorePos(no.getEsquerda()) 
					+ arvorePos(no.getDireita()) 
					+ " " 
					+ no.getInfo().toString();
		}
	}
	
}
