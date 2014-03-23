package com.liming.admin.webapp.vaadin;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;

//@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI
{

//    @WebServlet(value = "/*", asyncSupported = true)
//    @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class)
//    @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "app.AppWidgetSet")
    /*public static class Servlet extends VaadinServlet {
    }*/

    @Override
    protected void init(VaadinRequest request) {
        /*final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);
        
        Button button = new Button("Click Me");
        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                layout.addComponent(new Label("Thank you for clicking"));
            }
        });
        layout.addComponent(button);*/
        /*final HorizontalSplitPanel layout = new HorizontalSplitPanel();
        layout.setSizeFull();
        layout.setSplitPosition(150, Unit.PIXELS);
        layout.setFirstComponent(new Label("hello", ContentMode.HTML));
        layout.setSecondComponent(new Label("ExampleUtil.lorem", ContentMode.HTML));*/
        // Create an empty tab sheet.
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);

        TabSheet tabsheet = new TabSheet();

// Make the tabsheet shrink to fit the contents.
        tabsheet.setSizeUndefined();

        tabsheet.addTab(new Label("Contents of the first tab")).setCaption("first");
        tabsheet.addTab(new Label("Contents of the second tab")).setCaption("second");
        tabsheet.addTab(new Label("Contents of the third tab")).setCaption("third");
        layout.addComponent(tabsheet);
        setContent(layout);
    }

}
