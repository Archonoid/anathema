package net.sf.anathema.character.equipment.item.model;

import java.awt.Component;

import net.sf.anathema.character.generic.equipment.weapon.IEquipmentStats;
import net.sf.anathema.lib.resources.IResources;

public interface IEquipmentStatsEditor {

  public IEquipmentStats editStats(
      Component parentComponent,
      IResources resources,
      String[] nameArray,
      IEquipmentStats selectedStats);

}
