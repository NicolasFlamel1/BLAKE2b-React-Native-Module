// Package
package com.blake2breact;


// Imports
import androidx.annotation.NonNull;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;


// Classes

// BLAKE2b React module class
@ReactModule(name = Blake2bReactModule.NAME)
public class Blake2bReactModule extends ReactContextBaseJavaModule {

	// Name
	public static final String NAME = "Blake2bReact";
	
	// Static
	static {
	
		// Try
		try {
		
			// Load library
			System.loadLibrary("Blake2bReact");
		}
		
		// Catch errors
		catch(Exception error) {
		
		}
	}

	// Constructor
	public Blake2bReactModule(ReactApplicationContext reactContext) {
	
		// Delegate constructor
		super(reactContext);
	}

	// Get name
	@Override
	@NonNull
	public String getName() {
	
		// Return name
		return NAME;
	}
	
	// Compute
	@ReactMethod
	public void compute(double resultSize, String input, String key, Promise promise) {

		// Try
		try {

			// Resolve promise to native compute
			promise.resolve(nativeCompute(resultSize, input, key));
		}

		// Catch errors
		catch(Exception error) {

			// Reject promise
			promise.reject("Error", error);
		}
	}
	
	// Native compute prototype
	private static native String nativeCompute(double resultSize, String input, String key);
}
