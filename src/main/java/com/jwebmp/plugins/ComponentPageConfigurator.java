package com.jwebmp.plugins;

import com.jwebmp.core.Page;
import com.jwebmp.core.services.IPageConfigurator;

import javax.validation.constraints.NotNull;

public class ComponentPageConfigurator
		implements IPageConfigurator<ComponentPageConfigurator>
{
	private static boolean enabled = true;

	@Override
	public @NotNull Page<?> configure(Page<?> page)
	{
		return page;
	}

	@Override
	public boolean enabled()
	{
		return enabled;
	}

	public static boolean isEnabled()
	{
		return enabled;
	}

	public static void setEnabled(boolean enabled)
	{
		ComponentPageConfigurator.enabled = enabled;
	}
}
