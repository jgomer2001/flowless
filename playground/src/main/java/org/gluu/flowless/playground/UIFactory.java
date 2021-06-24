package org.gluu.flowless.playground;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zk.ui.http.SimpleUiFactory;
import org.zkoss.zk.ui.metainfo.PageDefinition;
import org.zkoss.zk.ui.sys.RequestInfo;

public class UIFactory extends SimpleUiFactory {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private String treePagePath; 

    @Override
    public PageDefinition getPageDefinition(RequestInfo ri, String path) {

        if (treePagePath == null) {
            //treePagePath = ri.getWebApp().getAttribute(ZKInitializer.TREE_PAGE_ATTR).toString();
        }
        if (treePagePath.equals(path)) { 
            String content = "<zk>"
                    + "<treechildren>\n"
                    + "<treeitem>\n"
                    + "<treerow>\n"
                    + "<treecell label=\"Item 1\" />\n"
                    + "<treecell label=\"Item 11 description\" />\n"
                    + "</treerow>\n"
                    + "</treeitem>\n"
                    + "</treechildren>\n"
                    + "</zk>";
            /*
            content="<zk xmlns:w=\"client\"><tree id=\"tree\" vflex=\"1\" width=\"300px\" w:onSelect=\"javascript:setValue('content', 'Loading...')\" \n" +
"			    onSelect=\"@('selected', self.treechildren.items)\">    \n" +
                   content + 
"        </tree></zk>";*/
            return getPageDefinitionDirectly(ri, content, "zul");
        } else {
            return super.getPageDefinition(ri, path);
        }

    }

}
