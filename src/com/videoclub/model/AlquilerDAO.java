package com.videoclub.model;

import java.util.ArrayList;

/**

 Esta clase representa un DAO (Data Access Object) para gestionar los alquileres.

 Permite realizar operaciones de consulta, inserción y eliminación de alquileres en una lista.
 */
public class AlquilerDAO {

	private final ArrayList<Alquiler> listAlquiler; // Lista de alquileres

	/**

	 Constructor de la clase AlquilerDAO.
	 Inicializa la lista de alquileres.
	 */
	public AlquilerDAO() {
		listAlquiler = new ArrayList<>();
	}
	/**

	 Devuelve una representación en formato de texto de la lista de alquileres.

	 @return La lista de alquileres en formato de texto.
	 */
	@Override
	public String toString() {
		StringBuilder txt = new StringBuilder();

		for (Alquiler alquiler : listAlquiler) {
			txt.append(alquiler.toString()).append("\n");
		}

		return txt.toString();
	}

	/**

	 Devuelve la lista de alquileres.
	 @return La lista de alquileres.
	 */
	public ArrayList<Alquiler> getListAlquiler() {
		return listAlquiler;
	}
	/**

	 Busca y devuelve un alquiler según su identificador.

	 @param id El identificador del alquiler a buscar.

	 @return El alquiler encontrado.

	 @throws RuntimeException Si no se encuentra ningún alquiler con el identificador especificado.
	 */
	public Alquiler encontrarAlquiler(int id) {
		Alquiler alquiler = null;
		boolean b = false;

		for (int i = 0; i < listAlquiler.size() && !b; i++) {
			if (id == listAlquiler.get(i).getContador()) {
				alquiler = listAlquiler.get(i);
				b = true;
			}
		}

		if (alquiler == null) {
			throw new RuntimeException("Rent Object with ID: " + id + " not found");
		}

		return alquiler;
	}

	/**

	 Busca y devuelve una lista de alquileres asociados a un determinado socio.

	 @param memberNIF El NIF del socio.

	 @return La lista de alquileres asociados al socio.
	 */
	public ArrayList<Alquiler> encontrarAlquiler(String memberNIF) {
		ArrayList<Alquiler> listAlquiler = new ArrayList<>();

		for (Alquiler alquiler : this.listAlquiler) {
			if (alquiler.getNif().equals(memberNIF)) {
				listAlquiler.add(alquiler);
			}
		}

		return listAlquiler;
	}

	/**

	 Añade un alquiler a la lista.
	 @param al El alquiler a añadir.
	 */
	public void aniadir(Alquiler al) {
		listAlquiler.add(al);
	}
	/**

	 Elimina un alquiler de la lista según su identificador.

	 @param id El identificador del alquiler a eliminar.

	 @throws RuntimeException Si no se encuentra ningún alquiler con el identificador especificado.
	 */
	public void eliminarAlquiler(int id) {
		Alquiler alquiler = encontrarAlquiler(id);

		if (!listAlquiler.remove(alquiler)) {
			throw new RuntimeException("Rent with ID: " + id + " not found");
		}
	}

	/**

	 Verifica si hay pagos pendientes para un socio según su NIF.

	 @param memberNIF El NIF del socio.

	 @return true si hay pagos pendientes, false de lo contrario.
	 */
	public boolean pagosPendientes(String memberNIF) {
		boolean pendingPayments = false;

		ArrayList<Alquiler> listAlquiler = encontrarAlquiler(memberNIF);

		for (Alquiler alquiler : listAlquiler) {
			pendingPayments = alquiler.esAtrasado();
		}

		return pendingPayments;
	}

	/**

	 Devuelve una lista de alquileres asociados a un socio según su NIF.

	 @param nif El NIF del socio.

	 @return La lista de alquileres asociados al socio.
	 */
	public ArrayList<Alquiler> listarAlquileresSocio(String nif) {
		ArrayList<Alquiler> listAlquileresSocio = new ArrayList<>();

		for (Alquiler alquiler : listAlquiler) {
			if (alquiler.getNif().equals(nif)) {
				listAlquileresSocio.add(alquiler);
			}
		}

		return listAlquileresSocio;
	}

	/**

	 Devuelve una lista de alquileres con retraso.

	 @return La lista de alquileres con retraso.
	 */
	public ArrayList<Alquiler> listarSocioRecargo() {
		ArrayList<Alquiler> listSocioRecargo = new ArrayList<>();

		for (Alquiler alquiler : listAlquiler) {
			if (alquiler.esAtrasado()) {
				listSocioRecargo.add(alquiler);
			}
		}

		return listSocioRecargo;
	}
}