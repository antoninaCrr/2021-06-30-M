package it.polito.tdp.genes.model;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import it.polito.tdp.genes.db.GenesDao;



public class Model {
	
	private GenesDao dao;
	private Graph<Integer, DefaultWeightedEdge> grafo;
	
	public Model() {
		dao = new GenesDao();
	}
	
	public void creaGrafo() {
		grafo = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
	
		// aggiunta vertici
		Graphs.addAllVertices(this.grafo, dao.getAllChromosomes());
		
		// aggiunta archi
		
		for(Collegamento ci : dao.getAllConnections()) {
		Graphs.addEdge(this.grafo, ci.getCromo1(), ci.getCromo2(),ci.getPeso());
		}
	
	}
	
	public boolean grafoCreato() {
		if(this.grafo == null)
			return false;
		else 
			return true;
	}
	
	public int nVertici() {
		return this.grafo.vertexSet().size();
	}
	
	public int nArchi() {
		return this.grafo.edgeSet().size();
	}
	
	public double pesoMin() {
		double min = Integer.MAX_VALUE;
		for(DefaultWeightedEdge ei : this.grafo.edgeSet()) {
			if(this.grafo.getEdgeWeight(ei) < min) {
				min = this.grafo.getEdgeWeight(ei);
			}
		}
		
		return min;
	}
	
	public double pesoMax() {
		double max = Integer.MIN_VALUE;
		for(DefaultWeightedEdge ei : this.grafo.edgeSet()) {
			if(this.grafo.getEdgeWeight(ei) > max) {
				max = this.grafo.getEdgeWeight(ei);
			}
		}
			
		return max;
		
	}
	
	public boolean verificaSoglia (double s) {
		if(s >= this.pesoMin() && s <= this.pesoMax()) 
			return true;
		else
			return false;
	}
	
	public String contaArchi(double s) {
		int sottoSoglia = 0;
		int sopraSoglia = 0;
		
		for(DefaultWeightedEdge ei : this.grafo.edgeSet()) {
			if(this.grafo.getEdgeWeight(ei) > s ) {
				sopraSoglia++;
				
			}else {
				sottoSoglia++;
			}
		}
		
		return sottoSoglia+";"+sopraSoglia;
	}

}