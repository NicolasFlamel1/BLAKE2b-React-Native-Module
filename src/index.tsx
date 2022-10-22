// Imports
import { NativeModules, Platform } from "react-native";
import { Buffer } from "buffer";


// Check if BLAKE2b React module doesn't exist
if(!NativeModules.Blake2bReact) {

	// Throw error
	throw new Error("The package '@nicolasflamel/blake2b-react' doesn't seem to be linked. Make sure: \n\n" + Platform.select({
		ios: "- You have run 'pod install'\n",
		default: ""
	}) + "- You rebuilt the app after installing the package\n- You are not using Expo managed workflow\n");
}


// Classes

// BLAKE2b class
export default class Blake2b {

	// Operation failed
	public static readonly OPERATION_FAILED = null;

	// Compute
	static async compute(
		resultSize: number,
		input: Buffer,
		key: Buffer
	): Promise<Buffer | null> {
	
		// Try
		try {
	
			// Return computing BLAKE2b with BLAKE2b React module
			return Buffer.from(await NativeModules.Blake2bReact.compute(resultSize, input.toString("hex"), key.toString("hex")), "hex");
		}
		
		// Catch errors
		catch(
			error: any
		) {
		
			// Return operation failed
			return Blake2b.OPERATION_FAILED;
		}
	}
}
