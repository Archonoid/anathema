package net.sf.anathema.charmtree.presenter.view;

import net.sf.anathema.lib.gui.IView;
import net.sf.anathema.platform.svgtree.presenter.view.INodeSelectionListener;

import java.awt.*;

public interface ICharmView extends ICascadeSelectionView, IView, ISpecialCharmViewContainer {

  void addCharmSelectionListener(INodeSelectionListener listener);

  void setCharmVisuals(String charmId, Color fillColor, int opacity);
}