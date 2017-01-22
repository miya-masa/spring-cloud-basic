package com.myms.cloud.example.shop.ui;

import javax.annotation.PostConstruct;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = "home", ui = MainUI.class)
public class HomeView extends VerticalLayout implements View {

    @PostConstruct
    private void init() {
        setMargin(true);
        setSpacing(true);
        addComponent(new Label("Hello HomeView!!!"));
    }

    @Override
    public void enter(ViewChangeEvent event) {

    }

}
