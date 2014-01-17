package com.liming.platform.admin.vaadin;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

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
        final HorizontalSplitPanel layout = new HorizontalSplitPanel();
        layout.setSizeFull();
        layout.setSplitPosition(150, Unit.PIXELS);
        layout.setFirstComponent(new Label("hello", ContentMode.HTML));
        layout.setSecondComponent(new Label("ExampleUtil.lorem", ContentMode.HTML));
        setContent(layout);
    }

}
