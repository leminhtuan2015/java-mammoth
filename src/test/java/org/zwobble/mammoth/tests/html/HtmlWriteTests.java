package org.zwobble.mammoth.tests.html;

import org.junit.Test;
import org.zwobble.mammoth.html.Html;
import org.zwobble.mammoth.html.HtmlNode;

import static org.junit.Assert.assertEquals;
import static org.zwobble.mammoth.util.MammothLists.list;

public class HtmlWriteTests {
    @Test
    public void textNodesAreWrittenAsPlainText() {
        assertEquals(
            "Dark Blue",
            write(Html.text("Dark Blue")));
    }

    @Test
    public void textNodesAreHtmlEscaped() {
        assertEquals(
            "&gt;&lt;&amp;",
            write(Html.text("><&")));
    }

    @Test
    public void canWriteElementWithNoChildren() {
        assertEquals(
            "<p></p>",
            write(Html.element("p")));
    }

    @Test
    public void canWriteElementWithChildren() {
        assertEquals(
            "<div><p></p><ul></ul></div>",
            write(Html.element("div", list(
                Html.element("p"),
                Html.element("ul")))));
    }

    private String write(HtmlNode node) {
        return Html.write(list(node));
    }
}
