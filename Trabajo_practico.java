public class TRABAJO_OBLIGATORIO {
    public static void main(String[] args) {
        GrafoDinamic grafo = new GrafoDinamic();
        grafo.inicializarGrafo(4);
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);
        grafo.agregarVertice(6);
        grafo.agregarVertice(7);
        grafo.agregarArista(1, 2, 0);
        grafo.agregarArista(1, 3, 0);
        grafo.agregarArista(1, 4, 0);
        grafo.agregarArista(2,3,0);
        grafo.agregarArista(4, 5, 0);
        grafo.agregarArista(4, 6, 0);
        grafo.agregarArista(6, 5, 0);
        grafo.agregarArista(6, 7, 0);
        int origen=1;
        BFS(grafo,origen);
        int[]vertices=grafo.vertices();
        for (int i=0;i<vertices.length;i++) {
            NodoGrafo nodo=grafo.encontrarNodo(vertices[i]);
            System.out.println("La distancia entre "+origen+" y "+ nodo.valor+" es: "+nodo.distancia);
        }
        System.out.println("-----------Arbol resultante por BFS-----------");
        grafo.mostrarMatriz();
        DFS(grafo, 1);
        
        System.out.println("-----------Arbol resultante por DFS-----------");
        grafo.mostrarMatriz();
    }
    public static void BFS(GrafoDinamic grafo,int origen) {
        ColaD cola;
        int u;
        cola=new ColaD();
        cola.InicializarCola();
        cola.Acolar(origen);
        NodoGrafo nodo=grafo.encontrarNodo(origen);
        nodo.distancia=0;
        nodo.predecesor=null;
        while  (!cola.ColaVacia()){
            u= cola.Primero();
            cola.Desacolar();
            int[] adyacentes=grafo.adyacentes(u);
            NodoGrafo j=grafo.encontrarNodo(u);
            for(int i:adyacentes) {
                nodo=grafo.encontrarNodo(i);
                if(!nodo.marcado) {
                    nodo.marcado=true;
                    nodo.predecesor=j;
                    nodo.distancia=j.distancia+1;
                    cola.Acolar(nodo.valor);
                    }
                }
            grafo.encontrarNodo(u).Visitado=true;

        }
    }
	public static void DFS( GrafoDinamic g, int v) {
		NodoGrafo origen =  g.encontrarNodo(v);
		origen.marcado = true;
		int[] ady = g.adyacentes(v);
		for(int i=0; i< ady.length; i++) {
			NodoGrafo aux = g.encontrarNodo(ady[i]);
			if(!aux.marcado) {	
				aux.marcado = true; 
				DFS(g,aux.valor);
			}
		}
	}


}
