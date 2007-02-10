package net.sf.anathema.platform.svgtree.document.visualizer;

import net.sf.anathema.character.generic.framework.magic.treelayout.graph.IProperHierarchicalGraph;
import net.sf.anathema.character.generic.framework.magic.treelayout.nodes.ISimpleNode;
import net.sf.anathema.character.generic.template.presentation.ITreePresentationProperties;
import net.sf.anathema.platform.svgtree.document.IVisualizedGraph;
import net.sf.anathema.platform.svgtree.document.SingleNodeVisualizedGraph;
import net.sf.anathema.platform.svgtree.document.components.ILayer;
import net.sf.anathema.platform.svgtree.document.components.Layer;
import net.sf.anathema.platform.svgtree.document.components.nodes.IVisualizableNode;
import net.sf.anathema.platform.svgtree.document.svg.SVGCreationUtils;

import org.apache.batik.util.SVGConstants;
import org.dom4j.Element;
import org.dom4j.QName;
import org.dom4j.tree.DefaultElement;

public class SingleNodeVisualizer extends AbstractCharmCascadeVisualizer {

  public SingleNodeVisualizer(ITreePresentationProperties properties, IProperHierarchicalGraph graph) {
    super(properties, graph);
  }

  public IVisualizedGraph buildCharmTree() {
    ISimpleNode node = getGraph().getNodesByLayer(1)[0];
    IVisualizableNode visualizableNode = getNodeFactory().registerVisualizableNode(node);
    ILayer layer = new Layer(getProperties().getGapDimension(), 0);
    visualizableNode.setLayer(layer);
    visualizableNode.setPosition(visualizableNode.getWidth() / 2);
    QName group = SVGCreationUtils.createSVGQName(SVGConstants.SVG_G_TAG);
    Element cascadeElement = new DefaultElement(group);
    visualizableNode.toXML(cascadeElement);
    return new SingleNodeVisualizedGraph(cascadeElement, getProperties().getNodeDimension());
  }
}