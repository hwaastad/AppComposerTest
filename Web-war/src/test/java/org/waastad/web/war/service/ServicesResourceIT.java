/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.web.war.service;

import java.util.Properties;
import org.apache.openejb.jee.jpa.unit.Persistence;
import org.apache.openejb.jee.jpa.unit.PersistenceUnit;
import org.apache.openejb.junit.ApplicationComposer;
import org.apache.openejb.junit.Configuration;
import org.apache.openejb.junit.MockInjector;
import org.apache.openejb.junit.Module;
import org.apache.openejb.mockito.MockitoInjector;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.waastad.ejb.jar.ejb.BusinessBean;
import org.waastad.web.war.helper.ContainerConfiguration;

/**
 *
 * @author helge
 */
@RunWith(ApplicationComposer.class)
public class ServicesResourceIT {

    public ServicesResourceIT() {
    }

    @Configuration
    public Properties configuration() {
        return ContainerConfiguration.getConfiguration();
    }

    @MockInjector
    public Class<?> mockitoInjector() {
        return MockitoInjector.class;
    }

    @Module
    public Class<?>[] app() {
        return new Class<?>[]{ServicesResource.class, BusinessBean.class};
    }

    @Module
    public Persistence persistence() {
        return ContainerConfiguration.getPersistence2();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getJson method, of class ServicesResource.
     */
    @Test
    public void testGetJson() {
        System.out.println("getJson");

    }

}
