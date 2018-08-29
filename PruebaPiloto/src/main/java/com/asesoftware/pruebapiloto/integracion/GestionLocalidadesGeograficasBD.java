package com.asesoftware.pruebapiloto.integracion;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.asesoftware.pruebapiloto.entidades.LocalidadesGeografica;

@Stateless
@LocalBean
public class GestionLocalidadesGeograficasBD {
	
	@PersistenceContext
	private EntityManager em;
	
	public GestionLocalidadesGeograficasBD() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * M�TODO QUE DEVUELVE LA LISTA DE TODAS CIUDADES DE LA BASE DE DATOS
	 * @return LISTA DE CIUDADES
	 */
	
	public LocalidadesGeografica consultarLocalidadPorId(String codigo) {
		return em.find(LocalidadesGeografica.class, codigo);
	}
	
	@SuppressWarnings("unchecked")
	public List<LocalidadesGeografica> consultarTodasCiudades(){
		Query queryTodasCiudades = em.createQuery("select c from LocalidadesGeografica c where c.tipoLoc = 'C' order by c.nombre desc");
		return queryTodasCiudades.getResultList();
	}
	
	

}
