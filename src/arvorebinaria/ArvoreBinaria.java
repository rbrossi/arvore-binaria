package arvorebinaria;

public class ArvoreBinaria<T> extends ArvoreBinariaAbstract<T>{
	public void setRaiz(NoArvoreBinaria<T> raiz) {
		super.setRaiz(raiz);
	}
	
	public ArvoreBinaria(NoArvoreBinaria<T> raiz) {
		setRaiz(raiz);
	}
}
