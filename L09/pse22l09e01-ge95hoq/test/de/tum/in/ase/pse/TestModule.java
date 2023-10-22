package de.tum.in.ase.pse;

import com.google.inject.AbstractModule;

import static org.easymock.EasyMock.mock;

public class TestModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(IMeteorologicalFileStorage.class).toInstance(mock(IMeteorologicalFileStorage.class));
        bind(IMeteorologicalSensorArray.class).toInstance(mock(IMeteorologicalSensorArray.class));
        bind(IMeteorologicalStationGUI.class).toInstance(mock(IMeteorologicalStationGUI.class));
    }
}
