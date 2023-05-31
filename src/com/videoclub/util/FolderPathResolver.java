package com.videoclub.util;

/**
 * Esta clase proporciona métodos para resolver las rutas de las carpetas en función del sistema operativo.
 */
public class FolderPathResolver
{
	private static final String OS = System.getProperty("os.name").toLowerCase();
	private static final boolean IS_WINDOWS = OS.contains("win");
	private static final boolean IS_UNIX = OS.contains("nix") || OS.contains("nux") || OS.contains("aix");

	/**
	 * Devuelve la ruta de la carpeta de configuración del usuario.
	 *
	 * @return La ruta de la carpeta de configuración del usuario.
	 * @throws RuntimeException si la ruta de la carpeta de configuración del usuario no es compatible en este sistema operativo.
	 */
	public static String getUserConfigPath()
	{
		if (IS_UNIX)
		{
			return System.getenv("XDG_CONFIG_HOME");
		}
		else if (IS_WINDOWS)
		{
			return System.getenv("APPDATA");
		}
		else
		{
			throw new RuntimeException("User config path not supported on this operating system");
		}
	}

	/**
	 * Devuelve la ruta de la carpeta de datos del usuario.
	 *
	 * @return La ruta de la carpeta de datos del usuario.
	 * @throws RuntimeException si la ruta de la carpeta de datos del usuario no es compatible en este sistema operativo.
	 */
	public static String getUserDataPath()
	{
		if (IS_WINDOWS)
		{
			return System.getenv("APPDATA");
		}
		else if (IS_UNIX)
		{
			String xdgDataHome = System.getenv("XDG_DATA_HOME");

			if (xdgDataHome != null)
			{
				return xdgDataHome;
			}
			else
			{
				return System.getProperty("user.home");
			}
		}
		else
		{
			throw new RuntimeException("OS not supported");
		}
	}
}
