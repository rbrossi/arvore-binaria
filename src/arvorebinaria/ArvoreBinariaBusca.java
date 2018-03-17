package arvorebinaria;

import java.util.Comparator;

import javax.xml.bind.helpers.ParseConversionEventImpl;

public class ArvoreBinariaBusca<T extends Comparable<T>> extends ArvoreBinariaAbstract<T>{
	
	
	public void inserir(T info){
		NoArvoreBinaria<T> novo = new NoArvoreBinaria<>(info);
		NoArvoreBinaria<T> p;
		NoArvoreBinaria<T> pai;
		
		if	(getRaiz() == null){
			setRaiz(novo);
		}else{
			p = getRaiz();
			while (true) {
				pai = p;
				if	(info.compareTo(p.getInfo()) < 0){
					p = pai.getEsquerda();
					if	(p == null){
						pai.setEsquerda(novo);
						break;
					}
				}else{
					p = pai.getDireita();
					if	(p == null){
						pai.setDireita(novo);
						break;
					}
				}
			}
		}
		
	}
	
	public NoArvoreBinaria<T> buscar(T info){
		NoArvoreBinaria<T> p;
		p = getRaiz();
		
		while (p != null && !p.getInfo().equals(info)){
			if	(info.compareTo(p.getInfo()) < 0){
				p = p.getEsquerda();
			}else{
				p = p.getDireita();
			}
		}
		
		return p;
	}
	
	public void retirar(T info){
		NoArvoreBinaria p = getRaiz();
		NoArvoreBinaria pai = null;
		boolean filhoEsquerda = false;
		boolean filhoDireita;
		
		while (p!=null && p.getInfo()!=info){
			pai = p;
			if	(info.compareTo((T) p.getInfo()) < 0){
				filhoEsquerda = true;
				p = p.getEsquerda();
			} else {
				filhoEsquerda = false;
				p = p.getDireita();
			}
		}
		
		if (p != null){
			if (p.getEsquerda()==null && p.getDireita()==null){
				if (p==getRaiz())
					setRaiz(null);
				else
					if (filhoEsquerda == true)
						pai.setEsquerda(null);
					else
						pai.setDireita(null);				
			} else {
				if (p.getDireita() == null){
					if (p == getRaiz())
						setRaiz(p.getEsquerda());
					else
						if (filhoEsquerda == true)
							pai.setEsquerda(p.getEsquerda());
						else
							pai.setDireita(p.getEsquerda());
				} else {
					if (p.getEsquerda() == null){
						if (p == getRaiz())
							setRaiz(p.getDireita());
						else 
							if (filhoEsquerda == true)
								pai.setEsquerda(p.getDireita());
							else
								pai.setDireita(p.getDireita());
					}			
					
				}
				
			}
		} else {
			NoArvoreBinaria sucessor = extrairSucessor(p);
			
			if (p == getRaiz())
				setRaiz(sucessor);
			else {
				if (filhoEsquerda==true)
					pai.setEsquerda(sucessor);
				else
					pai.setDireita(sucessor);				
			}
			sucessor.setEsquerda(p.getEsquerda());
		}
		

	}
	
	private NoArvoreBinaria extrairSucessor(NoArvoreBinaria excluir){
		NoArvoreBinaria p = excluir.getDireita();
		NoArvoreBinaria paiSucessor = excluir;
		NoArvoreBinaria sucessor = excluir;
		
		while (p!= null){
			paiSucessor = sucessor;
			sucessor = p;
			p = p.getEsquerda();
		}
		
		if (sucessor != excluir.getDireita()){
			paiSucessor.setEsquerda(sucessor.getDireita());
			sucessor.setDireita(excluir.getDireita());
		}
		return sucessor;
	}
	
}
