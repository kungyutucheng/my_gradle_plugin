package com.kungyu.tree;

import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.ColoredTreeCellRenderer;
import com.intellij.ui.ToolbarDecorator;
import com.intellij.ui.TreeSpeedSearch;
import com.intellij.ui.treeStructure.Tree;
import com.intellij.util.ui.EditableTreeModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.util.Collection;

/**
 * @author wengyongcheng
 * @since 2020/3/7 10:22 下午
 */
public class TreeDialogWrapper extends DialogWrapper {

    private Tree tree;

    private DefaultTreeModel model;

    public TreeDialogWrapper() {
        super(true);
        init();
        setTitle("Tree");
    }
    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        // 创建节点
        DefaultMutableTreeNode child1Leaf1 = new DefaultMutableTreeNode();
        child1Leaf1.setUserObject("child1Leaf1");

        DefaultMutableTreeNode child1 = new DefaultMutableTreeNode();
        child1.add(child1Leaf1);
        child1.setUserObject("child1");

        DefaultMutableTreeNode child1Leaf2 = new DefaultMutableTreeNode();
        child1Leaf2.setUserObject("child1Leaf2");

        DefaultMutableTreeNode child2 = new DefaultMutableTreeNode();
        child2.add(child1Leaf2);
        child2.setUserObject("child2");

        DefaultMutableTreeNode root = new DefaultMutableTreeNode();
        root.setUserObject("root");
        root.add(child1);
        root.add(child2);

        // 创建数据模型
        model = new DefaultTreeModel(root);
        tree = new Tree(model);
        tree.setDragEnabled(true);
        tree.setExpandableItemsEnabled(true);

        // 快速查找
        new TreeSpeedSearch(tree);

        // 自定义样式
        ColoredTreeCellRenderer coloredTreeCellRenderer = new ColoredTreeCellRenderer() {
            @Override
            public void customizeCellRenderer(@NotNull JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
                append(value + "-suffix");

            }
        };
        tree.setCellRenderer(coloredTreeCellRenderer);


        // 工具栏
        ToolbarDecorator toolbarDecorator = ToolbarDecorator.createDecorator(tree);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(toolbarDecorator.createPanel(), BorderLayout.CENTER);
        return panel;
    }


}
