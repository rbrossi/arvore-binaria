package arvorebinaria;


public class main {
	public static void main(String[] args){
		
		NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<>(0);
		NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<>(5);
		NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<>(2, no4, no5);
		NoArvoreBinaria<Integer> no7 = new NoArvoreBinaria<>(7);
//		NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<>(6, no7, null);
//		NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<>(3, null, no6);
//		NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<>(1, no2, no3);
//		ArvoreBinariaAbstract<Integer> arvore = new ArvoreBinaria<>();
//		arvore.setRaiz(no4);
//		arvore.setRaiz(no5);
		
		ArvoreBinariaBusca<Integer> ab = new ArvoreBinariaBusca<Integer>();
		ab.inserir(4);
		ab.inserir(1);
		ab.inserir(2);
		ab.inserir(3);
		
		ab.inserir(5);
		
		System.out.println(ab.toString());
		System.out.println(ab.contarFolhas());
		System.out.println(ab.calcularNosInternos());
		
	}
}
