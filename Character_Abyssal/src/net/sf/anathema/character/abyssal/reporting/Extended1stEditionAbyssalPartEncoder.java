package net.sf.anathema.character.abyssal.reporting;

import net.sf.anathema.character.abyssal.reporting.rendering.Anima1stEditionEncoderFactory;
import net.sf.anathema.character.abyssal.reporting.rendering.Resonance1stEditionEncoder;
import net.sf.anathema.character.reporting.pdf.content.BasicContent;
import net.sf.anathema.character.reporting.pdf.content.ReportContent;
import net.sf.anathema.character.reporting.pdf.layout.extended.AbstractFirstEditionExaltPdfPartEncoder;
import net.sf.anathema.character.reporting.pdf.layout.extended.RegisteredPartEncoder;
import net.sf.anathema.character.reporting.pdf.rendering.boxes.EncoderRegistry;
import net.sf.anathema.character.reporting.pdf.rendering.general.box.ContentEncoder;
import net.sf.anathema.lib.resources.IResources;

import static net.sf.anathema.character.generic.impl.rules.ExaltedEdition.FirstEdition;
import static net.sf.anathema.character.generic.type.CharacterType.ABYSSAL;

@RegisteredPartEncoder(characterType = ABYSSAL, edition = FirstEdition)
public class Extended1stEditionAbyssalPartEncoder extends AbstractFirstEditionExaltPdfPartEncoder {

  public Extended1stEditionAbyssalPartEncoder(IResources resources) {
    super(resources);
  }

  public ContentEncoder getGreatCurseEncoder(EncoderRegistry encoderRegistry, ReportContent content) {
    return new Resonance1stEditionEncoder();
  }

  @Override
  public ContentEncoder getAnimaEncoder(ReportContent reportContent) {
    BasicContent content = reportContent.createSubContent(BasicContent.class);
    return new Anima1stEditionEncoderFactory().create(getResources(), content);
  }
}
