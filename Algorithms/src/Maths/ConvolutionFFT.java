package Maths;

import java.util.ArrayList;

import Maths.FFT.Complex;

/**
 * 
 * @author Bharat
 *
 */
/**
 * 
 * Class fopr linear convolutioon of two discrete signals using the convolution theorem
 *
 */

public class ConvolutionFFT {
	/**
	 * This method pads the signal with zeroes until it recahes the new size 
	 * @param x the signal with zeroes until it recahes the new size
	 * @param newSize The new Size of the signal
	 */
	private static void padding (ArrayList<FFT.Complex> x, int newSize)
	{
		if(x.size() < newSize)
		{
			int diff = newSize - x.size();
			for(int i = 0; i  < diff; i++) x.add(new FFT.Complex());
		}
	}
	
	/**
	 * discrete linear convolution function. it use the convolution theorm for dicretye signals 
	 * convolved = IDFT(DFT(a)*DFT(b)) this is true circular convolution in order to get linear 
	 * convolution of the two signals we first add pad the two sognals to have the same size equal
	 * to the convolved signal (a.size() + b.size() - 1). Thn use the FFT algorithms for faster calculation of the two DFT's and fional IDFT 
	 * 
	 * @param a the first signal 
	 * @param b the other signal 
	 * @return the convolved signal 
	 */
	public static ArrayList<FFT.Complex> convolutionFFT(ArrayList<FFT.Complex> a, ArrayList<FFT.Complex> b)
	{
		int convolvedSize = a.size() + b.size() - 1;
		padding(a, convolvedSize);
		padding(b, convolvedSize);
		
		FFT.fft(a, false);
		FFT.fft(b, false);
		ArrayList<FFT.Complex> convolved = new ArrayList<>();
		
		for(int i = 0; i < a.size(); i++) convolved.add(a.get(i).multiply(b.get(i)));
		
		FFT.fft(convolved, true);
		convolved
		.subList(convolvedSize, convolved.size())
		.clear();
		
		return convolved;
		
		
		
	}

}
