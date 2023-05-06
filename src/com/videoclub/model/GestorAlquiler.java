package com.videoclub.model;

import java.util.ArrayList;

public class GestorAlquiler
{
	private ArrayList<Alquiler> arrayListMultimediaAlquilada;

	public GestorAlquiler()
	{
		arrayListMultimediaAlquilada = new ArrayList<>();
	}

	public void addAlquiler(Socio socio, Multimedia m)
	{
		Alquiler alquiler = new Alquiler();
		alquiler.setMySocio(socio);
		alquiler.getArrayListMultimedia().add(m);
		arrayListMultimediaAlquilada.add(alquiler);
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

	public boolean tieneDeudaPendiente2(Socio socio)
	{
		boolean nani = false;
		for (int x = 0; x < arrayListMultimediaAlquilada.size(); x++)
		{
			if (arrayListMultimediaAlquilada.get(x).getMySocio().equals(socio))
			{
				if (arrayListMultimediaAlquilada.get(x).isDeuda() == true)
				{
					nani = true;
				}
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
