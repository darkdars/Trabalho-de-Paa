/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.grafico.gui;

import java.net.URL;

/**
 *
 * @author jhssi
 */
public class Resources {
    
    public static final URL getResourceFile(String name){
		URL url=Resources.class.getResource(name);
		return url; 
	}
    
}
