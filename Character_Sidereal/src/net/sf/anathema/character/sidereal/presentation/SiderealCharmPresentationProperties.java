package net.sf.anathema.character.sidereal.presentation;

import net.sf.anathema.character.generic.framework.xml.presentation.GenericCharmPresentationProperties;

import java.awt.Color;
import java.awt.Dimension;

public class SiderealCharmPresentationProperties extends GenericCharmPresentationProperties {

  private static final String POLYGON = "89.0,11.0 99.0,5.0 121.0,12.0 148.0,14.0 146.0,20.0 157.0,22.0 168.0,19.0 173.0,27.0 174.0,33.0 168.0,43.0 174.0,53.0 173.0,59.0 168.0,67.0 157.0,64.0 146.0,66.0 148.0,72.0 121.0,74.0 99.0,81.0 89.0,75.0 79.0,81.0 57.0,74.0 30.0,72.0 32.0,66.0 21.0,64.0 12.0,67.0 7.0,59.0 6.0,53.0 12.0,43.0 6.0,33.0 7.0,27.0 12.0,19.0 23.0,22.0 32.0,20.0 30.0,14.0 57.0,12.0 79.0,5.0"; //$NON-NLS-1$

  public SiderealCharmPresentationProperties() {
    setPolygonString(POLYGON);
    setCharmDimension(new Dimension(178, 80));
    setColor(new Color(147, 112, 219));
  }
}