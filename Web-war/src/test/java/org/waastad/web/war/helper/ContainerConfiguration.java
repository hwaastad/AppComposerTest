/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.web.war.helper;

import java.security.acl.Acl;
import java.util.Arrays;
import java.util.Properties;
import javax.naming.Context;
import org.apache.openejb.BeanContext;
import org.apache.openejb.OpenEjbContainer;
import org.apache.openejb.bval.BeanValidationAppendixInterceptor;
import org.apache.openejb.core.LocalInitialContextFactory;
import org.apache.openejb.jee.jpa.unit.Persistence;
import org.apache.openejb.jee.jpa.unit.PersistenceUnit;
import org.eclipse.persistence.jpa.PersistenceProvider;
import org.waastad.ejb.jar.entity.Group;
import org.waastad.ejb.jar.entity.User;

/**
 *
 * @author helge
 */
public class ContainerConfiguration {

    public static Properties getConfiguration() {
        return new Properties() {
            private static final long serialVersionUID = 3109256773218160485L;

            {
                setProperty(OpenEjbContainer.OPENEJB_EMBEDDED_REMOTABLE, Boolean.TRUE.toString());
                setProperty("DEFAULTDS", "new://Resource?type=DataSource");

                setProperty("DEFAULTDS.JdbcDriver", "org.hsqldb.jdbcDriver");
                setProperty("DEFAULTDS.JdbcUrl", "jdbc:hsqldb:mem:portaldb");
                setProperty("DEFAULTDS.UserName", "SA");
                setProperty("DEFAULTDS.Password", "");

                setProperty("DEFAULT_PU.javax.persistence.schema-generation.database.action", "drop-and-create");
                setProperty("DEFAULT_PU.eclipselink.logging.level", "FINE");

                setProperty(Context.INITIAL_CONTEXT_FACTORY, LocalInitialContextFactory.class.getName());
                setProperty(BeanContext.USER_INTERCEPTOR_KEY, BeanValidationAppendixInterceptor.class.getName());
            }
        };
    }

    public static Properties getConfigurationWithoutValidation() {
        return new Properties() {
            private static final long serialVersionUID = 3109256773218160485L;

            {
                setProperty(OpenEjbContainer.OPENEJB_EMBEDDED_REMOTABLE, Boolean.TRUE.toString());
                setProperty("DEFAULTDS", "new://Resource?type=DataSource");

                setProperty("DEFAULTDS.JdbcDriver", "org.hsqldb.jdbcDriver");
                setProperty("DEFAULTDS.JdbcUrl", "jdbc:hsqldb:mem:portaldb");
                setProperty("DEFAULTDS.UserName", "SA");
                setProperty("DEFAULTDS.Password", "");

                setProperty("DEFAULTDS.javax.persistence.schema-generation.database.action", "create");
                setProperty("DEFAULTDS.eclipselink.logging.level", "FINE");

                setProperty(Context.INITIAL_CONTEXT_FACTORY, LocalInitialContextFactory.class.getName());
            }
        };
    }

    public static PersistenceUnit getPersistentUnit() {
        PersistenceUnit unit = new PersistenceUnit("DEFAULT_PU");
        unit.setProvider(PersistenceProvider.class);
        unit.setJtaDataSource("DEFAULTDS");
        unit.setNonJtaDataSource("DEFAULTDSUnmanaged");
        unit.setProperty("DEFAULTDS.UserName", "SA");
        unit.setProperty("DEFAULTDS.Password", "");
        unit.setProperty("javax.persistence.schema-generation.database.action", "drop-and-create");
        unit.setProperty("eclipselink.logging.level", "FINE");
        unit.getClazz().addAll(Arrays.asList(User.class.getName(), Group.class.getName()));
        return unit;
    }

    public static Persistence getPersistence() {
        final PersistenceUnit unit = new PersistenceUnit("DEFAULT_PU");
        unit.getClazz().addAll(Arrays.asList(User.class.getName(), Group.class.getName()));
        unit.setProperty("openjpa.RuntimeUnenhancedClasses", "supported");
        unit.setProperty("openjpa.jdbc.SynchronizeMappings", "buildSchema(ForeignKeys=true)");
        unit.setExcludeUnlistedClasses(true);
        final Persistence persistence = new Persistence(unit);
        persistence.setVersion("2.0");
        return persistence;
    }
    
    public static Persistence getPersistence2() {
        final PersistenceUnit unit = new PersistenceUnit("DEFAULT_PU");
        unit.setProvider(PersistenceProvider.class);
        unit.setJtaDataSource("DEFAULTDS");
        unit.setNonJtaDataSource("DEFAULTDSUnmanaged");
        unit.setProperty("DEFAULTDS.UserName", "SA");
        unit.setProperty("DEFAULTDS.Password", "");
        unit.setProperty("javax.persistence.schema-generation.database.action", "drop-and-create");
        unit.setProperty("eclipselink.logging.level", "FINE");
        unit.getClazz().addAll(Arrays.asList(User.class.getName(), Group.class.getName()));
        final Persistence persistence = new Persistence(unit);
        persistence.setVersion("2.0");
        return persistence;
    }

}
