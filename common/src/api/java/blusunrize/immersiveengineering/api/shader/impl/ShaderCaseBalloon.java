/*
 * BluSunrize
 * Copyright (c) 2017
 *
 * This code is licensed under "Blu's License of Common Sense"
 * Details can be found in the license file in the root folder of this project
 */

package blusunrize.Tournament.api.shader.impl;

import blusunrize.Tournament.api.Lib;
import blusunrize.Tournament.api.shader.ShaderCase;
import blusunrize.Tournament.api.shader.ShaderLayer;
import net.minecraft.resources.ResourceLocation;

import java.util.Collection;

public class ShaderCaseBalloon extends ShaderCase
{
	public ShaderCaseBalloon(ShaderLayer... layers)
	{
		super(layers);
	}

	public ShaderCaseBalloon(Collection<ShaderLayer> layers)
	{
		super(layers);
	}

	@Override
	public ResourceLocation getShaderType()
	{
		return new ResourceLocation(Lib.MODID, "balloon");
	}

	@Override
	public int getLayerInsertionIndex()
	{
		return layers.length-1;
	}

	@Override
	public boolean shouldRenderGroupForPass(String modelPart, int pass)
	{
		return true;
	}
}
