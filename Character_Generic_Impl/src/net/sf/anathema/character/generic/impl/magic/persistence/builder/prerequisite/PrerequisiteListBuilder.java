package net.sf.anathema.character.generic.impl.magic.persistence.builder.prerequisite;

import static net.sf.anathema.character.generic.impl.magic.ICharmXMLConstants.ATTRIB_THRESHOLD;
import static net.sf.anathema.character.generic.impl.magic.ICharmXMLConstants.ATTRIB_VALUE;
import static net.sf.anathema.character.generic.impl.magic.ICharmXMLConstants.TAG_ESSENCE;
import static net.sf.anathema.character.generic.impl.magic.ICharmXMLConstants.TAG_SELECTIVE_CHARM_GROUP;

import java.util.List;

import net.sf.anathema.character.generic.impl.magic.persistence.prerequisite.CharmPrerequisiteList;
import net.sf.anathema.character.generic.impl.magic.persistence.prerequisite.SelectiveCharmGroupTemplate;
import net.sf.anathema.character.generic.magic.charms.CharmException;
import net.sf.anathema.character.generic.magic.charms.ICharmAttributeRequirement;
import net.sf.anathema.character.generic.traits.IGenericTrait;
import net.sf.anathema.character.generic.traits.types.OtherTraitType;
import net.sf.anathema.character.generic.traits.types.ValuedTraitType;
import net.sf.anathema.lib.exception.PersistenceException;
import net.sf.anathema.lib.xml.ElementUtilities;

import org.dom4j.Element;

public class PrerequisiteListBuilder {

  private final ITraitPrerequisitesBuilder traitBuilder;
  private final IAttributeRequirementBuilder attributeBuilder;
  private final ICharmPrerequisiteBuilder charmPrerequisiteBuilder;
  
  public PrerequisiteListBuilder(ITraitPrerequisitesBuilder traitBuilder, IAttributeRequirementBuilder attributeBuilder, ICharmPrerequisiteBuilder charmPrerequisiteBuilder) {
    this.traitBuilder = traitBuilder;
    this.attributeBuilder = attributeBuilder;
    this.charmPrerequisiteBuilder = charmPrerequisiteBuilder;
  }

  public CharmPrerequisiteList buildPrerequisiteList(Element prerequisiteListElement) throws PersistenceException {
    IGenericTrait[] allPrerequisites = traitBuilder.buildTraitPrerequisites(prerequisiteListElement);
    IGenericTrait essence = buildEssencePrerequisite(prerequisiteListElement);
    String[] prerequisiteCharmIDs = charmPrerequisiteBuilder.buildCharmPrerequisites(prerequisiteListElement);
    SelectiveCharmGroupTemplate[] selectiveCharmGroups = buildSelectiveCharmGroups(prerequisiteListElement);
    ICharmAttributeRequirement[] attributeRequirements = attributeBuilder.getCharmAttributeRequirements(prerequisiteListElement);
    return new CharmPrerequisiteList(
        allPrerequisites,
        essence,
        prerequisiteCharmIDs,
        selectiveCharmGroups,
        attributeRequirements);
  }

  private IGenericTrait buildEssencePrerequisite(Element prerequisiteListElement) throws CharmException {
    Element essenceElement = prerequisiteListElement.element(TAG_ESSENCE);
    if (essenceElement == null) {
      throw new CharmException("Cannot process Charm without essence prerequisite."); //$NON-NLS-1$
    }
    int minValue;
    try {
      minValue = Integer.parseInt(essenceElement.attributeValue(ATTRIB_VALUE));
    }
    catch (NumberFormatException e) {
      throw new CharmException("Bad value on essence prerequisite."); //$NON-NLS-1$
    }
    IGenericTrait essence = new ValuedTraitType(OtherTraitType.Essence, minValue);
    return essence;
  }

  private SelectiveCharmGroupTemplate[] buildSelectiveCharmGroups(Element prerequisiteListElement)
      throws PersistenceException {
    List<Element> selectiveCharmGroupElements = ElementUtilities.elements(
        prerequisiteListElement,
        TAG_SELECTIVE_CHARM_GROUP);
    SelectiveCharmGroupTemplate[] charmGroups = new SelectiveCharmGroupTemplate[selectiveCharmGroupElements.size()];
    for (int index = 0; index < selectiveCharmGroupElements.size(); index++) {
      Element groupElement = selectiveCharmGroupElements.get(index);
      String[] groupCharmIds = charmPrerequisiteBuilder.buildCharmPrerequisites(groupElement);
      int threshold = ElementUtilities.getRequiredIntAttrib(groupElement, ATTRIB_THRESHOLD);
      charmGroups[index] = new SelectiveCharmGroupTemplate(groupCharmIds, threshold);
    }
    return charmGroups;
  }
}