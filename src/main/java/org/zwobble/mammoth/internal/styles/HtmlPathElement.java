package org.zwobble.mammoth.internal.styles;

import org.zwobble.mammoth.internal.html.HtmlElement;
import org.zwobble.mammoth.internal.html.HtmlNode;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static org.zwobble.mammoth.internal.util.Lists.list;
import static org.zwobble.mammoth.internal.util.Maps.map;

public class HtmlPathElement {
    public static HtmlPathElement collapsible(String tagName) {
        return collapsible(tagName, map());
    }

    public static HtmlPathElement collapsible(String tagName, Map<String, String> attributes) {
        return new HtmlPathElement(list(tagName), attributes, true, "");
    }

    private final List<String> tagNames;
    private final Map<String, String> attributes;
    private final boolean isCollapsible;
    private final String separator;

    public HtmlPathElement(List<String> tagNames, Map<String, String> attributes, boolean isCollapsible, String separator) {
        this.tagNames = tagNames;
        this.attributes = attributes;
        this.isCollapsible = isCollapsible;
        this.separator = separator;
    }

    public Supplier<List<HtmlNode>> wrap(Supplier<List<HtmlNode>> generateNodes) {
        return () -> wrapNodes(generateNodes.get());
    }

    private List<HtmlNode> wrapNodes(List<HtmlNode> nodes) {
        return list(new HtmlElement(tagNames, attributes, nodes, isCollapsible));
    }
}
