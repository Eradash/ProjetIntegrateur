package JTree;

import logiqueCircuit.Circuit;

public class MonTreeBuilder {

    public static MaNode build(Circuit c) {
        if(c != null){
            MaNode rootNode = new MaNode("Circuit", MaNode.NODE_ROOT);

            MaNode projectNode = new MaNode("TreeApp", MaNode.NODE_PROJECT);

            MaNode sourceNode = new MaNode("src", MaNode.NODE_PARALLELE);
            MaNode srcPackageNode = new MaNode("com.mycompany.tree", MaNode.NODE_BRANCHE);
            MaNode srcClassNode1 = new MaNode("TreeApp.java", MaNode.NODE_RESISTANCE);
            MaNode srcClassNode2 = new MaNode("ProjectItemNode.java", MaNode.NODE_RESISTANCE);
            MaNode srcClassNode3 = new MaNode("ProjectTreeModel.java", MaNode.NODE_RESISTANCE);
            MaNode srcClassNode4 = new MaNode("ProjectTreeBuilder.java", MaNode.NODE_RESISTANCE);
            MaNode srcClassNode5 = new MaNode("NodeRenderer.java", MaNode.NODE_RESISTANCE);

            srcPackageNode.addChild(srcClassNode1);
            srcPackageNode.addChild(srcClassNode2);
            srcPackageNode.addChild(srcClassNode3);
            srcPackageNode.addChild(srcClassNode4);
            srcPackageNode.addChild(srcClassNode5);
            sourceNode.addChild(srcPackageNode);

            projectNode.addChild(sourceNode);

            MaNode testNode = new MaNode("test", MaNode.NODE_PARALLELE);
            MaNode testPackageNode = new MaNode("com.mycompany.test", MaNode.NODE_BRANCHE);
            MaNode testClassNode = new MaNode("TreeAppTest.java", MaNode.NODE_RESISTANCE);

            testPackageNode.addChild(testClassNode);
            testNode.addChild(testPackageNode);

            projectNode.addChild(testNode);

            projectNode.addChild(new MaNode("bin", MaNode.NODE_FOLDER));

            projectNode.addChild(new MaNode("lib", MaNode.NODE_FOLDER));

            rootNode.addChild(projectNode);
            
            return rootNode;
        } else {
            return null;
        }
    }
}
