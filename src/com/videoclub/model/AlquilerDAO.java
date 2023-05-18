package com.videoclub.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AlquilerDAO
{
	private ArrayList<Alquiler> listAlquiler;

	public AlquilerDAO()
	{
		listAlquiler = new ArrayList<>();
	}

	@Override
	public String toString()
	{
		StringBuilder txt = new StringBuilder();

		for (Alquiler alquiler : listAlquiler)
		{
			txt.append(alquiler.toString()).append("\n");
		}

		return txt.toString();
	}

	public Alquiler encontrarAlquiler(int id)
	{
		Alquiler alquiler = null;
		boolean b = false;

		for (int i = 0; i < listAlquiler.size() && !b; i++)
		{
			if (id == listAlquiler.get(i).getContador())
			{
				alquiler = listAlquiler.get(i);
				b = true;
			}
		}

		if (alquiler == null)
		{
			throw new RuntimeException("Rent Object with ID: " + id + " not found");
		}

		return alquiler;
	}

	public ArrayList<Alquiler> encontrarAlquiler(String memberNIF)
	{
		ArrayList<Alquiler> listAlquiler = new ArrayList<>();

		for (Alquiler alquiler : this.listAlquiler)
		{
			if (alquiler.getNif().equals(memberNIF))
			{
				listAlquiler.add(alquiler);
			}
		}

		return listAlquiler;
	}

	public void aniadir(Alquiler al)
	{
		listAlquiler.add(al);
	}

	public void eliminarAlquiler(int id)
	{
		Alquiler alquiler = encontrarAlquiler(id);

		if (!listAlquiler.remove(alquiler))
		{
			throw new RuntimeException("Rent with ID: " + id + " not found");
		}
	}

	public boolean pagosPendientes(String memberNIF)
	{
		boolean pendingPayments = false;

		ArrayList<Alquiler> listAlquiler = encontrarAlquiler(memberNIF);

		for (Alquiler alquiler : listAlquiler)
		{
			pendingPayments = alquiler.esAtrasado();
		}

		return pendingPayments;
	}

	public ArrayList<String> listarAlquileresSocio(String nif)
	{
		ArrayList<String> listAlquileresSocio = new ArrayList<>();

		for (Alquiler alquiler : listAlquiler)
		{
			if (alquiler.getNif().equals(nif))
			{
				listAlquileresSocio.add(alquiler.toString());
			}
		}
		return listAlquileresSocio;
	}

	public ArrayList<String> listarTitulosAlquilerSocio(String nif)
	{
		ArrayList<String> listAlquileresSocio = new ArrayList<>();

		for (Alquiler alquiler : listAlquiler)
		{
			if (alquiler.getNif().equals(nif))
			{
				listAlquileresSocio.add(alquiler.listaAlquileres());
			}
		}
		return listAlquileresSocio;
	}

	public ArrayList<String> listarSocioRecargo()
	{
		ArrayList<String> listSocioRecargo = new ArrayList<>();

		for (Alquiler alquiler : listAlquiler)
		{
			if (alquiler.esAtrasado())
			{
				listSocioRecargo.add(alquiler.getNif());
			}
		}
		return listSocioRecargo;
	}

	// Hash map version
	public HashMap<Integer, Multimedia> test()
	{
		HashMap<Integer, Multimedia> hashMap = new HashMap<>();

		for (Alquiler alquiler : listAlquiler)
		{
			hashMap.put(alquiler.getContador(), alquiler.getMultimedia());
		}

		return hashMap;
	}

	// using 2d
	public String[][] obtenerAlquileres(String nif) {
		List<Alquiler> alquileres = encontrarAlquiler(nif);
		int tamanio = alquileres.size();

		String[][] matriz = new String[tamanio][4];

		for (int i = 0; i < tamanio; i++)
		{
			for (Alquiler alquiler : listAlquiler)
			{
				matriz[i][0] = String.valueOf(alquiler.getContador());
				matriz[i][1] = alquiler.getNif();
				matriz[i][2] = alquiler.getMultimedia().getTitulo();
				matriz[i][3] = alquiler.getMultimedia().getAutor();
			}

		}

		return matriz;
	}
}