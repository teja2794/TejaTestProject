package com.test.TestProject.util;

import java.awt.Color;
import java.lang.reflect.Field;

public class ColorUtil {
	public static Color stringToColor(final String value) {
	    if (value == null) {
	      return Color.black;
	    }
	    try {
	      return Color.decode(value);
	    } catch (NumberFormatException nfe) {
	      try {
	        final Field f = Color.class.getField(value);

	        return (Color) f.get(null);
	      } catch (Exception ce) {
	        return Color.black;
	      }
	    }
	  }


}
