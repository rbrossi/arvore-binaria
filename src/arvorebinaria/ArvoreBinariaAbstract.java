package arvorebinaria;

public abstract class ArvoreBinariaAbstract<T> {

	private StringBuilder huffmanCode;

	private NoArvoreBinaria<T> raiz;

	public ArvoreBinariaAbstract() {
	}

	public NoArvoreBinaria<T> getRaiz() {
		return raiz;
	}

	protected void setRaiz(NoArvoreBinaria<T> raiz) {
		this.raiz = raiz;
	}

	public boolean estaVazia() {
		if (raiz == null)
			return true;
		return false;
	}

	public boolean pertence(T info) {
		return pertence(raiz, info);
	}

	private boolean pertence(NoArvoreBinaria<T> no, T info) {
		if (no == null)
			return false;
		else
			return (no.getInfo() == info) || pertence(no.getEsquerda(), info) || pertence(no.getDireita(), info);
	}

	private String arvorePre(NoArvoreBinaria<T> no) {

		String saida = "<";
		if (no != null) {
			saida += no.getInfo().toString();
			saida += arvorePre(no.getEsquerda());
			saida += arvorePre(no.getDireita());
		}
		saida += ">";
		return saida;
	}

	@SuppressWarnings("unchecked")
	public String getHuffmanCode(Character character) {
		huffmanCode = new StringBuilder();
		return GetHuffmanCode(((NoArvoreBinaria<HuffmanNodeInfo>) raiz), character, 0);
	}

	private String GetHuffmanCode(NoArvoreBinaria<HuffmanNodeInfo> no, Character character, int direcao) {
		if (direcao == -1) {
			huffmanCode.append("0");
		} else if (direcao == 1) {
			huffmanCode.append("1");
		}

		if (no == null)
			return "";
		else {
			if (no.getInfo().getCharacter() == character) {
				return huffmanCode.toString();
			} else {
				String result = GetHuffmanCode(no.getEsquerda(), character, -1);
				if (result.equals("")) {
					return GetHuffmanCode(no.getDireita(), character, 1);
				}
				return result;
			}
		}

	}

	public void printPaths() {
		int path[] = new int[1000];
		printPathsRecur((NoArvoreBinaria<HuffmanNodeInfo>) raiz, path, 0, 0);
	}
	
	void printPathsRecur(NoArvoreBinaria<HuffmanNodeInfo> node, int path[], int pathLen, int direction) {
		if (node == null)
			return;

		/* append this node to the path array */
		if (direction == -1) {
			path[pathLen] = 0;
			pathLen++;
		} else if (direction == 1) {
			path[pathLen] = 1;
			pathLen++;
		}
		

		/* it's a leaf, so print the path that led to here */
		if (node.getEsquerda() == null && node.getDireita() == null)
			printArray(path, pathLen);
		else {
			/* otherwise try both subtrees */
			printPathsRecur(node.getEsquerda(), path, pathLen, -1);
			printPathsRecur(node.getDireita(), path, pathLen, 1);
		}
	}
	
	  void printArray(int ints[], int len) 
	    {
	        int i;
	        for (i = 0; i < len; i++) 
	        {
	            System.out.print(ints[i] + " ");
	        }
	        System.out.println("");
	    }

	public String toString() {
		return arvorePre(this.raiz);
	}

	public int contarFolhas() {
		return contarFolhas(raiz);
	}

	private int contarFolhas(NoArvoreBinaria<T> no) {
		if (no == null)
			return 0;
		if (no.getEsquerda() == null && no.getDireita() == null)
			return 1;
		else {
			return contarFolhas(no.getEsquerda()) + contarFolhas(no.getDireita());
		}
	}

	public int calcularNosInternos() {
		return calcularNosInternos(raiz);
	}

	private int calcularNosInternos(NoArvoreBinaria<T> no) {
		if (no == null)
			return 0;
		if (no.getEsquerda() != null || no.getDireita() != null) {
			return 1 + calcularNosInternos(no.getEsquerda()) + calcularNosInternos(no.getDireita());
		} else {
			return 0;
		}
	}

	public String arvorePos() {
		return arvorePos(raiz);
	}

	private String arvorePos(NoArvoreBinaria<T> no) {
		if (no == null) {
			return "";
		} else {
			return arvorePos(no.getEsquerda()) + arvorePos(no.getDireita()) + " " + no.getInfo().toString();
		}
	}

}
