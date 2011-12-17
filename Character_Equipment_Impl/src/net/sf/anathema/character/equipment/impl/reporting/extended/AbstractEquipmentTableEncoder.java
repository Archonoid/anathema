package net.sf.anathema.character.equipment.impl.reporting.extended;

import com.lowagie.text.pdf.BaseFont;
import net.sf.anathema.character.equipment.IEquipmentAdditionalModelTemplate;
import net.sf.anathema.character.equipment.character.model.IEquipmentAdditionalModel;
import net.sf.anathema.character.equipment.character.model.IEquipmentPrintModel;
import net.sf.anathema.character.generic.character.IGenericCharacter;
import net.sf.anathema.character.generic.equipment.weapon.IEquipmentStats;
import net.sf.anathema.character.reporting.pdf.rendering.general.stats.AbstractFixedLineStatsTableEncoder;

public abstract class AbstractEquipmentTableEncoder<T extends IEquipmentStats> extends
    AbstractFixedLineStatsTableEncoder<T> {

  public AbstractEquipmentTableEncoder(BaseFont baseFont) {
    super(baseFont);
  }

  protected IEquipmentPrintModel getEquipmentModel(IGenericCharacter character) {
    return ((IEquipmentAdditionalModel) character.getAdditionalModel(IEquipmentAdditionalModelTemplate.ID)).getPrintModel();
  }
}
