package net.sf.anathema.character.generic.impl.magic;

import net.sf.anathema.character.generic.magic.ICharm;
import net.sf.anathema.character.generic.magic.charms.ICharmAttribute;
import net.sf.anathema.character.generic.magic.charms.ICharmAttributeRequirement;
import net.sf.anathema.lib.lang.ReflectionEqualsObject;

public class CharmAttributeRequirement extends ReflectionEqualsObject implements ICharmAttributeRequirement {

  private final ICharmAttribute attribute;
  private final int count;

  public ICharmAttribute getAttribute() {
    return attribute;
  }

  public int getCount() {
    return count;
  }
  public CharmAttributeRequirement(ICharmAttribute attribute, int count) {
    this.attribute = attribute;
    this.count = count;
  }

  @Override
  public String getStringRepresentation() {
    return "Requirement." + attribute.getId() + "." + count; //$NON-NLS-1$//$NON-NLS-2$
  }

  @Override
  public String toString() {
    return attribute.toString() + "x" + count; //$NON-NLS-1$
  }

  public boolean isFulfilled(ICharm[] charms) {
    int amount = 0;
    for (ICharm charm : charms) {
      if (charm.hasAttribute(attribute)) {
        amount++;
      }
    }
    return amount >= count;
  }
}