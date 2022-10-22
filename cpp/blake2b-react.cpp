// Header files
#include <limits>
#include "./blake2b-react.h"

using namespace std;


// BLAKE2b namespace
namespace Blake2b {

	// Header files
	#include "../BLAKE2b-NPM-Package-master/main.cpp"
}


// Supporting function implementation

// Compute
vector<uint8_t> compute(double resultSize, const uint8_t *input, size_t inputSize, const uint8_t *key, size_t keySize) {

	// Check if result size is invalid
	if(resultSize < 0 || resultSize > numeric_limits<vector<uint8_t>::size_type>::max()) {
	
		// Throw error
		throw runtime_error("Result size is invalid");
	}
	
	// Check if computing BLAKE2b failed
	vector<uint8_t> result(resultSize);
	if(!Blake2b::compute(result.data(), result.size(), input, inputSize, key, keySize)) {
	
		// Throw error
		throw runtime_error("Computing BLAKE2b failed");
	}
	
	// Return result
	return result;
}
