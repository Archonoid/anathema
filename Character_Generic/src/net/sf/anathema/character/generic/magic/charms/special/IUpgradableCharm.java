package net.sf.anathema.character.generic.magic.charms.special;

public interface IUpgradableCharm extends IMultipleEffectCharm
{
	public int getUpgradeBPCost();
	
	public int getUpgradeXPCost();
	
	public int getCreationCharmCount();
	
	public int getExperiencedCharmCount();
	
	public boolean requiresBase();
	
	public boolean isComplex();
	
	public void learnFirst();
	
	public void forgetCharms();
	
	public ISubeffect[] getCharmEffects();
}