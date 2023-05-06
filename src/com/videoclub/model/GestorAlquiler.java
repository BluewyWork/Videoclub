package com.videoclub.model;

import java.util.ArrayList;

public class GestorAlquiler
{

	private ArrayList<Alquiler> arrayListMultimediaAlquilada;

	public GestorAlquiler()
	{
		arrayListMultimediaAlquilada = new ArrayList<>();
	}

	public void addAlquiler(Socio socio, boolean deuda)
	{
		arrayListMultimediaAlquilada.add(new Alquiler(socio));
	}

	@Override
	public String toString()
	{
		String text = "";

		for (int i = 0; i < arrayListMultimediaAlquilada.size(); i++)
		{
			text += arrayListMultimediaAlquilada.get(i).toString();
		}

		return text;
	}

	public boolean tieneDeudaPendiente(Socio socio)
	{
		for (Alquiler alquiler : socio.getAlquileres())
		{
			if (alquiler.isDeuda())
			{
				return true; // si encuentra un alquiler con deuda pendiente, devuelve true
			}
		}
		return false; // si no encuentra ningún alquiler con deuda pendiente, devuelve false
	}


    /*public boolean tieneDeuda(String nif) {
        for (Alquiler alquiler : arrayListMultimediaAlquilada) {
            if (alquiler.getMySocio().getNif().equals(nif))
                if (alquiler.isDeuda()) {
                    return true;
                }
        }
        return false;
    }*/


}
