package com.videoclub.model;

import java.util.ArrayList;

public class GestorAlquiler
{
	private ArrayList<Alquiler> arrayListMultimediaAlquilada;

	public GestorAlquiler()
	{
		arrayListMultimediaAlquilada = new ArrayList<>();
	}

	public void addAlquiler(Alquiler al)
	{
		arrayListMultimediaAlquilada.add(al);
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

	public boolean tieneDeudaPendiente2(String nif)
	{
		boolean nani = false;
		for (Alquiler alquiler : arrayListMultimediaAlquilada)
		{
			if (alquiler.getMySocio().getNif().equals(nif))
			{
				nani = true;
			}
		}
		return nani;
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

	public ArrayList<Alquiler> getArrayListMultimediaAlquilada()
	{
		return arrayListMultimediaAlquilada;
	}

	public void setArrayListMultimediaAlquilada(ArrayList<Alquiler> arrayListMultimediaAlquilada)
	{
		this.arrayListMultimediaAlquilada = arrayListMultimediaAlquilada;
	}
}
