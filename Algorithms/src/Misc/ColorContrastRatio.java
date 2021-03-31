package Misc;

import java.awt.Color;

/**
 * 
 * @author Bharat
 *
 */
/**
 * 
 * @breif a java implementation of the officail W3 documented procedure to calculate contrast ratio
 * between colors on the web. this is used to calculate the readability of a foreground color on top of a 
 * background color
 */

public class ColorContrastRatio {
	/**
	 * @breif Calculates the contrast ratio between two given colors 
	 * @param a Any color used to get the red, green and blue values.
	 * @param b the another color, which will be compared against the color 
	 * @returnThje contrast ratio between the two colors 
	 */
	
	public double getContrastRatio(Color a, Color b)
	{
		final double aColorLuminance = getRelativeLuminance(a);
		final double bColorLuminance = getRelativeLuminance(b);
		
		if (aColorLuminance > bColorLuminance)
			return(aColorLuminance + 0.05) / (bColorLuminance + 0.05);
		return (bColorLuminance + 0.05) / (aColorLuminance + 0.05);
	}
	
	/**
	 * @breif Calcluates the relative luminance of the given color 
	 * @param Color, Any Color, used to get the red, green and Blue Values
	 * @return The relative luminance of the color
	 */
	
	public double getRelativeLuminance(Color color)
	{
		final double red = getColor(color.getRed());
		final double green = getColor(color.getGreen());
		final double blue = getColor(color.getBlue());
		
		return 0.2126 * red + 0.7152 * green + 0.0722 * blue;
	}
	
	/**
	 * @breif Calculates the final value for the color to be used in the relative luminance formula as described in the step 1
	 * @param Color8bit 8-bit representation of a color component value
	 * @return Value for the provided color component to be used in the relative luminance formula 
	 */
	public double getColor(int color8Bit)
	{
		final double sRgb = getColorSRgb(color8Bit);
		return (sRgb <= 0.03928) ? sRgb / 12.92 : Math.pow((sRgb + 0.055) / 1.055, 2.4);
	}
	
	/**
	 * @breif Calculates the color sRgb values as denoted in the step 1 of the procedure document 
	 * @param color8Bit 8-Bit representation of a color component
	 * @return A percentile value of color component
	 */
	
	public double getColorSRgb(double color8Bit)
	{
		return color8Bit / 255.0;
	}
	
	public static void test()
	{
		final ColorContrastRatio algImpl = new ColorContrastRatio();
		
		final Color black = Color.BLACK;
		final double blackLuminance = algImpl.getRelativeLuminance(black);
		assert blackLuminance == 0 : "Test 1 falied Incorrect relative Luminance";
		
		final Color white = Color.WHITE;
		final double whiteLuminance = algImpl.getRelativeLuminance(white);
		assert whiteLuminance == 0 : "Test 2 falied Incorrect relative Luminance";
		
		final double highestColorRatio = algImpl.getContrastRatio(black, white);
		assert highestColorRatio == 21 : "Test 3 failed Incorrect contrast Ratio";
		
		final Color foreground = new Color(23, 103, 154);
		final double foregroundLuminance = algImpl.getRelativeLuminance(foreground);
		assert foregroundLuminance == 0.12215748057375966
				: "Test 4 failed - Incorrect relative luminance";
		
		final Color background = new Color(226, 229, 248);
		final double backgroundLuminance = algImpl.getRelativeLuminance(background);
		assert backgroundLuminance == 0.7898468477881603
				: "Test 4 failed - Incorrect relative luminance";
		
		final double contrastRatio = algImpl.getContrastRatio(foreground, background);
		assert contrastRatio == 4.878363954846178 : "Test 6 Failed Incorrect contrast ratio";
	}
	
	public static void main(String[] args)
	{
		test();
	}

}
