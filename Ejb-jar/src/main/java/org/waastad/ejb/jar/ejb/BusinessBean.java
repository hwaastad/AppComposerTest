/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.ejb.jar.ejb;

import javax.ejb.Stateless;

/**
 *
 * @author helge
 */
@Stateless
public class BusinessBean implements BusinessBeanLocal, BusinessBeanRemote {

    @Override
    public String sayHello() {
        return "Say Hello.....";
    }

}
