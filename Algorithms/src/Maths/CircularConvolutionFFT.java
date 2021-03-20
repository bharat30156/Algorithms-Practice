package Maths;

import java.util.ArrayList;



/**
 * 
 * @author Bharat
 *
 */
/** Class for circular convolution of two distances signals using the convolution theorm*/ 
public class CircularConvolutionFFT {
	/**
	 * This method pads the signal woith zeros until it reaches the new size
	 * 
	 * @param x The signal to be padded
	 * @param newSize the new size of the signal
	 */
	private static void padding(ArrayList<FFT.Complex> x, int newSize)
	{
		if(x.size() < newSize)
		{
			int diff = newSize - x.size();
			for(int i = 0; i < diff; i ++) x.add(new FFT.Complex());
		}
	}
	
	/**
	 * Discrete circular convolution function it uses the convolution theorem for discrete signals
	 * convolved = IDFT(DFT(a)*DFT(b)). Then we use the FFT algorithms for faster calulations of the 
	 * two DFT's and the final IDFT
	 * 
	 * @param a the first signal 
	 * @param b the other signal
	 * @return the convolved signal
	 */
	public ArrayList<FFT.Complex> fftCircularConvolution(ArrayList<FFT.Complex> a, ArrayList<FFT.Complex> b)
	{
		int convolvedSize = Math.max(a.size(), b.size());
		padding(a, convolvedSize);
		padding(b, convolvedSize);
		
		
		/**
		 * Find the FFT'sof both signal . here i am using bluestein algorithm because we wnat the FFT to have the same length with the signal and bigger
		 */
		FFTBluestein.fftBluestein(a, false);
		FFTBluestein.fftBluestein(b, false);
		ArrayList<FFT.Complex> convolved = new ArrayList();
		
		for(int i = 0; i < a.size(); i++) convolved.add(a.get(i).multiply(b.get(i)));
		
		FFTBluestein.fftBluestein(convolved, true);
		
		return convolved;
	}

}
