package net.sf.anathema.character.sidereal.reporting.extended;

import net.sf.anathema.character.reporting.pdf.content.stats.anima.*;
import net.sf.anathema.lib.resources.IResources;

public class SiderealAnimaTableStealthProvider extends AnimaTableStealthProvider {

  public SiderealAnimaTableStealthProvider(IResources resources) {
    super(resources);
  }

  @Override
  protected String getLevelTwoStealth() {
    return getNormalStealth();
  }

  @Override
  protected String getLevelThreeStealth() {
    return getString("Sheet.AnimaTable.Stealth2InDark"); //$NON-NLS-1$
  }
}
