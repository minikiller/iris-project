package com.liming.platform.admin.vaadin;


import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;

/**
 * Created by dell on 14-1-14.
 */
public class AdjustableLayout extends HorizontalSplitPanel {
    private static final String LIPSUM = "Lorem ipsum dolor …";
    public AdjustableLayout() {
        /*setFirstComponent(createMenu());
        setSecondComponent(createContentPanel());*/
        setSizeFull();setSplitPosition(150, Unit.PIXELS);
        setFirstComponent(new Label("hello", ContentMode.HTML));
        setSecondComponent(new Label("ExampleUtil.lorem", ContentMode.HTML));


    }

    private Component createContentPanel() {
        /*VerticalSplitPanel contentPanel = new VerticalSplitPanel();
        contentPanel.setFirstComponent(createEditorPanel());
        contentPanel.setSecondComponent(createTable());
        contentPanel.setSplitPosition(80, Unit.PERCENTAGE);
        return contentPanel;*/
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);


        Button button = new Button("Click Me");
        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                layout.addComponent(new Label("Thank you for clicking"));
            }
        });
        layout.addComponent(button);
        return layout;
    }

    private Component createEditorPanel() {
        SafeHtml safeHtml = SafeHtmlUtils.fromSafeConstant(
                "<b>Help</b> <br />" + LIPSUM);
        HorizontalSplitPanel editorPanel =
                new HorizontalSplitPanel();
        RichTextArea editor = new RichTextArea();
        editor.setSizeFull();
        editor.setValue(LIPSUM);
        editorPanel.setFirstComponent(editor);
        editorPanel.setSecondComponent(
                new Label(safeHtml.asString(), ContentMode.HTML));
        editorPanel.setSplitPosition(80, Unit.PERCENTAGE);
        return editorPanel;
    }

    private Tree createMenu() {
        Tree menu = new Tree();
        for (int i = 1; i < 6; i++) {
            String item = "item" + i;
            String childItem = "subitem" + i;
            menu.addItem(item);
            menu.addItem(childItem);
            menu.setParent(childItem, item);
            menu.setChildrenAllowed(childItem, false);
        }
        return menu;
    }

    private Table createTable() {
        Table table = new Table();
        table.addContainerProperty("Name", String.class, null);
        table.addContainerProperty("Value", String.class, null);
        table.addItem(new Object[] { "Color", "blue" }, null);
        table.addItem(new Object[] { "Height", "600 px" }, null);
        table.addItem(new Object[] { "Width", "1024 px" }, null);
        table.setSizeFull();
        return table;
    }
}
