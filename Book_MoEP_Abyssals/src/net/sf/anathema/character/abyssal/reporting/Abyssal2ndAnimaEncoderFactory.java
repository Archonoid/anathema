package net.sf.anathema.character.abyssal.reporting;

import com.lowagie.text.pdf.BaseFont;
import net.sf.anathema.character.reporting.pdf.content.stats.anima.AnimaTableStealthProvider;
import net.sf.anathema.character.reporting.pdf.rendering.boxes.anima.AbstractAnimaEncoderFactory;
import net.sf.anathema.character.reporting.pdf.rendering.boxes.anima.AnimaTableEncoder;
import net.sf.anathema.character.reporting.pdf.rendering.general.table.ITableEncoder;
import net.sf.anathema.lib.resources.IResources;

public class Abyssal2ndAnimaEncoderFactory extends AbstractAnimaEncoderFactory {

  public Abyssal2ndAnimaEncoderFactory(IResources resources, BaseFont basefont) {
    super(resources, basefont);
  }

  @Override
  protected ITableEncoder getAnimaTableEncoder() {
    return new AnimaTableEncoder(getResources(), getBaseFont(), getFontSize(), new AnimaTableStealthProvider(getResources()));
  }
}
