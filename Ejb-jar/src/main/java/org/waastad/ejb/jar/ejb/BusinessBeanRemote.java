/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.waastad.ejb.jar.ejb;

import javax.ejb.Remote;

/**
 *
 * @author helge
 */
@Remote
public interface BusinessBeanRemote {

    String sayHello();
    
}
